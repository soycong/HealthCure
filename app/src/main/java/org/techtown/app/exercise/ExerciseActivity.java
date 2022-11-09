package org.techtown.app.exercise;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import org.techtown.app.R;

public class ExerciseActivity extends AppCompatActivity {

    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        //ViewPager2
        mPager = findViewById(R.id.viewpager);
        //Adapter
        pagerAdapter = new Exercise_Adapter(this, num_page);
        mPager.setAdapter(pagerAdapter);

        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mPager.setCurrentItem(0); //시작 지점
        mPager.setOffscreenPageLimit(3); //최대 이미지 수






        //Exercise_WarmUp_Fragment ex1Fragment = new Exercise_WarmUp_Fragment();
        //getSupportFragmentManager().beginTransaction().add(R.id.frameLayout1,ex1Fragment).commit();


    }


}