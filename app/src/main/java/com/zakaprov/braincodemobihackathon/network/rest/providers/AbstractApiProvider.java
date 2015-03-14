package com.zakaprov.braincodemobihackathon.network.rest.providers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public abstract class AbstractApiProvider<ApiType>
{
    protected RestAdapter restAdapter;
    protected ApiType apiClient;

    final Class<ApiType> parameterApiType;

    protected abstract RequestInterceptor getRequestInterceptor();
    protected abstract String getEndPoint();



    public ApiType getRestClient(Class<ApiType> apiType)
    {
        ApiType client = null;
        client = restAdapter.create(apiType);
        return client;
    }

    protected AbstractApiProvider(Class<ApiType> apiType)
    {
        this.parameterApiType = apiType;
        initRestAdapter();
        apiClient = getRestClient(parameterApiType);
    }

    protected void initRestAdapter()
    {
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(getEndPoint())
                .setConverter(createGSONConverter())
                .setClient(new OkClient())
//                .setRequestInterceptor(getRequestInterceptor())
                .build();

    }

    protected GsonConverter createGSONConverter()
    {
        Gson gson = new GsonBuilder().create();
        return new GsonConverter(gson);
    }

    public ApiType getApiClient()
    {
        if (apiClient == null)
            apiClient = getRestClient(parameterApiType);

        return apiClient;
    }

}