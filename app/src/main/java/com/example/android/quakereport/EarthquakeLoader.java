package com.example.android.quakereport;

import android.content.Context;
import android.content.AsyncTaskLoader;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amani on 17-12-2017.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {
    public static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;

    public EarthquakeLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        Log.v(LOG_TAG, "onStartLoading called");
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        Log.v(LOG_TAG, "loadInBackground called");
        if(mUrl == null) {
            return null;
        }

        ArrayList<Earthquake> earthquake = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquake;

    }

}

