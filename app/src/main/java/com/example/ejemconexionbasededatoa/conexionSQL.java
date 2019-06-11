package com.example.ejemconexionbasededatoa;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*poner permisos para la conexion a la base de datos en android/app/minifests/androidManifest.xml
poner el driver desde project/app/libs/-AddLibrary
* <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
* */

public class conexionSQL {
<<<<<<< HEAD
    String ip = "192.168.43.12:1433";//conectarse a internet y poner la ip que me asignen aqui - debe ser del servidor
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "empresa";
    String un = "sa";
    String password = "12345";
=======
    String ip = "192.168.56.1:1433";
    String classs = "net.sourceforget.jtds.jbdc.Driver";
    String db = "empresa";
    String un = "android";
    String password = "1234567";
>>>>>>> 96ae4aa0c75834514dbda548da6d33df13d7221c

    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName(classs);
<<<<<<< HEAD
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";" + "databaseName=" + db + ";user=" + un + ";password=" + password;
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            conn=null;
=======
            ConnURL = "jdbc:jtds.sqlserver://" + ip + ";" + "databaseName=" + db + "; user=" + un + "password=" + password;
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
>>>>>>> 96ae4aa0c75834514dbda548da6d33df13d7221c
            Log.e("ERROR", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERROR", e.getMessage());
        } catch (Exception e) {
            Log.e("ERROR", e.getMessage());
        }
        return conn;
    }
}
