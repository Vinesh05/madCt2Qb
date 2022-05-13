package com.example.storeretrievestudentdetails;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbHelper extends SQLiteOpenHelper {

    public MyDbHelper(Context context) {
        super(context, "students.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table Student(roll_no primary key, name, branch, marks, percentage)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Student");
    }

    public Boolean addStudent(int roll_no, String name, String branch, int marks, int percentage) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("roll_no", roll_no);
        contentValues.put("name", name);
        contentValues.put("branch", branch);
        contentValues.put("marks", marks);
        contentValues.put("percentage", percentage);
        long result = db.insert("Student", null, contentValues);
        if(result!=-1)
            return true;
        return false;
    }

    public Cursor getStudents(int roll_no) {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Student Where roll_no="+roll_no, null);
        return cursor;
    }
}