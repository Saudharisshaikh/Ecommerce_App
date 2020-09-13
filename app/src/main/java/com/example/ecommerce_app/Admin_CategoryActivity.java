package com.example.ecommerce_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Admin_CategoryActivity extends AppCompatActivity {


    private ImageView tshirt,sportshirt,femaldress,sweater;
    private ImageView glasses,hat,purse,shoes;
    private ImageView handfree,watch,laptops,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__category);

        tshirt=findViewById(R.id.tshirt);
        sportshirt=findViewById(R.id.sportstshirt);
        femaldress=findViewById(R.id.femaledresses);
        sweater=findViewById(R.id.sweaters);

        glasses=findViewById(R.id.glasses);
        hat=findViewById(R.id.Hats);
        purse=findViewById(R.id.purses);
        shoes=findViewById(R.id.shoes);

        handfree=findViewById(R.id.headphones);
        watch=findViewById(R.id.watches);
        laptops=findViewById(R.id.laptops);
        mobile=findViewById(R.id.mobiles);

        tshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","tshirts");
                startActivity(intent);

            }
        });

        sportshirt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","sportshirts");
                startActivity(intent);

            }
        });

        femaldress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","femaledress");
                startActivity(intent);
            }
        });

        sweater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","sweater");
                startActivity(intent);
            }
        });

        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","glasses");
                startActivity(intent);
            }

        });

        hat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","hats");
                startActivity(intent);
            }
        });

        purse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","purses");
                startActivity(intent);
            }
        });

        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","shoes");
                startActivity(intent);
            }
        });

        handfree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","handfree");
                startActivity(intent);
            }
        });

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","watch");
                startActivity(intent);
            }
        });

        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","laptops");
                startActivity(intent);
            }
        });

        mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(Admin_CategoryActivity.this,AdminAddnewProduct.class);
                intent.putExtra("category","mobiles");
                startActivity(intent);
            }
        });
    }
}