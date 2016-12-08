package com.example.aluno.myapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import db.Db;
import db.LocalDAO;

public class FormularioActivity extends AppCompatActivity {

    EditText textoLocal;
    EditText textoLongitude;
    EditText textoLatitude;
    Local local = new Local();
    Db banco = new Db(this);

   LocalDAO dao = new LocalDAO(banco);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);
        Button salvar = (Button) findViewById(R.id.buttonSalvar);
        textoLocal= (EditText) findViewById(R.id.editText2);
        textoLatitude = (EditText) findViewById(R.id.editText3);
        textoLongitude = (EditText) findViewById(R.id.editText4);

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    local.setNome(textoLocal.getText().toString());
                    local.setLatitude(Double.parseDouble(textoLatitude.getText().toString()));
                    local.setLongitude(Double.parseDouble(textoLongitude.getText().toString()));
                    dao.insert(local);
                    Toast.makeText(getBaseContext(), "Salvo com Sucesso!", Toast.LENGTH_LONG).show();
                finish();
                overridePendingTransition(0, android.R.anim.slide_out_right);

            }

        });


    }
//    public void salvarLocal(){
//        Local local = new Local();
//        local.setNome(textoLocal.getText().toString());
//        local.setLatitude(Double.parseDouble(textoLatitude.getText().toString()));
//        local.setLongitude(Double.parseDouble(textoLongitude.getText().toString()));
//
//
//    }
//    Local ucsal = new Local();
//        ucsal.setId(1);
//        ucsal.setNome("Ucsal - Campus Paralela");
//        ucsal.setLatitude(-12.9494756);
//        ucsal.setLongitude(-38.5291857);
//        dao.insert(ucsal);

}
