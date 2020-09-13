package com.example.ecommerce_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class Register extends AppCompatActivity {

    private EditText name,phone_no,password;
    Button crtAccountbtn;

    private ProgressDialog loadingbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    name=findViewById(R.id.register_username);
    phone_no=findViewById(R.id.register_phoneinput);
    password=findViewById(R.id.register_login_password);
    crtAccountbtn=findViewById(R.id.register_loginbutton);

    loadingbar=new ProgressDialog(this);

    crtAccountbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {


            CreateAccount();
        }
    });

    }

    private void CreateAccount() {

        String username=name.getText().toString();
        String userphone=phone_no.getText().toString();
        String userpassword=password.getText().toString();

        if(TextUtils.isEmpty(username)){

            Toast.makeText(this, "Please write your name ....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(userphone)){

            Toast.makeText(this, "Please write your Phone no ....", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(userpassword)){

            Toast.makeText(this, "Please write your Password ....", Toast.LENGTH_SHORT).show();
        }

        else {
            loadingbar.setTitle("Create Account");
            loadingbar.setMessage("Please wait , while we are checking your credentials...");
            loadingbar.setCanceledOnTouchOutside(false);
            loadingbar.show();

            ValidatePhoneNO(username,userphone,userpassword);
        }

    }

    private void ValidatePhoneNO(final String username, final String userphone, final String userpassword) {


        final DatabaseReference RootRef;
        RootRef= FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (!(snapshot.child("Users").child(userphone).exists())){

                    HashMap<String ,Object> userdataMap=new HashMap<>();
                    userdataMap.put("phone",userphone);
                    userdataMap.put("password",userpassword);
                    userdataMap.put("name",username);

                    RootRef.child("Users").child(userphone).updateChildren(userdataMap)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()){

                                        Toast.makeText(Register.this, "Congratulation your account has been created successfully...", Toast.LENGTH_SHORT).show();
                                        loadingbar.dismiss();

                                        Intent intent=new Intent(Register.this,LoginActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        loadingbar.dismiss();

                                        Toast.makeText(Register.this, "Error ..."+task.getException(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

                else {

                    Toast.makeText(Register.this, "This "+userphone+" already exists....", Toast.LENGTH_SHORT).show();
                    loadingbar.dismiss();

                    Toast.makeText(Register.this, "Please try again with other phone no...", Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(Register.this,MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}