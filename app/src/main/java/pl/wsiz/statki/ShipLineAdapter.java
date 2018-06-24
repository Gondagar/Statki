package pl.wsiz.statki;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ketcher.statki.R;

import java.util.ArrayList;

public class ShipLineAdapter extends RecyclerView.Adapter<ShipLineAdapter.ViewHolder> {

    ArrayList<ShipLine> shipLinesArray = new ArrayList<>();
    int height = 0;
    boolean isPlayer;
    int adapCounter = 0;
    ShipLineAdapter.ViewHolder holder;
    static ArrayList<KratkiAdapter> kratkiAdapters = new ArrayList<>();




    public ShipLineAdapter(ArrayList<ShipLine> shipLinesArray, boolean isPlayer) {
        this.shipLinesArray = shipLinesArray;
        this.isPlayer = isPlayer;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ship_line_item, parent, false);
        ViewHolder pvh = new ViewHolder(itemView);


        int height = parent.getMeasuredHeight();
        this.height = height;
        adapCounter++;
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(height, height/11 - 2);


        itemView.setLayoutParams(lp);
        Log.i("Mqwe2", "" + adapCounter);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull ShipLineAdapter.ViewHolder holder, int position) {


        this.holder = holder;

        KratkiAdapter kratkiAdapter = new KratkiAdapter(shipLinesArray.get(position).kratkiArray, height / 11 - 2, isPlayer, this);
        kratkiAdapters.add(kratkiAdapter);

        holder.shipsLineRecyclerView.setAdapter(kratkiAdapter);
        if (position != 0) {
            if (position != 10)
                holder.liczbaTxt.setText(" " + (position));
            else {
                holder.liczbaTxt.setText("" + (position));
            }
        }


    }


    @Override
    public int getItemCount() {
        return shipLinesArray.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView shipsLineRecyclerView;
        TextView liczbaTxt;

        public ViewHolder(final View view) {
            super(view);

            shipsLineRecyclerView = (RecyclerView)view.findViewById(R.id.shipsLineRecyclerView);
            liczbaTxt = (TextView)view.findViewById(R.id.liczbaTxt);

            LinearLayoutManager mLayoutManager = new LinearLayoutManager(itemView.getContext());
            mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            shipsLineRecyclerView.setLayoutManager(mLayoutManager);



        }
    }


}
