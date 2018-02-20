package com.example.tinku.projectusingmvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tinku.projectusingmvp.R;
import com.example.tinku.projectusingmvp.viewholders.ListViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ryellap on 2/17/18.
 */

public class ListViewAdapter extends BaseAdapter {

    public Context context;
    public ArrayList<String> names;
    public ArrayList<String> description;
    public ArrayList<String> images;

    public ListViewAdapter(Context context, ArrayList<String> names, ArrayList<String> description, ArrayList<String> images) {
        this.context = context;
        this.names = names;
        this.description = description;
        this.images = images;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int i) {
        return getItem(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ListViewHolder listViewHolder = new ListViewHolder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_layout_list_view, null);

        listViewHolder.names = view.findViewById(R.id.tv_list_name);
        listViewHolder.description = view.findViewById(R.id.tv_list_description);
        listViewHolder.images = view.findViewById(R.id.imageView);
        String img_url = images.get(i);


        view.setTag(listViewHolder);
        if (img_url.isEmpty()) {
            listViewHolder.images.setImageResource(R.drawable.marioheroes);

        } else {
            Picasso.with(context).load(img_url).into(listViewHolder.images);
        }
        //listViewHolder.images.setImageResource(images.);
        listViewHolder.names.setText(names.get(i));
        listViewHolder.description.setText(description.get(i));
        return view;
    }

}
