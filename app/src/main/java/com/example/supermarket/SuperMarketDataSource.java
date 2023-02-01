package com.example.supermarket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SuperMarketDataSource {
    private SQLiteDatabase database;
    private SuperMarketDBHelper dbHelper;
    //declared to hold instances of the SQLite database and helper class

    public SuperMarketDataSource(Context context ){
        dbHelper = new SuperMarketDBHelper(context);
    } // helper class instantiated when data source is instantiated


    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public boolean insertRating(Rating c){

        boolean didSucceed = false;
        try {
            database =  dbHelper.getWritableDatabase();
            ContentValues initialValues = new ContentValues();

            initialValues.put("supermarketname", c.getSupermarketName());
            initialValues.put("streetaddress", c.getAddress());
            initialValues.put("city", c.getCity());
            initialValues.put("state", c.getState());
            initialValues.put("zipcode", c.getZipcode());
            initialValues.put("liquordept", c.getLiquorDptRating());
            initialValues.put("producedept", c.getProduceDptRating());
            initialValues.put("meatdept", c.getMeatDptRating());
            initialValues.put("cheeseselection", c.getCheeseSelRating());
            initialValues.put("easeofcheckout", c.getEocRating());


            didSucceed = database.insert("rating", null, initialValues) >0;
        }
        catch (Exception e){
            //Do nothing - will return false if there is an exception
        }
        return didSucceed;
    }
    public boolean updateRating(Rating c ) {
        boolean didSucceed = false;
        try {
            Long rowId = (long) c.getSupermarketID();
            ContentValues updateValues = new ContentValues();

            updateValues.put("liquordept", c.getLiquorDptRating());
            updateValues.put("producedept", c.getProduceDptRating());
            updateValues.put("meatdept", c.getMeatDptRating());
            updateValues.put("cheeseselection", c.getCheeseSelRating());
            updateValues.put("easeofcheckout", c.getEocRating());

            didSucceed = database.update("rating", updateValues, "_id=" +rowId, null) > 0;
        }
        catch (Exception e){
            //Do nothing - will return false if there is an exception
        }
        return didSucceed;
    }

    public int getLastSMID(){
        int lastId;
        try{
            String query = "Select MAX(_id) from rating";
            /*SQL query written to get max val for _id field in contact table -
            _id - auto increment
            * */
            Cursor cursor = database.rawQuery(query, null);
            //cursor is declared and assigned to hold results of exception of query
            //cursor- obj used to hold and move results of query

            cursor.moveToFirst();
            //move to first record in data
            lastId = cursor.getInt(0);
            //max id retreived from record set- fields in record set indexed at 0
            cursor.close();
        }
        catch (Exception e){
            lastId = -1;
        }
        return lastId;
    }

    public int getMarketNameToID(String name) throws Exception{
        String marketIdFromName = name;
        int nameToMarketID;
        String query = "Select _id from rating where supermarketname = '" + marketIdFromName + "'" ;
        Cursor cursor = database.rawQuery(query, null); //query that returns the last (max) _id
//A cursor is declared and assigned to hold the results of the execution of the query. A cursor is an object that is used to hold and move through the results of a query.
        cursor.moveToFirst(); //Cursor is told to move to the first record in the returned data.
        nameToMarketID = cursor.getInt(0);  //The maximum ID is retrieved from the record set. Fields in the record set are indexed starting at 0.
        cursor.close();
        return nameToMarketID;

    }
}
