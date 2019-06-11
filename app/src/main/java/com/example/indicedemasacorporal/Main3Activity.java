package com.example.indicedemasacorporal;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import net.sourceforge.jtds.jdbcx.proxy.PreparedStatementProxy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main3Activity extends AppCompatActivity {
    Button btnSalir;
    TextView bp, pn, sp, o1, o2, o3;
    int bpc, pnc, spc, o1c, o2c, o3c, total;//Contadores
    double bpn, pnn, spn, o1n, o2n, o3n;//Porcentajes
    conexionSQL conexion;
    buscarTodos b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        conexion=new conexionSQL();
        btnSalir=(Button)findViewById(R.id.btnBack);
        bp=(TextView)findViewById(R.id.numBP);//>18.5
        pn=(TextView)findViewById(R.id.numPN);//18.5-24.9
        sp=(TextView)findViewById(R.id.numSp);//25 - 29.9
        o1=(TextView)findViewById(R.id.numO1);//30 - 34.9
        o2=(TextView)findViewById(R.id.numO2);//35 - 40
        o3=(TextView)findViewById(R.id.numO3);//<40
        //Empieza la razon de existir de la ventana
        System.out.println("Creo los objetos y enlaces");
        b=new buscarTodos();
        System.out.println("Ejecuto la wea");
        b.execute("");

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ventana=new Intent(Main3Activity.this, MainActivity.class);
                startActivity(ventana);
            }
        });




    }//Fin del metodo principal
    public class buscarTodos extends AsyncTask<String,String,String> {
        @Override
        protected String doInBackground(String... strings) {
            Connection con=conexion.CONN();
            if(con!=null){
                try {
                    PreparedStatement ps=con.prepareStatement("select * from registro");
                    ResultSet rs=ps.executeQuery();
                    while(rs.next()){
                        System.out.println(rs.getDouble("imc"));
                        if(rs.getDouble("imc")<18.5){
                            bpc++;}
                        else if(rs.getDouble("imc")>=18.5&&rs.getDouble("imc")<25){
                            pnc++;}
                        else if(rs.getDouble("imc")>=25&&rs.getDouble("imc")<30){
                            spc++;}
                        else if(rs.getDouble("imc")>=30&&rs.getDouble("imc")<35){
                            o1c++;}
                        else if(rs.getDouble("imc")>=35&&rs.getDouble("imc")<40){
                            o2c++;}
                        else if(rs.getDouble("imc")>=40){
                            o3c++;}
                    }
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        public void onPreExecute(){

        }

        public void onPostExecute(String r){
            total=bpc+pnc+spc+o1c+o2c+o3c;
            System.out.println("El total es de: "+total);
            System.out.println(bpc);
            System.out.println(pnc);
            System.out.println(spc);
            System.out.println(o1c);
            System.out.println(o2c);
            System.out.println(o3c);
            bpn=(double)bpc*100/total;
            pnn=(double)pnc*100/total;
            spn=(double)spc*100/total;
            o1n=(double)o1c*100/total;
            o2n=(double)o2c*100/total;
            o3n=(double)o3c*100/total;
            //regla de 3, ((X)100)/total
            //si total es 100% - 6
            //cuanto es el % - x
            //
            bp.setText(String.valueOf(bpn)+"%");
            pn.setText(String.valueOf(pnn)+"%");
            sp.setText(String.valueOf(spn)+"%");
            o1.setText(String.valueOf(o1n)+"%");
            o2.setText(String.valueOf(o2n)+"%");
            o3.setText(String.valueOf(o3n)+"%");

        }
    }
}//Fin de la clase
