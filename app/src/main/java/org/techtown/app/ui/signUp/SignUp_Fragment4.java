package org.techtown.app.ui.signUp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.app.R;

public class SignUp_Fragment4 extends Fragment {
    private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_4p, container, false);

        button = rootView.findViewById(R.id.button22);
        RadioButton menButton = rootView.findViewById(R.id.menButton);
        RadioButton femaleButton = rootView.findViewById(R.id.femaleButton);

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
        return rootView;
    }

}
