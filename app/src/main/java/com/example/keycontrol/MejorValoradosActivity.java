package com.example.keycontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.keycontrol.Tienda.TiendaActivity;

public class MejorValoradosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mejor_valorados);
    }

    public void onClickMenu(View view){

        Intent intent = new Intent(MejorValoradosActivity.this, MenuActivity.class);

        startActivity(intent);
    }

    public void onClickProducto(View view){

        Intent intent = new Intent(MejorValoradosActivity.this, ProductoActivity.class);

        startActivity(intent);
    }

    public void onClickInicio(View view){

        Intent intent = new Intent(MejorValoradosActivity.this, MainActivity.class);

        startActivity(intent);
    }

    public void onClickTienda(View view){

        Intent intent = new Intent(MejorValoradosActivity.this, TiendaActivity.class);

        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu){
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
