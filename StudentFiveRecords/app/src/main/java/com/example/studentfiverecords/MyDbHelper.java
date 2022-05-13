package com.example.studentfiverecords;

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
        DB.execSQL("create Table Student(roll_no primary key, name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int ii) {
        DB.execSQL("drop Table if exists Student");
    }

    public Boolean addStudent(int roll_no, String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("roll_no", roll_no);
        contentValues.put("name", name);
        long result = db.insert("Student", null, contentValues);
        if(result!=-1)
            return true;
        return false;
    }

    public Boolean deleteStudent(int roll_no){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Student where roll_no = "+roll_no, null);
        if (cursor.getCount() > 0) {
            long result = DB.delete("Student", "roll_no="+roll_no, null);
            if(result != -1)
                return true;
        }
        return false;
    }

    public Cursor getStudents() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Student", null);
        return cursor;
    }
}
