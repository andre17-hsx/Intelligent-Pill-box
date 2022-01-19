package com.example.proy_g3_pastillerointeligente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.HashMap;
import java.util.Map;


public class DataBase extends AppCompatActivity {
    private EditText etName,etID,etEmail,etPassword;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    DatabaseReference mRootReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base);
        etName=(EditText)findViewById(R.id.textName);
        etID=(EditText)findViewById(R.id.textID);
        etEmail=(EditText)findViewById(R.id.textEmail);
        etPassword=(EditText)findViewById(R.id.textPassword);

        //Inicializar objeto Firebase para conexion con base de datos
        firebaseAuth= FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);


    }
    public void Registrar(View v) {


        String name = etName.getText().toString().trim();
        String id = etID.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if(TextUtils.isEmpty(name)){
            Toast.makeText(this, "Se  debe ingresar un name",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(id)){
            Toast.makeText(this, "Se  debe ingresar un id",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Se  debe ingresar un email",Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Se  debe ingresar un password",Toast.LENGTH_SHORT).show();
            return;
        }
        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();





        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()){
                            mRootReference = FirebaseDatabase.getInstance().getReference("users");
                            Toast.makeText(DataBase.this, "Usuario registrado", Toast.LENGTH_SHORT).show();
                            //Iniciarlizar el objeto Map y obtener datos del usuario
                            Map<String,Object> datosUsuario = new HashMap<>();
                            Map<String,Object> Pastillas = new HashMap<>();

                            datosUsuario.put("name", name);
                            datosUsuario.put("contrasena", password);

                            //crear lista de pastillas del usuario
                            datosUsuario.put("notificacion",Pastillas);

                            //subir informacion a la base de datos
                            mRootReference.child(id).setValue(datosUsuario);




                        }else{
                            if(task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(DataBase.this, "Usuario ya registrado, ingrese nuevamente", Toast.LENGTH_SHORT).show();

                            }else{
                                Toast.makeText(DataBase.this, "No se pudo registrar usuario", Toast.LENGTH_LONG).show();
                            }

                        }
                        progressDialog.dismiss();

                    }
                });
    }

}