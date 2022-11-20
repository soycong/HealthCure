package org.techtown.app.exercise;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;


import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import org.techtown.app.MainActivity;
import org.techtown.app.R;
import org.techtown.app.ui.exerciseList.Exercise1;
import org.techtown.app.ui.exerciseList.Exercise10;
import org.techtown.app.ui.exerciseList.Exercise11;
import org.techtown.app.ui.exerciseList.Exercise12;
import org.techtown.app.ui.exerciseList.Exercise13;
import org.techtown.app.ui.exerciseList.Exercise14;
import org.techtown.app.ui.exerciseList.Exercise15;
import org.techtown.app.ui.exerciseList.Exercise16;
import org.techtown.app.ui.exerciseList.Exercise17;
import org.techtown.app.ui.exerciseList.Exercise18;
import org.techtown.app.ui.exerciseList.Exercise19;
import org.techtown.app.ui.exerciseList.Exercise2;
import org.techtown.app.ui.exerciseList.Exercise20;
import org.techtown.app.ui.exerciseList.Exercise21;
import org.techtown.app.ui.exerciseList.Exercise22;
import org.techtown.app.ui.exerciseList.Exercise23;
import org.techtown.app.ui.exerciseList.Exercise24;
import org.techtown.app.ui.exerciseList.Exercise25;
import org.techtown.app.ui.exerciseList.Exercise26;
import org.techtown.app.ui.exerciseList.Exercise27;
import org.techtown.app.ui.exerciseList.Exercise28;
import org.techtown.app.ui.exerciseList.Exercise29;
import org.techtown.app.ui.exerciseList.Exercise3;
import org.techtown.app.ui.exerciseList.Exercise30;
import org.techtown.app.ui.exerciseList.Exercise31;
import org.techtown.app.ui.exerciseList.Exercise32;
import org.techtown.app.ui.exerciseList.Exercise33;
import org.techtown.app.ui.exerciseList.Exercise4;
import org.techtown.app.ui.exerciseList.Exercise5;
import org.techtown.app.ui.exerciseList.Exercise6;
import org.techtown.app.ui.exerciseList.Exercise7;
import org.techtown.app.ui.exerciseList.Exercise8;
import org.techtown.app.ui.exerciseList.Exercise9;

import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;


