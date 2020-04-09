package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminCategoryActivity extends AppCompatActivity {

    private ImageView tShirts, sportsTShirts, femaleDresses, sweathers;
    private ImageView glasses, hatsCaps, walletsBagsPurses, shoes;
    private ImageView headPhonesHandsFree, laptops, watches, mobilePhones;
    private Button LogoutBtn,CheckOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_category);

        LogoutBtn = (Button) findViewById( R.id.admin_logout_btn );
        CheckOrderBtn = (Button)findViewById( R.id.check_orders_btn );

        LogoutBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminCategoryActivity.this , MainActivity.class);
                intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
                startActivity( intent );
                finish();
            }
        } );

        CheckOrderBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this , AdimnNewOrderActivity.class);
                startActivity( intent );

            }
        } );

        tShirts = (ImageView) findViewById(R.id.t_shirts);
        sportsTShirts = (ImageView) findViewById(R.id.sports_t_shirts);
        femaleDresses = (ImageView) findViewById(R.id.female_dresses);
        sweathers = (ImageView) findViewById(R.id.sweather);
        glasses = (ImageView) findViewById(R.id.glasses);
        hatsCaps = (ImageView) findViewById(R.id.hats_caps);
        walletsBagsPurses = (ImageView) findViewById(R.id.purses_bags_wallets);
        shoes = (ImageView) findViewById(R.id.shoess);
        headPhonesHandsFree = (ImageView) findViewById(R.id.headphoness_handsfree);
        laptops = (ImageView) findViewById(R.id.laptops_pc);
        watches = (ImageView) findViewById(R.id.watches);
        mobilePhones = (ImageView) findViewById(R.id.mobiles_phones);



        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "tShirts");
                startActivity(intent);
            }
        });

        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "sportsTShirts");
                startActivity(intent);
            }
        });


        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "femaleDresses");
                startActivity(intent);
            }
        });

        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "sweathers");
                startActivity(intent);
            }
        });

        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "glasses");
                startActivity(intent);
            }
        });

        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "hatsCaps");
                startActivity(intent);
            }
        });

        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "walletsBagsPurses");
                startActivity(intent);
            }
        });

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "shoes");
                startActivity(intent);
            }
        });

        headPhonesHandsFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "headPhonesHandsFree");
                startActivity(intent);
            }
        });

        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "laptops");
                startActivity(intent);
            }
        });

        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "watches");
                startActivity(intent);
            }
        });

        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminCategoryActivity.this, AdminAddNewProductActivity.class);
                intent.putExtra("category", "mobilePhones");
                startActivity(intent);
            }
        });

    }
}
