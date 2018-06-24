package pl.wsiz.statki;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ketcher.statki.R;

import java.util.ArrayList;
import java.util.Random;

import pl.wsiz.java.model.Board;
import pl.wsiz.java.model.Player;
import pl.wsiz.java.model.TypePlayers;

public class KratkiAdapter extends RecyclerView.Adapter<KratkiAdapter.ViewHolder> {

    ArrayList<Kratka> kratkiArray = new ArrayList<>();
    ShipLineAdapter shipLinesAd;
    int height = 0;
    boolean isPlayer;

    int liczbaSet = 0;
    boolean first = true;
    ArrayList<GoodPosition> shipsCoordsList = new ArrayList<GoodPosition>();
    int adapterCount = 0;
    KratkiAdapter.ViewHolder holder;
    //  ConsoleView consoleView;


    public KratkiAdapter(ArrayList<Kratka> kratkiArray, int height, boolean isPlayer, ShipLineAdapter shipLinesAd) {
        this.kratkiArray = kratkiArray;
        this.height = height;
        this.isPlayer = isPlayer;
        this.shipLinesAd = shipLinesAd;


    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.kratka, parent, false);
        KratkiAdapter.ViewHolder pvh = new KratkiAdapter.ViewHolder(itemView);

       /* boardmy = humen.getBoard();
        boardai = ai.getBoard();*/


        //Log.i("My Board", viewEvilDebug(humen.getBoard().viewEvilDebugNormal()));
        //Log.i("AI Board", viewEvilDebug(ai.getBoard().viewEvilDebugNormal()));

