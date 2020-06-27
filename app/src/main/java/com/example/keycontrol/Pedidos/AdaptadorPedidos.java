package com.example.keycontrol.Pedidos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;
import com.example.keycontrol.Tienda.TecladosViewHolder;

import java.util.ArrayList;

public class AdaptadorPedidos extends RecyclerView.Adapter<PedidosViewHolder> {

    private ArrayList<Teclado> teclados;
    private Context context;

    public AdaptadorPedidos(Context context, ArrayList<Teclado> teclados){

        this.context = context;
        this.teclados = teclados;

    }

    @Override
    public PedidosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.elemento_pedido, viewGroup, false);

        PedidosViewHolder viewHolder = new PedidosViewHolder(itemView, context);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(PedidosViewHolder viewHolder, int posicion){

        Teclado teclado = teclados.get(posicion);
        viewHolder.bindTecladoPedido(teclado);

    }

    @Override
    public int getItemCount(){

        return teclados.size();

    }

}
