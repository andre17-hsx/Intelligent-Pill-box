package com.example.proy_g3_pastillerointeligente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText textUser, textPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textUser=(EditText)findViewById(R.id.textUser);
        textPass=(EditText)findViewById(R.id.textPass);

    }
    public void register(View view) {
        Intent i = new Intent(this, DataBase.class );
        startActivity(i);
    }

    public void Loggin(View v){

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);
        SQLiteDatabase bd = admin.getReadableDatabase();
        String id = textUser.getText().toString();
        String pass = textPass.getText().toString();

        Cursor user = bd.rawQuery(
                "select * from usuarios where ID=" + id,
                null);
        Cursor password = bd.rawQuery(
                "select * from usuarios where password=" + pass,
                null);
        if (user.moveToFirst() && password.moveToFirst()) {
            Intent i = new Intent(this, PillRegister.class );
            i.putExtra("User", textUser.getText().toString());
            i.putExtra("Password", textPass.getText().toString());
            startActivity(i);
        } else
            Toast.makeText(this, "Datos incorrectos, verifique su usuario o contraseña",
                    Toast.LENGTH_SHORT).show();
        bd.close();

    }
}