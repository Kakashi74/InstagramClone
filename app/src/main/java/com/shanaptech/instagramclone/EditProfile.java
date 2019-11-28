package com.shanaptech.instagramclone;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

public class EditProfile extends AppCompatActivity {

    ImageView imgprofile ,imgback , imgsave ;
    Context mcontext;
    TextView change_photo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_pro);

        mcontext = EditProfile.this;

        change_photo = findViewById(R.id.change_photo);
        // saving the settings
        imgsave = findViewById(R.id.save_settings);
        imgsave.setClickable(true);
        imgsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mcontext, " Saving", Toast.LENGTH_SHORT).show();
            }
        });


        // changing the fragment_profile picture
        imgprofile = findViewById(R.id.image_change_profile);

        // back  to the fragment_profile activity
        imgback = findViewById(R.id.back_settings);
        imgback.setClickable(true);
        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              finish();
            }
       });
       init();
       SetconfigImage();
   }
    private void SetconfigImage() {

        String uri = "https://damasnow.com/wp-content/uploads/2018/05/%D8%A3%D9%86%D8%AF%D8%B1%D9%88%D9%8A%D8%AF-%D8%A3%D9%88%D8%B1%D9%8A%D9%88.jpg";
       UniversalImageLoader.SetImage(uri , imgprofile,null , "");

   }
    private void init()
    {
        UniversalImageLoader imageLoader = new UniversalImageLoader(mcontext);
       ImageLoader.getInstance().init(imageLoader.imageConfig());
   }
}
