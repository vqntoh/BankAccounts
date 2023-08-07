package pro.cloudnode.smp.bankaccounts;

import org.jetbrains.annotations.NotNull;

/*public final class BankConfig {
    public final static @NotNull String DB_DB = "db.db";
    public final static @NotNull String DB_SQLITE_FILE = "db.sqlite.file";
    public final static @NotNull String DB_MARIADB_JDBC = "db.mariadb.jdbc";
    public final static @NotNull String DB_MARIADB_USER = "db.mariadb.user";
    public final static @NotNull String DB_MARIADB_PASSWORD = "db.mariadb.password";
    public final static @NotNull String DB_CACHEPREPSTMTS = "db.cachePrepStmts";
    public final static @NotNull String DB_PREPSTMTCACHESIZE = "db.prepStmtCacheSize";
    public final static @NotNull String DB_PREPSTMTCACHESQLLIMIT = "db.prepStmtCacheSqlLimit";
    public final static @NotNull String DB_USESERVERPREPSTMTS = "db.useServerPrepStmts";
    public final static @NotNull String DB_USELOCALSESSSIONSTATE = "db.useLocalSessionState";
    public final static @NotNull String DB_REWRITEBATCHEDSTATEMENTS = "db.rewriteBatchedStatements";
    public final static @NotNull String DB_CACHERESULTSETMETADATA = "db.cacheResultSetMetadata";
    public final static @NotNull String DB_CACHESERVERCONFIGURATION = "db.cacheServerConfiguration";
    public final static @NotNull String DB_ELIDESETAUTOCOMMITS = "db.elideSetAutoCommits";
    public final static @NotNull String DB_MAINTAINTIMESTATS = "db.maintainTimeStats";
}*/
public enum BankConfig {
    DB_DB("db.db"),
    DB_SQLITE_FILE("db.sqlite.file"),
    DB_MARIADB_JDBC("db.mariadb.jdbc"),
    DB_MARIADB_USER("db.mariadb.user"),
    DB_MARIADB_PASSWORD("db.mariadb.password"),
    DB_CACHEPREPSTMTS("db.cachePrepStmts"),
    DB_PREPSTMTCACHESIZE("db.prepStmtCacheSize"),
    DB_PREPSTMTCACHESQLLIMIT("db.prepStmtCacheSqlLimit"),
    DB_USESERVERPREPSTMTS("db.useServerPrepStmts"),
    DB_USELOCALSESSSIONSTATE("db.useLocalSessionState"),
    DB_REWRITEBATCHEDSTATEMENTS("db.rewriteBatchedStatements"),
    DB_CACHERESULTSETMETADATA("db.cacheResultSetMetadata"),
    DB_CACHESERVERCONFIGURATION("db.cacheServerConfiguration"),
    DB_ELIDESETAUTOCOMMITS("db.elideSetAutoCommits"),
    DB_MAINTAINTIMESTATS("db.maintainTimeStats"),
    CURRENCY_SYMBOL("currency.symbol"),
    CURRENCY_FORMAT("currency.format"),
    STARTING_BALANCE("starting-balance"),
    PREVENT_CLOSE_LAST_PERSONAL("prevent-close-last-personal"),
    SERVER_ACCOUNT_ENABLED("server-account.enabled"),
    SERVER_ACCOUNT_NAME("server-account.name"),
    SERVER_ACCOUNT_TYPE("server-account.type"),
    SERVER_ACCOUNT_STARTING_BALANCE("server-account.starting-balance"),
    ACCOUNT_LIMITS_PERSONAL("account-limits.0"),
    ACCOUNT_LIMITS_BUSINESS("account-limits.1"),
    TRANSFER_CONFIRMATION_ENABLED("transfer-confirmation.enabled"),
    TRANSFER_CONFIRMATION_MIN_AMOUNT("transfer-confirmation.min-amount"),
    TRANSFER_CONFIRMATION_BYPASS_OWN_ACCOUNTS("transfer-confirmation.bypass-own-accounts"),
    HISTORY_PER_PAGE("history.per-page"),
    INSTRUMENTS_MATERIAL("instruments.material"),
    INSTRUMENTS_REQUIRE_ITEM("instruments.require-item"),
    INSTRUMENTS_NAME("instruments.name"),
    INSTRUMENTS_LORE("instruments.lore"),
    INSTRUMENTS_GLINT_ENABLED("instruments.glint.enabled"),
    INSTRUMENTS_ENCHANTMENT("instruments.glint.enchantment"),
    POS_ALLOW_PERSONAL("pos.allow-personal"),
    POS_TITLE("pos.title"),
    POS_INFO_MATERIAL("pos.info.material"),
    POS_INFO_GLINT("pos.info.glint"),
    POS_INFO_NAME_OWNER("pos.info.name-owner"),
    POS_INFO_NAME_BUYER("pos.info.name-buyer"),
    POS_INFO_LORE_OWNER("pos.info.lore-owner"),
    POS_INFO_LORE_BUYER("pos.info.lore-buyer"),
    POS_DELETE_MATERIAL("pos.delete.material"),
    POS_DELETE_GLINT("pos.delete.glint"),
    POS_DELETE_NAME("pos.delete.name"),
    POS_DELETE_LORE("pos.delete.lore"),
    POS_CONFIRM_MATERIAL("pos.confirm.material"),
    POS_CONFIRM_GLINT("pos.confirm.glint"),
    POS_CONFIRM_NAME("pos.confirm.name"),
    POS_CONFIRM_LORE("pos.confirm.lore"),
    POS_DECLINE_MATERIAL("pos.decline.material"),
    POS_DECLINE_GLINT("pos.decline.glint"),
    POS_DECLINE_NAME("pos.decline.name"),
    POS_DECLINE_LORE("pos.decline.lore"),
    MESSAGES_COMMAND_USAGE("messages.command-usage"),
    MESSAGES_ERRORS_NO_ACCOUNTS("messages.errors.no-accounts"),
    MESSAGES_ERRORS_NO_PERMISSION("messages.errors.no-permission"),
    MESSAGES_ERRORS_ACCOUNT_NOT_FOUND("messages.errors.account-not-found"),
    MESSAGES_ERRORS_UNKNOWN_COMMAND("messages.errors.unknown-command"),
    MESSAGES_ERRORS_MAX_ACCOUNTS("messages.errors.max-accounts"),
    MESSAGES_ERRORS_RENAME_PERSONAL("messages.errors.rename-personal"),
    MESSAGES_ERRORS_NOT_ACCOUNT_OWNER("messages.errors.not-account-owner"),
    MESSAGES_ERRORS_FROZEN("messages.errors.frozen"),
    MESSAGES_ERRORS_SAME_FROM_TO("messages.errors.same-from-to"),
    MESSAGES_ERRORS_TRANSFER_SELF_ONLY("messages.errors.transfer-self-only"),
    MESSAGES_ERRORS_TRANSFER_OTHER_ONLY("messages.errors.transfer-other-only"),
    MESSAGES_ERRORS_INVALID_NUMBER("messages.errors.invalid-number"),
    MESSAGES_ERRORS_NEGATIVE_TRANSFER("messages.errors.negative-transfer"),
    MESSAGES_ERRORS_INSUFFICIENT_FUNDS("messages.errors.insufficient-funds"),
    MESSAGES_ERRORS_CLOSING_BALANCE("messages.errors.closing-balance"),
    MESSAGES_ERRORS_CLOSING_PERSONAL("messages.errors.closing-personal"),
    MESSAGES_ERRORS_PLAYER_ONLY("messages.errors.player-only"),
    MESSAGES_ERRORS_PLAYER_NOT_FOUND("messages.errors.player-not-found"),
    MESSAGES_ERRORS_INSTRUMENT_REQUIRES_ITEM("messages.errors.instrument-requires-item"),
    MESSAGES_ERRORS_TARGET_INVENTORY_FULL("messages.errors.target-inventory-full"),
    MESSAGES_ERRORS_BLOCK_TOO_FAR("messages.errors.block-too-far"),
    MESSAGES_ERRORS_POS_ALREADY_EXISTS("messages.errors.pos-already-exists"),
    MESSAGES_ERRORS_POS_NOT_CHEST("messages.errors.pos-not-chest"),
    MESSAGES_ERRORS_POS_EMPTY("messages.errors.pos-empty"),
    MESSAGES_ERRORS_POS_INVALID_CARD("messages.errors.pos-invalid-card"),
    MESSAGES_ERRORS_POS_NO_PERMISSION("messages.errors.pos-no-permission"),
    MESSAGES_ERRORS_CARD_NO_PERMISSION("messages.errors.card-no-permission"),
    MESSAGES_ERRORS_NO_CARD("messages.errors.no-card"),
    MESSAGES_ERRORS_POS_ITEMS_CHANGED("messages.errors.pos-items-changed"),
    MESSAGES_ERRORS_POS_CREATE_BUSINESS_ONLY("messages.errors.pos-create-business-only"),
    MESSAGES_ERRORS_DISALLOWED_CHARACTERS("messages.errors.disallowed-characters"),
    MESSAGES_BALANCE("messages.balance"),
    MESSAGES_LIST_ACCOUNTS_HEADER("messages.list-accounts.header"),
    MESSAGES_LIST_ACCOUNTS_ENTRY("messages.list-accounts.entry"),
    MESSAGES_RELOAD("messages.reload"),
    MESSAGES_ACCOUNT_CREATED("messages.account-created"),
    MESSAGES_BALANCE_SET("messages.balance-set"),
    MESSAGES_NAME_SET("messages.name-set"),
    MESSAGES_ACCOUNT_DELETED("messages.account-deleted"),
    MESSAGES_CONFIRM_TRANSFER("messages.confirm-transfer"),
    MESSAGES_TRANSFER_SENT("messages.transfer-sent"),
    MESSAGES_TRANSFER_RECEIVED("messages.transfer-received"),
    MESSAGES_HISTORY_HEADER("messages.history.header"),
    MESSAGES_HISTORY_ENTRY("messages.history.entry"),
    MESSAGES_HISTORY_FOOTER("messages.history.footer"),
    MESSAGES_HISTORY_NO_TRANSACTIONS("messages.history.no-transactions"),
    MESSAGES_INSTRUMENT_CREATED("messages.instrument-created"),
    MESSAGES_POS_CREATED("messages.pos-created"),
    MESSAGES_POS_REMOVED("messages.pos-removed"),
    MESSAGES_POS_PURCHASE("messages.pos-purchase"),
    MESSAGES_POS_PURCHASE_SELLER("messages.pos-purchase-seller"),
    MESSAGES_WHOIS("messages.whois");

    private final @NotNull String key;

    BankConfig(@NotNull String key) {
        this.key = key;
    }

    public @NotNull String getKey() {
        return key;
    }
}
