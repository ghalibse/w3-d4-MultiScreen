package com.example.simpledoublefragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements LeftFragment.CallbackComponent {

    private static final String LEFT_FRAGMENT_TAG = "LEFT_FRAGMENT";
    private static final String RIGHT_FRAGMENT_TAG = "RIGHT_FRAGMENT";

    private static final String TAG = "MainActivityTAG_";

    private LeftFragment mLeftFragment;
    private RightFragment mRightFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLeftFragment = new LeftFragment();
        mRightFragment = new RightFragment();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.a_main_left, mLeftFragment, LEFT_FRAGMENT_TAG)
                .add(R.id.a_main_right, mRightFragment, RIGHT_FRAGMENT_TAG)
                .commit();
    }

    @Override
    public void itemClicked(int name) {

        if (mRightFragment != null && mRightFragment.isAdded()) {
            mRightFragment.loadImage(name);
        }
    }
}
