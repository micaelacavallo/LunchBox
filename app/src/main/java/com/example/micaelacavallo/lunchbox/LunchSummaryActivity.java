package com.example.micaelacavallo.lunchbox;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;


public class LunchSummaryActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch_summary);

        LunchSummaryFragment lunchSummaryFragment = new LunchSummaryFragment();
        passSummaryAsArgumentsToFragment(lunchSummaryFragment);
        insertSummaryFragment(lunchSummaryFragment);

    }

    private void passSummaryAsArgumentsToFragment(LunchSummaryFragment lunchSummaryFragment) {
        String summary = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        Bundle bundle = new Bundle();
        bundle.putString(LunchSummaryFragment.SUMMARY_TEXT, summary);
        lunchSummaryFragment.setArguments(bundle);
    }

    private void insertSummaryFragment(LunchSummaryFragment lunchSummaryFragment ) {
        getFragmentManager().beginTransaction()
                .add(R.id.container, lunchSummaryFragment)
                .commit();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lunch_summary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
