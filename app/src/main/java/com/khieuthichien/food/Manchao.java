package com.khieuthichien.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Manchao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manchao);

        Thread thread = new Thread() {

            public void run() {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                } finally {
                    Intent a = new Intent(Manchao.this, Dangnhap.class);
                    startActivity(a);
                }
            }
        };
        thread.start();
    }
}
