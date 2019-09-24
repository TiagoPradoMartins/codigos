package seekbar.cursoandroid.com.seekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            seekBar = (SeekBar) findViewById(R.id.seekBar);
            textoResultado = (TextView) findViewById(R.id.textoResultadoId);

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    textoResultado.setText("Resultado: " + progress);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    Toast.makeText(MainActivity.this, "Progresso seekBar PRESSIONADO foi " + seekBar.getProgress() , Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                    Toast.makeText(MainActivity.this, "Progresso seekBar FINALIZADO foi " + seekBar.getProgress() , Toast.LENGTH_SHORT).show();
                }
            });


    }
}
