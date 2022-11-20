package org.techtown.app.ui.signUp;

import static android.speech.tts.TextToSpeech.ERROR;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;

import androidx.fragment.app.FragmentActivity;

import org.techtown.app.R;

import java.util.Locale;
import java.util.Random;


public class SignUpActivity extends FragmentActivity  {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Random rnd = new Random();
        int rndnum = rnd.nextInt(29); //랜덤 값 생성

        SharedPreferences sharedPreferences111 = getSharedPreferences("warmup", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferences111.edit();
        editor1.clear();
        editor1.commit();
        SharedPreferences sharedPreferences222 = getSharedPreferences("main", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sharedPreferences222.edit();
        editor2.clear();
        editor2.commit();
        SharedPreferences sharedPreferences333 = getSharedPreferences("finish", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sharedPreferences333.edit();
        editor3.clear();
        editor3.commit();
        SharedPreferences sharedPreferences100 = getSharedPreferences("rnd", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences100.edit();
        editor.putInt("rnd",rndnum);
        editor.commit();
        SignUp_Fragment1 fragment_1 = new SignUp_Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout1,fragment_1).commit();
    }
}