package com.example.ejemconexionbasededatoa;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import net.sourceforge.jtds.jdbcx.proxy.PreparedStatementProxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main2Activity extends AppCompatActivity {
    EditText numEmpleado, nomEmpleado, puestoEmpleado, sueldoEmpleadom, usuarioEmpleado, contrasenaEmpleado;
    Button btnConsultarEmpleado, btnNuevoEmpleado, btnModificarEmpleado, btnEliminarEmpleado;
    conexionSQL conexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Enlazar cajas de texto
        numEmpleado=(EditText)findViewById(R.id.txtNumEmpleado);
        nomEmpleado=(EditText)findViewById(R.id.txtNombreEmpleado);
        puestoEmpleado=(EditText)findViewById(R.id.txtPuestoEmpleado);
        sueldoEmpleadom=(EditText)findViewById(R.id.txtSueldo);
        usuarioEmpleado=(EditText)findViewById(R.id.txtUsuario);
        contrasenaEmpleado=(EditText)findViewById(R.id.txtContrasena);

        //Botones
        btnConsultarEmpleado=(Button)findViewById(R.id.btnBuscar);
        btnNuevoEmpleado=(Button)findViewById(R.id.btnNuevo);
        btnModificarEmpleado=(Button)findViewById(R.id.btnGuardar);
        btnEliminarEmpleado=(Button)findViewById(R.id.btnEliminar);

        //Crear instancia de la clase conexion
        conexion=new conexionSQL();

        //Crear accioneas al presionar los botones
        btnConsultarEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacionC op=new operacionC();
                System.out.println("entrando a buscar");
                op.execute("");
            }
        });
        btnNuevoEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Entro a hacer una insercion");
                operacionABM op=new operacionABM();
                op.execute("insert into empleado (nombre, puesto, sueldo, usuario, contrasena) values (?, ?, ?, ?, ?)","G");
            }
        });
        btnModificarEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Entro a modificar");
                operacionABM op=new operacionABM();
                op.execute("update empleado set nombre=?, puesto=?, sueldo=?, usuario=?, contrasena=? where idEmpleado=?","M");
            }
        });
        btnEliminarEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Elimino un empleado");
                operacionABM opabm=new operacionABM();
                opabm.execute("delete from empleado where idEmpleado=?","E");//Se dejan comillas vacias se dejan vaciAS PORQUE EL METODO NECESITA PARAMETROS STRING
            }
        });
    }//Fin de el metodo principal
    public class operacionABM extends AsyncTask<String,String,String> {
        String id=numEmpleado.getText().toString();
        boolean exito=false;

        public void onPreExecute(){

        }

        public void onPostExecute(String r){
            Toast.makeText(getApplicationContext(),r,Toast.LENGTH_LONG).show();
            if(exito){
                numEmpleado.setText("");
                nomEmpleado.setText("");
                puestoEmpleado.setText("");
                sueldoEmpleadom.setText("");
                usuarioEmpleado.setText("");
                contrasenaEmpleado.setText("");
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            String msj="";
            Connection con= conexion.CONN();
            if(con!=null){
                System.out.println("Reviso la conexion diferente de nula");
                try {
                    PreparedStatement ps = con.prepareStatement(strings[0]);
                    if(strings[1].equals("E")){
                        ps.setInt(1,Integer.parseInt(id));
                    }else if(strings[1].equals("G")){//G por guardar
                        ps.setString(1,nomEmpleado.getText().toString());
                        ps.setString(2,puestoEmpleado.getText().toString());
                        ps.setDouble(3,Double.parseDouble(sueldoEmpleadom.getText().toString()));
                        ps.setString(4,usuarioEmpleado.getText().toString());
                        ps.setString(5,contrasenaEmpleado.getText().toString());
                    }else if(strings[1].equals("M")){//Modificar
                        ps.setString(1,nomEmpleado.getText().toString());
                        ps.setString(2,puestoEmpleado.getText().toString());
                        ps.setDouble(3,Double.parseDouble(sueldoEmpleadom.getText().toString()));
                        ps.setString(4,usuarioEmpleado.getText().toString());
                        ps.setString(5,contrasenaEmpleado.getText().toString());
                        ps.setInt(6,Integer.parseInt(numEmpleado.getText().toString()));
                    }

                    if(ps.executeUpdate() > 0){
                        exito=true;
                        if(strings[1].equals("E")){
                            msj="Registro Elimindado";
                        }else if(strings[1].equals("G")){
                            msj="Registro Guardado";
                        }else if(strings[1].equals("M")){
                            msj="Registro Modificado";
                        }
                    }else{
                        if(strings[1].equals("E")){
                            msj="No se elimindo";
                        }else if(strings[1].equals("")){
                            msj="NO se guardo el registro";
                        }else if(strings[1].equals("M")){
                            msj="NO modifico el registro";
                        }
                    }
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }else{
                msj="Error al conectar";
            }
            return msj;
        }
    }//fin de la subclase operacion ABM

    public class operacionC  extends AsyncTask<String,String,String>{
    String msj="";
    String nombre="";
    boolean exito=false;
    String id, nom, pues, sue, usu, pass;


        public void onPreExecute(){

        }

        public void onPostExecute(String r){
            if(exito){
                numEmpleado.setText(id);
                nomEmpleado.setText(nom);
                puestoEmpleado.setText(pues);
                sueldoEmpleadom.setText(sue);
                usuarioEmpleado.setText(usu);
                contrasenaEmpleado.setText(pass);
            }else{
                msj="No se encontro a la persona";;
            }
        }

        @Override
        protected String doInBackground(String... strings) {
            Connection con=conexion.CONN();
            if(con!=null){
                String query="select * from empleado where nombre=? or idEmpleado=?";
                try {
                    PreparedStatement ps=con.prepareStatement(query);
                    ps.setString(1, nomEmpleado.getText().toString());
                    ps.setInt(2, Integer.parseInt(numEmpleado.getText().toString()));
                    ResultSet rs=ps.executeQuery();
                    if(rs.next()){
                        exito=true;
                        id=String.valueOf(rs.getInt("idEmpleado"));
                        nom=rs.getString("nombre");
                        pues=rs.getString("puesto");
                        sue=String.valueOf(rs.getDouble("sueldo"));
                        usu=rs.getString("usuario");
                        pass=rs.getString("contrasena");
                    }
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else{
                msj="Error al conectar con la base de datos";
            }
            return msj;
        }//
    }//fin de operacion consultar
}//Fin de la clase
