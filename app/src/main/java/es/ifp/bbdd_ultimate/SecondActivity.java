package es.ifp.bbdd_ultimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    protected TextView texto1;
    protected EditText caja1;
    protected Button boton1;
    protected Button boton2;

    protected Intent pasarPantalla;

    protected String contenidoCaja1="";

    protected GestorBD db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        texto1= (TextView) findViewById(R.id.texto1_second);
        caja1=(EditText) findViewById(R.id.caja1_second);
        boton1= (Button) findViewById(R.id.boton1_second);
        boton2= (Button) findViewById(R.id.boton2_second);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contenidoCaja1= caja1.getText().toString();
                if (contenidoCaja1.equals("")) {
                    Toast.makeText(SecondActivity.this, "Debe rellenar la caja de texto", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    db= new GestorBD(SecondActivity.this);
                    db.insert(contenidoCaja1);
                    Toast.makeText(SecondActivity.this, "Guardado correctamente", Toast.LENGTH_SHORT).show();
                    pasarPantalla= new Intent(SecondActivity.this, StartActivity.class);
                    finish();
                    startActivity(pasarPantalla);


                }

            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pasarPantalla= new Intent(SecondActivity.this, StartActivity.class);
                finish();
                startActivity(pasarPantalla);

            }
        });


    }
}