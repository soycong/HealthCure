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
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

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


public class Exercise_Main_Fragment extends Fragment{
    private Button button;
    private ViewPager2 mPager;

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
                R.layout.exercise_main, container, false);

        mPager = getActivity().findViewById(R.id.viewpager);
        ImageView imageViewback = rootView.findViewById(R.id.imageView5);
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
        SharedPreferences sharedPreferences222 = getActivity().getSharedPreferences("main", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences222.edit();
        SharedPreferences.Editor editorCheck = sharedPreferences222.edit();
        editorCheck.clear();
        editorCheck.commit();
        String exercise = sharedPreferences9.getString("exercise", "");

        imageViewback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(0);
            }
        });
        ImageView imageViewnext = rootView.findViewById(R.id.imageView4);
        imageViewnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(2);
            }
        });

        switch (exercise){
            case "시각장애":{
                set1 = sharedPreferences.getStringSet("array1", null);
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

        if(set1.contains(" 발 닿기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise5, "exercise5").commitAllowingStateLoss();
            editor.putString("main","발 닿기");
            editor.commit();
        }
        else if(set1.contains(" 앉아서 다리 모으기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise10, "exercise10").commitAllowingStateLoss();
            editor.putString("main","앉아서 다리 모으기");
            editor.commit();
        }
        else if(set1.contains(" 앉아서 위로 밀기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise11, "exercise11").commitAllowingStateLoss();
            editor.putString("main","앉아서 위로 밀기");
            editor.commit();
        }
        else if(set1.contains(" 서서 어깨 들어올리기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise12, "exercise12").commitAllowingStateLoss();
            editor.putString("main","서서 어깨 들어올리기");
            editor.commit();
        }
        else if(set1.contains(" 바벨 끌어당기기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise13, "exercise13").commitAllowingStateLoss();
            editor.putString("main","바벨 끌어당기기");
            editor.commit();
        }
        else if(set1.contains(" 턱걸이")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise14, "exercise14").commitAllowingStateLoss();
            editor.putString("main","턱걸이");
            editor.commit();
        }
        else if(set1.contains(" 한발 앞으로 내밀고 앉았다 일어서기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise22, "exercise22").commitAllowingStateLoss();
            editor.putString("main","한발 앞으로 내밀고 앉았다 일어서기");
            editor.commit();
        }
        else if(set1.contains(" 앉아서 뒤로 당기기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise23, "exercise23").commitAllowingStateLoss();
            editor.putString("main","앉아서 뒤로 당기기");
            editor.commit();
        }
        else if(set1.contains(" 누워서 밀기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise26, "exercise26").commitAllowingStateLoss();
            editor.putString("main","누워서 밀기");
            editor.commit();
        }
        else if(set1.contains(" 허리 굽혀 덤벨 들기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise27, "exercise27").commitAllowingStateLoss();
            editor.putString("main","허리 굽혀 덤벨 들기");
            editor.commit();
        }
        else if(set1.contains(" 계단 뛰어 오르기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise29, "exercise29").commitAllowingStateLoss();
            editor.putString("main","계단 뛰어 오르기");
            editor.commit();
        }
        else if(set1.contains(" 몸 기울이기/회전하기")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container3, exercise32, "exercise32").commitAllowingStateLoss();
            editor.putString("main","몸 기울이기/회전하기");
            editor.commit();
        }

        button = rootView.findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(), "운동 완료!", Toast.LENGTH_SHORT).show();
                editorCheck.putBoolean("mainCheck",true);
                editorCheck.commit();
                mPager.setCurrentItem(2);
            }
        });
        return rootView;
    }
}