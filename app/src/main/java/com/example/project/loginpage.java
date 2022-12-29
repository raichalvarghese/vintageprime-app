package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class loginpage extends AppCompatActivity {
    Button loginn;
    EditText name,contact;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);

        DB = new DBHelper(this);

        loginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametxt = name.getText().toString();
                String contacttxt = contact.getText().toString();
                Cursor res = DB.getdata();
                if(Objects.equals(res.getString(0), nametxt) & Objects.equals(res.getString(1), contacttxt)){
                    Intent intent = new Intent(getApplicationContext(),FrontPage.class);
                    startActivity(intent);
                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"Invalid credentials",Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

    }
}