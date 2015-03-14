package com.zakaprov.braincodemobihackathon.callbacks;

import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.Offer;

/**
 * Created by kacper on 14.03.15.
 */
public interface OfferCallback {

    public void onDownloadComplete(Offer result);
}
