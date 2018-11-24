package com.khieuthichien.food;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private Button fabthem;

    private List<Food> foodList;
    private FoodAdapter adapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);
        fabthem = findViewById(R.id.fabthem);

        databaseHelper = new DatabaseHelper(this);
        foodList = new ArrayList<>();

        foodList = databaseHelper.getAllFood();

        adapter = new FoodAdapter(this, foodList, databaseHelper);
        recyclerview.setAdapter(adapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerview.setLayoutManager(layoutManager);

        fabthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View dialogView = inflater.inflate(R.layout.dialog_add_food, null);
                builder.setView(dialogView);
                final Dialog dialog = builder.show();

                final EditText edtidfood;
                final EditText edtnamefood;
                final EditText edtprice;
                final Button btnadd;
                final Button btncancel;

                edtidfood = dialogView.findViewById(R.id.edtidfood);
                edtnamefood = dialogView.findViewById(R.id.edtnamefood);
                edtprice = dialogView.findViewById(R.id.edtprice);
                btnadd = dialogView.findViewById(R.id.btnadd);
                btncancel = dialogView.findViewById(R.id.btncancel);

                btnadd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int id = Integer.parseInt(edtidfood.getText().toString().trim());
                        String name = edtnamefood.getText().toString().trim();
                        long price = Long.parseLong(edtprice.getText().toString().trim());

                        if (edtidfood.getText().toString().equals("")){
                            edtidfood.setError(getString(R.string.notify_name));
                        }
                        if (name.equals("")){
                            edtnamefood.setError(getString(R.string.notify_name));
                        }
                        if (edtprice.getText().toString().equals("")){
                            edtprice.setError(getString(R.string.notify_name));
                        }

                        Food food = new Food();
                        food.setIdfood(id);
                        food.setNamefood(name);
                        food.setPrice(price);

                        databaseHelper.insertFood(food);
                        databaseHelper.getAllFood();

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));

                        dialog.dismiss();
                    }
                });

                btncancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

            }
        });


    }
}
