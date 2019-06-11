package com.example.indicedemasacorporal;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionSQL {
    String ip = "192.168.100.138:1433";//conectarse a internet y poner la ip que me asignen aqui - debe ser del servidor
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "imcDB";
    String un = "sa";
    String password = "12345";

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName(classs);
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";" + "databaseName=" + db + ";user=" + un + ";password=" + password;
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            conn=null;
            Log.e("ERROR", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
        return conn;
    }
}//Fin de la clase
