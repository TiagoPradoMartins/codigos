package sqlite.cursoandroid.com.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            //Cria banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Cria tabela no banco
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR , idade INT(3))");

            //Inserir dados
            bancoDados.execSQL("INSERT INTO pessoas (nome , idade) VALUES ('Tiago' , 32)");
            bancoDados.execSQL("INSERT INTO pessoas (nome , idade) VALUES ('Danuza' , 64)");

            //Resgatar dados do banco
            Cursor cursor = bancoDados.rawQuery("SELECT nome , idade FROM pessoas", null);

            //Recupera o indice
            int indiceCelulaNome = cursor.getColumnIndex("nome");
            int indiceCelulaIdade = cursor.getColumnIndex("idade");

            //Retornar o cursor para o inicio da tabela
            cursor.moveToFirst();

            //Apresentando o resultado
            while (cursor != null) {
                Log.i("RESULTADO - Nome  ", cursor.getString(indiceCelulaNome));
                Log.i("RESULTADO - Idade ", cursor.getString(indiceCelulaIdade));
                cursor.moveToNext();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }



}
