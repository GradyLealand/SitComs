package com.mobileapp.grady.sitcomsitdown.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.os.Debug;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

import com.mobileapp.grady.sitcomsitdown.R;
import com.mobileapp.grady.sitcomsitdown.models.Sitcom;
import com.mobileapp.grady.sitcomsitdown.models.SitcomCharacter;

public class SitcomDBHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "sitcom.db";
    private static final int DATABASE_VERSION = 1;
    private static final String SITCOM_TABLE_NAME = "Sitcoms";
    private static final String COLUMN_SITCOM_ID = "sitcom_id";
    private static final String COLUMN_SITCOM_NAME = "sitcom_name";
    private static final String COLUMN_SITCOM_IMAGE = "sitcom_image";
    private static final String CHARACTER_TABLE_NAME = "SitcomCharacters";
    private static final String COLUMN_CHARACTER_ID = "character_id";
    private static final String COLUMN_CHARACTER_NAME = "character_name";
    private static final String COLUMN_CHARACTER_DETAILS = "character_details";
    private static final String COLUMN_CHARACTER_IMAGE = "character_image";
    private static final String COLUMN_CHARACTER_SITCOM_ID = "sitcom_id";
    private Context dbContext;



    /**
     * Database constructor
     * @param context Current context
     */
    public SitcomDBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        dbContext = context;
    }

    /**
     * Build the DB
     * @param db The DB to be built
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" CREATE TABLE " + SITCOM_TABLE_NAME + " (" +
                COLUMN_SITCOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SITCOM_NAME + " TEXT NOT NULL, " +
                COLUMN_SITCOM_IMAGE + " INTEGER NOT NULL);"
        );

        db.execSQL(" CREATE TABLE " + CHARACTER_TABLE_NAME + " (" +
                COLUMN_CHARACTER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_CHARACTER_NAME + " TEXT NOT NULL, " +
                COLUMN_CHARACTER_DETAILS + " TEXT NOT NULL, " +
                COLUMN_CHARACTER_IMAGE + " TEXT," +
                COLUMN_CHARACTER_SITCOM_ID + " INTEGER NOT NULL);"
        );

        //get sitcom table default information
        String[] names = dbContext.getResources().getStringArray(R.array.sitcom_names) ;
        int[] covers = dbContext.getResources().getIntArray(R.array.cover_ids);

        ContentValues values = new ContentValues();

        //populate sitcoms table
        for(int i = 0; i < names.length; i++ )
        {
            values.put(COLUMN_SITCOM_NAME, names[i]);
            values.put(COLUMN_SITCOM_IMAGE, covers[i]);
            db.insert(SITCOM_TABLE_NAME,null, values);
        }

        //get character table default information
        String[] characters =  dbContext.getResources().getStringArray(R.array.charcter_names);
        String[] details =  dbContext.getResources().getStringArray(R.array.character_details);
        int [] sitcomId =  dbContext.getResources().getIntArray(R.array.character_sitcom_ids);

        //populate character table
        for(int i = 0; i < characters.length; i++ )
        {
            values.clear();
            values.put(COLUMN_CHARACTER_NAME, characters[i]);
            values.put(COLUMN_CHARACTER_DETAILS, details[i]);
            values.put(COLUMN_CHARACTER_IMAGE, "");
            values.put(COLUMN_CHARACTER_SITCOM_ID, sitcomId[i]);
            try{
                db.insert(CHARACTER_TABLE_NAME,null, values);
            }
            catch(Exception exception)
            {

            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + SITCOM_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CHARACTER_TABLE_NAME);
        this.onCreate(db);
    }

    /**
     * Get a list of all sitcoms in the DB
     * @return A list of sitcoms
     */
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
                int image = cursor.getInt(cursor.getColumnIndex(COLUMN_SITCOM_IMAGE));

                //build new sitcom object and add it to the list
                sitcom = new Sitcom(id, name, image);
                sitcomList.add(sitcom);

            }while (cursor.moveToNext());
        }
        return sitcomList;
    }

    /**
     * Get a list of characters for the selected sitcom
     * @param id The selected sitcoms id
     * @return A list of characters
     */
    public List<SitcomCharacter> getCharacters(int id)
    {
        String query = "SELECT * FROM " + SITCOM_TABLE_NAME;

        List<SitcomCharacter> characterList = new LinkedList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        SitcomCharacter sitcomCharacter;

        if(cursor.moveToFirst())
        {
            do
            {
                //get characters information from the DB
                int charId = cursor.getInt(cursor.getColumnIndex(COLUMN_SITCOM_ID));
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_SITCOM_NAME));
                String details = cursor.getString(cursor.getColumnIndex(COLUMN_SITCOM_NAME));

                //add character to the list
                sitcomCharacter = new SitcomCharacter(charId, name, details, "");
                characterList.add(sitcomCharacter);

            }while (cursor.moveToNext());
        }
        return characterList;
    }
}
