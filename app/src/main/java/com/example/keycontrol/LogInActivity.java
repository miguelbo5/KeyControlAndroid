package com.example.keycontrol;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.keycontrol.Tienda.TiendaActivity;


public class LogInActivity extends AppCompatActivity {

    private EditText editTextUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String name = preferences.getString("usuario", "");

        editTextUsuario = findViewById(R.id.editTextCorreo);
        editTextUsuario.setText(name);

    }

    public void onClickInicio(View view){

        Intent intent = new Intent(LogInActivity.this, MainActivity.class);

        startActivity(intent);
    }
    public void onClickMenu(View view){

        Intent intent = new Intent(LogInActivity.this, MenuActivity.class);

        startActivity(intent);
    }

    public void onClickRegistro(View view){

        Intent intent = new Intent(LogInActivity.this, RegistroActivity.class);

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
