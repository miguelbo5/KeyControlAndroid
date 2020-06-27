package com.example.keycontrol.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;

public class FragmentEditarProducto extends Fragment implements View.OnClickListener{

    Teclado teclado;

    Button botonEditar;

    private OnFragmentEditarProducto editarProductoListener;

    TextView id;
    EditText nombre;
    EditText precio;
    EditText color;
    EditText descripcion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View vistaLayout = inflater.inflate(R.layout.editar_producto_fragment, container, false);

        id = vistaLayout.findViewById(R.id.tv_id_teclado_editar);
        nombre = vistaLayout.findViewById(R.id.et_nombre_teclado_editar);
        precio = vistaLayout.findViewById(R.id.et_precio_teclado_editar);
        color = vistaLayout.findViewById(R.id.et_color_teclado_editar);
        descripcion = vistaLayout.findViewById(R.id.et_descripcion_teclado_editar);

        id.setText("El id es " + teclado.getId());
        nombre.setText(teclado.getNombre());
        precio.setText(teclado.getPrecio() + "");
        color.setText(teclado.getColorLed());
        descripcion.setText(teclado.getDescripcion());

        botonEditar = vistaLayout.findViewById(R.id.boton_editar);
        botonEditar.setOnClickListener(this);

        return vistaLayout;

    }

    public static FragmentEditarProducto newInstance(){

        FragmentEditarProducto fragmentEditarProducto = new FragmentEditarProducto();

        return fragmentEditarProducto;

    }

    public interface OnFragmentEditarProducto{

        void onFragmentEditarProductoClick(Teclado t);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentEditarProducto){
            editarProductoListener = (OnFragmentEditarProducto) context;
        }
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.boton_editar){

            String nombreTec = nombre.getText().toString();
            double precioTec = Double.parseDouble(precio.getText().toString());
            String descripcionTec = descripcion.getText().toString();
            String colorTec = color.getText().toString();

            Teclado tecladoEditado = new Teclado(teclado.getId(), nombreTec, precioTec, colorTec, teclado.getImg(), descripcionTec);

            editarProductoListener.onFragmentEditarProductoClick(tecladoEditado);

        }

    }
}

