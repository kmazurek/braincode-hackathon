package com.zakaprov.braincodemobihackathon.model;

/**
 * Created by konrad on 13.03.15.
 */
public class GameInterest extends Interest
{
    public GameInterest(String title)
    {
        super(title);
        categories.put("53451", "Figurki");
        categories.put("53452", "Koszulki");
        categories.put("147902", "Kubki");
        categories.put("147903", "Plakaty");
        categories.put("53453", "Pozostałe");

        fancyStrings = new String[] {"Get some gadgets from", "See what's available for", "Check out some merchandise for",
                        "Order great gadgets from"};

        generateFancyText();
    }

}
