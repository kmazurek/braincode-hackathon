package com.zakaprov.braincodemobihackathon.model;

import com.zakaprov.braincodemobihackathon.callbacks.InterestContainerCallback;

public class InterestContainer
{
    private Interest[] interests;

    public void getInterestsAsync(InterestContainerCallback callback)
    {
        // TODO
        callback.onDownloadComplete(interests);
    }
}
