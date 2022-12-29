package com.example.project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, "car.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table Users(name Text,contact Text primary key,email Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists Users");
    }

    public boolean insertdata(String name,String contact,String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("email",email);
        long result = db.insert("Users",null,cv);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }


    public Cursor getdata(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Users",null);
        return cursor;
    }
}
