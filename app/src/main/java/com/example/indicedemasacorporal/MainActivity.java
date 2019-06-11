package com.example.indicedemasacorporal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnCalcular, btnEstadistica, btnVerTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalcular=(Button)findViewById(R.id.btnCalcular2);
        btnEstadistica=(Button)findViewById(R.id.btnEstadistica);
        btnVerTodos=(Button)findViewById(R.id.btnVerTodos);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent calcular=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(calcular);
            }
        });
        btnEstadistica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                Intent estadistica=new Intent(MainActivity.this,Main3Activity.class);
=======
                Intent estadistica=new Intent(MainActivity.this,Main2Activity.class);
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
                startActivity(estadistica);
                //cambiar el activity
            }
        });
        btnVerTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verTodos=new Intent(MainActivity.this,Main2Activity.class);
<<<<<<< HEAD
                //startActivity(verTodos);
=======
                startActivity(verTodos);
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
            }
        });

    }//fin del metodo principal
}//fin de la clase