public class Exercise_WarmUp_Fragment extends Fragment implements TextToSpeech.OnInitListener{
    private ViewPager2 mPager;
    private TextToSpeech tts;
    private long btnPressTime = 0;
    private Button button;
    Exercise1 exercise1;Exercise2 exercise2;Exercise3 exercise3;Exercise4 exercise4;Exercise5 exercise5;
    Exercise6 exercise6;Exercise7 exercise7;Exercise8 exercise8;Exercise9 exercise9;Exercise10 exercise10;
    Exercise11 exercise11;Exercise12 exercise12;Exercise13 exercise13;Exercise14 exercise14;Exercise15 exercise15;
    Exercise16 exercise16;Exercise17 exercise17;Exercise18 exercise18;Exercise19 exercise19;Exercise20 exercise20;
    Exercise21 exercise21;Exercise22 exercise22;Exercise23 exercise23;Exercise24 exercise24;Exercise25 exercise25;
    Exercise26 exercise26;Exercise27 exercise27;Exercise28 exercise28;Exercise29 exercise29;Exercise30 exercise30;
    Exercise31 exercise31;Exercise32 exercise32;Exercise33 exercise33;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.exercise_warmup, container, false);

        mPager = getActivity().findViewById(R.id.viewpager);
        ImageView imageView = rootView.findViewById(R.id.imageView4);
        Set<String> set1 = new LinkedHashSet<String>();
        exercise1 = new Exercise1();exercise2 = new Exercise2();exercise3 = new Exercise3();exercise4 = new Exercise4();exercise5 = new Exercise5();
        exercise6 = new Exercise6();exercise7 = new Exercise7();exercise8 = new Exercise8();exercise9 = new Exercise9();exercise10 = new Exercise10();
        exercise11 = new Exercise11();exercise12 = new Exercise12();exercise13 = new Exercise13();exercise14 = new Exercise14();exercise15 = new Exercise15();
        exercise16 = new Exercise16();exercise17 = new Exercise17();exercise18 = new Exercise18();exercise19 = new Exercise19();exercise20 = new Exercise20();
        exercise21 = new Exercise21();exercise22 = new Exercise22();exercise23 = new Exercise23();exercise24 = new Exercise24();exercise25 = new Exercise25();
        exercise26 = new Exercise26();exercise27 = new Exercise27();exercise28 = new Exercise28();exercise29 = new Exercise29();exercise30 = new Exercise30();
        exercise31 = new Exercise31();exercise32 = new Exercise32();exercise33 = new Exercise33();

        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("exercise", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("array1",MODE_PRIVATE); //정보 받아오기
        SharedPreferences sharedPreferences111 = getActivity().getSharedPreferences("warmup", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences111.edit();
        SharedPreferences.Editor editorCheck = sharedPreferences111.edit();
        String exercise = sharedPreferences9.getString("exercise", "");
        editorCheck.clear();
        editorCheck.commit();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(1);
            }
        });

        switch (exercise){
            case "시각장애":{
                set1 = sharedPreferences.getStringSet("array1", null);
                tts = new TextToSpeech(getActivity(), this);
                break;
            }
            case "청각장애":{
                set1 = sharedPreferences.getStringSet("array2", null);
                break;
            }
            case "지적장애":{
                set1 = sharedPreferences.getStringSet("array3", null);
                break;
            }
            case "척수장애":{
                set1 = sharedPreferences.getStringSet("array4", null);
                break;
            }
        }

        if(set1.contains(" 원판던지기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise1, "exercise1").commitAllowingStateLoss();
            editor.putString("warmup","원판 던지기");
            editor.commit();
        }
        else if(set1.contains(" 몸통 들어올리기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise2, "exercise2").commitAllowingStateLoss();
            editor.putString("warmup","몸통 들어올리기");
            editor.commit();
        }
        else if(set1.contains(" 앉아서 몸통 움츠리기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise3, "exercise3").commitAllowingStateLoss();
            editor.putString("warmup","앉아서 몸통 움츠리기");
            editor.commit();
        }
        else if(set1.contains(" 앉아서 다리 밀기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise4, "exercise4").commitAllowingStateLoss();
            editor.putString("warmup","앉아서 다리 밀기");
            editor.commit();
        }
        else if(set1.contains(" 앉아서 다리 펴기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise6, "exercise6").commitAllowingStateLoss();
            editor.putString("warmup","앉아서 다리 펴기");
            editor.commit();
        }
        else if(set1.contains(" 매달려서 다리 들기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise7, "exercise7").commitAllowingStateLoss();
            editor.putString("warmup","매달려서 다리 들기");
            editor.commit();
        }
        else if(set1.contains(" 앉아서 모으기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise8, "exercise8").commitAllowingStateLoss();
            editor.putString("warmup","앉아서 모으기");
            editor.commit();
        }
        else if(set1.contains(" 거꾸로 누워서 밀기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise9, "exercise9").commitAllowingStateLoss();
            editor.putString("warmup","거꾸로 누워서 밀기");
            editor.commit();
        }
        else if(set1.contains(" 실내 자전거타기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise20, "exercise20").commitAllowingStateLoss();
            editor.putString("warmup","실내 자전거타기");
            editor.commit();
        }
        else if(set1.contains(" 파워클린")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise21, "exercise21").commitAllowingStateLoss();
            editor.putString("warmup","파워클린");
            editor.commit();
        }
        else if(set1.contains(" 뒤꿈치 들기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise24, "exercise24").commitAllowingStateLoss();
            editor.putString("warmup","뒤꿈치 들기");
            editor.commit();
        }
        else if(set1.contains(" 트레드밀에서 걷기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise25, "exercise25").commitAllowingStateLoss();
            editor.putString("warmup","트레드밀에서 걷기");
            editor.commit();
        }
        else if(set1.contains(" 앉았다 일어서기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise28, "exercise28").commitAllowingStateLoss();
            editor.putString("warmup","앉았다 일어서기");
            editor.commit();
        }else if(set1.contains(" 앉아서 밀기")) {
            getFragmentManager().beginTransaction()
                    .replace(R.id.container2, exercise31, "exercise31").commitAllowingStateLoss();
            editor.putString("warmup","앉아서 밀기");
            editor.commit();
        }

        button = rootView.findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "운동 완료!", Toast.LENGTH_SHORT).show();
                editorCheck.putBoolean("warmupCheck",true);
                editorCheck.commit();
                mPager.setCurrentItem(1);
            }
        });
        return rootView;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(){
        tts.setPitch((float)1); // 음성 톤 높이 지정
        tts.setSpeechRate((float)0.8); // 음성 속도 지정
        tts.speak("화면을 길게 누르면 준비 운동이 재생됩니다. \n 운동이 끝난 후 볼륨 버튼을 이용하여 다음 운동으로 이동할 수 있습니다.", TextToSpeech.QUEUE_FLUSH, null, "id1");
    }
    @Override
    public void onDestroy() {
        if(tts!=null){ // 사용한 TTS객체 제거
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int status) { // OnInitListener를 통해서 TTS 초기화
        if(status == TextToSpeech.SUCCESS){
            int result = tts.setLanguage(Locale.KOREA); // TTS언어 한국어로 설정

            if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
                Log.e("TTS", "This Language is not supported");
            }else{
                speakOut();// onInit에 음성출력할 텍스트를 넣어줌
            }
        }else{
            Log.e("TTS", "Initialization Failed!");
        }
    }


}