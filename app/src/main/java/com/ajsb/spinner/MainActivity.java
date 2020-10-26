package com.ajsb.spinner;

/**
 * Programación Multimedia y de Dispositivos Móviles
 * Antonio J.Sánchez
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private Spinner spin ;

    /**
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creamos el adaptador e indicamos qué y cómo queremos que se muestre
        ArrayAdapter<CharSequence> adaptador ;
        adaptador = ArrayAdapter.createFromResource(this,
                                                    R.array.idiomas,
                                                    android.R.layout.simple_spinner_item)    ;
        // Instanciar el componente|vista
        spin = findViewById(R.id.spinner) ;
        spin.setAdapter(adaptador) ;

        //
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            /**
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                String idioma = parent.getItemAtPosition(position).toString() ;
                //Toast tostada = Toast.makeText(view.getContext(), "Has elegido " + idioma, Toast.LENGTH_SHORT) ;
                //      tostada.show() ;

                Snackbar.make(view, getString(R.string.snack) + " " + idioma,
                              Snackbar.LENGTH_INDEFINITE)
                        .setAction("Aceptar", v -> {})
                        .show() ;
            }

            /**
             * @param parent
             */
            @Override
            public void onNothingSelected(AdapterView<?> parent) { }
        });
    }
}