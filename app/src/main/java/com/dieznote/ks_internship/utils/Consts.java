package com.dieznote.ks_internship.utils;

public class Consts {
    public final static String PREFS_NAME = "com.example.android.ksinternship.SETTINGS";
    public final static String PREFS_POKE = "PREFS_POKE";
    public final static String PREFS_DONT_CLEAR_LIST = "PREFS_DONT_CLEAR_LIST";
    public final static String PREFS_POKE_LIST = "PREFS_POKE_LIST";

    // Configuration of a CursorLoader
    public final static int LOADER_ID = 0;

    // Configuration of a database
    public final static String DB_NAME = "internship_app_db";
    public final static String DB_TABLE_NAME = "pokemons";
    public final static String DB_COL_ID_PRIMARY = "_id";
    public final static String DB_COL_ID = "pokeId";
    public final static String DB_COL_NAME = "pokeName";
    public final static String DB_COL_SPECIES = "pokeSpecies";
    public final static String DB_COL_WEIGHT = "pokeWeight";
    public final static String DB_COL_HEIGHT = "pokeHeight";
    public final static String DB_COL_URL = "pokeURL";
    public final static String DB_COL_POKE_AVATAR = "pokeAvatar";
    public final static String DB_COL_POKE_TYPE = "pokeType";
    public final static int DB_VERSION = 1;

    // SQL Query
    public static final String DB_CREATE =
            "create table " + DB_TABLE_NAME + "(" +
                    DB_COL_ID_PRIMARY + " integer primary key autoincrement, " +
                    DB_COL_ID + " integer, " +
                    DB_COL_SPECIES + " text, " +
                    DB_COL_WEIGHT + " text, " +
                    DB_COL_HEIGHT + " text, " +
                    DB_COL_URL + " text," +
                    DB_COL_NAME + " text," +
                    DB_COL_POKE_AVATAR + " text," +
                    DB_COL_POKE_TYPE + " text," +
                    " UNIQUE ( " + DB_COL_ID + " ) ON CONFLICT IGNORE" +
                    ");";

    public static final String DB_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DB_TABLE_NAME;

}

