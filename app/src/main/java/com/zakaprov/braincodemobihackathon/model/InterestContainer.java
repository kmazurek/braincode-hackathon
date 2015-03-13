package com.zakaprov.braincodemobihackathon.model;

import com.zakaprov.braincodemobihackathon.util.InterestContainerCallback;

public class InterestContainer
{
    private Interest[] interests;

    public void getInterestsAsync(InterestContainerCallback callback)
    {
        // TODO
        callback.onDownloadComplete(interests);
    }
}
