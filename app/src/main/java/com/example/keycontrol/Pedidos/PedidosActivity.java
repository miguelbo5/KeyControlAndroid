package com.example.keycontrol.Pedidos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.keycontrol.Carrito.AdaptadorTecladosCarrito;
import com.example.keycontrol.CuentaActivity;
import com.example.keycontrol.MainActivity;
import com.example.keycontrol.MenuActivity;
import com.example.keycontrol.ProductoActivity;
import com.example.keycontrol.R;
import com.example.keycontrol.Teclado;
import com.example.keycontrol.Tienda.TiendaActivity;

import java.util.ArrayList;

public class PedidosActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public AdaptadorPedidos adaptador;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Teclado> teclados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        teclados = new ArrayList<>();

        teclados.add(new Teclado(0, "Corsair K68", 65, "Rojo", R.drawable.teclado1, "dsadad"));
        teclados.add(new Teclado(1, "Newskill Hanshi", 78, "Verde", R.drawable.teclado2, "dsadad"));
        teclados.add(new Teclado(2, "MSI Vigor GK60", 98, "Azul", R.drawable.teclado3, "dsadad"));
        teclados.add(new Teclado(3, "Ozone Strike Battle", 75, "Negro", R.drawable.teclado4, "dsadad"));
        teclados.add(new Teclado(4, "Tacens Mars", 90, "Azul", R.drawable.teclado1, "dsadad"));

        recyclerView = (RecyclerView) findViewById(R.id.rv_pedidos);

        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        adaptador = new AdaptadorPedidos(this, teclados);

        recyclerView.setAdapter(adaptador);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

    }

    public void onClickCuenta(View view){

        Intent intent = new Intent(PedidosActivity.this, CuentaActivity.class);

        startActivity(intent);
    }

    public void onClickProducto(View view){

        Intent intent = new Intent(PedidosActivity.this, ProductoActivity.class);

        startActivity(intent);
    }

    public void onClickInicio(View view){

        Intent intent = new Intent(PedidosActivity.this, MainActivity.class);

        startActivity(intent);
    }

    public void onClickMenu(View view){

        Intent intent = new Intent(PedidosActivity.this, MenuActivity.class);

        startActivity(intent);
    }

    public void onClickTienda(View view){

        Intent intent = new Intent(PedidosActivity.this, TiendaActivity.class);

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
