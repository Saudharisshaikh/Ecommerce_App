package com.example.ecommerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ecommerce_app.Model.Users;
import com.example.ecommerce_app.Prevalent.Prevalent;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    private Button joinnowbtn,loginbtn;

   private ProgressDialog loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        joinnowbtn=findViewById(R.id.join_nowbutton);
        loginbtn=findViewById(R.id.main_loginbutton);

        loadingbar=new ProgressDialog(this);

        Paper.init(this);

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        joinnowbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,Register.class);
                startActivity(intent);
            }
        });

        /*
        String Userphonekey=Paper.book().read(Prevalent.UserPhonekey);
        String Userpasswordkey=Paper.book().read(Prevalent.UserPasswordkey);

        if (Userphonekey!=""&&Userpasswordkey!=""){

            if (TextUtils.isEmpty(Userphonekey)&&TextUtils.isEmpty(Userpasswordkey)){

                AllowAccess(Userphonekey,Userpasswordkey);

                loadingbar.setTitle("Already Logged in");
                loadingbar.setMessage("Please wait ....");
                loadingbar.setCanceledOnTouchOutside(false);
                loadingbar.show();
            }
        }

         */
    }

    private void AllowAccess(final String userphone, final String userpassword) {


        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {


               if(snapshot.child("Users").child(userphone).exists()){

                    Users userData=snapshot.child("Users").child(userphone).getValue(Users.class);
                    if (userData.getPhone().equals(userphone)){

                        if (userData.getPassword().equals(userpassword)){

                            Toast.makeText(MainActivity.this, "Logged in successfully....", Toast.LENGTH_SHORT).show();

                            loadingbar.dismiss();

                            Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                            startActivity(intent);
                        }
                        else {

                            loadingbar.dismiss();
                            Toast.makeText(MainActivity.this, "Password is incorrect ...", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                else {

                    Toast.makeText(MainActivity.this, "No Account exist with this "+userphone, Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();
                    Toast.makeText(MainActivity.this, "You need to create new Account...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}