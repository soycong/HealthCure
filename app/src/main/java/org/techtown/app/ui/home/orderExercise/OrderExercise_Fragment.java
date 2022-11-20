package org.techtown.app.ui.home.orderExercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class OrderExercise_Fragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.orderexercise_fragment, container, false);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle("더 많은 운동 보기");
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = rootView.findViewById(R.id.rec77);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        OrderExerciseAdapter adapter = new OrderExerciseAdapter();

        adapter.addItem(new OrderExercise("원판 던지기"));               //운동 아이템
        adapter.addItem(new OrderExercise("몸통 들어올리기"));
        adapter.addItem(new OrderExercise("앉아서 몸통 움츠리기"));
        adapter.addItem(new OrderExercise("앉아서 다리 밀기"));
        adapter.addItem(new OrderExercise("앉아서 다리 펴기"));
        adapter.addItem(new OrderExercise("매달려서 다리 들기"));
        adapter.addItem(new OrderExercise("앉아서 모으기"));
        adapter.addItem(new OrderExercise("거꾸로 누워서 밀기"));
        adapter.addItem(new OrderExercise("파워클린"));
        adapter.addItem(new OrderExercise("뒤꿈치 들기"));
        adapter.addItem(new OrderExercise("트레드밀에서 걷기"));
        adapter.addItem(new OrderExercise("앉았다 일어서기"));
        adapter.addItem(new OrderExercise("앉아서 밀기"));
        adapter.addItem(new OrderExercise("발 닿기"));
        adapter.addItem(new OrderExercise("앉아서 다리 모으기"));
        adapter.addItem(new OrderExercise("앉아서 위로 밀기"));
        adapter.addItem(new OrderExercise("서서 어깨 들어올리기"));
        adapter.addItem(new OrderExercise("바벨 끌어당기기"));
        adapter.addItem(new OrderExercise("턱걸이"));
        adapter.addItem(new OrderExercise("한발 앞으로 내밀고 앉았다 일어서기"));
        adapter.addItem(new OrderExercise("앉아서 뒤로 당기기"));
        adapter.addItem(new OrderExercise("누워서 밀기"));
        adapter.addItem(new OrderExercise("허리 굽혀 덤벨 들기"));
        adapter.addItem(new OrderExercise("계단 뛰어 오르기"));
        adapter.addItem(new OrderExercise("몸 기울이기/회전하기"));
        adapter.addItem(new OrderExercise("바벨 들어올리기"));
        adapter.addItem(new OrderExercise("앉아서 당겨 내리기"));
        adapter.addItem(new OrderExercise("앉아서 다리 벌리기"));
        adapter.addItem(new OrderExercise("비스듬히 누워서 밀기"));
        adapter.addItem(new OrderExercise("앉아서 다리 굽히기"));
        adapter.addItem(new OrderExercise("계단 올라갔다 내려오기"));
        adapter.addItem(new OrderExercise("옆구리 늘리기"));

        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnOrderExerciseClickListener() { //아이템 선택 되었을때
            @Override
            public void onItemClick(OrderExerciseAdapter.ViewHolder holder, View view, int position) {
                OrderExercise item = adapter.getItem(position);
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                if(item.getExercise().equals("원판 던지기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("원판 던지기");
                    Exercise1 exercise1 = new Exercise1();
                    transaction.replace(R.id.container, exercise1 , "exercise1"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("몸통 들어올리기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("몸통 들어올리기");
                    Exercise2 exercise2 = new Exercise2();
                    transaction.replace(R.id.container, exercise2 , "exercise2"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 몸통 움츠리기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 몸통 움츠리기");
                    Exercise3 exercise3 = new Exercise3();
                    transaction.replace(R.id.container, exercise3 , "exercise3"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 다리 밀기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 다리 밀기");
                    Exercise4 exercise4 = new Exercise4();
                    transaction.replace(R.id.container, exercise4 , "exercise4"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 다리 펴기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 다리 펴기");
                    Exercise6 exercise6 = new Exercise6();
                    transaction.replace(R.id.container, exercise6 , "exercise6"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("매달려서 다리 들기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("매달려서 다리 들기");
                    Exercise7 exercise7 = new Exercise7();
                    transaction.replace(R.id.container, exercise7 , "exercise7"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 모으기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 모으기");
                    Exercise8 exercise8 = new Exercise8();
                    transaction.replace(R.id.container, exercise8 , "exercise8"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("거꾸로 누워서 밀기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("거꾸로 누워서 밀기");
                    Exercise9 exercise9 = new Exercise9();
                    transaction.replace(R.id.container, exercise9 , "exercise9"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("실내 자전거타기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("실내 자전거타기");
                    Exercise20 exercise20 = new Exercise20();
                    transaction.replace(R.id.container, exercise20 , "exercise20"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("파워클린")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("파워클린");
                    Exercise21 exercise21 = new Exercise21();
                    transaction.replace(R.id.container, exercise21 , "exercise21"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("뒤꿈치 들기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("뒤꿈치 들기");
                    Exercise24 exercise24 = new Exercise24();
                    transaction.replace(R.id.container, exercise24 , "exercise24"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("트레드밀에서 걷기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("트레드밀에서 걷기");
                    Exercise25 exercise25 = new Exercise25();
                    transaction.replace(R.id.container, exercise25 , "exercise25"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉았다 일어서기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉았다 일어서기");
                    Exercise28 exercise28 = new Exercise28();
                    transaction.replace(R.id.container, exercise28 , "exercise28"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 밀기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 밀기");
                    Exercise31 exercise31 = new Exercise31();
                    transaction.replace(R.id.container, exercise31 , "exercise31"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("발 닿기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("발 닿기");
                    Exercise5 exercise5 = new Exercise5();
                    transaction.replace(R.id.container, exercise5 , "exercise5"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 다리 모으기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 다리 모으기");
                    Exercise10 exercise10 = new Exercise10();
                    transaction.replace(R.id.container, exercise10 , "exercise10"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 위로 밀기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 위로 밀기");
                    Exercise11 exercise11 = new Exercise11();
                    transaction.replace(R.id.container, exercise11 , "exercise11"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("서서 어깨 들어올리기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("서서 어꺠 들어올리기");
                    Exercise12 exercise12 = new Exercise12();
                    transaction.replace(R.id.container, exercise12 , "exercise12"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("바벨 끌어당기기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("바벨 끌어당기기");
                    Exercise13 exercise13 = new Exercise13();
                    transaction.replace(R.id.container, exercise13 , "exercise13"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("턱걸이")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("턱걸이");
                    Exercise14 exercise14 = new Exercise14();
                    transaction.replace(R.id.container, exercise14 , "exercise14"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("한발 앞으로 내밀고 앉았다 일어서기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("한발 앞으로 내밀고 앉았다 일어서기");
                    Exercise22 exercise22 = new Exercise22();
                    transaction.replace(R.id.container, exercise22 , "exercise22"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 뒤로 당기기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 뒤로 당기기");
                    Exercise23 exercise23 = new Exercise23();
                    transaction.replace(R.id.container, exercise23 , "exercise23"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("누워서 밀기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("누워서 밀기");
                    Exercise26 exercise26 = new Exercise26();
                    transaction.replace(R.id.container, exercise26 , "exercise26"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("허리 굽혀 덤벨 들기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("허리 굽혀 덤벨 들기");
                    Exercise27 exercise27 = new Exercise27();
                    transaction.replace(R.id.container, exercise27 , "exercise27"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("계단 뛰어 오르기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("계단 뛰어 오르기");
                    Exercise29 exercise29 = new Exercise29();
                    transaction.replace(R.id.container, exercise29 , "exercise29"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("몸 기울이기/회전하기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("몸 기울이기/회전하기");
                    Exercise32 exercise32 = new Exercise32();
                    transaction.replace(R.id.container, exercise32 , "exercise32"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("바벨 들어올리기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("바벨 들어올리기");
                    Exercise15 exercise15 = new Exercise15();
                    transaction.replace(R.id.container, exercise15 , "exercise15"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 당겨 내리기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 당겨 내리기");
                    Exercise16 exercise16 = new Exercise16();
                    transaction.replace(R.id.container, exercise16 , "exercise16"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 다리 벌리기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 다리 벌리기");
                    Exercise17 exercise17 = new Exercise17();
                    transaction.replace(R.id.container, exercise17 , "exercise17"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("비스듬히 누워서 밀기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("비스듬히 누워서 밀기");
                    Exercise18 exercise18 = new Exercise18();
                    transaction.replace(R.id.container, exercise18 , "exercise18"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("앉아서 다리 굽히기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("앉아서 다리 굽히기");
                    Exercise19 exercise19 = new Exercise19();
                    transaction.replace(R.id.container, exercise19 , "exercise19"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("계단 올라갔다 내려오기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("계단 올라갔다 내려오기");
                    Exercise30 exercise30 = new Exercise30();
                    transaction.replace(R.id.container, exercise30 , "exercise30"); //번들 보내줌
                    transaction.commit();
                }else if(item.getExercise().equals("옆구리 늘리기")){
                    ((MainActivity)getActivity()).getSupportActionBar().setTitle("옆구리 늘리기");
                    Exercise33 exercise33 = new Exercise33();
                    transaction.replace(R.id.container, exercise33 , "exercise33"); //번들 보내줌
                    transaction.commit();
                }
            }
        });
        return rootView;
    }
}
