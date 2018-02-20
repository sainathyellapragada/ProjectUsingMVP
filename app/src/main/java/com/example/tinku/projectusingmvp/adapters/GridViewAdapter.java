package com.example.tinku.projectusingmvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.tinku.projectusingmvp.R;
import com.example.tinku.projectusingmvp.viewholders.GridViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ryellap on 2/17/18.
 */

public class GridViewAdapter extends BaseAdapter {
    public Context context;
    public ArrayList<String> names;
    public ArrayList<String> description;
    public ArrayList<String> images;

    public GridViewAdapter(Context context, ArrayList<String> names, ArrayList<String> description, ArrayList<String> images) {
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
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        GridViewHolder gridViewHolder;
        gridViewHolder = new GridViewHolder();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item_layout_grid_view, null);

        //  gridViewHolder.images = view.findViewById(R.id.iv_grid_imageView);
        gridViewHolder.names = view.findViewById(R.id.tv_grid_name);
        gridViewHolder.description = view.findViewById(R.id.tv_grid_description);

        gridViewHolder.images = view.findViewById(R.id.iv_grid_imageView);
        String img_url = images.get(i);
        view.setTag(gridViewHolder);
        if (img_url.isEmpty()) {
            gridViewHolder.images.setImageResource(R.drawable.marioheroes);

        } else {
            Picasso.with(context).load(img_url).into(gridViewHolder.images);
        }

         // gridViewHolder.images.setImageResource(R.drawable.ic_launcher_background);//list.get(i).getImg();
        gridViewHolder.names.setText(names.get(i));
        gridViewHolder.description.setText(description.get(i));

        return view;
    }
}
