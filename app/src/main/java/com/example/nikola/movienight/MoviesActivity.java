package com.example.nikola.movienight;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nikola.movienight.Model.Film;
import com.example.nikola.movienight.Model.FilmListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MoviesActivity extends BaseActivity {

    private ListView        resp;
    private FilmListAdapter adapter;
    private List<Film>      mFilmList;

    private JSONObject jsonObject;
    private JSONArray  jsonArray;


    private String TAG = "MoviesActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        resp = (ListView) findViewById(R.id.resp);
        mFilmList = new ArrayList<>();


        showProgressDialog("Retrieving data...");

        RequestQueue rq = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/4/list/10?page=1&api_key=8e20230f25939a349c2e37680cdaff95&sort_by=release_date.asc";

        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                hideProgressDialog();
                try {
                    jsonObject = new JSONObject(response);
                    jsonArray  = jsonObject.getJSONArray("results");
                    int count = 0;

                    while (count < jsonObject.length()) {
                        JSONObject JO = jsonArray.getJSONObject(count);

                        //Log.d(TAG, JO.getString("original_title"));
                        //Log.d(TAG, JO.getString("overview"));
                        mFilmList.add(new Film(JO.getString("original_title"), JO.getString("overview"), "https://image.tmdb.org/t/p/w500" + JO.getString("poster_path")));
                        //Log.d(TAG, JO.getString("poster_path"));
                        count++;
                    }

                    adapter = new FilmListAdapter(getApplicationContext(), mFilmList);
                    resp.setAdapter(adapter);

                    resp.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Toast.makeText(getApplicationContext(), "Clicked on: " + i, Toast.LENGTH_SHORT).show();
                        }
                    });

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Nije moguce kontaktirati udaljeni servis.", Toast.LENGTH_SHORT).show();
            }
        });
// Add the request to the RequestQueue.
        rq.add(sr);
    }
}
