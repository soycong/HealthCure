package org.techtown.app.exercise;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Exercise_Adapter extends FragmentStateAdapter {
    public int mCount;
    public Exercise_Adapter(FragmentActivity fa, int count) {
        super(fa);
        mCount = count;
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int index = getRealPosition(position);
        if(index==0) return new Exercise_WarmUp_Fragment();
        else if(index==1) return new Exercise_Main_Fragment();
        else return new Exercise_Finish_Fragment();
    }
    @Override
    public int getItemCount() {
        return 3;
    }
    public int getRealPosition(int position) { return position % mCount; }
}
