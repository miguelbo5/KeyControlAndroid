package com.example.keycontrol.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FragmentNuevoProducto extends Fragment implements View.OnClickListener {

    private EditText editTextNombre;
    private EditText editTextPrecio;
    private EditText editTextColor;
    private EditText editTextDescripcion;
    private Button botonCrear;
    private Button botonAtras;

    private OnFragmentListadoProductoNuevo productoNuevoListener;
    public int listadoSize;

    private int myFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vistaLayout = inflater.inflate(R.layout.nuevo_producto_fragment, container, false);

        editTextNombre = vistaLayout.findViewById(R.id.et_nombre_teclado);
        editTextPrecio = vistaLayout.findViewById(R.id.et_precio_teclado);
        editTextColor = vistaLayout.findViewById(R.id.et_color_teclado);
        editTextDescripcion = vistaLayout.findViewById(R.id.et_descripcion_teclado);

        if (savedInstanceState != null) {

            editTextNombre.setText(savedInstanceState.getString("NOMBRE"));
            editTextPrecio.setText(savedInstanceState.getDouble("PRECIO") + "");
            editTextColor.setText(savedInstanceState.getString("COLOR"));

        }

        botonCrear = vistaLayout.findViewById(R.id.boton_crear);
        botonCrear.setOnClickListener(this);

        botonAtras = vistaLayout.findViewById(R.id.boton_atras);
        botonAtras.setOnClickListener(this);


        return vistaLayout;

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

    }

    public static FragmentNuevoProducto newInstance() {

        FragmentNuevoProducto fragmentNuevoProducto = new FragmentNuevoProducto();

        return fragmentNuevoProducto;

    }

    public interface OnFragmentListadoProductoNuevo {

        void onFragmentProductoNuevoClick(Teclado t);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentListadoProductos.OnFragmentListadoProductosListener) {
            productoNuevoListener = (OnFragmentListadoProductoNuevo) context;
        }
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.boton_crear) {

            String nombre;
            double precio;
            int imagen;
            String descripcion;

            //Para definir un valor por defecto, por si no ponen nada

            if (editTextPrecio.getText().toString() == null) {
                editTextPrecio.setText("0");
            }

            nombre = editTextNombre.getText().toString();

            precio = Double.parseDouble(editTextPrecio.getText().toString());

            String color = editTextColor.getText().toString();

            imagen = R.drawable.teclado1;

            descripcion = editTextDescripcion.getText().toString();

            Teclado t = new Teclado(listadoSize, nombre, precio, color, imagen, descripcion);

            Log.i("hola", t.toString());

            if (t != null) {
                productoNuevoListener.onFragmentProductoNuevoClick(t);
            }


        } else if (v.getId() == R.id.boton_atras) {


        }
    }
}
