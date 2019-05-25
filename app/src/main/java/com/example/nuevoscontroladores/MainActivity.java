package com.example.nuevoscontroladores;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
<<<<<<< HEAD
import android.widget.AdapterView;
=======
>>>>>>> af52b00f6bd65c5c78fc2f8eb65b636d7cacf455
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvHola;
    CheckBox checkFace, checkWhats;
    RadioButton rbMasculino, rbFemenino;
    Spinner spOciones;
    ListView lvNombres;
    Button btnRevisar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHola=(TextView)findViewById(R.id.textView);
        checkFace=(CheckBox)findViewById(R.id.checkFace);
        checkWhats=(CheckBox)findViewById(R.id.checkWhats);
        rbMasculino=(RadioButton)findViewById(R.id.rbMasculino);
        rbFemenino=(RadioButton)findViewById(R.id.rbFemenino);
        spOciones=(Spinner)findViewById(R.id.sOpciones);
        lvNombres=(ListView)findViewById(R.id.lvNombres);
        btnRevisar=(Button)findViewById(R.id.btnRevisar);

        //Adaptador para SPINNER
        //El contexto donde estas, como mmostrar informacion y la informacion a mostrar
        ArrayList datos=new ArrayList();
        datos.add("Elige Uno");
        datos.add("Opcion 1");
        datos.add("Opcion 2");
        datos.add("Opcion 3");

        Adapter adaptador=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item, datos);
        spOciones.setAdapter((SpinnerAdapter) adaptador);//No deberia pedir castep del adaptador, revisar despues

        //ListView se llena de la misma manera que el spinner
        ArrayList datosLista=new ArrayList();
        datos.add("Nombres");
        datos.add("Rafita");
        datos.add("Camila");
        datos.add("Jairo");

        ArrayAdapter adaptadorLista=new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,datosLista);
        lvNombres.setAdapter(adaptadorLista);

        btnRevisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkFace.isChecked()){
                    Toast.makeText(getApplicationContext(),"Redes Sociales: " + checkFace.getText(),Toast.LENGTH_LONG).show();
                }
                if(checkWhats.isChecked()){
                    Toast.makeText(getApplicationContext(),"Redes Sociales: " + checkWhats.getText(),Toast.LENGTH_SHORT).show();
                }
                //Revisar el codigo para que solo permita marcar una opcion
                if(rbFemenino.isChecked()){
                    tvHola.setText(rbFemenino.getText().toString());
                }
                else if(rbMasculino.isChecked()){
                    tvHola.setText(rbMasculino.getText().toString());
                }
            }//Termina el metodo on clicj\k
        });//Termina el btn on click

<<<<<<< HEAD
        spOciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),spOciones.getSelectedItem().toString(),Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lvNombres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), lvNombres.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
=======
>>>>>>> af52b00f6bd65c5c78fc2f8eb65b636d7cacf455
    }//fin del metodo princiapl
}//fin de la clase
