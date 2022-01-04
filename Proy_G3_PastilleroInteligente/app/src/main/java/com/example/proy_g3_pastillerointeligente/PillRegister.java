package com.example.proy_g3_pastillerointeligente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PillRegister extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_register);
        Bundle bundle = getIntent().getExtras();
        String User= bundle.getString("User");
        String Pass= bundle.getString("Pasword");
        TextView textPrueba= (TextView)findViewById(R.id.textPrueba);
        textPrueba.setText(User);
    }



}