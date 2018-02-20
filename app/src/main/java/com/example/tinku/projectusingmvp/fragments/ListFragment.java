package com.example.tinku.projectusingmvp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.tinku.projectusingmvp.DisplayActivity;
import com.example.tinku.projectusingmvp.R;
import com.example.tinku.projectusingmvp.adapters.ListViewAdapter;

import java.util.ArrayList;


public class ListFragment extends Fragment {

    ArrayList<String> listOfNames = new ArrayList<String>();
    ArrayList<String> listOfDescriptions = new ArrayList<String>();
    ArrayList<String> imageUrls = new ArrayList<String>();
    ListView listView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            imageUrls = getArguments().getStringArrayList("imageurls");
            listOfDescriptions = getArguments().getStringArrayList("description");
            listOfNames = getArguments().getStringArrayList("names");
        }
        //  listView = getActivity().findViewById(R.id.listView);
        //    ArrayList<String> listOfNames = (ArrayList<String>) mainActivity.getNames();
        //    ArrayList<String> listOfDescriptions = (ArrayList<String>) mainActivity.getDescriptions();
        //   listView.setAdapter(new ListViewAdapter(getContext(), listOfNames, listOfDescriptions));

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listView = view.findViewById(R.id.listView);
        listView.setAdapter(new ListViewAdapter(getContext(), listOfNames, listOfDescriptions, imageUrls));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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


}
