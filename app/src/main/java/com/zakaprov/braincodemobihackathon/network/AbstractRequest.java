package com.zakaprov.braincodemobihackathon.network;

public abstract class AbstractRequest
{
    public enum Types
    {
        GET, POST, DELETE
    }

    public abstract void execute();
}
