package pl.wsiz.statki;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.ketcher.statki.R;

public class MenuActivity extends AppCompatActivity {

    MediaPlayer mp1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_content);

        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.menu_music);
        mp1.setLooping(true);
        mp1.start();

        Button startGame = (Button)findViewById(R.id.startGameButton);
        Button exitGame = (Button)findViewById(R.id.exitGameButton);
        final ImageView volumeOff = (ImageView)findViewById(R.id.volumeOff);
        final ImageView volumeOn = (ImageView)findViewById(R.id.volumeOn);

        volumeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeOff.setVisibility(View.GONE);
                volumeOn.setVisibility(View.VISIBLE);

                mp1 = MediaPlayer.create(getApplicationContext(), R.raw.menu_music);
                mp1.setLooping(true);
                mp1.start();
            }
        });

        volumeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volumeOn.setVisibility(View.GONE);
                volumeOff.setVisibility(View.VISIBLE);

                mp1.stop();
            }
        });

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                if(volumeOn.getVisibility() == View.VISIBLE) {
                    mainActivityIntent.putExtra("music", "on");
                }
                else{
                    mainActivityIntent.putExtra("music", "off");
                }
                startActivity(mainActivityIntent);


                finish();
                mp1.stop();
            }
        });

        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                mp1.stop();
            }
        });
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.menu_music);
        mp1.start();
    }

    @Override
    protected void onPause() {
        super.onPause();

        if(mp1 != null) {
            mp1.stop();
        }
    }
}
