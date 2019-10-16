package com.pharahonics.timobileapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.pharahonics.timobileapp.R;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class FerramentasActivity extends AppCompatActivity {

    //private TextView textoTeste;
    private DatabaseReference databaseReferencia = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference codigoReferencia = databaseReferencia.child("codigoBarras");
    //private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ferramentas);


        Bundle extra = getIntent().getExtras();
        if(extra != null){
            final String codigoRecebido = extra.getString("codigo");
            Query buscaCodigo = codigoReferencia.child(codigoRecebido).equalTo(codigoRecebido).limitToFirst(1);
            buscaCodigo.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                   Log.i("data " , dataSnapshot.getValue().toString());
                    alert("Esse codigo ja existe " + codigoRecebido);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }


    }
    public void alert (String msn){
        Toast.makeText(FerramentasActivity.this ,  msn , Toast.LENGTH_SHORT).show();
    }
}
