package com.shanaptech.instagramclone;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.shanaptech.instagramclone.Fragments.Camera_Fragment;
import com.shanaptech.instagramclone.Fragments.Chat_Fragment;
import com.shanaptech.instagramclone.Fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager ;
    FragmentPagerAdapter pagerAdapter;
  //  public static final int PICK_IMAGE = 1;
    Context mcontext = MainActivity.this ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageLoader();
        viewPager = findViewById(R.id.pager);
        viewPager.setPageTransformer(true, new ZoomOutPageTransformer());

        pagerAdapter = new pageAdapter(getSupportFragmentManager());
             viewPager.setAdapter(pagerAdapter);
             viewPager.setCurrentItem(2);


    }
    private void initImageLoader()
    {
        UniversalImageLoader universalImageLoader = new UniversalImageLoader(mcontext);
        ImageLoader.getInstance().init(universalImageLoader.imageConfig());
    }
    public static class ZoomOutPageTransformer implements ViewPager.PageTransformer {

        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        public void transformPage(View view, float position) {
            int pageWidth = view.getWidth();
            int pageHeight = view.getHeight();

            if (position < -1) { // [-Infinity,-1)
                // This page is way off-screen to the left.
                view.setAlpha(0f);

            } else if (position <= 1) { // [-1,1]
                // Modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                if (position < 0) {
                    view.setTranslationX(horzMargin - vertMargin / 2);
                } else {
                    view.setTranslationX(-horzMargin + vertMargin / 2);
                }

                // Scale the page down (between MIN_SCALE and 1)
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);

                // Fade the page relative to its size.
                view.setAlpha(MIN_ALPHA +
                        (scaleFactor - MIN_SCALE) /
                                (1 - MIN_SCALE) * (1 - MIN_ALPHA));

            } else { // (1,+Infinity]
                // This page is way off-screen to the right.
                view.setAlpha(0f);
            }
        }

    }

        public static class pageAdapter extends FragmentPagerAdapter {

            private Fragment[] childFragments;



        public pageAdapter(FragmentManager fm) {

            super(fm);
            childFragments = new Fragment[] {
                    new Chat_Fragment(),
                    new Camera_Fragment(),
                    new MainFragment()
            };
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                        return Chat_Fragment.newInstance();
                case 1:
                        return Camera_Fragment.newInstance();
                case 2:
                        return MainFragment.newInstance();

            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
           @Override
            public CharSequence getPageTitle(int position) {
                String title = getItem(position).getClass().getName();
                return title.subSequence(title.lastIndexOf(".") + 1, title.length());
            }
    }
}



// pick img and pass it
/*
Intent intent = new Intent();
intent.setType("image/*");
intent.setAction(Intent.ACTION_GET_CONTENT);
 //startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
Uri selectedImages=data.getData();
        String[] filePathColon={MediaStore.Images.Media.DATA};
        Cursor cursr=getContentResolver().query(selectedImages, filePathColon, null, null, null);
        cursr.moveToFirst();
        int columnindex=cursr.getColumnIndex(filePathColon[0]);
        String picturepath=cursr.getString(columnindex);
        cursr.close();

    Intent  intent= new Intent(MainActivity.this,SecondActivity.class);
      intent.putExtra("imagePath",filePathColon );
        startActivity(intent);

String ps=getIntent().getStringExtra("imagePath"); //it should be same as you send it

 */