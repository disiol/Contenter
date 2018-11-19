package com.denis.counter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button mCrowsCounterButton;
    private Button mCatsCounterButton;
    private TextView mInfoTextView;
    private Button mCounterOfCatsButton;
    private Button mCrowsAndCatsCountersButton;
    private Button mResetCountersButton;
    private Button mExitButton;

    private static final String KEY_COUNT_CROWS = "COUNT_CROWS";
    private static final String KEY_COUNT_CATS = "COUNT_CATS";
    private static final String KEY_TEXT_INFO_TEXT_VIEW = "TEXT_INFO_TEXT_VIEW";

    private int mCountCrows = 0;
    private int mCountCats = 0; //TODO хохранять переменные при повороте
    private String TAG = "my log";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCrowsCounterButton = (Button) findViewById(R.id.crowsCounterButton);
        mCounterOfCatsButton = (Button) findViewById(R.id.counterOfCatsButton);
        mCrowsAndCatsCountersButton = (Button) findViewById(R.id.crowsAndCatsCountersButton);
        mResetCountersButton = (Button) findViewById(R.id.resetCountersButton);
        mExitButton = (Button) findViewById(R.id.exitButton);
        mInfoTextView = (TextView) findViewById(R.id.InfoTextView);


        doWhenScreenRoot(savedInstanceState);


    }

    private void doWhenScreenRoot(Bundle savedInstanceState) {
        if (savedInstanceState != null) {

            mCountCrows = savedInstanceState.getInt(KEY_COUNT_CROWS, 0);
            mCountCats = savedInstanceState.getInt(KEY_COUNT_CATS, 0);

            String mInfoTextViewText;
            mInfoTextViewText = savedInstanceState.getString(KEY_TEXT_INFO_TEXT_VIEW, "");
            Log.d(TAG, "mInfoTextViewText = " + mInfoTextViewText);

            mInfoTextView.setText(mInfoTextViewText);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT_CROWS, mCountCrows);
        outState.putInt(KEY_COUNT_CATS, mCountCats);
        outState.putString(KEY_TEXT_INFO_TEXT_VIEW, mInfoTextView.getText().toString());
    }

    public void onClickButtonHello(View view) {

        mInfoTextView.setText(getString(R.string.InfoTextViewText));

    }

    public void onClickCrowsCounterButton(View view) {
        mInfoTextView.setText("Я насчитал " + ++mCountCrows + " ворон");
    }


    public void onClickCounterOfCatsButton(View view) {
        mInfoTextView.setText("Я насчитал " + ++mCountCats + " котов");
    }

    public void onClickCrowsAndCatsCountersButton(View view) {
        mInfoTextView.setText("Я насчитал " + mCountCats + " котов и " + mCountCrows + " ворон");

    }

    public void onClickResetCountersButton(View view) {
        mCountCrows = 0;
        mCountCats = 0;

        mInfoTextView.setText("Я насчитал " + mCountCats + " котов и " + mCountCrows + " ворон");


    }

    public void onClickExitButton(View view) {
        finish();
    }
}
