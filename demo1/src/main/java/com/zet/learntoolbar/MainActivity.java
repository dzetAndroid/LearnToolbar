package com.zet.learntoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final Handler mHandler = new Handler();
    private Button mBtnJump;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        viewAction();
    }

    private void viewAction() {
        Toast.makeText(this, "0.5秒后, 跳转...", Toast.LENGTH_SHORT).show();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                clickJump();
            }
        }, 500);
    }

    private void clickJump() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    private void initView() {
        mBtnJump = (Button) findViewById(R.id.mBtnJump);
        mBtnJump.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBtnJump:
                clickJump();
                break;
        }
    }
}
