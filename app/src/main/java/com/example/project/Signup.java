package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    Button signupp;
    EditText name,contact,email;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        email = findViewById(R.id.email);

        DB = new DBHelper(this);
        signupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt = name.getText().toString();
                String contacttxt = contact.getText().toString();
                String emailtxt = email.getText().toString();

                boolean check = DB.insertdata(nametxt,contacttxt,emailtxt);
                if(check){
                    Toast.makeText(getApplicationContext(),"New User Inserted",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),FrontPage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"New Entry not inserted",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}