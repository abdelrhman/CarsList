package com.podo.carslist.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.podo.carslist.model.Car;

import java.io.IOException;
import java.util.ArrayList;

public class DataAdapter {
    protected static final String TAG = "DataAdapter";
    static final String CARS_TABLE = "cars";
    static final String CAR_COLUMN_ID = "id";
    static final String CAR_COLUMN_MODEL = "model";
    static final String CAR_COLUMN_MANUFACTURER = "manufacturer";
    static final String CAR_COLUMN_THUMBNAIL_SMALL = "thumbnail_small";
    static final String CAR_COLUMN_THUMBNAIL_LARGE = "thumbnail_large";
    static final String CAR_COLUMN_ENGINE_SIZE= "engine_size";
    static final String CAR_COLUMN_ENGINE_SPEED= "speed";
    static final String CAR_COLUMN_ENGINE_ACCELERATION= "acceleration";

    private final Context mContext;
    private SQLiteDatabase mDb;
    private DataBaseHelper mDbHelper;

    private static DataAdapter sInstance;

    public static synchronized DataAdapter getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new DataAdapter(context.getApplicationContext());
        }
        return sInstance;
    }

    private DataAdapter(Context context)
    {
        this.mContext = context;
        mDbHelper = new DataBaseHelper(mContext);
    }

    public DataAdapter createDatabase() throws SQLException
    {
        try
        {
            mDbHelper.createDataBase();
        }
        catch (IOException mIOException)
        {
            Log.e(TAG, mIOException.toString() + "  UnableToCreateDatabase");
            throw new Error("UnableToCreateDatabase");
        }
        return this;
    }

    public DataAdapter open() throws SQLException
    {
        try
        {
            mDbHelper.openDataBase();
            mDbHelper.close();
            mDb = mDbHelper.getReadableDatabase();
        }
        catch (SQLException mSQLException)
        {
            Log.e(TAG, "open >>"+ mSQLException.toString());
            throw mSQLException;
        }
        return this;
    }

    public void close()
    {
        mDbHelper.close();
    }

    public ArrayList<Car> getCars() {
        ArrayList<Car> result = new ArrayList<>();
        String sql ="SELECT * FROM \"cars\"";
        Cursor cursor = mDb.rawQuery(sql, null);
        if (cursor!=null && cursor.getCount() > 0){
            while (cursor.moveToNext()){
                result.add(new Car(
                        cursor.getLong(cursor.getColumnIndex(CAR_COLUMN_ID)),
                        cursor.getString(cursor.getColumnIndex(CAR_COLUMN_MODEL)),
                        cursor.getString(cursor.getColumnIndex(CAR_COLUMN_MANUFACTURER)),
                        cursor.getString(cursor.getColumnIndex(CAR_COLUMN_THUMBNAIL_SMALL)),
                        cursor.getString(cursor.getColumnIndex(CAR_COLUMN_THUMBNAIL_LARGE)),
                        cursor.getInt(cursor.getColumnIndex(CAR_COLUMN_ENGINE_SIZE)),
                        cursor.getInt(cursor.getColumnIndex(CAR_COLUMN_ENGINE_ACCELERATION)),
                        cursor.getInt(cursor.getColumnIndex(CAR_COLUMN_ENGINE_SPEED))
                ));
            }




        }
        return  result;
    }
}