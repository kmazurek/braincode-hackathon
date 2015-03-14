package com.zakaprov.braincodemobihackathon;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zakaprov.braincodemobihackathon.fragments.AuctionListFragment;
import com.zakaprov.braincodemobihackathon.fragments.MainListFragment;
import com.zakaprov.braincodemobihackathon.model.Auction;
import com.zakaprov.braincodemobihackathon.model.Interest;


public class MainActivity extends ActionBarActivity
{
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private String[] mNavigationItems;

    private Interest chosenInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationItems = getResources().getStringArray(R.array.array_navigation_drawer_items);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerList = (ListView) findViewById(R.id.navigationDrawer);

        mDrawerList.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, mNavigationItems));
        mDrawerList.setOnItemClickListener(new NavigationDrawerListener());
    }

    private class NavigationDrawerListener implements AdapterView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            Fragment chosenFragment = null;

                switch(position)
                {
                    case 0:
                    chosenFragment = new MainListFragment();
                    break;

                    case 1:
                    case 2:
                    case 3:
                    case 4:
                }

            changeFragment(chosenFragment);

            mDrawerList.setItemChecked(position, true);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
    }

    public void onChooseInterest(Interest interest)
    {
        chosenInterest = interest;
        AuctionListFragment newFragment = new AuctionListFragment();
        newFragment.setChosenInterest(interest);
        changeFragment(newFragment);
    }

    public void onChooseAuction(Auction auction)
    {
        // TODO go to auction details fragment
    }

    private void changeFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }

    public Interest getChosenInterest()
    {
        return chosenInterest;
    }

    public void setChosenInterest(Interest interest)
    {
        chosenInterest = interest;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
            return true;

        return super.onOptionsItemSelected(item);
    }
}
