package com.example.keycontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.keycontrol.Fragments.FragmentNuevoProducto;
import com.example.keycontrol.Fragments.FragmentPreference;
import com.example.keycontrol.Tienda.TiendaActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button botonPreferencias;

    public ArrayList<Teclado> tecladosFichero;
    public ArrayList<Teclado> tecladosBaseDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonPreferencias = findViewById(R.id.boton_preferencias);
        botonPreferencias.setOnClickListener(this);

        tecladosFichero = new ArrayList<>();
        tecladosFichero.add(new Teclado(0, "Corsair K68", 65, "Rojo", R.drawable.teclado1, "Descripcion9"));
        tecladosFichero.add(new Teclado(1, "Newskill Hanshi", 78, "Verde", R.drawable.teclado2, "Descripcion9"));
        tecladosFichero.add(new Teclado(2, "MSI Vigor GK60", 98, "Azul", R.drawable.teclado3, "Descripcion9"));
        tecladosFichero.add(new Teclado(3, "Ozone Strike Battle", 75, "Negro", R.drawable.teclado4, "Descripcion9"));
        tecladosFichero.add(new Teclado(4, "Tacens Mars", 90, "Azul", R.drawable.teclado1, "Descripcion9"));

        tecladosBaseDatos = new ArrayList<>();
        tecladosBaseDatos.add(new Teclado(5, "Logitech G213", 56, "Blanco", R.drawable.teclado2, "Descripcion9"));
        tecladosBaseDatos.add(new Teclado(6, "Razer Huntsman", 96, "Rojo", R.drawable.teclado3, "Descripcion9"));
        tecladosBaseDatos.add(new Teclado(7, "Newskill Suiko Ivory", 78, "Blanco", R.drawable.teclado4, "Descripcion9"));
        tecladosBaseDatos.add(new Teclado(8, "Krom Kernel TKL", 65, "Rojo", R.drawable.teclado1, "Descripcion9"));
        tecladosBaseDatos.add(new Teclado(9, "Corsair TY8", 344, "Verde", R.drawable.teclado2, "Descripcion9"));


        try {

            FileOutputStream fileOutputStream = openFileOutput("teclados.txt", Context.MODE_PRIVATE);

            FileWriter fw = new FileWriter(fileOutputStream.getFD());

            BufferedWriter bw = new BufferedWriter(fw);

            for (int i = 0; i < tecladosFichero.size(); i++) {

                bw.write(tecladosFichero.get(i).toFile());
                bw.newLine();

            }

            bw.close();
            fw.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

////        try {
////
////            FileInputStream fileInputStream = openFileInput("teclados.txt");
////            FileReader fr = new FileReader(fileInputStream.getFD());
////            BufferedReader br = new BufferedReader(fr);
////
////            String linea = "";
////
////            while ((linea = br.readLine()) != null) {
////
////                Log.i("jeje", linea);
////
////            }
////
////            br.close();
////            fr.close();
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    @Override
    public void onClick(View v) {

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = supportFragmentManager.beginTransaction();

        FragmentPreference fragmentPreference = FragmentPreference.newInstance();

        transaction.add(R.id.layout_container_main, fragmentPreference);

        transaction.addToBackStack(null);

        transaction.commit();

    }

    public void onClickTienda(View view) {

        Intent intent = new Intent(MainActivity.this, TiendaActivity.class);

        startActivity(intent);
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

}