package com.example.keycontrol.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;
import com.example.keycontrol.Tienda.AdaptadorTeclados;

import java.util.ArrayList;

public class FragmentListadoProductos extends Fragment implements View.OnClickListener {

    public ArrayList<Teclado> teclados;
    private RecyclerView recyclerView;
    public AdaptadorTeclados adaptador;
    private RecyclerView.LayoutManager layoutManager;


    private Spinner spinnerMarca;
    private Spinner spinnerColor;

    private Button botonCrearProducto;

    private OnProductoListener productoListener;

    private OnFragmentListadoProductosListener listadoListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vistaLayout = inflater.inflate(R.layout.listado_productos_fragment, container, false);

        recyclerView = vistaLayout.findViewById(R.id.rv_productos);

        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        adaptador = new AdaptadorTeclados(getContext(), teclados);

        adaptador.setOnClickListener(this);

        recyclerView.setAdapter(adaptador);

        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        String[] marcas = new String[]{"Marca", "Logitech", "G.Skill", "Razer"};
        ArrayAdapter<String> adaptadorMarcas = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, marcas);

        spinnerMarca = (Spinner) vistaLayout.findViewById(R.id.spinner_marca);
        adaptadorMarcas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMarca.setAdapter(adaptadorMarcas);

        //Spinner colores
        String[] colores = new String[]{"Color", "Negro", "Rojo", "Verde"};
        ArrayAdapter<String> adaptadorColores = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, colores);

        spinnerColor = (Spinner) vistaLayout.findViewById(R.id.spinner_color);
        adaptadorColores.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerColor.setAdapter(adaptadorColores);

        botonCrearProducto = vistaLayout.findViewById(R.id.boton_crear_producto);
        botonCrearProducto.setOnClickListener(this);

        return vistaLayout;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public interface OnProductoListener {

        void onProductoClick(Teclado t);

    }

    public static FragmentListadoProductos newInstance() {

        FragmentListadoProductos fragmentListadoProductos = new FragmentListadoProductos();

        return fragmentListadoProductos;

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.boton_crear_producto) {
            listadoListener.onFragmentListadoClick();

        } else {
            productoListener.onProductoClick(teclados.get(recyclerView.getChildAdapterPosition(v)));

        }
    }

    public interface OnFragmentListadoProductosListener {

        void onFragmentListadoClick();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentListadoProductosListener) {
            listadoListener = (OnFragmentListadoProductosListener) context;
        }
        if (context instanceof OnProductoListener) {
            productoListener = (OnProductoListener) context;
        }

    }

}
