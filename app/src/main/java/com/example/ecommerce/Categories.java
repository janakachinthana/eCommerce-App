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
    private Button LogoutBtn,CheckOrderBtn, maintainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Noodles = (ImageView) findViewById(R.id.imageView16);
        Vegetables = (ImageView) findViewById(R.id.categoryDetailsBtn);

        LogoutBtn = (Button) findViewById( R.id.admin_logout_btn );
        CheckOrderBtn = (Button)findViewById( R.id.check_orders_btn );
        maintainBtn = (Button)findViewById( R.id.maintain_btn );


        maintainBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Categories.this , HomeActivity.class);
                intent.putExtra( "category", "Admin" );
                startActivity( intent );
            }
        } );



        LogoutBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Categories.this , MainActivity.class);
                intent.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK );
                startActivity( intent );
                finish();
            }
        } );

        CheckOrderBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Categories.this , AdimnNewOrderActivity.class);
                startActivity( intent );

            }
        } );

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
