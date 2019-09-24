package checkbox.cursoandroid.com.checkbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxCao;
    private CheckBox checkBoxGato;
    private CheckBox checkBoxRato;
    private TextView textoMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxCao = (CheckBox) findViewById(R.id.checkBoxCaoId);
        checkBoxGato = (CheckBox) findViewById(R.id.checkBoxGatoId);
        checkBoxRato = (CheckBox) findViewById(R.id.checkBoxRatoId);
        Button botaoMostrar = (Button) findViewById(R.id.botaoMostrarId);
        textoMostrar = (TextView) findViewById(R.id.textoMostrarId);

        botaoMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String itemSelecionado = "";
                itemSelecionado += "Item :" + checkBoxCao.getText() + " Status: " + checkBoxCao.isChecked() + "\n";
                itemSelecionado += "Item :" + checkBoxGato.getText() + " Status: " + checkBoxGato.isChecked() + "\n";
                itemSelecionado += "Item :" + checkBoxRato.getText() + " Status: " + checkBoxRato.isChecked();

                textoMostrar.setText(itemSelecionado);

            }
        });



    }
}
