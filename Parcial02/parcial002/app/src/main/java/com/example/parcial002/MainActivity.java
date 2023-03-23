package com.example.parcial002;

import static com.example.parcial002.R.id.lvlista;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    String[][]datos= {
            {"alexander","ceo","Insure S.O"},
            {"Carlos lopez","sistente","Hospital blue"},
            {"Sara bonz","Directira de marekting","Electrical parts"},
            {"liliana clarence","Diseñadora de poducto","Creativa App"},
            {"Benito Peralta","Supervisor de ventas","Neumaticos prees"},
            {"Juan Jaramillo", "CEO", "Banco Nacional"},
            {"Christian Steps", "CTO", "Cooperativa Verde"},
            {"Alexa Giraldo", "Lead Programmer", "Frutisofy"},
            {"Linda Murillo", "Directora de Marketing", "Seguros Boliver"},
            {"Lizeth Astrada", "CEO", "Concesionario Motolox"}
    };

    int[] datosImg ={R.drawable.lead_photo_1,R.drawable.lead_photo_2,R.drawable.lead_photo_3,R.drawable.lead_photo_4,
            R.drawable.lead_photo_5,R.drawable.lead_photo_6,R.drawable.lead_photo_7,R.drawable.lead_photo_8,R.drawable.lead_photo_9,
            R.drawable.lead_photo_10};
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=(ListView) findViewById(lvlista);

    }


}