package com.example.ejemconexionbasededatoa;

<<<<<<< HEAD
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity {

    EditText txtUsu, txtContra;
    Button btnEntrar;
    ProgressBar pbInicio;
    conexionSQL con;

=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

>>>>>>> 96ae4aa0c75834514dbda548da6d33df13d7221c
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        txtUsu=(EditText)findViewById(R.id.txtUsuario);
        txtContra=(EditText)findViewById(R.id.txtContrasena);
        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        pbInicio=(ProgressBar)findViewById(R.id.pbInicio);
        con=new conexionSQL();

        pbInicio.setVisibility(View.GONE);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("\n\n\n------------------Boton entrar\n\n\n");
                inicioSesion is=new inicioSesion();
                is.execute("");
            }
        });//Fin de el metodo onClic del btn inicio
    }//fin de el metodo principal
    public class inicioSesion extends AsyncTask<String,String,String> {
        boolean entrar = false;
        String mensaje;
        String usuario = txtUsu.getText().toString();
        String contra = txtContra.getText().toString();

        ////OLIVER, SI VES ESTO ERES PUTO
        @Override
        public void onPreExecute() {
            pbInicio.setVisibility(View.VISIBLE);
        }

        @Override
        public void onPostExecute(String r) {
            pbInicio.setVisibility(View.GONE);
            Toast.makeText(getApplicationContext(), r, Toast.LENGTH_LONG).show();
            if (entrar) {
                Intent ventana = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(ventana);
            }//Fin de el si Entrar es verdadero
        }//Termina onPostExecute(String r)

        @Override
        protected String doInBackground(String... strings) {
            if (usuario.trim().equals("") || contra.trim().equals("")) {
                mensaje = "No se permiten campos vacios";
            } else {
                Connection conn = con.CONN();
                if (conn!=null) {
                    String query = "select * from empleado where usuario=? and contrasena=?";
                    try {
                        PreparedStatement ps = conn.prepareStatement(query);
                        ps.setString(1, usuario);
                        ps.setString(2, contra);
                        ResultSet rs = ps.executeQuery();
                        if (rs.next()) {
                            mensaje = "Bienvenido al Sistema";
                            entrar = true;
                        } else {
                            mensaje = "Usuario o contrasena invalidos";
                        }
                    } catch (SQLException e) {
                        //e.printStackTrace();//el usuario final no debe ver el error que esta sucediendo
                        mensaje = "Error en la operacion de base de datos: " + e.getMessage();
                    }
                } else {
                    mensaje = "Error al conectar la base de datos";
                }
                /*try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }*/
            }
            return mensaje;
        }
    }
}//Fin de la clase
=======
    }
}
>>>>>>> 96ae4aa0c75834514dbda548da6d33df13d7221c
