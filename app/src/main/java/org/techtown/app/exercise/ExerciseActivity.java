package org.techtown.app.exercise;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import org.techtown.app.MainActivity;
import org.techtown.app.R;

import java.util.Locale;

public class ExerciseActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    private ViewPager2 mPager;
    private FragmentStateAdapter pagerAdapter;
    private int num_page = 3;
    public String s;
    private String exercise;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //ViewPager2
        mPager = findViewById(R.id.viewpager);
        //Adapter
        pagerAdapter = new Exercise_Adapter(this, num_page);
        mPager.setAdapter(pagerAdapter);
        //ViewPager Setting
        mPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        mPager.setCurrentItem(0); //시작 지점
        mPager.setOffscreenPageLimit(3); //최대 이미지 수
        getSupportActionBar().setTitle("오늘의 추천 운동");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tts = new TextToSpeech(this, this);

        SharedPreferences sharedPreferences9 = getSharedPreferences("exercise", Context.MODE_PRIVATE);
        exercise = sharedPreferences9.getString("exercise", "");
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: { //toolbar의 back키 눌렀을 때 동작
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode){
            case KeyEvent.KEYCODE_BACK :
                // 여기에 뒤로가기 버튼을 눌렀을 때 행동 입력
                SharedPreferences sharedPreferences111 = getSharedPreferences("warmup", Context.MODE_PRIVATE);
                SharedPreferences.Editor editorCheck = sharedPreferences111.edit();
                editorCheck.putBoolean("warmupCheck",true);
                editorCheck.commit();

                SharedPreferences sharedPreferences222 = getSharedPreferences("main", Context.MODE_PRIVATE);
                SharedPreferences.Editor editorCheck1 = sharedPreferences222.edit();
                editorCheck1.putBoolean("mainCheck",true);
                editorCheck1.commit();

                SharedPreferences sharedPreferences333 = getSharedPreferences("finish", Context.MODE_PRIVATE);
                SharedPreferences.Editor editorCheck3 = sharedPreferences333.edit();
                editorCheck3.putBoolean("finishCheck",true);
                editorCheck3.commit();

                finish();
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN :
                // 여기에 볼륨 ↓ 버튼을 눌렀을 때 행동 입력
                if(exercise.equals("시각장애")){
                    if(mPager.getCurrentItem()==1){
                        speakOut("준비 운동 화면입니다");
                    }else if(mPager.getCurrentItem()==2){
                        speakOut("메인 운동 화면입니다.");
                    }
                    mPager.setCurrentItem(mPager.getCurrentItem()-1);
                }
                break;
            case KeyEvent.KEYCODE_VOLUME_UP :
                // 여기에 볼륨 ↑ 버튼을 눌렀을 때 행동 입력
                if(exercise.equals("시각장애")){
                    if(mPager.getCurrentItem()==0){
                        speakOut("메인 운동 화면입니다");
                    }else if(mPager.getCurrentItem()==1){
                        speakOut("마무리 운동 화면입니다.");
                    }else if(mPager.getCurrentItem()==2){
                        speakOut("오늘의 추천 운동을 완료하였습니다. 휴대폰 하단의 뒤로가기 버튼을 눌러 홈 화면으로 돌아가시면 됩니다.");
                    }
                    mPager.setCurrentItem(mPager.getCurrentItem()+1);
                }
                break;
        }
        return true;
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
                speakOut(s);// onInit에 음성출력할 텍스트를 넣어줌
            }
        }else{
            Log.e("TTS", "Initialization Failed!");
        }
    }
}
