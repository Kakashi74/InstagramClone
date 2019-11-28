//package com.shanaptech.instagramclone.InstaStuff;
//
//import android.content.Context;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//
//import com.shanaptech.instagramclone.GridImgApabter;
//import com.shanaptech.instagramclone.R;
//import com.shanaptech.instagramclone.UniversalImageLoader;
//
//import java.util.ArrayList;
//
//public class Profile_Activity extends AppCompatActivity {
//
//        private int NUMBER_GRID_COLUMN = 3;
//        Context mcontext;
//        ProgressBar progressBar;
//
//        ImageView imageProfile;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile_);
//
//        imageProfile = findViewById(R.id.profile_image);
//
//       ImgofGrid();
//       setProfileImg();
//
//       progressBar = findViewById(R.id.progress_barr);
//       progressBar.setVisibility(View.GONE);
//
//    }
//        private void setProfileImg ()
//        {
//            String uri = "https://damasnow.com/wp-content/uploads/2018/05/%D8%A3%D9%86%D8%AF%D8%B1%D9%88%D9%8A%D8%AF-%D8%A3%D9%88%D8%B1%D9%8A%D9%88.jpg";
//
//            UniversalImageLoader.SetImage(uri, imageProfile, progressBar, "");
//        }
//
//        private void ImgofGrid()
//        {
//        ArrayList<String> URLs = new ArrayList<>();
//    URLs.add("https://cdn.windowsreport.com/wp-content/uploads/2017/12/animation-software-kids.png");
//    URLs.add("https://i.ytimg.com/vi/--oTQCysVTs/maxresdefault.jpg");
//    URLs.add("https://lesterbanks.com/lxb_metal/wp-content/uploads/2016/02/Pose-to-Pose-Character-Animation-in-After-Effects.jpg");
//    SetUp_ImgGrid(URLs);
//
//}
//    private void SetUp_ImgGrid(ArrayList<String> imgUrls)
//    {
//
//        GridView gridView = findViewById(R.id.grid_view_images);
//
//        int gridwidth =  getResources().getDisplayMetrics().widthPixels;
//        int imgwidth =  gridwidth/NUMBER_GRID_COLUMN;
//
//        gridView.setColumnWidth(imgwidth);
//
//
//        GridImgApabter apabter = new GridImgApabter(mcontext , R.layout.layout_grid_imgview ,"" , imgUrls);
//         gridView.setAdapter(apabter);
//    }
//
//}
