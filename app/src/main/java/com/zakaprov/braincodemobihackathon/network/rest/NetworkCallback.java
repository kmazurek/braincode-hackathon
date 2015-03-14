package com.zakaprov.braincodemobihackathon.network.rest;

import android.util.Log;

import retrofit.Callback;
import retrofit.RetrofitError;

public abstract class NetworkCallback<ModelType> implements Callback<ModelType>
{
    public void failure(RetrofitError error)
    {
        Log.e(this.getClass().getName(), error.getMessage());
    }
}
