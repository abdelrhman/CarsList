package com.podo.carslist;

import android.app.Application;

import com.podo.carslist.database.DataAdapter;

/**
 * Created by podo on 4/2/16.
 */
public class CarsListApplication extends Application {
    DataAdapter mDbHelper;
    @Override
    public void onCreate() {
        super.onCreate();
        mDbHelper = DataAdapter.getInstance(getApplicationContext());
        mDbHelper.createDatabase();
        mDbHelper.open();
    }


}

