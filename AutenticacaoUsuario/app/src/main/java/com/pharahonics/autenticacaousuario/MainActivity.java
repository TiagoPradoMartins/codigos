package com.pharahonics.autenticacaousuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        //Login do usuario
       firebaseAuth.signInWithEmailAndPassword("tiagopradomartins@gmail.com" , "teste123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.i("LOGINUSUARIO" , "Logado com sucesso");
                        }else{
                            Log.i("LOGINUSUARIO" , "Erro ao logar " + task.getException());
                        }
                    }
                });

       //Desconecta Usuario
       firebaseAuth.signOut();

       //Verifica se o usuario está logado
        if (firebaseAuth.getCurrentUser() != null){
            Log.i("USUARIOLOGADO" , "USUARIO LOGADO ");
        }else{
            Log.i("USUARIOLOGADO" , "USUARIO DESLOGADO ");
        }

        //Cadastro
        firebaseAuth.createUserWithEmailAndPassword("tiagopradomartins@gmail.com" , "teste123")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){ //sucesso ao cadastrar usuario
                            Log.i("createUser" , "USUARIO CADASTRADO");

                        }else { // erro ao cadastrar usuario
                            Log.i("createUser" , "ERRO AO CADASTRAR USUARIO CADASTRADO");
                        }
                    }
                });


    }
}
