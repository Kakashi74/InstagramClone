package com.shanaptech.instagramclone;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.shanaptech.instagramclone.Fragments.ViewPost;
import com.shanaptech.instagramclone.Fragments.fragment_profile;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Profile extends AppCompatActivity implements fragment_profile.GridImageSelectedListener {

//        private int NUMBER_GRID_COLUMN = 3;
//        Context mcontext;
//        ProgressBar progressBar;
//        GridView gridView;
//        ImageView img1 ;
//        ImageView Settings_img;


//        public interface  GridImageSelectedListener
//    {
//
//         void onGridImageSelected();
//    }

   // GridImageSelectedListener gridImageSelectedListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fkn_profile);


        fragment_profile fragment1 = new fragment_profile();

        FragmentTransaction transaction = Profile.this.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container , fragment1).addToBackStack("fragment_profile").commit();


//
//        mcontext = Profile.this;
//
//        Settings_img = findViewById(R.id.edit);
//        Settings_img.setClickable(true);
//        Settings_img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent = new Intent(Profile.this , EditProfile.class);
//                startActivity(intent);
//            }
//        });
//
//        img1 = findViewById(R.id.my_photo);
//        gridView = findViewById(R.id.grid_view_images);
//
//       progressBar = findViewById(R.id.home_progressbar);
//       progressBar.setVisibility(View.GONE);

//        init();
//        setProfileImg();
//        ImgofGrid();

    }

    @Override
    public void onGridImageSelected(int postion) {
        ViewPost fragment = new ViewPost();
        Bundle args = new Bundle();
        args.putInt("position" ,postion);
        fragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container , fragment).addToBackStack("fragment_post").commit();


    }
//        private void setProfileImg ()
//        {
//            String uri = "https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png";
//
//            UniversalImageLoader.SetImage(uri, img1, progressBar, "");
//        }
//        private void init()
//        {
//            UniversalImageLoader imageLoader = new UniversalImageLoader(mcontext);
//            ImageLoader.getInstance().init(imageLoader.imageConfig());
//        }
//
//       private void ImgofGrid()
//        {
//        ArrayList<String> URLs = new ArrayList<>();
//         URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
//           URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
//           URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
//          URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
//          URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
//        URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
//        URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
//         URLs.add("https://media.kasperskydaily.com/wp-content/uploads/sites/92/2014/11/06042229/Android-2.png");
//
//            SetUp_ImgGrid(URLs);
//
//}
//    private void SetUp_ImgGrid(ArrayList<String> imgUrls)
//    {
//
//        int gridwidth =  getResources().getDisplayMetrics().widthPixels;
//        int imgwidth =  gridwidth/NUMBER_GRID_COLUMN;
//
//       gridView.setColumnWidth(imgwidth);
//
//       GridImgApabter apabter = new GridImgApabter(mcontext , R.layout.layout_grid_imgview ,"" , imgUrls);        gridView.setAdapter(apabter);
//    }
//




}
