package com.example.proy_g3_pastillerointeligente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.Button;
=======
>>>>>>> 39a69313515598b7b2b33e411242339fdfc24a23

public class MainActivity2 extends AppCompatActivity {
    Button botonCC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        botonCC=(Button)findViewById(R.id.botonCC);

        botonCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i2 = new Intent(MainActivity2.this, MainActivity4.class);
                startActivity(i2);
            }
        });
    }
    public void register(View view) {
        Intent i = new Intent(this, DataBase.class );
        startActivity(i);
    }

}