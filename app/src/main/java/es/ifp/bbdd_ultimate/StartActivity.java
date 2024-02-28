package es.ifp.bbdd_ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity {

    protected TextView label1;
    protected ListView lista1;
    protected Button boton1;

    protected Intent pasarPantalla;

    protected ArrayList<String> listado= new ArrayList<String>();
    protected ArrayAdapter<String> adaptador;

    protected GestorBD db;

    protected String contenidoItem="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label1= (TextView) findViewById(R.id.label1_start);
        lista1= (ListView) findViewById(R.id.lista1_start);
        boton1=(Button) findViewById(R.id.boton1_start);

        db= new GestorBD(StartActivity.this);




        listado= db.getAllProducts();
        adaptador= new ArrayAdapter<String>(StartActivity.this, android.R.layout.simple_list_item_1, listado);
        lista1.setAdapter(adaptador);

        lista1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                contenidoItem= adapterView.getItemAtPosition(i).toString();
                db.delete(contenidoItem);
                /*pasarPantalla= new Intent(StartActivity.this, StartActivity.class);
                finish();
                startActivity(pasarPantalla);*/

                listado= db.getAllProducts();
                adaptador.clear();
                adaptador.addAll(listado);
                adaptador.notifyDataSetChanged();



                return true;
            }
        });

        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                contenidoItem= adapterView.getItemAtPosition(i).toString();
                pasarPantalla= new Intent(StartActivity.this, BorrarActividad.class);
                pasarPantalla.putExtra("CONTENIDO", contenidoItem);
                finish();
                startActivity(pasarPantalla);

            }
        });




        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarPantalla= new Intent(StartActivity.this, SecondActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });




    }
}