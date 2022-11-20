package org.techtown.app.exercise;

import static android.content.Context.MODE_PRIVATE;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

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
import java.util.Set;


public class Exercise_Finish_Fragment extends Fragment {
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
                R.layout.exercise_finish, container, false);

        ImageView imageView = rootView.findViewById(R.id.imageView4);
        mPager = getActivity().findViewById(R.id.viewpager);
        exercise1 = new Exercise1();exercise2 = new Exercise2();exercise3 = new Exercise3();exercise4 = new Exercise4();exercise5 = new Exercise5();
        exercise6 = new Exercise6();exercise7 = new Exercise7();exercise8 = new Exercise8();exercise9 = new Exercise9();exercise10 = new Exercise10();
        exercise11 = new Exercise11();exercise12 = new Exercise12();exercise13 = new Exercise13();exercise14 = new Exercise14();exercise15 = new Exercise15();
        exercise16 = new Exercise16();exercise17 = new Exercise17();exercise18 = new Exercise18();exercise19 = new Exercise19();exercise20 = new Exercise20();
        exercise21 = new Exercise21();exercise22 = new Exercise22();exercise23 = new Exercise23();exercise24 = new Exercise24();exercise25 = new Exercise25();
        exercise26 = new Exercise26();exercise27 = new Exercise27();exercise28 = new Exercise28();exercise29 = new Exercise29();exercise30 = new Exercise30();
        exercise31 = new Exercise31();exercise32 = new Exercise32();exercise33 = new Exercise33();

        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("exercise", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("array1",MODE_PRIVATE); //정보 받아오기
        SharedPreferences sharedPreferences333 = getActivity().getSharedPreferences("finish", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences333.edit();

        SharedPreferences.Editor editorCheck = sharedPreferences333.edit();
        editorCheck.clear();
        editorCheck.commit();
        String exercise = sharedPreferences9.getString("exercise", "");
        Set<String> set1 = new LinkedHashSet<String>();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPager.setCurrentItem(1);
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

        if(set1.contains(" 바벨들어올리기]")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container4, exercise15, "exercise15").commitAllowingStateLoss();
            editor.putString("finish","바벨들어올리기");
            editor.commit();

        } else if(set1.contains(" 앉아서 당겨 내리기]")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container4, exercise16, "exercise16").commitAllowingStateLoss();
            editor.putString("finish","앉아서 당겨 내리기");
            editor.commit();
        }else if(set1.contains(" 앉아서 다리 벌리기]")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container4, exercise17, "exercise17").commitAllowingStateLoss();
            editor.putString("finish","앉아서 다리 벌리기");
            editor.commit();
        }else if(set1.contains(" 비스듬히 누워서 밀기]")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container4, exercise18, "exercise18").commitAllowingStateLoss();
            editor.putString("finish","비스듬히 누워서 밀기");
            editor.commit();
        }else if(set1.contains(" 앉아서 다리 굽히기]")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container4, exercise19, "exercise19").commitAllowingStateLoss();
            editor.putString("finish","앉아서 다리 굽히기");
            editor.commit();
        }else if(set1.contains(" 계단 올라갔다 내려오기]")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container4, exercise30, "exercise30").commitAllowingStateLoss();
            editor.putString("finish","계단 올라갔다 내려오기");
            editor.commit();
        }else if(set1.contains(" 옆구리 늘리기]")){
            getFragmentManager().beginTransaction()
                    .replace(R.id.container4, exercise33, "exercise33").commitAllowingStateLoss();
            editor.putString("finish","옆구리 늘리기");
            editor.commit();
        }

        button = rootView.findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg =new AlertDialog.Builder(getActivity());
                dlg.setTitle("수고하셨습니다 !");
                dlg.setPositiveButton("Cancle",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                    }
                });
                dlg.setNegativeButton("Home",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        getActivity().finish();
                    }
                });
                dlg.show();
                editorCheck.putBoolean("finishCheck",true);
                editorCheck.commit();
            }
        });
        return rootView;
    }

}