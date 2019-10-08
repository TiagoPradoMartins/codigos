package com.pharaohnics.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarioReferencia = firebaseReferencia.child("Usuarios");
    private DatabaseReference produtosReferencia = firebaseReferencia.child("Produtos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Usuarios usuarios = new Usuarios();
        usuarios.setIdade(32);
        usuarios.setNome("Tiago");
        usuarios.setSobrenome("Prado Martins");
        usuarios.setSexo("Masculino");
        usuarioReferencia.child("003").setValue(usuarios);

        Produtos produtos = new Produtos();
        produtos.setDescricao("Iphone X 128GB");
        produtos.setFabricante("Apple");
        produtos.setCor("Dourado");
        produtosReferencia.child("001").setValue(produtos);
        */

        produtosReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE",dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
