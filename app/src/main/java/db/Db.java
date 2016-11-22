package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
/**
 * Created by aluno on 21/11/16.
 */

public class Db extends SQLiteOpenHelper{

    private static final String NOME_BANCO = "banco";
    public static final String TABELA = "localizacao";

    public Db(Context context) {
        super(context, "APP", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        StringBuilder sql = new StringBuilder();
        sql.append(" CREATE TABLE ");
        sql.append(TABELA);
        sql.append(" ( ID integer primary key autoincrement, ");
        sql.append(" NOME VARCHAR(30) NOT NULL , ");
        sql.append(" LATITUDE NUMERIC NOT NULL , ");
        sql.append(" LONGITUDE NUMERIC NOT NULL  )");


        sqLiteDatabase.execSQL(sql.toString());

    }
/*

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
*/

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int velha, int nova) {
        sqLiteDatabase.execSQL("DROP TABLE localizacao");
        onCreate(sqLiteDatabase);

        switch (velha){
            case 1:
                //sql da 1 para 2
            case 2:
                //sql da 2 para 3
            case 3:
                //sql da 3 para 4
        }

    }
}
