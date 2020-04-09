package com.example.ecommerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecommerce.Model.Users;
import com.example.ecommerce.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {

    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;
    private TextView AdminLink, NotAdminLink, ForgetPasswordLink;

    private String parentDbName = "Users";
    private CheckBox chkBoxRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginButton = (Button) findViewById(R.id.login_btn);
        InputPhoneNumber = (EditText) findViewById(R.id.login_phone_number_input);
        InputPassword = (EditText) findViewById(R.id.login_password_input);
        AdminLink = (TextView) findViewById(R.id.admin_panel_link);
        NotAdminLink = (TextView) findViewById(R.id.no_admin_panel_link);
        ForgetPasswordLink = findViewById( R.id.forget_password_link );
        loadingBar = new ProgressDialog(this);


        chkBoxRememberMe = (CheckBox)  findViewById(R.id.remember_me_chkb);
        Paper.init(this);

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginUser();
            }
        });

        AdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login Admin");
                AdminLink.setVisibility(View.INVISIBLE);
                NotAdminLink.setVisibility(View.VISIBLE);
                parentDbName = "Admins";

            }
        });

        NotAdminLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginButton.setText("Login");
                AdminLink.setVisibility(View.VISIBLE);
                NotAdminLink.setVisibility(View.INVISIBLE);
                parentDbName = "Users";
            }
        });
    }

    private void LoginUser()
    {
        String phone = InputPhoneNumber.getText().toString();
        String password = InputPassword.getText().toString();


            if(TextUtils.isEmpty(phone))
        {
            Toast.makeText(this, "Plase type your Phone Number... ", Toast.LENGTH_SHORT).show();
        }

        else if(TextUtils.isEmpty(password))
        {
            Toast.makeText(this, "Plase type your Password... ", Toast.LENGTH_SHORT).show();
        }

        else
            {
                loadingBar.setTitle("Login Account");
                loadingBar.setMessage("Please wait, while we are checking the credentials.");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();
                
                AllowAccessToAccount(phone, password);
            }
    }

    private void AllowAccessToAccount(final String phone, final String password)
    {
        if(chkBoxRememberMe.isChecked())
        {
            Paper.book().write(Prevalent.UserPhoneKey, phone);
            Paper.book().write(Prevalent.UserPasswordKey, password);
        }

        final DatabaseReference Rootref;
        Rootref = FirebaseDatabase.getInstance().getReference();

        Rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
              if(dataSnapshot.child(parentDbName).child(phone).exists())
              {
                  Users usersData = dataSnapshot.child(parentDbName).child(phone).getValue(Users.class);
                  if (usersData.getPhone().equals(phone))
                  {
                      if (usersData.getPassword().equals(password))
                      {
                          if(parentDbName.equals("Admins"))
                          {
                              Toast.makeText(LoginActivity.this, "Wllcome Admin, You are Logged in Successfully...!",Toast.LENGTH_SHORT).show();
                              loadingBar.dismiss();

                              Intent intent = new Intent(LoginActivity.this, Categories.class);
                              startActivity(intent);
                          }
                          else if(parentDbName.equals("Users"))
                          {
                              Toast.makeText(LoginActivity.this, "Logged in Successfully...!",Toast.LENGTH_SHORT).show();
                              loadingBar.dismiss();

                              Intent intent = new Intent(LoginActivity.this, Customer_view_Category.class);
                              Prevalent.CurrentOnlineUser = usersData;
                              startActivity(intent);
                          }
                      }
                      else
                      {
                          Toast.makeText(LoginActivity.this, "Your password does not matching...!",Toast.LENGTH_SHORT).show();
                          loadingBar.dismiss();
                          Toast.makeText(LoginActivity.this, "Please login again",Toast.LENGTH_SHORT).show();
                      }
                  }
              }
              else
              {
                  Toast.makeText(LoginActivity.this, "Account with this ( " + phone + " ) number does not exits...",Toast.LENGTH_SHORT).show();
                  loadingBar.dismiss();
                  Toast.makeText(LoginActivity.this, "You need to create new account...!",Toast.LENGTH_SHORT).show();
              }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
