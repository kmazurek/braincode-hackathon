package com.zakaprov.braincodemobihackathon.model;

import com.zakaprov.braincodemobihackathon.callbacks.InterestContainerCallback;

public class InterestContainer
{
    private Interest[] interests;

    public InterestContainer() {
        interests = new Interest[9];
        interests[0] = new GameInterest("Half Life 3");
        interests[1] = new GameInterest("Assassins Creed");
        interests[2] = new GameInterest("League of Legends");

        interests[3] = new BandInterest("Metallica");
        interests[4] = new BandInterest("Red Hot Chili Peppers");
        interests[5] = new BandInterest("Iron Maiden");

        interests[6] = new BookInterest("50 Shades of Grey");
        interests[7] = new BookInterest("Lord of The Rings");

        interests[8] = new MovieInterest("Interstellar");
    }

    public void getInterestsAsync(InterestContainerCallback callback)
    {
        // TODO
        callback.onDownloadComplete(interests);
    }
}
