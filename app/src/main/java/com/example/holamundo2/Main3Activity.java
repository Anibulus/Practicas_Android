package com.example.holamundo2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    //Button btnRegresar;
    //TextView etiqueta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        //Bundle b=new Bundle();
        //b.getIntent().getExtras();
       // btnRegresar=(Button)findViewById(R.id.btnEnviar);

        //etiqueta=(TextView)findViewById(R.id.txtMensaje);
        //etiqueta.setText(b.getString("nombre"));

        //Esta funcion cambia de ventana
        /*btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana = new Intent (Main3Activity.this,MainActivity.class);
                startActivity(ventana);
            }
        });*/
    }
}
