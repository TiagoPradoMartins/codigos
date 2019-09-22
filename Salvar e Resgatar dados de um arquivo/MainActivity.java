package minhasanotacoes.cursoandroid.com.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    private EditText texto;
    private ImageView botaoSalvar;
    private static final String ARQUIVO_TEXTO = "ArquivoTextoDigitado";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.textoId);
        botaoSalvar = (ImageView) findViewById(R.id.botaoSalvarId);
        //Cria o botaoSalvar
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoDigitado = texto.getText().toString();
                gravarNoArquivo(textoDigitado);
                alert("Informaçoes salvas com sucesso");
            }
        });
        //Recupera o que foi gravado no arquivo ARQUIVO_TEXTO

        if (lerArquivo() != null) {
            texto.setText(lerArquivo());
        }




    }

    //Toast do botaoSalvar
    private void alert(String msn){
        Toast.makeText(MainActivity.this , msn , Toast.LENGTH_SHORT).show();
    }

    // Grava a informaçao no arquivo
    private void gravarNoArquivo(String texto){

        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(ARQUIVO_TEXTO, Context.MODE_PRIVATE));
            outputStreamWriter.write(texto);
            outputStreamWriter.close();
        }catch(IOException e){
            Log.v("MainActivity" , e.toString());
        }
    }

    private String lerArquivo(){
        String resultado = "";

        try {
            //Abrir o arquivo
            InputStream arquivo = openFileInput(ARQUIVO_TEXTO);
            if(arquivo != null){

                //Ler Arquivo
                InputStreamReader inputStreamReader = new InputStreamReader(arquivo);

                //Gerar Buffer do arquivo lido
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                //Recuperar Textos do Arquivo
                String linhaArquivo = "";
                while ((linhaArquivo = bufferedReader.readLine()) != null){
                    resultado += linhaArquivo;
                }
                //Fecha o arquivo aberto pelo InputStream
                arquivo.close();
            }
        //Retorna um erro caso nao leia o arquivo
        }catch (IOException e){
            Log.v("MainActivity" , e.toString());
        }

        //Retorna o resultado para o metodo
        return resultado;
    }

}
