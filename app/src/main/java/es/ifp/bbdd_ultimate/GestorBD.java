package es.ifp.bbdd_ultimate;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class GestorBD extends SQLiteOpenHelper {


    public GestorBD(Context context) {
        super(context, "listacompra", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE lista (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, producto TEXT)");
        db.execSQL("INSERT INTO lista (producto) VALUES ('prueba')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS lista");
        this.onCreate(db);

    }
    public void insert(String producto)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("INSERT INTO lista (producto) VALUES ('"+producto+"')");

    }
    public void delete(String producto)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("DELETE FROM  lista WHERE producto='"+producto+"'");

    }
    public void delete(int id)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("DELETE FROM  lista WHERE id='"+id+"'");

    }
    public void deleteAll()
    {
        SQLiteDatabase db= this.getWritableDatabase();
        db.execSQL("DELETE FROM  lista WHERE id>=0");

    }

    public ArrayList<String> getAllProducts()
    {
        SQLiteDatabase db= this.getReadableDatabase();
        ArrayList<String> lista= new ArrayList<String>();

        String contenidoFila="";

        Cursor res= null;
        res= db.rawQuery("SELECT * FROM lista",null);
        res.moveToFirst();
        while (!res.isAfterLast())
        {
            // Tomates
            contenidoFila=res.getString(0)+ ".-"+ res.getString(1);
            lista.add(contenidoFila);
            res.moveToNext();
        }

        return lista;
    }


}
