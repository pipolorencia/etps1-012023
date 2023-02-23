package com.example.parcial01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class CaliMC extends AppCompatActivity {
    private EditText peso,altura;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cali_mc);
        peso = (EditText)findViewById(R.id.txtpeso);
        altura = (EditText)findViewById(R.id.txtaltura);

        mensaje = (TextView)findViewById(R.id.mensaje);
    }

    public void masaCorporal(View view){
        double dimc = 0;
        dimc = Double.parseDouble(peso.getText().toString())/(Double.parseDouble(altura.getText().toString())*Double.parseDouble(altura.getText().toString()));
        //imc.setText(String.valueOf(dimc));
       if (dimc < 10.5){

            mensaje.setText("Estado: Críticamente Bajo de Peso");
        }else if (dimc < 15.9){
            mensaje.setText("Estado: Severamente Bajo de Peso");
        }else if (dimc < 18.5){
            mensaje.setText("Estado: SobrePeso");
        }else if (dimc < 25){
            mensaje.setText("Estado: Normal (Peso Saludable)");
        }else if (dimc < 30){
            mensaje.setText("Sobrepeso");
        }else if (dimc < 35){
            mensaje.setText("Estado: Obesidad Clase 1 - Moderadamente Obeso");
        }else if (dimc < 40){
            mensaje.setText("Estado: Obesidad Clase 2 - Severamente Obeso");
        }else if (dimc > 50){
            mensaje.setText("Estado: Obesidad Clase 3 - Criticamente Obeso");
        }else{
            mensaje.setText("Valores ingresados incorrectamente, Vuelva a ingresarlos por favor");
        }
        /*if (dimc < 10.5){
            mensaje.setText("Su peso ingresado: "+peso.getText().toString()+ "\nSu altura ingresado:"+altura.getText().toString()+"\nEstado: Críticamente Bajo de Peso");
        }else if (dimc < 15.9){
            mensaje.setText("Su peso ingresado: "+peso.getText().toString()+ "\nSu altura ingresado:"+altura.getText().toString()+"\nEstado: Severamente Bajo de Peso");
        }else if (dimc < 18.5){
            mensaje.setText("Su peso ingresado: "+peso.getText().toString()+ "\nSu altura ingresado:"+altura.getText().toString()+"\nEstado: SobrePeso");
        }else if (dimc < 25){
            mensaje.setText("Su peso ingresado: "+peso.getText().toString()+ "\nSu altura ingresado:"+altura.getText().toString()+"\nEstado: Normal (Peso Saludable)");
        }else if (dimc < 30){
            mensaje.setText("Su peso ingresado: "+peso.getText().toString()+ "\nSu altura ingresado:"+altura.getText().toString()+"\nSobrepeso");
        }else if (dimc < 35){
            mensaje.setText("Su peso ingresado: "+peso.getText().toString()+ "\nSu altura ingresado:"+altura.getText().toString()+"\nEstado: Obesidad Clase 1 - Moderadamente Obeso");
        }else if (dimc < 40){
            mensaje.setText("Su peso ingresado: "+peso.getText().toString()+ "\nSu altura ingresado:"+altura.getText().toString()+"\nEstado: Obesidad Clase 2 - Severamente Obeso");
        }else if (dimc > 50){
            mensaje.setText("Su peso ingresado: "+peso.getText().toString()+ "\nSu altura ingresado:"+altura.getText().toString()+"\nEstado: Obesidad Clase 3 - Criticamente Obeso");
        }else{
            mensaje.setText("Valores ingresados incorrectamente, Vuelva a ingresarlos por favor");
        }*/
    }
}