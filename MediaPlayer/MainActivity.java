package mediaplayer.cursoandroid.com.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button botaoPlay;
    private MediaPlayer mediaPlayer;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            botaoPlay = (Button)findViewById(R.id.botaoPlayId);
            mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.musica);

            botaoPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mediaPlayer.isPlaying()){
                        pausarMusica();
                    }else{
                        tocarMusica();
                    }


                }
            });

    }


    private void tocarMusica() {

        if(mediaPlayer != null){

            mediaPlayer.start();
            botaoPlay.setText("Pausar");
        }

    }

    private void pausarMusica(){
        if(mediaPlayer != null){
            mediaPlayer.pause();
            botaoPlay.setText("Tocar");
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }
}
