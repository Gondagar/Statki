package pl.wsiz.statki;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.ketcher.statki.R;

import java.util.ArrayList;

import pl.wsiz.java.model.Player;
import pl.wsiz.java.model.TypePlayers;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp1;
    static int myScore = 0;
    static int hisScore = 0;
    RecyclerView myShipsRecyclerView;
    RecyclerView hisShipsRecyclerView;
    ArrayList<ShipLine>myShipLinesArrayList = new ArrayList<>();
    ArrayList<ShipLine>hisShipLinesArrayList = new ArrayList<>();
    static ShipLineAdapter shipLineAdapter2;
    static ShipLineAdapter shipLineAdapter;
    static boolean isMusicPlaying = false;
    Bundle savedInst;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        savedInst = savedInstanceState;
        setContentView(R.layout.activity_main);
        if(getIntent().getStringExtra("music").equals("on")) {
            isMusicPlaying = true;
        }
        else{
            isMusicPlaying = false;
        }

        myShipsRecyclerView = (RecyclerView)findViewById(R.id.myShipsRecyclerView);
        hisShipsRecyclerView = (RecyclerView)findViewById(R.id.hisShipsRecyclerView);


        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.game_music);
        mp1.setLooping(true);
        if(getIntent().getStringExtra("music").equals("on")) {
            mp1.start();
        }


        for(int i = 0; i<11; i++) {
            ArrayList<Kratka>kratkiArray = new ArrayList<>();
            for (int j = 0; j < 11; j++) {
                Kratka kratka = new Kratka(i+1, j+2);
                kratkiArray.add(kratka);
            }
            ShipLine shipLine = new ShipLine(kratkiArray, i);
            myShipLinesArrayList.add(shipLine);
        }

        for(int i = 0; i<11; i++) {
            ArrayList<Kratka>kratkiArray = new ArrayList<>();
            for (int j = 0; j < 11; j++) {
                Kratka kratka = new Kratka(i+1, j+2);
                kratkiArray.add(kratka);
            }
            ShipLine shipLine = new ShipLine(kratkiArray, i);
            hisShipLinesArrayList.add(shipLine);
        }

        Player humen = new Player("Humen", TypePlayers.Humen, myShipLinesArrayList);
        Player ai = new Player("AI", TypePlayers.AI, hisShipLinesArrayList);

        viewEvilDebug3(ai.getBoard().getShipsCordinats());


        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        myShipsRecyclerView.setLayoutManager(mLayoutManager);

        shipLineAdapter = new ShipLineAdapter(myShipLinesArrayList, true);
        myShipsRecyclerView.setAdapter(shipLineAdapter);


        LinearLayoutManager mLayoutManager2 = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        hisShipsRecyclerView.setLayoutManager(mLayoutManager2);

        shipLineAdapter2 = new ShipLineAdapter(hisShipLinesArrayList, false);
        hisShipsRecyclerView.setAdapter(shipLineAdapter2);

        shipLineAdapter.notifyDataSetChanged();
        shipLineAdapter2.notifyDataSetChanged();
    }

    public void viewEvilDebug3(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            GoodPosition goodPosition = new GoodPosition(0,0);

            String po = "";
            for (int j = 0; j < board.length; j++) {
                po = po + " " + board[i][j];
                if(board[i][j] == 1){
                    Log.i("Sss", "" + (i + 1) + " " + (j + 1));
                    goodPosition.litera = j+1;
                    goodPosition.liczba = i+1;
                }
            }
            Log.i("Woo", "\n" + po);

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        mp1.stop();
        myScore = 0;
        hisScore = 0;
        shipLineAdapter = null;
        shipLineAdapter2 = null;
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        if(getIntent().getStringExtra("music").equals("on")) {
            mp1 = MediaPlayer.create(getApplicationContext(), R.raw.game_music);
            mp1.start();
          //  onCreate(savedInst) ;

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
