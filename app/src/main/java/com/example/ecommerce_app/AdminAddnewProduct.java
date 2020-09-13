package com.example.ecommerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AdminAddnewProduct extends AppCompatActivity {

    private String CategoryName;

    private Button addnewProductbtn;
    private ImageView productImage;
    private EditText productname,productdiscription,productprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_addnew_product);

        CategoryName= getIntent().getExtras().get("category").toString();

        addnewProductbtn=findViewById(R.id.addnewProduct);
        productImage=findViewById(R.id.selectImage);
        productname=findViewById(R.id.productname);
        productdiscription=findViewById(R.id.productdiscription);
        productprice=findViewById(R.id.productprice);


        Toast.makeText(this, CategoryName+"", Toast.LENGTH_SHORT).show();

    }
}