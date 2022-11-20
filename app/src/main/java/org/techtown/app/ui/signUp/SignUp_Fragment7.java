package org.techtown.app.ui.signUp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.app.MainActivity;
import org.techtown.app.R;
import org.techtown.app.exercise.ExerciseActivity;

import java.util.Locale;

public class SignUp_Fragment7 extends Fragment implements TextToSpeech.OnInitListener{
    private Button button;
    private ImageButton button2;
    private TextToSpeech tts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_7p, container, false);

        tts = new TextToSpeech(getActivity(), this);
        button = rootView.findViewById(R.id.button);
        button2= rootView.findViewById(R.id.imageButton2);
        speakOut();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.stop();
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.stop();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment6 fragment_6 = new SignUp_Fragment6();
                transaction.replace(R.id.frameLayout1, fragment_6);
                transaction.commit();
            }
        });
        return rootView;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(){
        tts.setPitch((float)1); // 음성 톤 높이 지정
        tts.setSpeechRate((float)0.8); // 음성 속도 지정
        tts.speak("정보입력이 완료되었습니다. \n 시작하기 버튼을 눌러 운동을 시작해주세요.", TextToSpeech.QUEUE_FLUSH, null, "id1");
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
