package db;

/**
 * Created by aluno on 21/11/16.
 */

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.aluno.myapplication.Local;

import java.util.ArrayList;
import java.util.List;

public class LocalDAO {



    private Db banco;


    public LocalDAO(Db banco){
        this.banco = banco;
    }

    public void insert(Local  local){
        ContentValues values = new ContentValues();
        values.put("latitude",local.getLatitude());
        values.put("longitude",local.getLongitude());
        values.put("nome",local.getNome());
        banco.getWritableDatabase().insert(banco.TABELA,null,values);
        banco.close();
    }



    public List<Local> list(){
        Cursor cursor = banco.getReadableDatabase().query(banco.TABELA,new String[]{"id","latitude","longitude","nome"},null,null,null,null,"nome");
        List<Local> locais = new ArrayList<Local>();
        if(cursor.moveToFirst()) {
            do {
                Local l = new Local();
                String nome = cursor.getString(3);
                l.setNome(nome);
                locais.add(l);
            } while (cursor.moveToNext());
        }
        cursor.close();
        banco.close();
        return locais;




    }


}