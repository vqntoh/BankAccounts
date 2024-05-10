package pro.cloudnode.smp.bankaccounts.commands;

import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.DoubleChestInventory;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pro.cloudnode.smp.bankaccounts.Account;
import pro.cloudnode.smp.bankaccounts.BankAccounts;
import pro.cloudnode.smp.bankaccounts.Command;
import pro.cloudnode.smp.bankaccounts.POS;
import pro.cloudnode.smp.bankaccounts.Permissions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

/**
 * Create a POS at the location the player is looking at.
 * <p>
 * Permission: {@code bank.pos.create}
 * <p>
 * {@code /pos <account> <price> [description]}
 */
public final class POSCommand extends Command {
    @Override
    public boolean execute(final @NotNull CommandSender sender, final @NotNull String label, final @NotNull String @NotNull [] args) {
        if (!(sender instanceof final @NotNull Player player))
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsPlayerOnly());
        if (!player.hasPermission(Permissions.POS_CREATE))
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsNoPermission());

        if (args.length < 2)
            return sendUsage(sender, label, (args.length > 0 ? args[0] : "<account>") + " <price> [description]");

        final @NotNull BigDecimal price;
        try {
            price = BigDecimal.valueOf(Double.parseDouble(args[1])).setScale(2, RoundingMode.HALF_UP);
        }
        catch (final @NotNull NumberFormatException e) {
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsInvalidNumber(args[1]));
        }

        if (price.compareTo(BigDecimal.ZERO) <= 0)
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsInvalidNumber(args[1]));

        final @Nullable Block target = player.getTargetBlockExact(5);
        if (target == null) return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsBlockTooFar());

        final @NotNull Optional<@NotNull BlockState> block = BankAccounts.runOnMain(target::getState, 5);
        if (block.isEmpty()) return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsAsyncFailed());
        if (!(block.get() instanceof final @NotNull Chest chest))
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsPosNotChest());
        if (chest.getInventory() instanceof DoubleChestInventory)
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsPosDoubleChest());
        if (chest.getInventory().isEmpty()) return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsPosEmpty());
        if (POS.get(chest).isPresent()) return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsPosAlreadyExists());
        if (args[0].equals("add")) {
            chest.getInventory().addItem(player.getInventory().getItemInMainHand());
            player.getInventory().getItemInMainHand().setAmount(0);
            POS.get(chest).get().price.add(new BigDecimal(args[1]));
            return sendMessage(sender, BankAccounts.getInstance().config().messagesPosUpdated());
        }
        final @NotNull Optional<@NotNull Account> account = Account.get(args[0]);
        if (account.isEmpty()) return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsAccountNotFound());
        if (account.get().type == Account.Type.PERSONAL && !BankAccounts.getInstance().config().posAllowPersonal() && !player.hasPermission(Permissions.POS_CREATE_PERSONAL))
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsPosCreateBusinessOnly());
        if (account.get().frozen)
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsFrozen(account.get()));
        if (!player.hasPermission(Permissions.POS_CREATE_OTHER) && !account.get().owner.equals(player))
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsNotAccountOwner());

        @Nullable String description = args.length > 2 ? String.join(" ", Arrays.copyOfRange(args, 2, args.length)) : null;
        if (description != null && description.length() > 64) description = description.substring(0, 64);

        if (description != null && (description.contains("<") || description.contains(">")))
            return sendMessage(sender, BankAccounts.getInstance().config().messagesErrorsDisallowedCharacters("<>"));

        final @NotNull POS pos = new POS(target.getLocation(), price, description, account.get(), new Date());
        pos.save();
        return sendMessage(sender, BankAccounts.getInstance().config().messagesPosCreated(pos));
    }

    @Override
    public @NotNull ArrayList<@NotNull String> tab(final @NotNull CommandSender sender, final @NotNull String @NotNull [] args) {
        final @NotNull ArrayList<@NotNull String> suggestions = new ArrayList<>();
        if (sender.hasPermission(Permissions.POS_CREATE) && sender instanceof Player && args.length == 1) {
            final @NotNull Account[] accounts = sender.hasPermission(Permissions.POS_CREATE_OTHER) ? Account.get() : Account.get(BankAccounts.getOfflinePlayer(sender));
            for (final @NotNull Account account : accounts) {
                if (account.frozen || (account.type == Account.Type.PERSONAL && !BankAccounts.getInstance().config().posAllowPersonal() && !sender.hasPermission(Permissions.POS_CREATE_PERSONAL)))
                    continue;
                suggestions.add(account.id);
            }
        }
        return suggestions;
    }
}
