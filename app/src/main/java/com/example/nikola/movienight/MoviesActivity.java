package com.example.nikola.movienight;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MoviesActivity extends BaseActivity {

    private TextView resp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        resp = (TextView) findViewById(R.id.resp);

        RequestQueue rq = Volley.newRequestQueue(this);
        String url = "https://api.themoviedb.org/4/list/10?page=1&api_key=8e20230f25939a349c2e37680cdaff95&sort_by=release_date.asc";

        StringRequest sr = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // Display the first 500 characters of the response string.
                resp.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                resp.setText("Nije moguce kontaktirati servis");
            }
        });
// Add the request to the RequestQueue.
        rq.add(sr);
    }
}
