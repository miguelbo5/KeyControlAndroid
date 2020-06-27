package com.example.keycontrol.Pedidos;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;

public class PedidosViewHolder  extends RecyclerView.ViewHolder{

    private ImageView imgProducto;
    private TextView tv_nombre;
    private TextView tv_precio;
    private Context contexto;

    public PedidosViewHolder(View itemView, Context contexto){
        super(itemView);

        imgProducto = itemView.findViewById(R.id.img_pedido);
        tv_nombre = itemView.findViewById(R.id.tv_nombre_pedido);
        tv_precio = itemView.findViewById(R.id.tv_precio_pedido);
        this.contexto = contexto;

    }

    public void bindTecladoPedido(Teclado t){

        imgProducto.setImageDrawable(contexto.getDrawable(t.getImg()));

        tv_nombre.setText(t.getNombre());

        tv_precio.setText((int) t.getPrecio() + "€");
    }

}
