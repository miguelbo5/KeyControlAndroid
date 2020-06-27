package com.example.keycontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.keycontrol.Carrito.CarritoActivity;
import com.example.keycontrol.Pedidos.PedidosActivity;
import com.example.keycontrol.Tienda.TiendaActivity;

public class CuentaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);
    }

    public void onClickTienda(View view){

        Intent intent = new Intent(CuentaActivity.this, TiendaActivity.class);

        startActivity(intent);
    }

    public void onClickFavoritos(View view){

        Intent intent = new Intent(CuentaActivity.this, ListaFavoritosActivity.class);

        startActivity(intent);
    }

    public void onClickPedidos(View view){

        Intent intent = new Intent(CuentaActivity.this, PedidosActivity.class);

        startActivity(intent);
    }

    public void onClickInicio(View view){

        Intent intent = new Intent(CuentaActivity.this, MainActivity.class);

        startActivity(intent);
    }

    public void onClickCarrito(View view){

        Intent intent = new Intent(CuentaActivity.this, CarritoActivity.class);

        startActivity(intent);
    }

    public void onClickLogInRegistro(View view){

        Intent intent = new Intent(CuentaActivity.this, LogInActivity.class);

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
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
