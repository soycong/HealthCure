package org.techtown.app.ui.signUp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import org.techtown.app.R;

public class SignUp_Fragment5 extends Fragment {
    private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_5p, container, false);

        Spinner spinnertype = rootView.findViewById(R.id.spinnerType);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getActivity().getBaseContext(), //장애 타입 스피너 어뎁터
                R.array.spinner_type, android.R.layout.simple_spinner_item //r.string.xml에 스피너 데이터 넣어주고 씀.
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnertype.setAdapter(adapter1);




        button = rootView.findViewById(R.id.button22);
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
        return rootView;
    }

}
