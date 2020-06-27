package com.example.keycontrol;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorTeclados extends RecyclerView.Adapter<TecladosViewHolder> implements View.OnClickListener{

    private ArrayList<Teclado> teclados;
    private Context context;
    private View.OnClickListener listener;

    public AdaptadorTeclados(Context context, ArrayList<Teclado> teclados){

        this.context = context;
        this.teclados = teclados;

    }

    @Override
    public TecladosViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){

        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.elemento_lista, viewGroup, false);

        TecladosViewHolder viewHolder = new TecladosViewHolder(itemView, context);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(TecladosViewHolder viewHolder, int posicion){

        Teclado teclado = teclados.get(posicion);
        viewHolder.bindTeclado(teclado);

    }

    @Override
    public int getItemCount(){

        return teclados.size();

    }

    @Override
    public void onClick(View v) {

        if(listener != null){

            listener.onClick(v);

        }

    }
}
