package com.rku.tutorial07;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE = "UserDetails.db";
    public static final String TBL_USER = "user";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FirstName";
    public static final String COL_3 = "LastName";
    public static final String COL_4 = "Email";
    public static final String COL_5 = "Password";
    public static final String COL_6 = "Gender";
    public static final String COL_7 = "Branch";

    public Database(@Nullable Context context) {
        super(context, DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table if not exists " + TBL_USER + " (" +
                COL_1 + " integer primary key autoincrement, "+
                COL_2 + " text, "+
                COL_3 + " text, "+
                COL_4 + " text, "+
                COL_5 + " text, "+
                COL_6 + " text, "+
                COL_7 + " text)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+TBL_USER);
        onCreate(db);
    }
    public boolean insertData(String valFirstName, String valLastName, String valEmail, String valPassword, String valGender, String valBranch)
    {
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_2,valFirstName);
        values.put(COL_3,valLastName);
        values.put(COL_4,valEmail);
        values.put(COL_5,valPassword);
        values.put(COL_6, String.valueOf(valGender));
        values.put(COL_7,valBranch);

        return (database.insert(TBL_USER,null,values)==1)?false:true;
    }

    public Cursor checkLogin() {

        SQLiteDatabase db=getWritableDatabase();
        Cursor cursor=db.query(TBL_USER,null,null,null,null,null,null);
        return cursor;
       /*
        SQLiteDatabase database = getWritableDatabase();
        Cursor cursor = database.rawQuery("select email,password from "+TBL_USER+" where email = ? AND password = ?",new String[]{usernameValue,passwordValue});
        return (cursor.getCount()>0)?true:false;*/
    }
}