        //viewEvilDebug3(ai.getBoard().viewEvilDebugNormal());


        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull KratkiAdapter.ViewHolder holder, int position) {

        holder.popawImg.setVisibility(View.GONE);
        holder.korablyk1Img.setVisibility(View.GONE);
        holder.niePopawImg.setVisibility(View.GONE);

        this.holder = holder;
        if (kratkiArray.get(position).striliana) {
            if (!kratkiArray.get(position).isShip) {
                holder.niePopawImg.setVisibility(View.VISIBLE);
                holder.popawImg.setVisibility(View.GONE);
                holder.korablyk1Img.setVisibility(View.GONE);
            } else {
                holder.niePopawImg.setVisibility(View.GONE);
                holder.popawImg.setVisibility(View.VISIBLE);
                holder.korablyk1Img.setVisibility(View.VISIBLE);
            }
        }
        if (!isPlayer) {
            holder.kratkaWrogaImg.setVisibility(View.VISIBLE);
        }
        if (kratkiArray.get(position).getLiczba() == 1 && position != 0) {
            holder.kratkaImg.setVisibility(View.INVISIBLE);
            holder.kratkaWrogaImg.setVisibility(View.INVISIBLE);

            char litera = (char) (kratkiArray.get(position).getLitera() - 2 + 64);

            holder.itemView.setClickable(false);
            holder.literaKratkiTxt.setText("" + litera);
            holder.literaKratkiTxt.setVisibility(View.VISIBLE);
        }

        if (position == 0) {
            holder.kratkaImg.setVisibility(View.INVISIBLE);
            holder.kratkaWrogaImg.setVisibility(View.INVISIBLE);

            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.kratkaImg.getLayoutParams();
            params.rightMargin = 22;
            holder.kratkaImg.setLayoutParams(params);
            holder.itemView.setClickable(false);
        }
        adapterCount++;
        holder.liczbaKratki = kratkiArray.get(position).liczba;
        holder.literaKratki = kratkiArray.get(position).litera;
        holder.isShip = kratkiArray.get(position).isShip;
        holder.postrilyana = kratkiArray.get(position).striliana;

        // Log.i("Pozit", "" + position + " " + (kratkiArray.get(position).liczba-1) + " " + (kratkiArray.get(position).litera-1) + " " + boardai.getShipsCordinats()[holder.liczbaKratki-1][holder.literaKratki-1]);


        if (isPlayer) {

            if (kratkiArray.get(position).isShip) {
                holder.korablyk1Img.setVisibility(View.VISIBLE);
            }
        }

        if (MainActivity.hisScore == 20) {
            Intent winnerIntent = new Intent(holder.itemView.getContext(), WinnerActivity.class);
            winnerIntent.putExtra("winner", "P");

            holder.itemView.getContext().startActivity(winnerIntent);

            MainActivity.hisScore++;
        }
    }

    @Override
    public int getItemCount() {
        return kratkiArray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView kratkaImg;
        ImageView korablyk1Img;
        ImageView popawImg;
        ImageView niePopawImg;
        ImageView kratkaWrogaImg;
        int liczbaKratki;
        int literaKratki;
        boolean isShip;
        boolean postrilyana;
        TextView literaKratkiTxt;


        public ViewHolder(final View view) {
            super(view);

            kratkaImg = (ImageView) view.findViewById(R.id.kratkaImg);
            korablyk1Img = (ImageView) view.findViewById(R.id.korablyk1Img);
            popawImg = (ImageView) view.findViewById(R.id.popawImg);
            niePopawImg = (ImageView) view.findViewById(R.id.niePopawImg);
            kratkaWrogaImg = (ImageView) view.findViewById(R.id.kratkaWrogaImg);
            literaKratkiTxt = (TextView) view.findViewById(R.id.literaTxt);

            kratkaImg.getLayoutParams().width = height;
            korablyk1Img.getLayoutParams().width = height;
            popawImg.getLayoutParams().width = height;
            niePopawImg.getLayoutParams().width = height;
            kratkaWrogaImg.getLayoutParams().width = height;

            kratkaImg.getLayoutParams().height = height;
            korablyk1Img.getLayoutParams().height = height;
            popawImg.getLayoutParams().height = height;
            niePopawImg.getLayoutParams().height = height;
            kratkaWrogaImg.getLayoutParams().height = height;


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (!isPlayer && !postrilyana && MainActivity.myScore < 20 && MainActivity.hisScore < 20) {

                        if (isShip) {
                            MainActivity.myScore++;
                            popawImg.setVisibility(View.VISIBLE);
                            korablyk1Img.setVisibility(View.VISIBLE);
                            postrilyana = true;
                            shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 2).striliana = true;

                            if (literaKratki - 1 < 11) {
                                if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 1).isShip
                                        || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 1).striliana) {

                                    if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).isShip
                                            || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).striliana) {

                                        if (literaKratki < 11) {
                                            if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki).isShip
                                                    || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki).striliana) {

                                                if (liczbaKratki > 3) {

                                                    if (literaKratki - 4 > -1) {
                                                        if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 4).isShip
                                                                || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 4).striliana
                                                                || !shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).isShip) {


                                                            if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 2).kratkiArray.get(literaKratki - 2).isShip
                                                                    || shipLinesAd.shipLinesArray.get(liczbaKratki - 2).kratkiArray.get(literaKratki - 2).striliana) {

                                                                if (liczbaKratki < 11) {
                                                                    if (!shipLinesAd.shipLinesArray.get(liczbaKratki).kratkiArray.get(literaKratki - 2).isShip
                                                                            || shipLinesAd.shipLinesArray.get(liczbaKratki).kratkiArray.get(literaKratki - 4).striliana
                                                                            || !shipLinesAd.shipLinesArray.get(liczbaKratki).kratkiArray.get(literaKratki - 3).isShip) {

                                                                        Toast.makeText(v.getContext(), "Zabił", Toast.LENGTH_SHORT).show();
                                                                    }
                                                                }
                                                                else{
                                                                    Toast.makeText(v.getContext(), "Zabił", Toast.LENGTH_SHORT).show();
                                                                }
                                                            }
                                                        }


                                                    } else {
                                                        if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 2).kratkiArray.get(literaKratki - 2).isShip || shipLinesAd.shipLinesArray.get(liczbaKratki - 2).kratkiArray.get(literaKratki - 2).striliana) {
                                                            if (liczbaKratki < 11) {
                                                                if (!shipLinesAd.shipLinesArray.get(liczbaKratki).kratkiArray.get(literaKratki - 2).isShip || shipLinesAd.shipLinesArray.get(liczbaKratki).kratkiArray.get(literaKratki - 2).striliana) {
                                                                    if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 1).isShip || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 1).striliana)
                                                                        Toast.makeText(v.getContext(), "Zabił", Toast.LENGTH_SHORT).show();
                                                                }
                                                            } else {
                                                                if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 1).isShip || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 1).striliana)
                                                                    Toast.makeText(v.getContext(), "Zabił", Toast.LENGTH_SHORT).show();
                                                            }
                                                        }
                                                    }
                                                }
                                                else{
                                                  if(  shipLinesAd.shipLinesArray.get(liczbaKratki).kratkiArray.get(literaKratki - 2).isShip
                                                            || shipLinesAd.shipLinesArray.get(liczbaKratki).kratkiArray.get(literaKratki - 2).striliana){

                                                      if(shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).isShip
                                                              || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).striliana){

                                                          if(shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 1).isShip
                                                                  || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 1).striliana){

                                                              Toast.makeText(v.getContext(),"Zabił", Toast.LENGTH_SHORT).show();
                                                          }
                                                      }

                                                  }

                                                }



                                            } else {
                                                Toast.makeText(v.getContext(), "Zabił", Toast.LENGTH_SHORT).show();
                                            }

                                        } else {
                                            if (liczbaKratki > 3) {

                                                if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 4).isShip
                                                        || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 4).striliana
                                                        || !shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).isShip) {

                                                    Toast.makeText(v.getContext(), "Zabił", Toast.LENGTH_SHORT).show();
                                                }


                                            } else {
                                                Toast.makeText(v.getContext(), "Zabił", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }

                                }

                                if (MainActivity.myScore == 20) {
                                    Intent winnerIntent = new Intent(v.getContext(), WinnerActivity.class);
                                    winnerIntent.putExtra("winner", "W");
                                    v.getContext().startActivity(winnerIntent);
                                }

                            }
                            else {
                                if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 2).kratkiArray.get(literaKratki - 2).isShip || shipLinesAd.shipLinesArray.get(liczbaKratki - 2).kratkiArray.get(literaKratki - 2).striliana) {
                                    if(liczbaKratki < 11) {
                                        if (!shipLinesAd.shipLinesArray.get(liczbaKratki).kratkiArray.get(literaKratki - 2).isShip || shipLinesAd.shipLinesArray.get(liczbaKratki).kratkiArray.get(literaKratki - 2).striliana) {
                                            if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).isShip || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).striliana) {

                                                Toast.makeText(v.getContext(), "Zabił", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                    else{
                                        if (!shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).isShip || shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 3).striliana) {

                                            Toast.makeText(v.getContext(), "Zabił", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                }
                            }
                        }
                        else {
                            niePopawImg.setVisibility(View.VISIBLE);
                            postrilyana = true;
                            shipLinesAd.shipLinesArray.get(liczbaKratki - 1).kratkiArray.get(literaKratki - 2).striliana = true;

                            kompHodyt(v);
                        }

                    }

                }


            });
        }

    }

    private void kompHodyt(View v) {

        Random rnd = new Random();
        int x = 1 + rnd.nextInt(10);
        int y = 1 + rnd.nextInt(10);

        if (!MainActivity.shipLineAdapter.shipLinesArray.get(x).kratkiArray.get(y).striliana) {

            MainActivity.shipLineAdapter.shipLinesArray.get(x).kratkiArray.get(y).striliana = true;

            if (MainActivity.shipLineAdapter.shipLinesArray.get(x).kratkiArray.get(y).isShip == true) {
                //  SystemClock.sleep(2000);
                MainActivity.hisScore++;
                if (MainActivity.hisScore == 20) {
                    ShipLineAdapter.kratkiAdapters.get(x).notifyDataSetChanged();
                } else {
                    kompHodyt(v);
                }


            }
            else{
                ShipLineAdapter.kratkiAdapters.get(x).notifyDataSetChanged();
            }


        }
        else {
            kompHodyt(v);
        }


    }

    public String viewEvilDebug(int[][] board) {


        String temp = "Table \n";
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {
                temp = temp + String.format("%3s", board[i][j]);
            }
            temp = temp + "\n";
        }
        temp = temp + "\n";
        return temp;
    }


}
