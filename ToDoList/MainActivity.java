package todolist.cursoandroid.com.todolist;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {
    private EditText textoTarefa;
    private Button botaoAdicionar;
    private ListView listaTarefas;
    private SQLiteDatabase bancoDeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Recuperar componentes , localiza componentes
            textoTarefa = (EditText) findViewById(R.id.textoId);
            listaTarefas = (ListView) findViewById(R.id.listViewId);
            botaoAdicionar = (Button) findViewById(R.id.botaoAdicionarId);

            //Banco de dados
            bancoDeDados = openOrCreateDatabase("apptarefas", MODE_PRIVATE, null);

            //Tabela Tarefas
            bancoDeDados.execSQL("CREATE TABLE IF NOT EXISTS tarefas(id INTEGER PRIMARY KEY AUTOINCREMENT , tarefa VARCHAR)");


            //Cria botaoAdicionar
            botaoAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Resgata o que foi digitado
                    String textoDigitado = textoTarefa.getText().toString();

                    //Insere o que foi digitado no campo tarefa
                    bancoDeDados.execSQL("INSERT INTO tarefas(tarefa) VALUES('" + textoDigitado + "')");

                }

            });

            //Recuperar as tarefas
            Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM tarefas" , null);

            //Recuperar ids das colunas , Index das colunas
            int indiceCulunaId = cursor.getColumnIndex("id");
            int indiceCulunaTarefa = cursor.getColumnIndex("tarefa");

            //Listar as tarefas
            cursor.moveToFirst(); //move o cursor para a primeira posiçao
            while (cursor != null){

                Log.i("Resultado -","Tarefa : " + cursor.getString(indiceCulunaTarefa));
                Log.i("Resultado -","Id     : " + cursor.getString(indiceCulunaId));
                cursor.moveToNext(); // move o cursor para a proxima posiçao
            }


        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
