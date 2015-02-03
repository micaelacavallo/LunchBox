package com.example.micaelacavallo.lunchbox;


import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class LunchOptionsActivity extends Activity implements LunchOptionsFragment.ChangeListener{

    LunchOptionsFragment mLunchOptionsFragment;
    Boolean mLoggedIn=false;
    final static Integer REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLunchOptionsFragment = new LunchOptionsFragment();
        insertFragment();
        if (findViewById(R.id.lunchbox) != null){
            LunchSummaryFragment lunchSummaryFragment = new LunchSummaryFragment();
           mLunchOptionsFragment.setTargetFragment(lunchSummaryFragment, REQUEST_CODE);
            performLunchSummaryFragmentTransaction(lunchSummaryFragment);
        }
    }

    private void insertFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.options, mLunchOptionsFragment ).commit();

    }

    private void performLunchSummaryFragmentTransaction(LunchSummaryFragment lunchSummaryFragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().
                replace(R.id.lunchbox, lunchSummaryFragment).
                commit();
    }

    private void showSummaryInActivity(String summary) {
        Intent intent = new Intent (LunchOptionsActivity.this, LunchSummaryActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT, summary);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Boolean handled = false;
        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.action_login:
                handled = true;
                launchLogin();
                break;
            case R.id.action_settings:
                handled = true;
                break;
        }
        if (id == R.id.action_settings) {
            return true;
        }
        if (!handled)
        {
            handled = super.onOptionsItemSelected(item);
        }

        return handled;
    }

    private void launchLogin() {
        Intent intent = new Intent (this, LoginActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLunchOptionsFragment.enableAuthorizedOptions(mLoggedIn);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                mLoggedIn=true;
            }
            else
            {
                mLoggedIn=false;
            }
    }
}

    @Override
    public void onLunchChange(String options) {
        showSummaryInActivity(options);
    }
}
