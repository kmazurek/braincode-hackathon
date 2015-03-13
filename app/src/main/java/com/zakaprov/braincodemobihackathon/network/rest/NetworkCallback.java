package com.zakaprov.braincodemobihackathon.network.rest;

import android.util.Log;

import retrofit.RetrofitError;

public abstract class NetworkCallback<ModelType>
{
    public abstract void onSuccess(ModelType object);

    public void onFailure(RetrofitError error)
    {
        Log.e(this.getClass().getName(), error.getMessage());
    }
}
