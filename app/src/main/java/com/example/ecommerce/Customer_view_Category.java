package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Customer_view_Category extends AppCompatActivity {

    ImageView noodlesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view__category);

        noodlesButton = findViewById(R.id.noodlesBtn);
        noodlesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_view_Category.this, Customer_Main_Category_Activity.class);
                startActivity(intent);
            }
        });
    }

}
