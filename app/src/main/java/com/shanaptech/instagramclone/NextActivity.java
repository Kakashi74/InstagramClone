package com.shanaptech.instagramclone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

public class NextActivity extends AppCompatActivity {

    ImageView image_back;
    TextView text_share;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);


        image_back = findViewById(R.id.back_share);
        image_back.setClickable(true);
        image_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        text_share = findViewById(R.id.share_text);
        text_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //here we will upload the image to the firebase
            }
        });

        Intent i = getIntent();
        ImageView image = findViewById(R.id.image_share);
        UniversalImageLoader.SetImage(i.getStringExtra("selected_image"), image , null , "file:/");

    }
}
