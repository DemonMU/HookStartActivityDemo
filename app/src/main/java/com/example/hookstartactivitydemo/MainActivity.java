package com.example.hookstartactivitydemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

    private Button mJumBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mJumBtn = (Button) findViewById(R.id.jump);
        mJumBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    startActivity(new Intent(v.getContext(), TargetActivity.class));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        try {
            AMSHookHelper.hookActivityManagerNative();
            AMSHookHelper.hookActivityThreadHandler();
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
