package com.slf.carplay;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.slf.carplay.bo.ServerBo;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "carplay.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "t_server";

    private final static String createTable()
    {
        StringBuilder table = new StringBuilder("create table ")
                .append(TABLE_NAME)
                .append(" (")
                .append(ServerBo.SERVER_ID)
                .append(" integer primary key autoincrement,")
                .append(ServerBo.SERVER_IP)
                .append(" text,")
                .append(ServerBo.SERVER_PORT)
                .append(" integer)");
        return table.toString();
    }


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}
