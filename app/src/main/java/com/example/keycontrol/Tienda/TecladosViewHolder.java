package com.example.keycontrol.Tienda;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;

public class TecladosViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgProducto;
    private TextView tv_nombre;
    private TextView tv_precio;
    private Context contexto;

    public TecladosViewHolder(View itemView, Context contexto){
        super(itemView);

        imgProducto = itemView.findViewById(R.id.img_producto);
        tv_nombre = itemView.findViewById(R.id.texto_nombre);
        tv_precio = itemView.findViewById(R.id.texto_precio);
        this.contexto = contexto;

    }

    public void bindTeclado(Teclado t){

        imgProducto.setImageDrawable(contexto.getDrawable(t.getImg()));

        tv_nombre.setText(t.getNombre());

        tv_precio.setText((int) t.getPrecio() + "€");
    }

}
