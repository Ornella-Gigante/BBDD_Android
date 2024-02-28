package es.ifp.bbdd_ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class BorrarActividad extends AppCompatActivity {

    protected TextView label1;
    protected TextView label2;

    protected Button boton1;
    protected Button boton2;

    protected String paquete1="";
    protected Bundle extras;

    protected GestorBD db;

    protected String[] partes;

    protected Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_actividad);

        label1= (TextView) findViewById(R.id.label1_borrado);
        label2= (TextView) findViewById(R.id.label2_borrado);

        boton1=(Button) findViewById(R.id.boton1_borrado);
        boton2=(Button) findViewById(R.id.boton2_borrado);

        extras= getIntent().getExtras();
        if (extras!=null) {

            paquete1= extras.getString("CONTENIDO");

            label2.setText(paquete1);

            boton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    db= new GestorBD(BorrarActividad.this);


                    partes= paquete1.split(".-");
                    label1.setText(partes[0]+"----"+ partes[1]);
                    //db.delete(Integer.parseInt(partes[0]));
                    db.delete(partes[1]);

                    Toast.makeText(BorrarActividad.this, "Borrado correctamente", Toast.LENGTH_SHORT).show();
                    pasarPantalla= new Intent(BorrarActividad.this, StartActivity.class);

                    finish();
                    startActivity(pasarPantalla);


                }
            });

        }



    }
}
