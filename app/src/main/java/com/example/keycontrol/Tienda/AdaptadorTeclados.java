package com.example.keycontrol.Tienda;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.keycontrol.Fragments.FragmentProducto;
import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;

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

        itemView.setOnClickListener(this);

        TecladosViewHolder viewHolder = new TecladosViewHolder(itemView, context);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(TecladosViewHolder viewHolder, int posicion){

        Teclado teclado = teclados.get(posicion);

        viewHolder.bindTeclado(teclado);

    }

    @Override
    public int getItemCount() {
        return teclados.size();
    }

    @Override
    public void onClick(View v) {

        if(listener != null){

            listener.onClick(v);

        }

    }

    public void setOnClickListener(View.OnClickListener listener){

        this.listener = listener;

    }
}
