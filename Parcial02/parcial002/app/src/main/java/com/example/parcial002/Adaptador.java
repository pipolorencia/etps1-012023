package com.example.parcial002;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class Adaptador extends BaseAdapter {

    private static layoutinflater inflater= null;
    Context contexto;
    String[][] datos;
    int [] datosimg;
    @SuppressLint("ServiceCast")
    public Adaptador(Context contexto, String[][]datos, int[]imagenes){
        this.contexto=contexto;
        this.datos=datos;
        this.datosimg=imagenes;
        inflater=(layoutinflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView titulo = (TextView) vista.findViewById(R.id.lbnombre);
        TextView duracion = (TextView) vista.findViewById(R.id.lbcargo);
        TextView director = (TextView) vista.findViewById(R.id.lbcompañia);

        ImageView imagen = (ImageView) vista.findViewById(R.id.imageView);


        titulo.setText(datos[i][0]);
        director.setText(datos[i][1]);
       // imagen.setImageResource(datosImg[i]);

        imagen.setTag(i);

        return vista;
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
