package com.example.parcial01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         username = (EditText)findViewById(R.id.txtUSer);
         password = (EditText)findViewById(R.id.txtPass);
    }
    public void login(View view){

        if(!username.getText().toString().isEmpty() || password.getText().toString().isEmpty())
        {
            if(username.getText().toString().equals("parcialETps1") && password.getText().toString().equals("p4rC14l#tp$")){
                Intent intento=new Intent(this,CaliMC.class);
                startActivity(intento);

            }
            }

        else{
            System.out.println("los datos vienen vacios");
            if(username.getText().toString().isEmpty()){
                username.setError("Favor de escribir algo");
            }else if(password.getText().toString().isEmpty()){
                password.setError("Favor de escribir contraseña");
            }

        }

       };
}