package com.example.parcial4;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listClienteVehiculo;
    private ConexionSqlite databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listClienteVehiculo = findViewById(R.id.listClienteVehiculo);
        databaseHelper = new ConexionSqlite(this);

        mostrarClienteVehiculo();
    }

    private void mostrarClienteVehiculo() {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();

        String query = "SELECT MD_Clientes.sNombreCliente, MD_Clientes.sApellidosCliente, " +
                "MD_Vehiculos.sMarca, MD_Vehiculos.sModelo, " +
                "MD_ClienteVehiculo.sMatricula, MD_ClienteVehiculo.iKilometros " +
                "FROM MD_ClienteVehiculo " +
                "INNER JOIN MD_Clientes ON MD_ClienteVehiculo.ID_Cliente = MD_Clientes.ID_Cliente " +
                "INNER JOIN MD_Vehiculos ON MD_ClienteVehiculo.ID_Vehiculo = MD_Vehiculos.ID_Vehiculo";

        Cursor cursor = db.rawQuery(query, null);

        List<String> clienteVehiculos = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow("sNombreCliente"));
                String apellidos = cursor.getString(cursor.getColumnIndexOrThrow("sApellidosCliente"));
                String marca = cursor.getString(cursor.getColumnIndexOrThrow("sMarca"));
                String modelo = cursor.getString(cursor.getColumnIndexOrThrow("sModelo"));
                String matricula = cursor.getString(cursor.getColumnIndexOrThrow("sMatricula"));
                int kilometros = cursor.getInt(cursor.getColumnIndexOrThrow("iKilometros"));

                String registro = "Cliente: " + nombre + " " + apellidos + "\n" +
                        "Vehículo: " + marca + " " + modelo + "\n" +
                        "Matrícula: " + matricula + "\n" +
                        "Kilómetros: " + kilometros;

                clienteVehiculos.add(registro);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, clienteVehiculos);
        listClienteVehiculo.setAdapter(adapter);
    }
}

