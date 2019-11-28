package com.shanaptech.instagramclone;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shanaptech.instagramclone.Fragments.Camera_Fragment;
import com.shanaptech.instagramclone.Fragments.Chat_Fragment;
import com.shanaptech.instagramclone.Fragments.Gallery_Fragment;
import com.shanaptech.instagramclone.Fragments.MainFragment;
import com.shanaptech.instagramclone.Fragments.Photo_Fragment;

public class ChooseActivity extends AppCompatActivity {
    ViewPager mviewPager ;
    FragmentPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        mviewPager = findViewById(R.id.View_Pager_layout);
        pagerAdapter = new pageAdapter(getSupportFragmentManager());
        mviewPager.setAdapter(pagerAdapter);
        mviewPager.setCurrentItem(1);

    }
     public int getitemTag()
     {
         return mviewPager.getCurrentItem();
     }
    public static class pageAdapter extends FragmentPagerAdapter {

        private Fragment[] childFragments;



        public pageAdapter(FragmentManager fm) {

            super(fm);
            childFragments = new Fragment[] {
                    new Photo_Fragment(),
                    new Gallery_Fragment(),

            };
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return Photo_Fragment.newInstance();
                case 1:
                    return Gallery_Fragment.newInstance();

            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

    }

//    private void set_tabelayout()
//    {
//
//        SectionPagerAdapter section = new SectionPagerAdapter(getSupportFragmentManager());
//        section.addFragment( new Gallery_Fragment());
//        section.addFragment(new Photo_Fragment());
//
//        mviewPager = findViewById(R.id.View_Pager_layout);
//        mviewPager.setAdapter(section);
//
//        tabLayout = findViewById(R.id.choose_bar);
//        tabLayout.setupWithViewPager(mviewPager);
//        tabLayout.getTabAt(0).setText("Gallery");
//        tabLayout.getTabAt(1).setText("Camera");
//
//        }
}
