package org.techtown.app.ui.signUp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.app.R;

public class SignUp_Fragment3 extends Fragment {
    private Button button;
    EditText ageInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_3p, container, false);

        button = rootView.findViewById(R.id.button22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ageInput = rootView.findViewById(R.id.textage);
                String ageStr = ageInput.getText().toString();

                SharedPreferences sharedPreferences2 = getActivity().getSharedPreferences("age", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences2.edit();
                editor.putString("age",ageStr);
                editor.commit();

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment4 fragment_4 = new SignUp_Fragment4();
                transaction.replace(R.id.frameLayout1,fragment_4);
                transaction.commit();
            }
        });

        return rootView;
    }

}
