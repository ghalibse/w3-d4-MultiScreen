package com.example.simpledoublefragment;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements LeftFragment.CallbackComponent {

    private static final String LEFT_FRAGMENT_TAG = "LEFT_FRAGMENT";
    private static final String RIGHT_FRAGMENT_TAG = "RIGHT_FRAGMENT";

    private static final String TAG = "MainActivityTAG_";

    private LeftFragment mLeftFragment;
    private RightFragment mRightFragment = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int orientation = this.getResources().getConfiguration().orientation;
        Log.d(TAG, "onCreate: " + orientation);

        mLeftFragment = new LeftFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.a_main_left, mLeftFragment, LEFT_FRAGMENT_TAG)
                .commit();

        if (orientation == 2) {
            mRightFragment = new RightFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.a_main_right, mRightFragment, RIGHT_FRAGMENT_TAG)
                    .commit();
        }
    }

    @Override
    public void itemClicked(int name) {

        if (mRightFragment != null && mRightFragment.isAdded()) {
            mRightFragment.loadImage(name);
        }
    }

}
