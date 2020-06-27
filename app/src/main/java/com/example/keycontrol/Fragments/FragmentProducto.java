package com.example.keycontrol.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;
import com.google.android.material.snackbar.Snackbar;

public class FragmentProducto extends Fragment implements View.OnClickListener{

//    private String nombre;
//    private double precio;
//    private String colorLed;
//    private int img;
//    private String descripcion;

    public Teclado teclado;

    private OnEliminarProductoListener eliminarProductoListener;

    View vistaLayout;

    ImageView imagen;
    TextView nombre;
    TextView precio;

    Button botonBorrar;
    Button botonEditar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        vistaLayout = inflater.inflate(R.layout.producto_fragment, container, false);

        imagen = vistaLayout.findViewById(R.id.imagen_producto);
        nombre = vistaLayout.findViewById(R.id.nombre_producto);
        precio = vistaLayout.findViewById(R.id.precio_producto);

        botonBorrar = vistaLayout.findViewById(R.id.boton_borrar);
        botonBorrar.setOnClickListener(this);

        botonEditar = vistaLayout.findViewById(R.id.boton_editar);
        botonEditar.setOnClickListener(this);

        nombre.setText(teclado.getNombre());
        imagen.setImageResource(teclado.getImg());
        precio.setText(teclado.getPrecio() + "");

        return vistaLayout;

    }

    public static FragmentProducto newInstance(){

        FragmentProducto fragmentProducto = new FragmentProducto();

        return fragmentProducto;

    }



    public interface OnEliminarProductoListener{

        void onEliminarProductoClick(Teclado t);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.boton_borrar){

            Snackbar.make(vistaLayout, "Presiona borrar para confirmar", Snackbar.LENGTH_LONG)
                    .setAction("Borrar", new View.OnClickListener(){

                        @Override
                        public void onClick(View v){

                            eliminarProductoListener.onEliminarProductoClick(teclado);

                            Toast.makeText(getContext(), teclado.getNombre() +  " se ha borrado correctamente", Toast.LENGTH_LONG).show();

                        }

                    })
                    .setActionTextColor(getResources().getColor(R.color.colorSecundary))
                    .show();

        }

        if(v.getId() == R.id.boton_editar){

            Snackbar.make(vistaLayout, "Presiona el boton para editar", Snackbar.LENGTH_LONG)
                    .setAction("Editar", new View.OnClickListener(){

                        @Override
                        public void onClick(View v){

                            FragmentManager supportFragmentManager = getFragmentManager();

                            FragmentTransaction transaction = supportFragmentManager.beginTransaction();

                            FragmentEditarProducto editar = FragmentEditarProducto.newInstance();

                            editar.teclado = teclado;

                            transaction.replace(R.id.layout_container, editar);

                            transaction.commit();

                        }

            }).setActionTextColor(getResources().getColor(R.color.colorSecundary))
                    .show();


        }

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof FragmentListadoProductos.OnFragmentListadoProductosListener){
            eliminarProductoListener = (OnEliminarProductoListener) context;
        }

    }

}
