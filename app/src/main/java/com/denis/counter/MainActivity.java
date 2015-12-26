package com.denis.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    private int mCountCrows = 0;
    private int mCountCats = 0;


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


    }

    public void onClickButtonHello(View view) {
        mInfoTextView.setText("Hello");

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
        System.exit(0);
    }
}
