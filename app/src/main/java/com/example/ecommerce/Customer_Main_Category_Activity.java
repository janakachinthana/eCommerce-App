package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Customer_Main_Category_Activity extends AppCompatActivity {

    private ImageView tShirts, sportsTShirts, femaleDresses, sweathers;
    private ImageView glasses, hatsCaps, walletsBagsPurses, shoes;
    private ImageView headPhonesHandsFree, laptops, watches, mobilePhones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer__main__category_);

        tShirts = (ImageView) findViewById(R.id.customer_t_shirts);
        sportsTShirts = (ImageView) findViewById(R.id.customer_sports_t_shirts);
        femaleDresses = (ImageView) findViewById(R.id.customer_female_dresses);
        sweathers = (ImageView) findViewById(R.id.customer_sweather);
        glasses = (ImageView) findViewById(R.id.customer_glasses);
        hatsCaps = (ImageView) findViewById(R.id.customer_hats_caps);
        walletsBagsPurses = (ImageView) findViewById(R.id.customer_purses_bags_wallets);
        shoes = (ImageView) findViewById(R.id.customer_shoess);
        headPhonesHandsFree = (ImageView) findViewById(R.id.customer_headphoness_handsfree);
        laptops = (ImageView) findViewById(R.id.customer_laptops_pc);
        watches = (ImageView) findViewById(R.id.customer_watches);
        mobilePhones = (ImageView) findViewById(R.id.customer_mobiles_phones);



        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "tShirts");

                startActivity(intent);
            }
        });

        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "sportsTShirts");
                startActivity(intent);
            }
        });


        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "femaleDresses");
                startActivity(intent);
            }
        });

        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "sweathers");
                startActivity(intent);
            }
        });

        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "glasses");
                startActivity(intent);
            }
        });

        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "hatsCaps");
                startActivity(intent);
            }
        });

        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "walletsBagsPurses");
                startActivity(intent);
            }
        });

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "shoes");
                startActivity(intent);
            }
        });

        headPhonesHandsFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "headPhonesHandsFree");
                startActivity(intent);
            }
        });

        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "laptops");
                startActivity(intent);
            }
        });

        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "watches");
                startActivity(intent);
            }
        });

        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer_Main_Category_Activity.this, HomeActivity.class);
                intent.putExtra("category", "mobilePhones");
                startActivity(intent);
            }
        });


    }
}
