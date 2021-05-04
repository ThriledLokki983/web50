module com.company.db {
    exports com.company.db;
    requires java.sql;
    requires sqlite.jdbc;

    requires transitive com.company.common;
}