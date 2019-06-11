package com.example.indicedemasacorporal;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

<<<<<<< HEAD


public class Main2Activity extends AppCompatActivity {
    Button btnCalcular, btnGuardar,btnGoBack;
    EditText nombre;
    TextView indice;
=======
public class Main2Activity extends AppCompatActivity {
    Button btnCalcular, btnGuardar,btnGoBack;
    EditText nombre, indice;
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
    EditText altura;
    EditText peso;
    double imc;
    conexionSQL conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        nombre=(EditText)findViewById(R.id.txtNombre);
<<<<<<< HEAD
        indice=(TextView)findViewById(R.id.txtIMC);
=======
        indice=(EditText)findViewById(R.id.txtIMC);
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
        altura=(EditText)findViewById(R.id.numEstatura);
        peso=(EditText)findViewById(R.id.numPeso);
        btnCalcular=(Button)findViewById(R.id.btnCalcular2);
        btnGuardar=(Button)findViewById(R.id.btnGuardar);
        btnGoBack=(Button)findViewById(R.id.btnRegresar);
        conexion=new conexionSQL();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                if(!altura.getText().toString().equals("")&&!peso.getText().toString().equals("")) {
                    imc = Double.parseDouble(peso.getText().toString()) / ((Double.parseDouble(altura.getText().toString())) * Double.parseDouble(altura.getText().toString()));
                    String coso=String.valueOf(imc);
                    coso=coso.substring(0,5);
                    System.out.println(coso);
                    imc=Double.parseDouble(coso);
                    indice.setText("IMC: "+String.valueOf(imc));
                    //Toast.makeText(getApplicationContext(), "El IMC es de:" + imc, Toast.LENGTH_LONG).show();
=======
                //imc=peso*(Double.parseDouble(Double.parseDouble(String.valueOf(altura))*Double.parseDouble(String.valueOf(altura)));
                //double v1=Double.parseDouble(altura.getText().toString())
                if(!altura.getText().toString().equals("")&&!peso.getText().toString().equals("")) {
                    imc = Double.parseDouble(peso.getText().toString()) / ((Double.parseDouble(altura.getText().toString())) * Double.parseDouble(altura.getText().toString()));
                    indice.setText(String.valueOf(imc));
                    Toast.makeText(getApplicationContext(), "El IMC es de:" + imc, Toast.LENGTH_LONG).show();
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
                }else{
                    Toast.makeText(getApplicationContext(), "Llenar minimo los campos de Estatura y Peso", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< HEAD
                if (indice.length()>5) {
                    operacionRegistro op = new operacionRegistro();
                    op.execute("");
=======
                if (!indice.getText().toString().equals("")) {
                    operacionRegistro op = new operacionRegistro();
                    //op.execute();
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
                }else{
                    Toast.makeText(getApplicationContext(), "Es necesario calcular antes de Guardar", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regreso=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(regreso);
            }
        });
    }//Fin del metodo principal
    public class operacionRegistro extends AsyncTask<String,String,String>{
        String msj;

        public void onPreExecute(){

        }

        public void onPostExecute(String r){
<<<<<<< HEAD
            indice.setText("IMC: ");
            Toast.makeText(getApplicationContext(),r,Toast.LENGTH_LONG).show();
            nombre.setText("");
            peso.setText("");
            altura.setText("");
=======
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51

        }


        @Override
        protected String doInBackground(String... strings) {
            Connection con=conexion.CONN();
<<<<<<< HEAD
            System.out.println("Cree la conexion");
            if(con!=null){
                try {
                    PreparedStatement ps=con.prepareStatement("insert into registro (nombre, peso, estatura, imc) values (?, ?, ?, ?)");
                    ps.setString(1,nombre.getText().toString());
                    ps.setDouble(2,Double.parseDouble(peso.getText().toString()));
                    ps.setDouble(3,Double.parseDouble(altura.getText().toString()));
                    ps.setDouble(4,imc);
                    System.out.println("Estoy aqui");
                    if(ps.executeUpdate()>0){
                        //Toast.makeText(getApplicationContext(),"Se registro correctamente",Toast.LENGTH_LONG).show();
                        msj="Se registro correctamente";
                    }
                    con.close();
                } catch (SQLException e) {
                    msj="ocurrio un error en la base de datos";
                    //Toast.makeText(getApplicationContext(),"Ocurrio un error durante el proceso",Toast.LENGTH_LONG).show();
=======
            if(con!=null){
                try {
                    PreparedStatement ps=con.prepareStatement("insert into registro (nombre, peso, estatura, imc) values (?, ?, ?, ?)");
                    ps.setString(1,nombre.toString());
                    ps.setDouble(2,Double.parseDouble(peso.getText().toString()));
                    ps.setDouble(3,Double.parseDouble(altura.getText().toString()));
                    ps.setDouble(4,imc);
                    if(ps.executeUpdate()>0){
                        Toast.makeText(getApplicationContext(),"Se registro correctamente",Toast.LENGTH_LONG).show();
                    }
                    con.close();
                } catch (SQLException e) {
                    Toast.makeText(getApplicationContext(),"Ocurrio un error durante el proceso",Toast.LENGTH_LONG).show();
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
                    e.printStackTrace();
                }
            }else{
                //No conecto a la base de datos
<<<<<<< HEAD
                msj="No conecto la base de datos";
                //Toast.makeText(getApplicationContext(),"No se conecto a la base de datos",Toast.LENGTH_LONG).show();
=======
                Toast.makeText(getApplicationContext(),"No se conecto a la base de datos",Toast.LENGTH_LONG).show();
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
            }
            return msj;
        }
    }
}//Fin de la clase
