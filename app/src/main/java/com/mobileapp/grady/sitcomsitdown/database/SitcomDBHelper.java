package com.mobileapp.grady.sitcomsitdown.database;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;

public class SitcomDBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "sitcom.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SITCOM_TABLE_NAME = "Sitcoms";
    private static final String COLUMN_SITCOM_ID = "sitcom_id";
    private static final String COLUMN_SITCOM_NAME = "sitcom_name";
    private static final String COLUMN_SITCOM_IMAGE = "sitcom_image";
    private static final String CHARACTER_TABLE_NAME = "Characters";
    private static final String COLUMN_CHARACTER_ID = "character_id";
    private static final String COLUMN_CHARACTER_NAME = "character_name";
    private static final String COLUMN_CHARACTER_DETAILS = "character_details";
    private static final String COLUMN_CHARACTER_IMAGE = "character_image";

    /**
     * Database constructor
     * @param context Current context
     */
    public SitcomDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + SITCOM_TABLE_NAME + " (" +
                COLUMN_SITCOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SITCOM_NAME + " TEXT NOT NULL, " +
                COLUMN_SITCOM_IMAGE + " BLOB NOT NULL);"
        );

        db.execSQL(" CREATE TABLE " + CHARACTER_TABLE_NAME + " (" +
                COLUMN_CHARACTER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CHARACTER_NAME + " TEXT NOT NULL, " +
                COLUMN_CHARACTER_DETAILS + " TEXT NOT NULL, " +
                COLUMN_CHARACTER_IMAGE + " BLOB NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
