package listview.cursoandroid.com.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView listaItens;
    private String[] itens = {"Brasil","Italia","Japao"
                            ,"Argentina","Chile","Paraguai"
                            ,"França","Russia","Espanha"
                            ,"Inglaterra","Portugal","China"
                            ,"Bolivia","Canada","Estados Unidos"
                            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            listaItens = (ListView) findViewById(R.id.listViewId);
            //Cria o adaptador para o array
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

            listaItens.setAdapter(adaptador);

    }
}
