package com.example.keycontrol.Carrito;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;

public class TecladosCarritoViewHolder extends RecyclerView.ViewHolder{


        private ImageView imgProducto;
        private TextView tv_nombre;
        private TextView tv_precio;
        private Context contexto;

        public TecladosCarritoViewHolder(View itemView, Context contexto){
            super(itemView);

            imgProducto = itemView.findViewById(R.id.img_producto_carrito);
            tv_nombre = itemView.findViewById(R.id.tv_nombre_carrito);
            tv_precio = itemView.findViewById(R.id.tv_precio_carrito);
            this.contexto = contexto;

        }

        public void bindTecladoCarrito(Teclado t){

            imgProducto.setImageDrawable(contexto.getDrawable(t.getImg()));

            tv_nombre.setText(t.getNombre());

            tv_precio.setText((int) t.getPrecio() + "€");
        }

    }