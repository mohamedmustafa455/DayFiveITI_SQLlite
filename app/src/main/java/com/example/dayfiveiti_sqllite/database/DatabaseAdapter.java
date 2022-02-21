package com.example.dayfiveiti_sqllite.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DatabaseAdapter {

    static DatabaseHelper dphelper;

    public DatabaseAdapter(Context context){
        dphelper=new DatabaseHelper(context);

    }
    public long insertEntity(Model entity){
        SQLiteDatabase db=dphelper.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.cl_phone,entity.getPhone());
        contentValues.put(DatabaseHelper.col_message,entity.getMessage());

        long id= db.insert(DatabaseHelper.db_table_name,null,contentValues);  ;

        return id;
    }

    public Model getEntre(){
        Model entite =null;
        Cursor c;
       SQLiteDatabase dp=dphelper.getReadableDatabase();
       String []columns ={DatabaseHelper.col_message,DatabaseHelper.cl_phone};
         c =dp.query(DatabaseHelper.db_table_name,columns,null,null,null,null,null);
        while (c.moveToNext()){
            entite=new Model(c.getString(0),c.getString(1));

        }

        return entite;
    }

    //this class will creat and drope
    static class DatabaseHelper extends SQLiteOpenHelper{
        private static final int db_version=1;
        private static final String db_name="PHONE_MESSAGE";
        private static final String db_table_name="TABLE_PHONE_MESSAGE";
        private static final String col_id="id";
        private static final String col_message="MESSAGE";
        private static final String cl_phone="PHONE";

        private static final String CREAT_PHONE_MESSAGE_TABLE = "CREATE TABLE " + db_table_name + " (" + col_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " + col_message+" TEXT, " + cl_phone + " TEXT);";


        public DatabaseHelper(@Nullable Context context) {
            super(context, db_name, null, db_version);


        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREAT_PHONE_MESSAGE_TABLE);

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
             db.execSQL("DROP TABLE IF EXISTS "+db_table_name);
            //onCreate(db);
        }
    }

}
