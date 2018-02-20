package com.example.tinku.projectusingmvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DisplayActivity extends AppCompatActivity {
    Context context;
    TextView name, description;
    ImageView iv_imageOfDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        name = findViewById(R.id.tv_names_detailscreen);
        description = findViewById(R.id.tv_details_detailscreen);
        iv_imageOfDescription = findViewById(R.id.iv_detailScreen);
        String img_url = intent.getStringExtra("image_url");
        if (img_url.isEmpty()) {
            iv_imageOfDescription.setImageResource(R.drawable.marioheroes);
        } else {
            Picasso.with(context).load(img_url).into(iv_imageOfDescription);
        }
        name.setText(intent.getStringExtra("name"));
        description.setText(intent.getStringExtra("description"));

    }
}
