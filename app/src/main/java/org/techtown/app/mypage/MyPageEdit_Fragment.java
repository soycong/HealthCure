package org.techtown.app.mypage;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.app.MainActivity;
import org.techtown.app.R;
import org.techtown.app.mypage.MyPage_Fragment;

public class MyPageEdit_Fragment extends Fragment {

    private View view;
    private Button btn;
    EditText nameInput;
    EditText ageInput;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mypage_edit_fragment, container, false);

        nameInput = view.findViewById(R.id.insert_name);
        ageInput = view.findViewById(R.id.insert_age);
        btn = view.findViewById(R.id.edit_finish);
        RadioButton menButton = view.findViewById(R.id.menButton);
        RadioButton femaleButton = view.findViewById(R.id.femaleButton);
        Spinner spinnertype = view.findViewById(R.id.spinnerType);
        Spinner spinnerclass = view.findViewById(R.id.spinnerClass);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity().getBaseContext(), //장애 타입 스피너 어뎁터
                R.array.spinner_type, android.R.layout.simple_spinner_item
        );
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity().getBaseContext(), //장애 등급 스피너 어뎁터
                R.array.spinner_class, android.R.layout.simple_spinner_item
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnertype.setAdapter(adapter1);
        spinnerclass.setAdapter(adapter2);

        SharedPreferences sharedPreferences_name = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences_age = getActivity().getSharedPreferences("age", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences_disability = getActivity().getSharedPreferences("type", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences_disabilitygrade = getActivity().getSharedPreferences("class", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences_sex = getActivity().getSharedPreferences("sex", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor_name = sharedPreferences_name.edit();
        SharedPreferences.Editor editor_age = sharedPreferences_age.edit();
        SharedPreferences.Editor editor_disability = sharedPreferences_disability.edit();
        SharedPreferences.Editor editor_disabilitygrade = sharedPreferences_disabilitygrade.edit();
        SharedPreferences.Editor editor_sex = sharedPreferences_sex.edit();

        editor_name.clear();
        editor_age.clear();
        editor_disability.clear();
        editor_disabilitygrade.clear();
        editor_sex.clear();

        editor_name.commit();
        editor_age.commit();
        editor_disability.commit();
        editor_disabilitygrade.commit();
        editor_sex.commit();

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(nameInput.getText().toString().length()==0){
                    showDialog("이름을 입력하세요");
                    return;
                }else if(ageInput.getText().toString().length()==0){
                    showDialog("나이를 입력하세요");
                    return;
                }else if(menButton.isChecked()==false&&femaleButton.isChecked()==false){
                    showDialog("성별을 체크해주세요");
                    return;
                }else if(spinnertype.getSelectedItem().toString().equals("장애유형 선택")){
                    showDialog("장애유형을 선택해주세요");
                    return;
                }else if(spinnerclass.getSelectedItem().toString().equals("장애등급 선택")){
                    showDialog("장애등급을 선택해주세요");
                    return;
                }
                if (menButton.isChecked()) { //남성 체크 됐을 때
                    menButton.setChecked(true);
                    editor_sex.putString("sex","남자");
                }else if(femaleButton.isChecked()){ //여성 체크 됐을 때
                    femaleButton.setChecked(true);
                    editor_sex.putString("sex","남자");
                }

                editor_name.putString("name",nameInput.getText().toString());
                editor_age.putString("age",ageInput.getText().toString());
                editor_disability.putString("type",spinnertype.getSelectedItem().toString());
                editor_disabilitygrade.putString("class",spinnerclass.getSelectedItem().toString());

                editor_name.clear();
                editor_age.clear();
                editor_disability.clear();
                editor_disabilitygrade.clear();
                editor_sex.clear();

                editor_name.commit();
                editor_age.commit();
                editor_disability.commit();
                editor_disabilitygrade.commit();
                editor_sex.commit();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                MyPage_Fragment fragment3 = new MyPage_Fragment();//프래그먼트3 선언
                transaction.replace(R.id.container, fragment3, "myPage").commit(); //번들 보내줌
                Toast.makeText(getContext(),  "저장되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    void showDialog(String s) {
        AlertDialog.Builder msgBuilder = new AlertDialog.Builder(getActivity())
                .setTitle("정보를 입력하시오")
                .setMessage(s)
                .setNegativeButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
        AlertDialog msgDlg = msgBuilder.create();
        msgDlg.show();
    }
}