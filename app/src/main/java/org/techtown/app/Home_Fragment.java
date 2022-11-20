package org.techtown.app;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.app.exercise.ExerciseActivity;
import org.techtown.app.ui.checkList.CheckList_Fragment;
import org.techtown.app.ui.home.orderExercise.OrderExercise_Fragment;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Home_Fragment extends Fragment implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    private Button button;
    private Button button2;
    private long btnPressTime = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.home_fragment, container, false);

        ConstraintLayout constraintLayout;
        constraintLayout=rootView.findViewById(R.id.constrain1);
        TextView textView1 = rootView.findViewById(R.id.textView8);
        TextView textView2 = rootView.findViewById(R.id.textView9);
        TextView textView3 = rootView.findViewById(R.id.textView10);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("array1",MODE_PRIVATE); //정보 받아오기
        SharedPreferences sharedPreferences_disability = getActivity().getSharedPreferences("type", MODE_PRIVATE);
        SharedPreferences sharedPreferences9 = getActivity().getSharedPreferences("exercise", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences111 = getActivity().getSharedPreferences("warmup", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences222 = getActivity().getSharedPreferences("main", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences333 = getActivity().getSharedPreferences("finish", Context.MODE_PRIVATE);

        String disability = sharedPreferences_disability.getString("type", "");
        SharedPreferences.Editor editor = sharedPreferences9.edit();
        SharedPreferences.Editor editor1 = sharedPreferences111.edit();
        SharedPreferences.Editor editor2 = sharedPreferences222.edit();
        SharedPreferences.Editor editor3 = sharedPreferences333.edit();

        Set<String> set1 = new HashSet<String>();
        if(disability.equals("시각장애")){
            set1 = sharedPreferences.getStringSet("array1", null);
            editor.putString("exercise","시각장애");
            tts = new TextToSpeech(getActivity(), this);
            speakOut("시각장애인을 위한 음성 서비스 입니다 \n 추천운동을 진행하려면 화면을 길게 터치하고 \n 운동 체크리스트를 보고싶으시다면 두번 클릭해주세요.");
            constraintLayout.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    tts.stop();
                    Intent intent1 = new Intent(getActivity(), ExerciseActivity.class);
                    startActivity(intent1);
                    return false;
                }
            });
            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (System.currentTimeMillis() > btnPressTime + 1000) {
                        tts.stop();
                        btnPressTime = System.currentTimeMillis();
                        return;
                    }
                    if (System.currentTimeMillis() <= btnPressTime + 1000) {
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        CheckList_Fragment checkList_fragment = new CheckList_Fragment();
                        transaction.replace(R.id.container,checkList_fragment,"checkList"); //번들 보내줌
                        transaction.commit();
                    }
                }
            });
        }else if(disability.equals("청각장애")){
            System.out.println(set1);
            set1 = sharedPreferences.getStringSet("array2", null);
            editor.putString("exercise","청각장애");

        }else if(disability.equals("지적장애")){
            System.out.println(set1);
            set1 = sharedPreferences.getStringSet("array3", null);
            editor.putString("exercise","지적장애");
        }else {
            System.out.println(set1);
            set1 = sharedPreferences.getStringSet("array4", null);
            editor.putString("exercise","척수장애");
        }
        editor.commit();
        if(set1.contains(" 원판던지기")){
            editor1.putString("warmup","원판 던지기");
            textView1.setText("준비 운동 : 원판 던지기");
        }
        else if(set1.contains(" 몸통 들어올리기")){
            editor1.putString("warmup","몸통 들어올리기");
            textView1.setText("준비 운동 : 몸통 들어올리기");
        }
        else if(set1.contains(" 앉아서 몸통 움츠리기")){
            editor1.putString("warmup","앉아서 몸통 움츠리기");
            textView1.setText("준비 운동 : 앉아서 몸통 움츠리기");
        }
        else if(set1.contains(" 앉아서 다리 밀기")){
            editor1.putString("warmup","앉아서 다리 밀기");
            textView1.setText("준비 운동 : 앉아서 다리 밀기");
        }
        else if(set1.contains(" 앉아서 다리 펴기")){
            editor1.putString("warmup","앉아서 다리 펴기");
            textView1.setText("준비 운동 : 앉아서 다리 펴기");
        }
        else if(set1.contains(" 매달려서 다리 들기")){
            editor1.putString("warmup","매달려서 다리 들기");
            textView1.setText("준비 운동 : 매달려서 다리 들기");
        }
        else if(set1.contains(" 앉아서 모으기")){
            editor1.putString("warmup","앉아서 모으기");
            textView1.setText("준비 운동 : 앉아서 모으기");
        }
        else if(set1.contains(" 거꾸로 누워서 밀기")){
            editor1.putString("warmup","거꾸로 누워서 밀기");
            textView1.setText("준비 운동 : 거꾸로 누워서 밀기");
        }
        else if(set1.contains(" 실내 자전거타기")){
            editor1.putString("warmup","실내 자전거타기");
            textView1.setText("준비 운동 : 실내 자전거타기");
        }
        else if(set1.contains(" 파워클린")){
            editor1.putString("warmup","파워클린");
            textView1.setText("준비 운동 : 파워클린");
        }
        else if(set1.contains(" 뒤꿈치 들기")){
            editor1.putString("warmup","뒤꿈치 들기");
            textView1.setText("준비 운동 : 뒤꿈치 들기");
        }
        else if(set1.contains(" 트레드밀에서 걷기")){
            editor1.putString("warmup","트레드밀에서 걷기");
            textView1.setText("준비 운동 : 트레드밀에서 걷기");
        }
        else if(set1.contains(" 앉았다 일어서기")){
            editor1.putString("warmup","앉았다 일어서기");
            textView1.setText("준비 운동 : 앉았다 일어서기");
        }else if(set1.contains(" 앉아서 밀기")) {
            editor1.putString("warmup","앉아서 밀기");
            textView1.setText("준비 운동 : 앉아서 밀기");
        }
        editor1.commit();
        if(set1.contains(" 발 닿기")){
            editor2.putString("main","발 닿기");
            textView2.setText("본 운동 : 발 닿기");
        }
        else if(set1.contains(" 앉아서 다리 모으기")){
            editor2.putString("main","앉아서 다리 모으기");
            textView2.setText("본 운동 : 앉아서 다리 모으기");
        }
        else if(set1.contains(" 앉아서 위로 밀기")){
            editor2.putString("main","앉아서 위로 밀기");
            textView2.setText("본 운동 : 앉아서 위로 밀기");
        }
        else if(set1.contains(" 서서 어깨 들어올리기")){
            editor2.putString("main","서서 어깨 들어올리기");
            textView2.setText("본 운동 : 서서 어깨 들어올리기");
        }
        else if(set1.contains(" 바벨 끌어당기기")){
            editor2.putString("main","바벨 끌어당기기");
            textView2.setText("본 운동 : 바벨 끌어당기기");
        }
        else if(set1.contains(" 턱걸이")){
            editor2.putString("main","턱걸이");
            textView2.setText("본 운동 : 턱걸이");
        }
        else if(set1.contains(" 한발 앞으로 내밀고 앉았다 일어서기")){
            editor2.putString("main","한발 앞으로 내밀고 앉았다 일어서기");
            textView2.setText("본 운동 : 한발 앞으로 내밀고 앉았다 일어서기");
        }
        else if(set1.contains(" 앉아서 뒤로 당기기")){
            editor2.putString("main","앉아서 뒤로 당기기");
            textView2.setText("본 운동 : 앉아서 뒤로 당기기");
        }
        else if(set1.contains(" 누워서 밀기")){
            editor2.putString("main","누워서 밀기");
            textView2.setText("본 운동 : 누워서 밀기");
        }
        else if(set1.contains(" 허리 굽혀 덤벨 들기")){
            editor2.putString("main","허리 굽혀 덤벨 들기");
            textView2.setText("본 운동 : 허리 굽혀 덤벨 들기");
        }
        else if(set1.contains(" 계단 뛰어 오르기")){
            editor2.putString("main","계단 뛰어 오르기");
            textView2.setText("본 운동 : 계단 뛰어 오르기");
        }
        else if(set1.contains(" 몸 기울이기/회전하기")){
            editor2.putString("main","몸 기울이기/회전하기");
            textView2.setText("본 운동 : 몸 기울이기/회전하기");
        }
        editor2.commit();
        if(set1.contains(" 바벨들어올리기]")){
            editor3.putString("finish","바벨 들어올리기");
            textView3.setText("마무리 운동 : 바벨 들어올리기");

        } else if(set1.contains(" 앉아서 당겨 내리기]")){
            editor3.putString("finish","앉아서 당겨 내리기");
            textView3.setText("마무리 운동 : 앉아서 당겨 내리기");
        }else if(set1.contains(" 앉아서 다리 벌리기]")){
            editor3.putString("finish","앉아서 다리 벌리기");
            textView3.setText("마무리 운동 : 앉아서 다리 벌리기");
        }else if(set1.contains(" 비스듬히 누워서 밀기]")){
            editor3.putString("finish","비스듬히 누워서 밀기");
            textView3.setText("마무리 운동 : 비스듬히 누워서 밀기");
        }else if(set1.contains(" 앉아서 다리 굽히기]")){
            editor3.putString("finish","앉아서 다리 굽히기");
            textView3.setText("마무리 운동 : 앉아서 다리 굽히기");
        }else if(set1.contains(" 계단 올라갔다 내려오기]")){
            editor3.putString("finish","계단 올라갔다 내려오기");
            textView3.setText("마무리 운동 : 계단 올라갔다 내려오기");
        }else if(set1.contains(" 옆구리 늘리기]")){
            editor3.putString("finish","옆구리 늘리기");
            textView3.setText("마무리 운동 : 옆구리 늘리기");
        }
        editor3.commit();

        button = rootView.findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(disability.equals("시각장애")){
                    tts.stop();
                }
                Intent intent1 = new Intent(getActivity(), ExerciseActivity.class);
                startActivity(intent1);
            }
        });
        button2 = rootView.findViewById(R.id.other_ex);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
               OrderExercise_Fragment orderExercise_fragment = new OrderExercise_Fragment();
               transaction.replace(R.id.container, orderExercise_fragment , "orderExercise_fragment"); //번들 보내줌
               transaction.commit();
            }
        });
        return rootView;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(String s){
        tts.setPitch((float)1); // 음성 톤 높이 지정
        tts.setSpeechRate((float)0.8); // 음성 속도 지정
        tts.speak(s, TextToSpeech.QUEUE_FLUSH, null, "id1");
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
                speakOut("시각장애인을 위한 음성 서비스 입니다 \n 화면을 길게 터치하면 추천운동 \n 화면을 두번 터치하면 체크리스트 화면으로 이동합니다.");
            }
        }else{
            Log.e("TTS", "Initialization Failed!");
        }
    }
}
