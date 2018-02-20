package com.example.tinku.projectusingmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.tinku.projectusingmvp.fragments.GridFragment;
import com.example.tinku.projectusingmvp.fragments.ListFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListFragment listFragment = new ListFragment();
    GridFragment gridFragment = new GridFragment();

    Toolbar toolbar;
    ToggleButton change;
    String URL = "http://api.duckduckgo.com/?q=simpsons+characters&format=json";
    ArrayList<String> names = new ArrayList<String>();
    ArrayList<String> descriptions = new ArrayList<String>();
    ArrayList<String> imageUrls = new ArrayList<String>();
    String result;
    String myName;
    String images;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        change = findViewById(R.id.toggleButton);
        change.setChecked(true);

        change.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (change.isChecked()) {
                    change.setTextOn("GRID VIEW");
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Container, listFragment)
                            .commit();
                } else {
                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.Container, gridFragment)
                            .commit();
                    change.setTextOff("LIST VIEW");

                }
            }
        });
        getConnected();

    }


    public void getConnected() {

        StringRequest myStringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {

            @Override
            public void onResponse(String response) {
                try {
                    JSONObject topicsObject = new JSONObject(response);
                    JSONArray jsonArray = topicsObject.getJSONArray("RelatedTopics");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject data = jsonArray.getJSONObject(i);
                        result = data.getString("Result");
                        myName = data.getString("Text");
                        JSONObject image = data.getJSONObject("Icon");
                        images = image.getString("URL");
                        names.add(myName);
                        descriptions.add(result);
                        imageUrls.add(images);
                        populateUI();
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {

                    //       EventBus.getDefault().register(this);

//                    BusStation busStation = new BusStation();
//                    busStation.setNames(names);
//                    busStation.setDescription(descriptions);
//                    EventBus.getDefault().post(busStation);
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Volley", "Error");
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(myStringRequest);
    }

    public void populateUI() {


        Bundle data = new Bundle();

        data.putStringArrayList("names", names);
        data.putStringArrayList("description", descriptions);
        data.putStringArrayList("imageurls", imageUrls);
        gridFragment.setArguments(data);
        listFragment.setArguments(data);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.Container, listFragment)
                .commit();


    }

}
