package com.pharahonics.timobileapp.activity;

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
import com.pharahonics.timobileapp.R;

public class MainActivity extends AppCompatActivity {


    private Button botaoScan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoScan = (Button) findViewById(R.id.botaoScanId);
        botaoScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                integrator.setPrompt("Aguardando Código de Barras");
                integrator.setCameraId(0);
                integrator.initiateScan();

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){
            if (result.getContents() != null){
                //Envia o codigo lido para a activity FerramentasActivity
                String codigoScaneado = result.getContents();
                Intent intent = new Intent(MainActivity.this,FerramentasActivity.class);
                intent.putExtra("codigo",codigoScaneado);
                startActivity(intent);


                //barCodeReferencia.child(result.getContents()).child("Nome");

            }else{
                alert ("Scaner Cancelado");
            }

        }else {
            super.onActivityResult(requestCode, resultCode, data);

        }}

    private void alert (String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
    }



}
