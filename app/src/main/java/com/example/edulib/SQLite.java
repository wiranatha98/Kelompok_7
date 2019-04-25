package com.example.edulib;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

public class SQLite extends SQLiteOpenHelper {

    Context context;
    private static final int DB_VERSION = 1;

    public SQLite(Context context) {
        super(context, "db_andro", null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tabel_kegiatan.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS 'tabel_kegiatan'");
        onCreate(db);
    }

    static class tabel_kegiatan implements BaseColumns {
        static final String TABLE_NAME = "tabel_kegiatan";
        static final String ID = "Id";
        static final String TITLE = "Title";
        static final String PRIORITY= "Prior";
        static final String DESC = "Description";
        static final String JAM = "Jam";
        static final String TANGGAL = "Tanggal";
        static final String TIMESTAMP = "Created_at";

        static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS 'tabel_kegiatan' (" +
                "'Id' INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "'Title' TEXT, " +
                "'Prior' TEXT, " +
                "'Jam'TEXT, " +
                "'Tanggal' TEXT," +
                "'Description' TEXT, " +
                "'Created_at' TEXT)";
    }

    public void tambahKegiatan(Pengingatmodel art) {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO tabel_kegiatan(Title, Prior, Jam, Tanggal, Description, Created_at) " +
                "VALUES (?,?,?,?,?,datetime('now','localtime'))"; //diganti

        db.execSQL(query,new String[]{art.getTitle(),art.getPriority(),art.getJam(),art.getTanggal(),art.getDesc()});
        db.close();
    }

    public List<Pengingatmodel> pilihSemuaArtikel() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Pengingatmodel> artlist = new ArrayList<>();

        //Cursor cursor = db.query("tabel_kegiatan",null,null,null,null,null,null,null,null);
        //Cursor cursor = db.query("tabel_artikel",null,"Id = ?",new String[]{id},null,null,null);


        Cursor cursor = db.query("tabel_kegiatan",null,null,null,null,null,null);

        if(cursor != null) {
            while(cursor.moveToNext()) {
                Pengingatmodel art = new Pengingatmodel();
                art.setId(cursor.getString(cursor.getColumnIndex("Id")));
                art.setTitle(cursor.getString(cursor.getColumnIndex("Title")));
                art.setPriority(cursor.getString(cursor.getColumnIndex("Prior")));
                art.setDesc(cursor.getString(cursor.getColumnIndex("Description")));
                art.setJam(cursor.getString(cursor.getColumnIndex("Jam")));
                art.setTanggal(cursor.getString(cursor.getColumnIndex("Tanggal")));
                art.setCreated_at(cursor.getString(cursor.getColumnIndex("Created_at")));
                //ada penambahan return list
                artlist.add(art);
            }
        }
        return artlist;
    }

    public Pengingatmodel pilihSatuArtikel(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Pengingatmodel art = new Pengingatmodel();

        Cursor cursor = db.query("tabel_kegiatan",null,"Id = ?",new String[]{id},null,null,null);

        if(cursor != null && cursor.moveToFirst()) {
            art.setId(cursor.getString(cursor.getColumnIndex("Id")));
            art.setTitle(cursor.getString(cursor.getColumnIndex("Title")));
            art.setPriority(cursor.getString(cursor.getColumnIndex("Prior")));
            art.setJam(cursor.getString(cursor.getColumnIndex("Jam")));
            art.setTanggal(cursor.getString(cursor.getColumnIndex("Tanggal")));
            art.setDesc(cursor.getString(cursor.getColumnIndex("Description")));
            art.setCreated_at(cursor.getString(cursor.getColumnIndex("Created_at")));
        }
        return art;
    }
}
