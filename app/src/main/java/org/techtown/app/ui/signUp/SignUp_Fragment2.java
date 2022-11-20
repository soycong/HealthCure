package org.techtown.app.ui.signUp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import org.techtown.app.R;

import java.util.Locale;


public class SignUp_Fragment2 extends Fragment implements TextToSpeech.OnInitListener{
    private TextToSpeech tts;
    private Button button;
    private ImageButton button2;
    EditText nameInput;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_2p, container, false);

        tts = new TextToSpeech(getActivity(), this);
        nameInput = rootView.findViewById(R.id.textage);
        button = rootView.findViewById(R.id.button22);
        button2 = rootView.findViewById(R.id.imageButton2);
        speakOut();

        nameInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() > 0) {
                    button.setText("다음으로");
                    button.setEnabled(true);
                    button.setBackgroundColor(Color.parseColor("#FF9900"));
                } else {
                    button.setText("이름을 입력하세요.");
                    button.setEnabled(false);
                    button.setBackgroundColor(Color.GRAY);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = nameInput.getText().toString();
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", nameStr);
                editor.commit();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment3 fragment_3 = new SignUp_Fragment3();
                transaction.replace(R.id.frameLayout1, fragment_3);
                transaction.commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment1 fragment_1 = new SignUp_Fragment1();
                transaction.replace(R.id.frameLayout1, fragment_1);
                transaction.commit();
            }
        });
        return rootView;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(){
        tts.setPitch((float)1); // 음성 톤 높이 지정
        tts.setSpeechRate((float)0.8); // 음성 속도 지정
        tts.speak("이름을 입력해주세요.", TextToSpeech.QUEUE_FLUSH, null, "id1");
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
