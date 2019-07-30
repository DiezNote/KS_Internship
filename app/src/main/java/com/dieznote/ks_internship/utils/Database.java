package com.dieznote.ks_internship.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dieznote.ks_internship.models.NetResponse;

import java.util.List;

public class Database {
    private final Context ctx;

    private DBHelper dbHelper;

    private SQLiteDatabase mDB;

    public Database(Context ctx) {
        this.ctx = ctx;
    }

    public void open() {
        dbHelper = new DBHelper(ctx, Consts.DB_NAME, null, Consts.DB_VERSION);
        mDB = dbHelper.getWritableDatabase();
    }

    public void close() {
        if (dbHelper != null) {
            dbHelper.close();
        }
    }

    public Cursor getAllData() {
        return mDB.query(Consts.DB_TABLE_NAME, null, null, null, null, null, Consts.DB_COL_ID_PRIMARY + " DESC");
    }

    public void clearData() {
        mDB.delete(Consts.DB_TABLE_NAME, null, null);
    }

    private void addRec(NetResponse item) {
        ContentValues cv = new ContentValues();
        cv.put(Consts.DB_COL_ID, item.getId());
        cv.put(Consts.DB_COL_SPECIES, item.getPokeSpecies().getName().toString());
        cv.put(Consts.DB_COL_NAME, item.getName());
        cv.put(Consts.DB_COL_URL, item.getPokeForms().get(0).getUrl());
        cv.put(Consts.DB_COL_POKE_AVATAR, item.getPokeSprites().getFront_default());
        cv.put(Consts.DB_COL_POKE_TYPE, item.getPokeTypes().get(0).getName());//выдает только первый из возможного списка
        cv.put(Consts.DB_COL_HEIGHT, item.getHeight());
        cv.put(Consts.DB_COL_WEIGHT, item.getWeight());

        mDB.insert(Consts.DB_TABLE_NAME, null, cv);
    }

    public void addApiData(NetResponse items) {

                addRec(items);

    }
    /*public void addApiData(List<NetResponse> items) {
        if (items.size() != 0) {
            for (int i = items.size() - 1; i >= 0; i--) {
                addRec(items.get(i));
            }
        }
    }*/
   /* public NetResponse getNote(long id) {
        // get readable database as we are not inserting anything
        String TAG="sefse ";
        Log.w(TAG, "ID is GETNOTE =  " + id);

        Cursor cursor = mDB.query(Consts.DB_NAME,
                new String[]{Consts.DB_TABLE_NAME, Consts.DB_COL_ID_PRIMARY,Consts.DB_COL_ID,Consts.DB_COL_NAME,Consts.DB_COL_SPECIES,Consts.DB_COL_WEIGHT,Consts.DB_COL_HEIGHT,Consts.DB_COL_URL, Consts.DB_COL_POKE_AVATAR, Consts.DB_COL_POKE_TYPE},
                Consts.DB_COL_ID_PRIMARY + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        // prepare note object
        Note note = new Note(
                cursor.getInt(cursor.getColumnIndex(Consts.COLUMN_ID)),
                cursor.getInt(cursor.getColumnIndex(Consts.COLUMN_KolvoAlt)),
                cursor.getInt(cursor.getColumnIndex(Consts.COLUMN_KolvoKrit)),
                cursor.getString(cursor.getColumnIndex(Consts.COLUMN_AltNames)),
                cursor.getString(cursor.getColumnIndex(Consts.COLUMN_KritNames)),
                cursor.getString(cursor.getColumnIndex(Consts.COLUMN_KritValues)),
                cursor.getString(cursor.getColumnIndex(Consts.COLUMN_DopolnitZnach)),
                cursor.getString(cursor.getColumnIndex(Consts.COLUMN_Decision)),
                cursor.getString(cursor.getColumnIndex(Consts.COLUMN_TIMESTAMP)));

        // close the db connection
        cursor.close();

        return note;
    }*/

    /**
     * Subclass of {@link android.database.sqlite.SQLiteOpenHelper} which provides custom database helper.
     */
    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(Consts.DB_CREATE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL(Consts.DB_DELETE_ENTRIES);
            onCreate(db);
        }
    }

}
