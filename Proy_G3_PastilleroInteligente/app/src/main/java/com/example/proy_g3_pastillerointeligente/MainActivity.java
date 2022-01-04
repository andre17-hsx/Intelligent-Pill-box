package com.example.proy_g3_pastillerointeligente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button Boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        Boton1=(Button)findViewById(R.id.Boton1);

        Boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
            }

        });

=======
       // Boton1=(Button)findViewById(R.id.Boton1);
>>>>>>> 39a69313515598b7b2b33e411242339fdfc24a23
    }

    public void iniciar(View v) {

        Intent i = new Intent(MainActivity.this, MainActivity2.class);
        startActivity(i);
    }

}