package com.example.luvphoto;

import android.app.Activity;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class tables extends ArrayAdapter {
    private Activity mContext;
    List<workdetails> workdetailsList;
    public tables(Activity mContext,List<workdetails> workdetailsList){
        super(mContext,R.layout.list_item,workdetailsList);
        this.mContext = mContext;
        this.workdetailsList = workdetailsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item,null,true);
        TextView Tvlocation = listItemView.findViewById(R.id.Tvlocation);
        TextView TvworkYType = listItemView.findViewById(R.id.TvworkType);
        TextView Tvwid = listItemView.findViewById(R.id.Tvwid);
        TextView Tvnw = listItemView.findViewById(R.id.Tvnw);
        TextView Tvallot = listItemView.findViewById(R.id.Tvallot);
        TextView Tvrw =  listItemView.findViewById(R.id.Tvrw);

        workdetails wd = workdetailsList.get(position);

        Tvwid.setText(wd.getwid());
        Tvlocation.setText(wd.getLocation());
        TvworkYType.setText(wd.getWorktype());
        Tvnw.setText(String.valueOf(wd.getNw()));
        Tvallot.setText(String.valueOf(wd.getAllot()));
        Tvrw.setText(String.valueOf(wd.getRw()));


        return listItemView;
    }
}
