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

public class SignUp_Fragment6 extends Fragment {
    private Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_6p, container, false);

        Spinner spinnercalss = rootView.findViewById(R.id.spinnerClass);


        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(getActivity().getBaseContext(), //장애 등급 스피너 어뎁터
                R.array.spinner_class, android.R.layout.simple_spinner_item
        );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnercalss.setAdapter(adapter2);



        button = rootView.findViewById(R.id.button22);
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
        return rootView;
    }

}
