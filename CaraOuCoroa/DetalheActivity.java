package caraoucoroa.cursoandroid.com.caraoucoroa;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;

public class DetalheActivity extends AppCompatActivity {

    private ImageView botaoVoltar;
    private ImageView imagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);

            //Relacionando os campos no codigo
            botaoVoltar = (ImageView) findViewById(R.id.botaoVoltarId);
            imagem = (ImageView) findViewById(R.id.moedaId);


                Bundle extra = getIntent().getExtras();
                if(extra != null){
                    String resultadoOpcao = extra.getString("opcao");
                    if (resultadoOpcao.equals("cara")) {
                        imagem.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_cara));
                    }else{
                        imagem.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_coroa));
                    }
                }

                //Botao Voltar
                botaoVoltar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();

                }
            });


    }
}
