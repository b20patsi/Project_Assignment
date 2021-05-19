package com.example.project_assignment;

class DatabaseTable {
    static class Country {

        static final String TABLE_NAME = "country";
        static final String COLUMN_NAME_ID = "id";
        static final String COLUMN_NAME_NAME = "name";
        static final String COLUMN_NAME_COMPANY = "company";
        static final String COLUMN_NAME_LOCATION = "location";
        static final String COLUMN_NAME_URL = "url";
        static final String COLUMN_NAME_COST = "cost";
    }

    static final String SQL_CREATE_TABLE_COUNTRY =
            // "CREATE TABLE country (name STRING PRIMARY KEY, age INT, city TEXT)"
            "CREATE TABLE " + Country.TABLE_NAME + " (" +
                    Country.COLUMN_NAME_ID + " STRING PRIMARY KEY," +
                    Country.COLUMN_NAME_NAME + " STRING," +
                    Country.COLUMN_NAME_COMPANY + " STRING," +
                    Country.COLUMN_NAME_LOCATION + " STRING," +
                    Country.COLUMN_NAME_URL + " STRING," +
                    Country.COLUMN_NAME_COST + " INT)";

    static final String SQL_DELETE_TABLE_COUNTRY =
            // "DROP TABLE IF EXISTS country"
            "DROP TABLE IF EXISTS " + Country.TABLE_NAME;
}