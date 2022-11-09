package org.techtown.app.exercise;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.techtown.app.R;
import org.techtown.app.ui.checkList.CheckList_Fragment;
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


public class Exercise_WarmUp_Fragment extends Fragment {
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

        exercise1 = new Exercise1();exercise2 = new Exercise2();exercise3 = new Exercise3();exercise4 = new Exercise4();exercise5 = new Exercise5();
        exercise6 = new Exercise6();exercise7 = new Exercise7();exercise8 = new Exercise8();exercise9 = new Exercise9();exercise10 = new Exercise10();
        exercise11 = new Exercise11();exercise12 = new Exercise12();exercise13 = new Exercise13();exercise14 = new Exercise14();exercise15 = new Exercise15();
        exercise16 = new Exercise16();exercise17 = new Exercise17();exercise18 = new Exercise18();exercise19 = new Exercise19();exercise20 = new Exercise20();
        exercise21 = new Exercise21();exercise22 = new Exercise22();exercise23 = new Exercise23();exercise24 = new Exercise24();exercise25 = new Exercise25();
        exercise26 = new Exercise26();exercise27 = new Exercise27();exercise28 = new Exercise28();exercise29 = new Exercise29();exercise30 = new Exercise30();
        exercise31 = new Exercise31();exercise32 = new Exercise32();exercise33 = new Exercise33();

//        switch (item.getItemId()) {
//            case R.id."원판 던지기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise1, "exercise1").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."몸통 들어올리기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise2, "exercise2").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 몸통 움츠리기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise3, "exercise3").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 다리 밀기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise4, "exercise4").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."발 닿기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise5, "exercise5").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 다리 펴기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise6, "exercise6").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."매달려서 다리 들기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise7, "exercise7").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 모으기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise8, "exercise8").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."거꾸로 누워서 밀기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise9, "exercise9").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 다리 모으기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise10, "exercise10").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 위로 밀기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise11, "exercise11").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."서서 어깨 들어올리기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise12, "exercise12").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."바벨 끌어당기기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise13, "exercise13").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."턱걸이":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise14, "exercise14").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."바벨 들어올리기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise15, "exercise15").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 당겨 내리기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise16, "exercise16").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 다리 벌리기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise17, "exercise17").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."비스듬히 누워서 밀기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise18, "exercise18").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 다리 굽히기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise19, "exercise19").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."실내 자전거타기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise20, "exercise20").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."파워클린":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise21, "exercise21").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."한발 앞으로 내밀고 앉았다 일어서기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise22, "exercise22").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 뒤로 당기기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise23, "exercise23").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."뒤꿈치 들기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise24, "exercise24").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."트레드밀에서 걷기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise25, "exercise25").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."누워서 밀기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise26, "exercise26").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."허리 굽혀 덤벨 들기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise27, "exercise27").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉았다 일어서기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise28, "exercise28").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."계단 뛰어 오르기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise29, "exercise29").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."계단 올라갔다 내려오기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise30, "exercise30").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."앉아서 밀기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise31, "exercise31").commitAllowingStateLoss();
//
//                return true;
//            }
//            case R.id."몸 기울이기/회전하기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise32, "exercise32").commitAllowingStateLoss();
//
//                return true;
//
//            }
//            case R.id."옆구리 늘리기":{
//                getFragmentManager().beginTransaction()
//                        .replace(R.id.container2, exercise33, "exercise33").commitAllowingStateLoss();
//
//                return true;
//
//            }


//        }
        button = rootView.findViewById(R.id.button9);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return rootView;
    }


}