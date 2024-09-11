package com.example.fragments01_039;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.fragments01_039.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // referencia a la clase bingding
    private ActivityMainBinding mbinding;
    private boolean isFragmentShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //inflando la vista
        mbinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mbinding.getRoot());

        mbinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isFragmentShow) {

                    closeQuestionFragment();
                } else {
                    openFragment();
                }

            }
        });


    }


    private void openFragment() {

        // primer paso es instanciar el fragmento
        QuestionFragment questionFragment = new QuestionFragment();
        // segundo paso es tener la instancia del fragmento
        FragmentManager manager = getSupportFragmentManager();

        // tercer paso crear la transaccion
        FragmentTransaction transaction = manager.beginTransaction()
                .replace(mbinding.Contenedor.getId(), questionFragment,
                        QuestionFragment.class.getSimpleName());

        // carga la pila del fragmento.. añade el fragmento a la pila puedo referenciarla si vuelo atras
        // no se cierra aplicacion
        // addToBackStack(null);

        // punto 4
        transaction.commit();
        mbinding.button.setText("Abrir");
        isFragmentShow = true;

    }


    private void closeQuestionFragment() {

            // Generar instancia del fragment manager
            FragmentManager manager = getSupportFragmentManager();
            //Instanciar la instancia si existe en el contenedor
            QuestionFragment questionFragment = (QuestionFragment) manager.findFragmentById(mbinding.Contenedor.getId());


            if (questionFragment != null) {

                FragmentTransaction transaction = manager.beginTransaction();
                transaction.remove(questionFragment).commit();
                mbinding.button.setText("cerrar");
                isFragmentShow = false;


            }

        }


    }


