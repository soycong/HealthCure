package org.techtown.app.mypage;

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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.app.MainActivity;
import org.techtown.app.R;

import java.util.Locale;

public class MyPage_Fragment extends Fragment implements TextToSpeech.OnInitListener{

    private View view;
    private Button btn_edit;
    static TextView insert_name;
    static TextView insert_age;
    static TextView picked_sex;
    static TextView choose_disability;
    static TextView choose_disabilityGrade;
    static String name;
    static String age;
    static String sex;
    static String disability;
    static String disabilityGrade;
    private TextToSpeech tts;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mypage_fragment, container, false);
        insert_name = view.findViewById(R.id.insert_name);
        insert_age = view.findViewById(R.id.insert_age);
        picked_sex = view.findViewById(R.id.sex);
        choose_disability = view.findViewById(R.id.spinnerType);
        choose_disabilityGrade = view.findViewById(R.id.spinnerClass);
        btn_edit = view.findViewById(R.id.edit_button);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                MyPageEdit_Fragment mypage_edit = new MyPageEdit_Fragment();
                transaction.replace(R.id.container, mypage_edit, "myPage_edit").commit();
            }
        });

        SharedPreferences sharedPreferences_name = this.getActivity().getSharedPreferences("name", MODE_PRIVATE); //정보 받아오기
        SharedPreferences sharedPreferences_age = this.getActivity().getSharedPreferences("age", MODE_PRIVATE);
        SharedPreferences sharedPreferences_sex = this.getActivity().getSharedPreferences("sex", MODE_PRIVATE);
        SharedPreferences sharedPreferences_disability = this.getActivity().getSharedPreferences("type", MODE_PRIVATE);
        SharedPreferences sharedPreferences_disabilitygrade = this.getActivity().getSharedPreferences("class", MODE_PRIVATE);

        name = sharedPreferences_name.getString("name", "");
        age = sharedPreferences_age.getString("age", "");
        sex = sharedPreferences_sex.getString("sex", "");
        disability = sharedPreferences_disability.getString("type", "");
        disabilityGrade = sharedPreferences_disabilitygrade.getString("class", "");

        if(disability.equals("시각장애")){
            tts = new TextToSpeech(getActivity(), this);
            speakOut();
        }

        insert_name.setText(name);
        insert_age.setText(age);
        picked_sex.setText(sex);
        choose_disability.setText(disability);
        choose_disabilityGrade.setText(disabilityGrade);
        return view;
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) { //프래그먼트 이동하기전 값 저장
        super.onSaveInstanceState(outState);
        outState.putString("name_edit",name);
        outState.putString("age_edit",age);
        outState.putString("sex_edit",sex);
        outState.putString("disability_edit",disability);
        outState.putString("disabilityGrade_edit",disabilityGrade);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(){
        tts.setPitch((float)1); // 음성 톤 높이 지정
        tts.setSpeechRate((float)0.8); // 음성 속도 지정
        tts.speak("마이페이지 화면입니다.", TextToSpeech.QUEUE_FLUSH, null, "id1");
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


