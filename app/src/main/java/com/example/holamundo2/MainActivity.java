package com.example.holamundo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText cajanom;
    Button btnmsj, btnenviar;
    TextView etiqueta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //empieza el enlace de variables a objetos (botones)
        cajanom=(EditText) findViewById(R.id.txtMsj);
        etiqueta=(TextView)findViewById(R.id.etnom);
        btnmsj=(Button)findViewById(R.id.btnmsj);
        btnenviar=(Button)findViewById(R.id.btnEnviar);


        btnmsj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Este codigo hace que al presionar el boton del activity se cambie el texto de la primera etiqueta
                etiqueta.setText(cajanom.getText());
                Toast.makeText(getApplicationContext(),"Hola " + cajanom.getText(),Toast.LENGTH_LONG).show();
            }
        });//Fin de la accion del boton de de enviar
        /*btnenviar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"Estoy cambiando",Toast.LENGTH_LONG).show();
                ///los parametros de este objeto es donde estoy y donde voy
                Intent ventana = new Intent(MainActivity.this, Main3Activity.class);
                //ventana.putExtra("nombre", etiqueta.getText()); //anadir toString porque si no no muestra nada
                //Cada dato que se requiera enviar necesitaras un outExtra
                startActivity(ventana);
            }//fin de la funcion
        });//fin de la accion del boton de cambiar
        */
        btnenviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(ventana);
            }
        });
    }//fin del metodo de creacion
}//fin de la clase
