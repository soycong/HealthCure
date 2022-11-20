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

public class SignUp_Fragment5 extends Fragment implements TextToSpeech.OnInitListener{
    private Button button;
    private ImageButton button2;
    private TextToSpeech tts;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_5p, container, false);

        Spinner spinnertype = rootView.findViewById(R.id.spinnerType);
        tts = new TextToSpeech(getActivity(), this);
        button = rootView.findViewById(R.id.button22);
        button2 = rootView.findViewById(R.id.imageButton2);
        speakOut();

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity().getBaseContext(), //장애 타입 스피너 어뎁터
                R.array.spinner_type, android.R.layout.simple_spinner_item //r.string.xml에 스피너 데이터 넣어주고 씀.
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnertype.setAdapter(adapter1);

        spinnertype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if(!spinnertype.getSelectedItem().toString().equals("장애유형 선택")) {
                    button.setText("다음으로");
                    button.setEnabled(true);
                    button.setBackgroundColor(Color.parseColor("#FF9900"));
                } else {
                    button.setText("장애 유형을 선택하세요.");
                    button.setEnabled(false);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                button.setText("장애 유형 선택");
                button.setEnabled(false);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String typeStr = spinnertype.getSelectedItem().toString();

                SharedPreferences sharedPreferences4 = getActivity().getSharedPreferences("type", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences4.edit();
                editor.putString("type",typeStr);
                editor.commit();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment6 fragment_6 = new SignUp_Fragment6();
                transaction.replace(R.id.frameLayout1,fragment_6);
                transaction.commit();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment4 fragment_4 = new SignUp_Fragment4();
                transaction.replace(R.id.frameLayout1, fragment_4);
                transaction.commit();

            }
        });
        return rootView;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void speakOut(){
        tts.setPitch((float)1); // 음성 톤 높이 지정
        tts.setSpeechRate((float)0.8); // 음성 속도 지정
        tts.speak("장애 유형을 선택해 주세요.", TextToSpeech.QUEUE_FLUSH, null, "id1");
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
