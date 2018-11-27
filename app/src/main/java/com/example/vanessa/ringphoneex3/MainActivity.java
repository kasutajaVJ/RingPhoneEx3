package com.example.vanessa.ringphoneex3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onStart(View view) {
        Intent intent = new Intent(this, RingService.class);
        this.startService(intent);
    }

    public void onStop(View view) {
        Intent intent = new Intent(this, RingService.class);
        stopService(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
            }
        }, 10000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
            }
        }, 10000);
    }
}
