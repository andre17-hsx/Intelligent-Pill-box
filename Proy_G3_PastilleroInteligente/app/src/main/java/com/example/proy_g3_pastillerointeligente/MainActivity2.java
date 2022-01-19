package com.example.proy_g3_pastillerointeligente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class MainActivity2 extends AppCompatActivity {
    private EditText textUser, textPass;

    //Imagen de cargando y declarar  un objeto firebaseAuth.
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Datos del usuario
        textUser=(EditText)findViewById(R.id.textUser);
        textPass=(EditText)findViewById(R.id.textPass);

        //Inicializar objeto Firebase para conexion con base de datos
        firebaseAuth= FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
    }
    public void register(View view) {
        Intent i = new Intent(this, DataBase.class );
        startActivity(i);
    }

    public void Loggin(View v){

        String email = textUser.getText().toString().trim();
        String password = textPass.getText().toString().trim();


        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Se  debe ingresar un id",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Se  debe ingresar un password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Iniciando sesion...");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //checking if success
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity2.this, "BIENVENIDO", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplication(), Menu.class );
                            startActivity(i);

                        }else{
                            Toast.makeText(MainActivity2.this, "Datos no coinciden con ningun usuario registrado", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();

                    }
                });
    }
}