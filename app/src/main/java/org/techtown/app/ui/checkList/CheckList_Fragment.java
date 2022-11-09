package org.techtown.app.ui.checkList;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.techtown.app.R;

public class CheckList_Fragment extends Fragment {
    static String n1;
    static String n2;static String n3; static String n4; static String n5; static String n6;
    static String n7; static String n8; static String n9; static String n10; static String n11; static String n12;
    static String n13; static String n14; static String n15; static String n16; static String n17; static String n18;
    static String n19; static String n20; static String n21; static String n22; static String n23; static String n24;
    static String n25; static String n26; static String n27; static String n28; static String n29; static String n30;
    static String n31; static String n32; static String n33;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.checklist_fragment, container, false);

        if(savedInstanceState != null){ // 저장한 값 불러옴
            n1 = savedInstanceState.getString("1");
            n2 = savedInstanceState.getString("2");
            n3 = savedInstanceState.getString("3");
            n4 = savedInstanceState.getString("4");
            n5 = savedInstanceState.getString("5");
            n6 = savedInstanceState.getString("6");
            n7 = savedInstanceState.getString("7");
            n8 = savedInstanceState.getString("8");
            n9 = savedInstanceState.getString("9");
            n10 = savedInstanceState.getString("10");
            n11 = savedInstanceState.getString("11");
            n12 = savedInstanceState.getString("12");
            n13 = savedInstanceState.getString("13");
            n14 = savedInstanceState.getString("14");
            n15 = savedInstanceState.getString("15");
            n16 = savedInstanceState.getString("16");
            n17 = savedInstanceState.getString("17");
            n18 = savedInstanceState.getString("18");
            n19 = savedInstanceState.getString("19");
            n20 = savedInstanceState.getString("20");
            n21 = savedInstanceState.getString("21");
            n22 = savedInstanceState.getString("22");
            n23 = savedInstanceState.getString("23");
            n24 = savedInstanceState.getString("24");
            n25 = savedInstanceState.getString("25");
            n26 = savedInstanceState.getString("26");
            n27 = savedInstanceState.getString("27");
            n28 = savedInstanceState.getString("28");
            n29 = savedInstanceState.getString("29");
            n30 = savedInstanceState.getString("30");
            n31 = savedInstanceState.getString("31");
            n32 = savedInstanceState.getString("32");
            n33 = savedInstanceState.getString("33");
        }

        RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview);
        CheckBox checkBox = rootView.findViewById(R.id.checkBox);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getBaseContext(), LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        ChecklistAdapter adapter = new ChecklistAdapter();

        adapter.addItem(new CheckList("준비 운동",false));
        adapter.addItem(new CheckList("본 운동",false));
        adapter.addItem(new CheckList("마무리 운동",false));


        if(n1 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n1,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n1 = getArguments().getString("1");
                if(n1 !=null){
                    adapter.addItem(new CheckList(n1,true));
                }
            }
        }

        if(n2 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n2,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n2 = getArguments().getString("2");
                if(n2 !=null){
                    adapter.addItem(new CheckList(n2, true));
                }
            }
        }

        if(n3 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n3,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n3 = getArguments().getString("3");
                if(n3 !=null){
                    adapter.addItem(new CheckList(n3,true));
                }
            }
        }

        if(n4 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n4,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n4 = getArguments().getString("4");
                if(n4 !=null){
                    adapter.addItem(new CheckList(n4, true));
                }
            }
        }

        if(n5 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n5,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n5 = getArguments().getString("5");
                if(n5 !=null){
                    adapter.addItem(new CheckList(n5,true));
                }
            }
        }

        if(n6 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n6,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n6 = getArguments().getString("6");
                if(n6 !=null){
                    adapter.addItem(new CheckList(n6, true));
                }
            }
        }

        if(n7 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n7,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n7 = getArguments().getString("7");
                if(n7 !=null){
                    adapter.addItem(new CheckList(n7,true));
                }
            }
        }

        if(n8 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n8,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n8 = getArguments().getString("8");
                if(n8 !=null){
                    adapter.addItem(new CheckList(n8, true));
                }
            }
        }

        if(n9 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n9,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n9 = getArguments().getString("9");
                if(n9 !=null){
                    adapter.addItem(new CheckList(n9,true));
                }
            }
        }

        if(n10 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n10,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n10 = getArguments().getString("10");
                if(n10 !=null){
                    adapter.addItem(new CheckList(n10,true));
                }
            }
        }

        if(n11 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n11,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n11 = getArguments().getString("11");
                if(n11 !=null){
                    adapter.addItem(new CheckList(n11, true));
                }
            }
        }

        if(n12 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n12,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n12 = getArguments().getString("12");
                if(n12 !=null){
                    adapter.addItem(new CheckList(n12,true));
                }
            }
        }

        if(n13 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n13,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n13 = getArguments().getString("13");
                if(n13 !=null){
                    adapter.addItem(new CheckList(n13, true));
                }
            }
        }

        if(n14 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n14,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n14 = getArguments().getString("14");
                if(n14 !=null){
                    adapter.addItem(new CheckList(n14,true));
                }
            }
        }

        if(n15 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n15,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n15 = getArguments().getString("15");
                if(n15 !=null){
                    adapter.addItem(new CheckList(n15, true));
                }
            }
        }

        if(n16 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n16,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n16 = getArguments().getString("16");
                if(n16 !=null){
                    adapter.addItem(new CheckList(n16,true));
                }
            }
        }

        if(n17 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n17,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n17 = getArguments().getString("17");
                if(n17 !=null){
                    adapter.addItem(new CheckList(n17, true));
                }
            }
        }

        if(n18 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n18,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n18 = getArguments().getString("18");
                if(n18 !=null){
                    adapter.addItem(new CheckList(n18,true));
                }
            }
        }

        if(n19 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n19,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n19 = getArguments().getString("19");
                if(n19 !=null){
                    adapter.addItem(new CheckList(n19, true));
                }
            }
        }

        if(n20 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n20,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n20 = getArguments().getString("20");
                if(n20 !=null){
                    adapter.addItem(new CheckList(n20,true));
                }
            }
        }

        if(n21 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n21,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n21 = getArguments().getString("21");
                if(n21 !=null){
                    adapter.addItem(new CheckList(n21, true));
                }
            }
        }

        if(n22 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n22,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n22 = getArguments().getString("22");
                if(n22 !=null){
                    adapter.addItem(new CheckList(n22,true));
                }
            }
        }

        if(n23 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n23,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n23 = getArguments().getString("23");
                if(n23 !=null){
                    adapter.addItem(new CheckList(n23, true));
                }
            }
        }

        if(n24 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n24,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n24 = getArguments().getString("24");
                if(n24 !=null){
                    adapter.addItem(new CheckList(n24,true));
                }
            }
        }

        if(n25 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n25,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n25 = getArguments().getString("25");
                if(n25 !=null){
                    adapter.addItem(new CheckList(n25,true));
                }
            }
        }

        if(n26 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n26,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n26 = getArguments().getString("26");
                if(n26 !=null){
                    adapter.addItem(new CheckList(n26, true));
                }
            }
        }

        if(n27 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n27,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n27 = getArguments().getString("27");
                if(n27 !=null){
                    adapter.addItem(new CheckList(n27,true));
                }
            }
        }

        if(n28 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n28,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n28 = getArguments().getString("28");
                if(n28 !=null){
                    adapter.addItem(new CheckList(n28, true));
                }
            }
        }

        if(n29 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n29,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n29 = getArguments().getString("29");
                if(n29 !=null){
                    adapter.addItem(new CheckList(n29,true));
                }
            }
        }

        if(n30 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n30,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n30 = getArguments().getString("30");
                if(n30 !=null){
                    adapter.addItem(new CheckList(n30, true));
                }
            }
        }
        if(n31 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n31,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n31 = getArguments().getString("31");
                if(n31 !=null){
                    adapter.addItem(new CheckList(n31, true));
                }
            }
        }

        if(n32 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n32,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n32 = getArguments().getString("32");
                if(n32!=null){
                    adapter.addItem(new CheckList(n32,true));
                }
            }
        }

        if(n33 !=null) { // 첫 번째 운동 변수에 값이 있을때
            adapter.addItem(new CheckList(n33,true)); //체크 리스트에 추가
        }else {
            if (getArguments()!= null) { //값이 없다면, 완료 버튼 누른곳에서 데이터 받아서 체크리스트 추가
                n33 = getArguments().getString("33");
                if(n33 !=null){
                    adapter.addItem(new CheckList(n33, true));
                }
            }
        }




        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnHealthItemClickListener() { //아이템 선택 되었을때
            @Override
            public void onItemClick(ChecklistAdapter.ViewHolder holder, View view, int position) {
                CheckList item = adapter.getItem(position);
                Toast.makeText(getActivity().getBaseContext(),"아이템 선택됨: "+item.getHitem(), Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState){ //프래그먼트 이동하기전 값 저장
        super.onSaveInstanceState(outState);
        outState.putString("1",n1);
        outState.putString("2",n2);
        outState.putString("3",n3);
        outState.putString("4",n4);
        outState.putString("5",n5);
        outState.putString("6",n6);
        outState.putString("7",n7);
        outState.putString("8",n8);
        outState.putString("9",n9);
        outState.putString("10",n10);
        outState.putString("11",n11);
        outState.putString("12",n12);
        outState.putString("13",n13);
        outState.putString("14",n14);
        outState.putString("15",n15);
        outState.putString("16",n16);
        outState.putString("17",n17);
        outState.putString("18",n18);
        outState.putString("19",n19);
        outState.putString("20",n20);
        outState.putString("21",n21);
        outState.putString("22",n22);
        outState.putString("23",n23);
        outState.putString("24",n24);
        outState.putString("25",n25);
        outState.putString("26",n26);
        outState.putString("27",n27);
        outState.putString("28",n28);
        outState.putString("29",n29);
        outState.putString("30",n30);
        outState.putString("31",n31);
        outState.putString("32",n32);
        outState.putString("33",n33);
    }

}
