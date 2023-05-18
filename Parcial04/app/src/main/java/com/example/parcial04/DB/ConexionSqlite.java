package com.example.parcial04.DB;

import androidx.annotation.Nullable;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSqlite extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "Clientes.db";
    private static final int DATABASE_VERSION = 1;

    public ConexionSqlite(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // tabla MD_Clientes
        String createClientesTableQuery = "CREATE TABLE MD_Clientes (" +
                "ID_Cliente INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "sNombreCliente TEXT, " +
                "sApellidosCliente TEXT, " +
                "sDireccionCliente TEXT, " +
                "sCiudadCliente TEXT)";
        db.execSQL(createClientesTableQuery);

        // tabla MD_Vehiculos
        String createVehiculosTableQuery = "CREATE TABLE MD_Vehiculos (" +
                "ID_Vehiculo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "sMarca TEXT, " +
                "sModelo TEXT)";
        db.execSQL(createVehiculosTableQuery);

        // tabla MD_ClienteVehiculo
        String createClienteVehiculoTableQuery = "CREATE TABLE MD_ClienteVehiculo (" +
                "ID_Cliente INTEGER, " +
                "ID_Vehiculo INTEGER, " +
                "sMatricula TEXT, " +
                "iKilometros INTEGER, " +
                "FOREIGN KEY (ID_Cliente) REFERENCES MD_Clientes(ID_Cliente), " +
                "FOREIGN KEY (ID_Vehiculo) REFERENCES MD_Vehiculos(ID_Vehiculo))";
        db.execSQL(createClienteVehiculoTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // metodo para actualizar la base si se desea en algun caso
    }

    public void insertarRegistros() {
        SQLiteDatabase db = getWritableDatabase();

        // Inserción de registros en la tabla MD_Clientes
        //registro1
        ContentValues valoresCliente1 = new ContentValues();
        valoresCliente1.put("sNombreCliente", "Juan");
        valoresCliente1.put("sApellidosCliente", "Pérez");
        valoresCliente1.put("sDireccionCliente", "Calle 123");
        valoresCliente1.put("sCiudadCliente", "Ciudad A");
        db.insert("MD_Clientes", null, valoresCliente1);
        //registro2
        ContentValues valoresCliente2 = new ContentValues();
        valoresCliente2.put("sNombreCliente", "María");
        valoresCliente2.put("sApellidosCliente", "López");
        valoresCliente2.put("sDireccionCliente", "Avenida 456");
        valoresCliente2.put("sCiudadCliente", "Ciudad B");
        db.insert("MD_Clientes", null, valoresCliente2);

        // Inserción de registros en la tabla MD_Vehiculos
        //registro1
        ContentValues valoresVehiculo1 = new ContentValues();
        valoresVehiculo1.put("sMarca", "Toyota");
        valoresVehiculo1.put("sModelo", "Corolla");
        db.insert("MD_Vehiculos", null, valoresVehiculo1);
        //registro2
        ContentValues valoresVehiculo2 = new ContentValues();
        valoresVehiculo2.put("sMarca", "Honda");
        valoresVehiculo2.put("sModelo", "Civic");
        db.insert("MD_Vehiculos", null, valoresVehiculo2);

        // Inserción de registros en la tabla MD_ClienteVehiculo
        //registro1
        ContentValues valoresClienteVehiculo1 = new ContentValues();
        valoresClienteVehiculo1.put("ID_Cliente", 1);
        valoresClienteVehiculo1.put("ID_Vehiculo", 1);
        valoresClienteVehiculo1.put("sMatricula", "ABC123");
        valoresClienteVehiculo1.put("iKilometros", 10000);
        db.insert("MD_ClienteVehiculo", null, valoresClienteVehiculo1);
        //registro2
        ContentValues valoresClienteVehiculo2 = new ContentValues();
        valoresClienteVehiculo2.put("ID_Cliente", 2);
        valoresClienteVehiculo2.put("ID_Vehiculo", 3);
        valoresClienteVehiculo2.put("sMatricula", "DEF456");
        valoresClienteVehiculo2.put("iKilometros", 20000);
        db.insert("MD_ClienteVehiculo", null, valoresClienteVehiculo2);

        db.close();
    }
}