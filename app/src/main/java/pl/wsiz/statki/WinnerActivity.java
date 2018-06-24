package pl.wsiz.statki;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.ketcher.statki.R;

public class WinnerActivity extends AppCompatActivity {

    MediaPlayer mp1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.winner_layout);


        TextView winnerText = (TextView)findViewById(R.id.winnerText);
        if(getIntent().getStringExtra("winner").equals("W")) {

            mp1 = MediaPlayer.create(getApplicationContext(), R.raw.we_are_the_champions);
            mp1.setLooping(true);
            if(MainActivity.isMusicPlaying) {
                mp1.start();
            }
            winnerText.setText("GRATULUJĘ! WYGRAŁEŚ!");
        }
        else{
            mp1 = MediaPlayer.create(getApplicationContext(), R.raw.lost);
            mp1.setLooping(true);

            mp1.start();

            winnerText.setText("Ooops... Przegrałeś :(");
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        mp1.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if(MainActivity.isMusicPlaying) {
            mp1.start();
            mp1 = MediaPlayer.create(getApplicationContext(), R.raw.game_music);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(mp1 != null) {
            mp1.stop();
        }
    }
}
