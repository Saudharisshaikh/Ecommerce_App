package com.example.ecommerce_app;

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

import com.example.ecommerce_app.Model.Users;
import com.example.ecommerce_app.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class LoginActivity extends AppCompatActivity {

    EditText number,password;
    Button  loginbtn;
    ProgressDialog loadingBar;

    private String ParentDbname="Users";
    private TextView adminlink,notadminlink;


    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        adminlink=findViewById(R.id.Admin_panel);
        notadminlink=findViewById(R.id.Not_adminpanel);

        number=findViewById(R.id.login_phoneinput);
        password=findViewById(R.id.login_password);
        loginbtn=findViewById(R.id.main_loginbutton);

        checkBox=findViewById(R.id.chkboxrememberme);

        Paper.init(this);

        loadingBar=new ProgressDialog(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LoginUser();
            }
        });

        adminlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginbtn.setText("Login Admin");
                adminlink.setVisibility(View.INVISIBLE);
                notadminlink.setVisibility(View.VISIBLE);

            ParentDbname="Admins";
            }
        });

        notadminlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginbtn.setText("Admin");
                adminlink.setVisibility(View.VISIBLE);
                notadminlink.setVisibility(View.INVISIBLE);

                ParentDbname="Users";

            }
        });
    }

    private void LoginUser() {

        String userphone=number.getText().toString();
        String userpassword=password.getText().toString();


         if(TextUtils.isEmpty(userphone)){

            Toast.makeText(this, "Please write your Phone no ....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(userpassword)){

            Toast.makeText(this, "Please write your Password ....", Toast.LENGTH_SHORT).show();
        }

         else {
             loadingBar.setTitle("Logging  in");
             loadingBar.setMessage("Please wait , while we are checking your credentials...");
             loadingBar.setCanceledOnTouchOutside(false);
             loadingBar.show();


             AllowAccesstoAccount(userphone,userpassword);
         }
}

    private void AllowAccesstoAccount(final String userphone, final String userpassword) {


        if(checkBox.isChecked()){

            Paper.book().write(Prevalent.UserPhonekey,userphone);
            Paper.book().write(Prevalent.UserPasswordkey,userpassword);
        }

        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


                if(snapshot.child(ParentDbname).child(userphone).exists()){

                    Users userData=snapshot.child(ParentDbname).child(userphone).getValue(Users.class);
                    if (userData.getPhone().equals(userphone)){

                        if (userData.getPassword().equals(userpassword)){

                          if(ParentDbname.equals("Admins")){

                              Toast.makeText(LoginActivity.this, "Welcome you are Logged in successfully....", Toast.LENGTH_SHORT).show();

                              loadingBar.dismiss();

                              Intent intent=new Intent(LoginActivity.this,Admin_CategoryActivity.class);
                              startActivity(intent);
                          }

                          else  if(ParentDbname.equals("Users")){

                              Toast.makeText(LoginActivity.this, "Logged in successfully....", Toast.LENGTH_SHORT).show();

                              loadingBar.dismiss();

                              Intent intent=new Intent(LoginActivity.this,HomeActivity.class);
                              startActivity(intent);
                          }
                        }
                        else {

                            loadingBar.dismiss();
                            Toast.makeText(LoginActivity.this, "Password is incorrect ...", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else {

                    Toast.makeText(LoginActivity.this, "No Account exist with this "+userphone, Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                    Toast.makeText(LoginActivity.this, "You need to create new Account...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}