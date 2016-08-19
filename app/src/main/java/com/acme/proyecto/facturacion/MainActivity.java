package com.acme.proyecto.facturacion;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    String proveedor;
    Button  opciones;
    Button createAlesur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDFactura usdbh = new BDFactura(this, "DBUsuarios", null, 1);

        SQLiteDatabase db = usdbh.getWritableDatabase();
        db.execSQL("INSERT INTO Usuarios (codigo, nombre) VALUES("+ 1 +", '" + Parametros.proveedor + "')");
        db.close();

        String[] campos = new String[] {"nombre, nif, dir, cp"};

        final Cursor  c = db.query("Usuarios", campos, null, null, null, null, null);

        createAlesur = (Button)findViewById(R.id.CreateInvoiceAlesur);
        createAlesur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InvoiceAlesur.class);
                //Lógica que obtenga los valores del cliente Alesur y los envie en el objeto Intent creado.
                startActivity(intent);
            }
        });


        opciones = (Button)findViewById(R.id.Options);
        opciones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Opciones.class);
                if(c.moveToFirst()) {
                    do {
                        proveedor = c.getString(1);
                    } while(c.moveToNext());
                }

                //intent.putExtra("proveedor", Parametros.proveedor);
                intent.putExtra("proveedor", proveedor);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
