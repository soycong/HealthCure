package org.techtown.app.ui.signUp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.app.R;

import java.util.Locale;

public class SignUp_Fragment4 extends Fragment implements TextToSpeech.OnInitListener{
    private Button button;
    private ImageButton button2;
    private TextToSpeech tts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_4p, container, false);
        tts = new TextToSpeech(getActivity(), this);
        button = rootView.findViewById(R.id.button22);
        button2 = rootView.findViewById(R.id.imageButton2);
        RadioGroup radioGroup = rootView.findViewById(R.id.radioGroup);
        RadioButton menButton = rootView.findViewById(R.id.menButton);
        RadioButton femaleButton = rootView.findViewById(R.id.femaleButton);
        speakOut();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected
                if (menButton.isChecked()){
                    button.setText("다음으로");
                    button.setEnabled(true);
                    button.setBackgroundColor(Color.parseColor("#FF9900"));
                } else if (femaleButton.isChecked()) {
                    button.setText("다음으로");
                    button.setEnabled(true);
                    button.setBackgroundColor(Color.parseColor("#FF9900"));
                } else {
                    button.setEnabled(false);
                    button.setBackgroundColor(Color.GRAY);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sexStr = null;
                if (menButton.isChecked()) { //남성 체크 됐을 때
                    sexStr = "남성";
                }
                else if(femaleButton.isChecked()){ //여성 체크 됐을 때
                    sexStr = "여성";
                }
                SharedPreferences sharedPreferences3 = getActivity().getSharedPreferences("sex", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences3.edit();
                editor.putString("sex",sexStr);
                editor.commit();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment5 fragment_5 = new SignUp_Fragment5();
                transaction.replace(R.id.frameLayout1,fragment_5);
                transaction.commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment3 fragment_3 = new SignUp_Fragment3();
                transaction.replace(R.id.frameLayout1, fragment_3);
                transaction.commit();
            }
        });
        return rootView;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(){
        tts.setPitch((float)1); // 음성 톤 높이 지정
        tts.setSpeechRate((float)0.8); // 음성 속도 지정
        tts.speak("성별을 선택해 주세요.", TextToSpeech.QUEUE_FLUSH, null, "id1");
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
