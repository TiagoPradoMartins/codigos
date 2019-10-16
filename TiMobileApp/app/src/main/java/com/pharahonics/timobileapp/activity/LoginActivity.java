package com.pharahonics.timobileapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pharahonics.timobileapp.R;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    private EditText campoUsuario;
    private EditText campoSenha;
    private Button   botaoEntrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Referencia dos objetos da tela
        campoUsuario = (EditText) findViewById(R.id.campoUsuarioId);
        campoSenha = (EditText) findViewById(R.id.campoSenhaId);
        botaoEntrar = (Button) findViewById(R.id.botaoEntrarId);

        try {
            //Cria envento Click no botao Entrar
            botaoEntrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (campoUsuario.getText().toString().equals("") || campoSenha.getText().toString().equals("")){
                        alert("Digite o Usuário e Senha");
                    }else{
                        String usuarioDigitado = campoUsuario.getText().toString();
                        String senhaDigitada = campoSenha.getText().toString();
                        firebaseAuth.signInWithEmailAndPassword(usuarioDigitado , senhaDigitada)
                                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            Log.i("LOGINUSUARIO" , "Logado com sucesso");
                                            startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                        }else{
                                            alert("Usuário ou Senha INVÁLIDOS");
                                            Log.i("LOGINUSUARIO" , "Erro ao logar " + task.getException());
                                        }
                                    }
                                });
                    }


                }
            });

        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void alert(String msn){
        Toast.makeText(LoginActivity.this , msn , Toast.LENGTH_SHORT).show();
    }
}
