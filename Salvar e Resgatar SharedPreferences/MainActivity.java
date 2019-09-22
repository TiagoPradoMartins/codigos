package preferenciascorusuario.cursoandroid.com.preferenciascorusuario;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private RadioGroup      radioGroup;
    private Button          botaoSalvar;
    private RadioButton     radioButtonSelecionado;
    private RelativeLayout  layout;
    private static final String ARQUIVO_PREFERENCIAS = "ArqPreferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        botaoSalvar = (Button) findViewById(R.id.botaoSalvarId);
        layout = (RelativeLayout) findViewById(R.id.layoutId);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
				//Grava informaçoes no SharedPreferences	
                int idRadioButtonSelecionado = radioGroup.getCheckedRadioButtonId();
                if (idRadioButtonSelecionado > 0) {
                    SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    radioButtonSelecionado = (RadioButton) findViewById(idRadioButtonSelecionado);
                    editor.putString("corEscolhida", radioButtonSelecionado.getText().toString());
                    editor.commit();
                    String corEscolhida = radioButtonSelecionado.getText().toString();
                    trocarCor(corEscolhida);

                }
            }
        });
        //Recupera as informaçoes do SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_PREFERENCIAS, 0);
        if(sharedPreferences.contains("corEscolhida")) {
            String corSalva = sharedPreferences.getString("corEscolhida", "Laranja");
            trocarCor(corSalva);
        }
    }

    private void trocarCor(String cor){

        if (cor.equals("Azul")){
            layout.setBackgroundColor(Color.parseColor("#0099cc"));

        }else if (cor.equals("Laranja")){
            layout.setBackgroundColor(Color.parseColor("#ff8800"));
        }else if (cor.equals("Verde")){
            layout.setBackgroundColor(Color.parseColor("#669900"));
        }
    }


}
