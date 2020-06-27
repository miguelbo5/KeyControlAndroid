package com.example.keycontrol.Tienda;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.keycontrol.Fragments.FragmentEditarProducto;
import com.example.keycontrol.Fragments.FragmentListadoProductos;
import com.example.keycontrol.Fragments.FragmentNuevoProducto;
import com.example.keycontrol.Fragments.FragmentProducto;
import com.example.keycontrol.MainActivity;
import com.example.keycontrol.MenuActivity;
import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TiendaActivity extends AppCompatActivity implements FragmentListadoProductos.OnFragmentListadoProductosListener, FragmentNuevoProducto.OnFragmentListadoProductoNuevo, FragmentListadoProductos.OnProductoListener, FragmentProducto.OnEliminarProductoListener, FragmentEditarProducto.OnFragmentEditarProducto {

    private ArrayList<Teclado> teclados;

    public TiendaActivity() {

        teclados = new ArrayList<>();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tienda);

        teclados = leerFichero();

        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        transaction.addToBackStack(null);

        if (savedInstanceState != null) {
            Fragment fragment = getSupportFragmentManager().getFragment(savedInstanceState, "fragment");
            if (fragment instanceof FragmentNuevoProducto) {
                FragmentNuevoProducto fragmentNuevoProducto = (FragmentNuevoProducto) fragment;
                fragmentNuevoProducto.listadoSize = teclados.size();
                transaction.replace(R.id.layout_container, fragmentNuevoProducto);
            }
        } else {
            FragmentListadoProductos frListado = FragmentListadoProductos.newInstance();
            frListado.teclados = this.teclados;
            transaction.replace(R.id.layout_container, frListado);
        }

        transaction.commit();
    }

    public ArrayList<Teclado> leerFichero() {

        ArrayList<Teclado> tecladosLeer = new ArrayList<>();

        try {

            FileInputStream fileInputStream = openFileInput("teclados.txt");
            FileReader fr = new FileReader(fileInputStream.getFD());
            BufferedReader br = new BufferedReader(fr);

            String linea;

            String[] tecladoArray = new String[5];

            while ((linea = br.readLine()) != null) {

                tecladoArray = linea.split(";");

                int id = Integer.parseInt(tecladoArray[0]);
                String nombre = tecladoArray[1];
                double precio = Double.parseDouble(tecladoArray[2]);
                String color = tecladoArray[3];
                int img = Integer.parseInt(tecladoArray[4]);
                String descripcion = tecladoArray[5];

                Teclado t = new Teclado(id, nombre, precio, color, img, descripcion);

                tecladosLeer.add(t);

            }

            br.close();
            fr.close();


        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return tecladosLeer;
    }


    @Override
    public void onFragmentListadoClick() {

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        FragmentNuevoProducto nuevoProducto = FragmentNuevoProducto.newInstance();

        nuevoProducto.listadoSize = teclados.size();

        transaction.replace(R.id.layout_container, nuevoProducto);

        transaction.addToBackStack(null);

        transaction.commit();


    }

    @Override
    public void onFragmentProductoNuevoClick(Teclado t) {

        teclados.add(0, t);

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        FragmentListadoProductos listado = FragmentListadoProductos.newInstance();
        listado.teclados = this.teclados;

        transaction.replace(R.id.layout_container, listado);

        transaction.addToBackStack(null);

        transaction.commit();

        try {

            FileOutputStream fileOutputStream = openFileOutput("teclados.txt", Context.MODE_APPEND);

            FileWriter fw = new FileWriter(fileOutputStream.getFD());

            BufferedWriter bw = new BufferedWriter(fw);


            bw.write(t.toFile());
            bw.newLine();


            bw.close();
            fw.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.boton_menu:
                startActivity(new Intent(this, MenuActivity.class));
                return true;
            case R.id.boton_tienda:
                startActivity(new Intent(this, TiendaActivity.class));
                return true;
            case R.id.boton_inicio:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onProductoClick(Teclado t) {

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        FragmentProducto fragment = FragmentProducto.newInstance();

        fragment.teclado = t;

        transaction.replace(R.id.layout_container, fragment);

        transaction.addToBackStack(null);

        transaction.commit();

    }

    @Override
    public void onEliminarProductoClick(Teclado t) {

        teclados.remove(t);

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        FragmentListadoProductos listado = FragmentListadoProductos.newInstance();
        listado.teclados = this.teclados;

        transaction.replace(R.id.layout_container, listado);

        transaction.addToBackStack(null);

        transaction.commit();

    }

    @Override
    public void onFragmentEditarProductoClick(Teclado t) {

        for (int i = 0; i < teclados.size(); i++) {

            if (t.getId() == teclados.get(i).getId()) {

                teclados.set(i, t);

            }

        }

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        FragmentListadoProductos listado = FragmentListadoProductos.newInstance();
        listado.teclados = this.teclados;

        transaction.replace(R.id.layout_container, listado);

        transaction.addToBackStack(null);

        transaction.commit();

    }

}