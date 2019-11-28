package com.shanaptech.instagramclone.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.shanaptech.instagramclone.DirectoryPath;
import com.shanaptech.instagramclone.GridImgApabter;
import com.shanaptech.instagramclone.NextActivity;
import com.shanaptech.instagramclone.R;
import com.shanaptech.instagramclone.SearchDir;

import java.util.ArrayList;

public class Gallery_Fragment extends Fragment {

    public static  Gallery_Fragment  newInstance() {
        Gallery_Fragment f = new Gallery_Fragment() ;
        return f;
    }

    ProgressBar progressBar;
    GridView gridView;
    Spinner spinner;
    ImageView img_close;
    ImageView img_show ;
    TextView text_next;
    private ArrayList<String> allDirs;
    int NUMBER_OF_COLUMNS = 3;
    String Selectedimg;



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallary , container , false);

     progressBar = v.findViewById(R.id.progress_bar_gallery);
      progressBar.setVisibility(View.GONE);
       gridView = v.findViewById(R.id.grid_view_gallery);
        spinner = v.findViewById(R.id.spinner_gallery_path);
       allDirs = new ArrayList<>();

       img_show = v.findViewById(R.id.image_gallery);

     img_close = v.findViewById(R.id.close_activity);
    img_close.setClickable(true);
      img_close.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View v) {

                getActivity().finish();
            }
        });

        text_next = v.findViewById(R.id.next);
       text_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(getActivity() , NextActivity.class);
               next.putExtra("selected_image" , Selectedimg);
                startActivity(next);
            }
       });
        init_path();
        return v;
    }

    private void init_path()
    {
       DirectoryPath dpath = new DirectoryPath();

   if(SearchDir.getDirpath(dpath.Pic) != null)
    {
        allDirs = SearchDir.getDirpath(dpath.Pic);
    }

   ArrayList<String> Dirname = new ArrayList<>();
   for(int  i =0 ; i < allDirs.size() ; i++)
    {
        int index = allDirs.get(i).lastIndexOf("/");
        String sub = allDirs.get(i).substring(index).replace("/" , " ");
       Dirname.add(sub);
    }

    allDirs.add(dpath.Cam);
        ArrayAdapter<String> madpater = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item , Dirname) ;

        madpater.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(madpater);

spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Setup_GridView(allDirs.get(position));

   }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

   }
});
    }

    private void Setup_GridView(String SelectedDir)
    {

       final ArrayList<String> arrayImgs = SearchDir.getFilePath(SelectedDir);
       int width = getResources().getDisplayMetrics().widthPixels;
        int imgwidth = width / NUMBER_OF_COLUMNS ;
        gridView.setColumnWidth(imgwidth);
        GridImgApabter mAdapter =  new GridImgApabter(getActivity() , R.layout.layout_grid_imgview ,"file:/",arrayImgs);
        gridView.setAdapter(mAdapter);
try {
    SetImg(arrayImgs.get(0), img_show, "file:/");
    Selectedimg = arrayImgs.get(0);
}
catch (ArrayIndexOutOfBoundsException e)
{
    e.printStackTrace();
}
       gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              SetImg(arrayImgs.get(position) , img_show , "file:/");
              Selectedimg = arrayImgs.get(position);

            }
        });
    }
    private void SetImg(String urls , ImageView img_view , String append )
    {
        ImageLoader imageLoader = ImageLoader.getInstance();

        imageLoader.displayImage(append + urls, img_view, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(View.VISIBLE);

           }

            @Override
           public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(View.INVISIBLE);
            }
        });
    }
}
