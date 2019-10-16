package com.pharahonics.whatsapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pharahonics.whatsapp.R;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText nome;
    private EditText telefone;
    private EditText codPais;
    private EditText codArea;
    private Button   botaoCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nome            = (EditText)findViewById(R.id.edit_nome);
        telefone        = (EditText)findViewById(R.id.edit_telefone);
        codPais         = (EditText)findViewById(R.id.edit_cod_pais);
        codArea         = (EditText)findViewById(R.id.edit_cod_area);
        botaoCadastrar  = (Button)findViewById(R.id.bt_cadastrar);


        //Definir mascaras, SimpleMaskFormatter , MaskTextWatcher , addTextChangedListener nao pode alterar a ordem
        SimpleMaskFormatter simpleMaskTelefone  = new SimpleMaskFormatter("NNNNN-NNNN");
        SimpleMaskFormatter simpleMaskArea      = new SimpleMaskFormatter("NN");
        SimpleMaskFormatter simpleMaskPais      = new SimpleMaskFormatter("+NN");

        MaskTextWatcher maskArea        = new MaskTextWatcher(codArea, simpleMaskArea);
        MaskTextWatcher maskPais        = new MaskTextWatcher(codPais, simpleMaskPais);
        MaskTextWatcher maskTelefone    = new MaskTextWatcher(telefone, simpleMaskTelefone);

        telefone.addTextChangedListener(maskTelefone);
        codArea.addTextChangedListener(maskArea);
        codPais.addTextChangedListener(maskPais);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nomeUsuario = nome.getText().toString();
                String telefoneCompleto =   telefone.getText().toString() +
                                            codArea.getText().toString()  +
                                            codPais.getText().toString();

                String telefoneSemFormatacao = telefoneCompleto.replace("+" , "");
                telefoneSemFormatacao = telefoneSemFormatacao.replace("-" , "");
            }
        });



    }
}
