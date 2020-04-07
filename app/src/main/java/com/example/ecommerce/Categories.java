package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Categories extends AppCompatActivity {

    private ImageView Noodles, Vegetables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Noodles = (ImageView) findViewById(R.id.imageView16);
        Vegetables = (ImageView) findViewById(R.id.categoryDetailsBtn);

        Noodles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, AdminCategoryActivity.class);
                startActivity(intent);
            }
        });



        Vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this, AdminCategoryActivity.class);
                startActivity(intent);
            }
        });


    }

}
