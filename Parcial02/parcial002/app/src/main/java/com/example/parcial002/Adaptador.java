package com.example.parcial002;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater= null;
    Context contexto;
    String[][] datos;
    int [] datosimg;

    public Adaptador(Context contexto, String[][]datos, int[]imagenes){
        this.contexto=contexto;
        this.datos=datos;
        this.datosimg=imagenes;
        inflater=(LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView nombre = (TextView) vista.findViewById(R.id.lbnombre);
        TextView cargo = (TextView) vista.findViewById(R.id.lbcargo);
        TextView compañia = (TextView) vista.findViewById(R.id.lbcompañia);
        ImageView imagen=(ImageView)vista.findViewById(R.id.imageView);
        nombre.setText(datos[i][0]);
        cargo.setText(datos[i][1]);
        compañia.setText(datos[i][2]);
        imagen.setImageResource(datosimg[i]);
        return vista;
    }
    @Override
    public int getCount() {
        return datosimg.length;
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
