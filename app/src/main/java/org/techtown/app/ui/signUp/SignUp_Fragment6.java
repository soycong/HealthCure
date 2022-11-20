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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.app.R;

import java.util.Locale;

public class SignUp_Fragment6 extends Fragment implements TextToSpeech.OnInitListener{
    private Button button;
    private ImageButton button2;
    private TextToSpeech tts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_6p, container, false);

        Spinner spinnercalss = rootView.findViewById(R.id.spinnerClass);
        tts = new TextToSpeech(getActivity(), this);
        button = rootView.findViewById(R.id.button22);
        button2 = rootView.findViewById(R.id.imageButton2);
        speakOut();
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity().getBaseContext(), //장애 등급 스피너 어뎁터
                R.array.spinner_class, android.R.layout.simple_spinner_item
        );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnercalss.setAdapter(adapter2);
        spinnercalss.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(!spinnercalss.getSelectedItem().toString().equals("장애등급 선택")) {
                    button.setText("다음으로");
                    button.setEnabled(true);
                    button.setBackgroundColor(Color.parseColor("#FF9900"));
                } else {
                    button.setText("장애등급을 선택하세요.");
                    button.setEnabled(false);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                button.setText("장애 등급 선택");
                button.setEnabled(false);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String calssStr = spinnercalss.getSelectedItem().toString();
                SharedPreferences sharedPreferences5 = getActivity().getSharedPreferences("class", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences5.edit();
                editor.putString("class",calssStr);
                editor.commit();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment7 fragment_7 = new SignUp_Fragment7();
                transaction.replace(R.id.frameLayout1,fragment_7);
                transaction.commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment5 fragment_5= new SignUp_Fragment5();
                transaction.replace(R.id.frameLayout1, fragment_5);
                transaction.commit();

            }
        });
        return rootView;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(){
        tts.setPitch((float)1); // 음성 톤 높이 지정
        tts.setSpeechRate((float)0.8); // 음성 속도 지정
        tts.speak("장애 등급을 선택해 주세요.", TextToSpeech.QUEUE_FLUSH, null, "id1");
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
