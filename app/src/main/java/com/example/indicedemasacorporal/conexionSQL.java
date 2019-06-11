package com.example.indicedemasacorporal;

<<<<<<< HEAD
import android.annotation.SuppressLint;
=======
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionSQL {
<<<<<<< HEAD
    String ip = "192.168.100.138:1433";//conectarse a internet y poner la ip que me asignen aqui - debe ser del servidor
    String classs = "net.sourceforge.jtds.jdbc.Driver";
=======
    String ip = "192.168.1.70:1433";//conectarse a internet y poner la ip que me asignen aqui - debe ser del servidor
    String classs = "net.sourceforget.jtds.jbdc.Driver";
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
    String db = "imcDB";
    String un = "sa";
    String password = "12345";

<<<<<<< HEAD
    @SuppressLint("NewApi")
=======
    //@SuppressLint("NewApi")
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName(classs);
<<<<<<< HEAD
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";" + "databaseName=" + db + ";user=" + un + ";password=" + password;
=======
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";" + "databaseName=" + db + "; user=" + un + "password=" + password;
>>>>>>> d3737ae1b659f6b72f1425142f7b5b218c228b51
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
