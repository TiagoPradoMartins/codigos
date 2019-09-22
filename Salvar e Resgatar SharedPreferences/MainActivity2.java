package sharedpreferences.cursoandroid.com.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText campoDigitado;
    private TextView textoDigitado;
    private Button   botaoSalvar;
    // Cria uma constante
    private static final String ARQUIVO_PREFERENCIA = "ArquivoPrefencia";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            campoDigitado = (EditText) findViewById(R.id.campoDigitadoId);
            textoDigitado = (TextView) findViewById(R.id.textoDigitadoId);
            botaoSalvar   = (Button)   findViewById(R.id.botaoSalvarId);

            botaoSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Editor do SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
                    SharedPreferences.Editor editor     = sharedPreferences.edit();

                    if (campoDigitado.getText().toString().equals("")){
                     alert("Digite um texto");
                    }else{
                        editor.putString("nome" , campoDigitado.getText().toString());
                        editor.commit();
                        textoDigitado.setText(campoDigitado.getText().toString());
                    }
                }
            });

        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if (sharedPreferences.contains("nome")){
            String nomeDigitado = sharedPreferences.getString("nome","nenhum usuario cadastrado");
            textoDigitado.setText(nomeDigitado);

        }else{
            textoDigitado.setText("Olá Visitante");
        }

    }


    public void alert(String msn){
        Toast.makeText(MainActivity.this , msn , Toast.LENGTH_LONG).show();
    }
}
