package com.zakaprov.braincodemobihackathon.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Token
{
    @SerializedName("access_token")
    @Expose
    private String token;
    @SerializedName("token_type")
    @Expose
    private String tokenType;
    @SerializedName("expires_in")
    @Expose
    private Integer expiresIn;

    public String getToken()
    {
        return token;
    }

    public String getTokenType()
    {

        return tokenType;
    }

    public void setTokenType(String tokenType)
    {

        this.tokenType = tokenType;
    }

    public Integer getExpiresIn()
    {

        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn)
    {

        this.expiresIn = expiresIn;
    }

    public void setToken(String token)
    {
        this.token = token;
    }
}
