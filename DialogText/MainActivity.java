package dialog.cursoandroid.com.dialogtext;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button botao;
    private AlertDialog.Builder dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            botao = (Button) findViewById(R.id.botaoId);
            botao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // CRia a dialog
                    dialog = new AlertDialog.Builder(MainActivity.this);
                    // nao permite cancelar a dialog
                    dialog.setCancelable(false);
                    // Adiciona um icone padrao do android na dialog
                    dialog.setIcon(android.R.drawable.ic_menu_delete);
                    // Texto do Titulo da dialog
                    dialog.setTitle("Exlusao de arquivo");
                    // Texto da Mensagem da dialog
                    dialog.setMessage("Deseja excluir esse arquivo?");
                    // Cria o botao NAO e o evento click
                    dialog.setNegativeButton("Não",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Mensagem Toast do botao nao
                                    Toast.makeText(MainActivity.this, "Voce NAO excluiu o arquivo", Toast.LENGTH_SHORT).show();

                                }
                            }
                    );
                    // Cria o botao SIM e o evento click
                    dialog.setPositiveButton("Sim",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //Mensagem Toast do botao sim
                                    Toast.makeText(MainActivity.this, "Voce EXCLUIU o arquivo", Toast.LENGTH_SHORT).show();
                                }
                            }
                    );

                    // Cria a dialog
                    dialog.create();
                    // Exibe a dialog na tela
                    dialog.show();

                }
            });

    }
}
