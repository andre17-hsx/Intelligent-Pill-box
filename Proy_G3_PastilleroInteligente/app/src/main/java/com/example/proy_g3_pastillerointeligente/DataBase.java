package com.example.proy_g3_pastillerointeligente;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class DataBase extends AppCompatActivity {
    private EditText etName,etID,etEmail,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        etName=(EditText)findViewById(R.id.textName);
        etID=(EditText)findViewById(R.id.textID);
        etEmail=(EditText)findViewById(R.id.textEmail);
        etPassword=(EditText)findViewById(R.id.textPassword);

    }
    public void Registrar(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String name = etName.getText().toString();
        String id = etID.getText().toString();
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        bd.execSQL("insert into usuarios (name,ID,email,password) values ("+"'"+name+"',"+id+",'"+email+"',"+"'"+password+"')");
        //insert into articulos (codigo,descripcion,precio) values (1, raspberrypi3, 65.39)
        bd.close();
        etName.setText("");
        etID.setText("");
        etEmail.setText("");
        etPassword.setText("");
        Toast.makeText(this, "Se cargaron los datos del usuario",
                Toast.LENGTH_SHORT).show();
    }


}