package com.zakaprov.braincodemobihackathon.callbacks;

import com.zakaprov.braincodemobihackathon.model.Auction;

public interface InterestAuctionsCallback
{
    public void onDownloadComplete(Auction[] result);
}
