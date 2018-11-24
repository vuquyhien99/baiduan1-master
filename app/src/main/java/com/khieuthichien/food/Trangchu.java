package com.khieuthichien.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Trangchu extends AppCompatActivity {
    private ImageView imganh;
    private ImageView imganhmenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        imganh = findViewById(R.id.imageanh);
        imganhmenu = findViewById(R.id.imagemenu);


        imganh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Trangchu.this,MainActivity.class));
            }
        });

        imganhmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Trangchu.this,Menucuahang.class));
            }
        });
    }
}
