package com.example.supermarket;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SuperMarketDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ratings.dp";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_CONTACT =

            "create table rating (_id integer primary key autoincrement,"
                    + "supermarketname text not null, streetaddress text,"
                    + "city text, state text, zipcode text, "
                    + "liquordept text, producedept text, meatdept text,"
                    + "cheeseselection text, easeofcheckout text);";

    public SuperMarketDBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_CONTACT);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(SuperMarketDBHelper.class.getName(),
                "Upgrading database from version" + oldVersion + " to "
                        + newVersion + ", which will destroy all the old data");
        db.execSQL("DROP TABLE IF EXISTS contact");
        onCreate(db);
    }
}

