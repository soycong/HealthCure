package org.techtown.app.ui.exerciseList;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.techtown.app.R;
import org.techtown.app.ui.checkList.CheckList_Fragment;


public class Exercise5 extends Fragment {

    VideoView videoView;
    TextView textView;
    private Button button;
    private Button backbutton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.exerciselist_exercise5, container, false);

        textView = rootView.findViewById(R.id.textView4);
        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setScrollY(0);
        videoView = rootView.findViewById(R.id.v5);
        videoView.setMediaController(new MediaController(getActivity()));
        videoView.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.exercise5));
        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("exercise", Context.MODE_PRIVATE);
        String exercise = sharedPreferences9.getString("exercise", "");
        ConstraintLayout constraintLayout =rootView.findViewById(R.id.c5);

        if (exercise.equals("시각장애")){
            constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    videoView.start();
                    return false;
                }
            });
        }

        button = rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nfa.kspo.or.kr/front/movie/movieTypeList.do#"));
                startActivity(intent);
            }
        });

        backbutton = rootView.findViewById(R.id.button4);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("5","발 닿기");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                CheckList_Fragment checkList_fragment = new CheckList_Fragment();
                checkList_fragment.setArguments(bundle);
                transaction.replace(R.id.container,checkList_fragment,"checkList"); //번들 보내줌
                transaction.commit();
            }
        });
        return rootView;
    }
    @Override
    public void onPause() {
        super.onPause();
        if(videoView!=null && videoView.isPlaying()) videoView.pause();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(videoView!=null) videoView.stopPlayback();
    }
}