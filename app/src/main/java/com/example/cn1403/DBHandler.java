package com.example.cn1403;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {

    private static final String DB_NAME = "coursedb";

    private static final int DB_VERSION = 1;

    private static final String TABLE_NAME = "mycourses";

    private static final String ID_COL = "id";

    private static final String NAME_COL = "name";

    private static final String DESCRIPTION_COL = "description";


    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT, "
                + DESCRIPTION_COL + " TEXT)";
        db.execSQL(query);
        query = "CREATE TABLE " + "Mon" + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT, "
                + DESCRIPTION_COL + " TEXT)";
        db.execSQL(query);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse(String courseName, String courseDescription) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_COL, courseName);
        values.put(DESCRIPTION_COL, courseDescription);
        db.insert(TABLE_NAME, null, values);

        db.close();
    }
    public void readCourses()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);

//        ArrayList<CourseModal> courseModalArrayList = new ArrayList<>();

        if (cursorCourses.moveToFirst()) {
            Log.d("aaaa", cursorCourses.getString(1));
//            do {
//                courseModalArrayList.add(new CourseModal(
//                        cursorCourses.getString(1),
//                        cursorCourses.getString(4),
//                        cursorCourses.getString(2),
//                        cursorCourses.getString(3)));
//            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
//        return courseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
