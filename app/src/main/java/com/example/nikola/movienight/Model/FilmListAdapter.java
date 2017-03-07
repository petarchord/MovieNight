package com.example.nikola.movienight.Model;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nikola.movienight.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by nikola on 5.3.17..
 */

public class FilmListAdapter extends BaseAdapter {

    private Context aContext;
    private List<Film> mListFilm;
    private String TAG = "";

    public FilmListAdapter(Context context, List<Film> list) {
        this.aContext  = context;
        this.mListFilm = list;
    }

    @Override
    public int getCount() {
        return mListFilm.size();
    }

    @Override
    public Object getItem(int i) {
        return mListFilm.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = View.inflate(aContext, R.layout.item, null);
        //TextView nazivFilma = (TextView) v.findViewById(R.id.naziv_filma);
        //TextView zanrFilma  = (TextView) v.findViewById(R.id.zanr_filma);
        //TextView opisFilma  = (TextView) v.findViewById(R.id.opis_filma);
        ImageView poster = (ImageView) v.findViewById(R.id.poster);

        //nazivFilma.setText(mListFilm.get(i).getNaziv());
        //Log.d(TAG, "FilmListAdapter:poster" + mListFilm.get(i).getPoster());
        Picasso.with(aContext).load(mListFilm.get(i).getPoster()).into(poster);
        //zanrFilma.setText(mListFilm.get(i).getZanr());
        //opisFilma.setText(mListFilm.get(i).getOpis());

        v.setTag(mListFilm.get(i));

        return v;
    }
}
