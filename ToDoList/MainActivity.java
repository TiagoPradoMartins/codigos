package todolist.cursoandroid.com.todolist;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends Activity {
    private EditText textoTarefa;
    private Button botaoAdicionar;
    private ListView listaTarefas;
    private SQLiteDatabase bancoDeDados;

    private ArrayAdapter <String> itensAdaptador;
    private ArrayList    <String> itens;
    private ArrayList    <Integer> ids;

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
                    salvarTafera(textoDigitado);
                }

            });
            //Cria evento click da ListView
            listaTarefas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    deletarTarefas(ids.get(position));
                    alert("Tarefa removida com sucesso");
                    recuperarTarefas();
                }
            });
            //chama o Metodo recuperarTarefas
            recuperarTarefas();


        }catch (Exception e){
            e.printStackTrace();
        }


    }
    //Metodo para salvar tarefa
    private void salvarTafera(String texto){

        try {

            if(texto.equals("")){                       //Verifica se o campo digitado está vazio
                alert("Digitar tarefa ");
            }else {
                //Insere o que foi digitado no campo tarefa
                bancoDeDados.execSQL("INSERT INTO tarefas(tarefa) VALUES('" + texto + "')");

                alert("Tarefa adicionada com sucesso!");

                recuperarTarefas();                     //chama o Metodo recuperarTarefas

                //limpa o campo digitado
                textoTarefa.setText("");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //Metodo para Deletar tarefas e atualizar a lista na tela
    private void deletarTarefas(Integer id){
        bancoDeDados.execSQL("DELETE FROM tarefas WHERE id=" + id);
        recuperarTarefas();
    }

    //Metodo para enviar mensagem Toast
    private void alert(String msn){
        Toast.makeText(MainActivity.this , msn , Toast.LENGTH_SHORT ).show();
    }

    //Metodo para Recuperar as tarefas e apresentar no ListView
    private void recuperarTarefas(){
        try {
            //Recuperar as tarefas
            Cursor cursor = bancoDeDados.rawQuery("SELECT * FROM tarefas ORDER BY id DESC" , null);

            //Recuperar ids das colunas , Index das colunas
            int indiceCulunaId = cursor.getColumnIndex("id");
            int indiceCulunaTarefa = cursor.getColumnIndex("tarefa");
            //Cria a arraylist ids
            ids   = new ArrayList<Integer>();

            //Criar o Adaptador ArrayAdapter
            itens = new ArrayList<String>();
            itensAdaptador = new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_2,
                    android.R.id.text2,
                    itens);
            listaTarefas.setAdapter(itensAdaptador);

            //Listar as tarefas
            cursor.moveToFirst(); //move o cursor para a primeira posiçao
            while (cursor != null){

                Log.i("Resultado - ","Tarefa :" +  cursor.getString(indiceCulunaTarefa));
                //Adiciona indice da coluna tarefa na arraylist itens
                itens.add(cursor.getString(indiceCulunaTarefa));
                //Adiciona indice da coluna id na arraylist ids e converte para Integer
                ids.add(Integer.parseInt(cursor.getString(indiceCulunaId)));

                cursor.moveToNext(); // move o cursor para a proxima posiçao
            }
        }catch (Exception e){
            e.printStackTrace(); // printa o erro caso ocorra
        }

    }
}