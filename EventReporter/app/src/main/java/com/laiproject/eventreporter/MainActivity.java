package com.laiproject.eventreporter;

import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private EventFragment mListFragment;
    private CommentFragment mGridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        // Get ListView object from xml.
        ListView eventListView = (ListView) findViewById(R.id.event_list);

        // Initialize an adapter.
        EventAdapter adapter = new EventAdapter(this);

        // Assign adapter to ListView.
        eventListView.setAdapter(adapter);*/

/*        // Show different fragments based on screen size.
        if (findViewById(R.id.fragment_container) != null) {
            Fragment fragment = isTablet() ? new  CommentFragment() : new EventFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
            // will keep adding fragment. need to check getSupportFragmentManager().findFragmentById(...) == null
        }*/
        //add list view
        mListFragment = new EventFragment();
        if (getSupportFragmentManager().findFragmentById(R.id.event_container) == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.event_container, mListFragment).commit();
            // if want to update the fragment, use .replace() instead of .add()
        }

        //add Gridview
        if (isTablet()) {
            mGridFragment = new CommentFragment();
            if (getSupportFragmentManager().findFragmentById(R.id.comment_container) == null) {
                getSupportFragmentManager().beginTransaction().add(R.id.comment_container, mGridFragment).commit();
            }
        }
    }

    // xml boolean value depends on screen size
    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

}
