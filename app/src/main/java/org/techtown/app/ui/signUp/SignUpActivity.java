package org.techtown.app.ui.signUp;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import org.techtown.app.R;


public class SignUpActivity extends FragmentActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        SignUp_Fragment1 fragment_1 = new SignUp_Fragment1();
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout1,fragment_1).commit();



    }

}