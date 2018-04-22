package com.mobileapp.grady.sitcomsitdown.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import com.mobileapp.grady.sitcomsitdown.models.Sitcom;
import com.mobileapp.grady.sitcomsitdown.models.Character;

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
                COLUMN_SITCOM_IMAGE + " TEXT NOT NULL);"
        );

        db.execSQL(" CREATE TABLE " + CHARACTER_TABLE_NAME + " (" +
                COLUMN_CHARACTER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CHARACTER_NAME + " TEXT NOT NULL, " +
                COLUMN_CHARACTER_DETAILS + " TEXT NOT NULL, " +
                COLUMN_CHARACTER_IMAGE + " TEXT NOT NULL);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SITCOM_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CHARACTER_TABLE_NAME);
        this.onCreate(db);
    }

    public List<Sitcom> getSitcoms()
    {
        String query = "SELECT  * FROM " + SITCOM_TABLE_NAME;

        List<Sitcom> sitcomList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        Sitcom sitcom;

        if(cursor.moveToFirst())
        {
            do
            {
                //get sitcom information from the db
                int id = cursor.getInt(cursor.getColumnIndex(COLUMN_SITCOM_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_SITCOM_NAME));
                String image = cursor.getString(cursor.getColumnIndex(COLUMN_SITCOM_IMAGE));

                //get character list for sitcom

                //build new sitcom object and add it to the list
                sitcom = new Sitcom(id, name, image);
                sitcomList.add(sitcom);

            }while (cursor.moveToNext());
        }
        return sitcomList;
    }
}
