package org.techtown.app.ui.exerciseList;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import org.techtown.app.R;
import org.techtown.app.ui.checkList.CheckList_Fragment;


public class Exercise10 extends Fragment {

    VideoView videoView;
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
                R.layout.exerciselist_exercise10, container, false);

        videoView = rootView.findViewById(R.id.videoView);

        videoView.setMediaController(new MediaController(getActivity()));

        videoView.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.exercise10));

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });

        button = rootView.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/8ko-6CfE2G0"));
                startActivity(intent);
            }
        });

        backbutton = rootView.findViewById(R.id.button4);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("10","앉아서 다리 모으기");

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