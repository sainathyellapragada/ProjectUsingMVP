package com.example.tinku.projectusingmvp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.tinku.projectusingmvp.DisplayActivity;
import com.example.tinku.projectusingmvp.R;
import com.example.tinku.projectusingmvp.adapters.GridViewAdapter;

import java.util.ArrayList;

//import com.example.tinku.projectusingmvp.adapters.ListViewAdapter;

public class GridFragment extends Fragment {
    GridView gridview;
    ArrayList<String> listOfNames = new ArrayList<String>();
    ArrayList<String> listOfDescriptions = new ArrayList<String>();
    ArrayList<String> imageUrls = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            ArrayList<String> mParam1 = getArguments().getStringArrayList("description");
            imageUrls = getArguments().getStringArrayList("imageurls");
            listOfDescriptions = getArguments().getStringArrayList("description");
            listOfNames = getArguments().getStringArrayList("names");
        }


        //  EventBus.getDefault().register(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //   Log.e("namesfromGridActivity", listOfNames + "");

        View view = inflater.inflate(R.layout.fragment_grid, container, false);
        gridview = view.findViewById(R.id.gridView);
        gridview.setAdapter(new GridViewAdapter(getContext(), listOfNames, listOfDescriptions, imageUrls));
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), DisplayActivity.class);
                intent.putExtra("name", listOfNames.get(i));
                intent.putExtra("description", listOfDescriptions.get(i));
                intent.putExtra("image_url", imageUrls.get(i));
                startActivity(intent);
            }
        });

        return view;
    }

// //   @Subscribe
//    public void onEvent(BusStation busStation) {
//        Log.e("onEvent", "Event Fired" + busStation.getNames());
//        listOfNames = busStation.getNames();
//        listOfDescriptions = busStation.getDescription();
//
//    }


}
