package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import db.Db;
import db.LocalDAO;

public class MainActivity extends AppCompatActivity {

    Db banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        banco = new Db(this);

        LocalDAO dao = new LocalDAO(banco);

        ListView apresentarLocais = (ListView) findViewById(R.id.listview);

//        Local ucsal = new Local();
//        ucsal.setId(1);
//        ucsal.setNome("Ucsal - Campus Paralela");
//        ucsal.setLatitude(-12.9494756);
//        ucsal.setLongitude(-38.5291857);
//        dao.insert(ucsal);
        List<Local> locais = dao.list();
        ArrayAdapter<Local> adapter = new ArrayAdapter<Local>(this,android.R.layout.simple_list_item_1,locais);
        apresentarLocais.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.add){
            Intent form = new Intent(this,FormularioActivity.class);
            startActivity(form);
        }
        return super.onOptionsItemSelected(item);
    }
}
