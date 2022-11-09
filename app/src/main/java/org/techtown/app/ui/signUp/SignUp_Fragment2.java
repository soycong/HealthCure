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

public class SignUp_Fragment2 extends Fragment {

    private Button button;
    EditText nameInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.signup_frame_2p, container, false);

       nameInput = rootView.findViewById(R.id.textage);

        button = rootView.findViewById(R.id.button22);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = nameInput.getText().toString();

                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name",nameStr);
                editor.commit();


                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                SignUp_Fragment3 fragment_3 = new SignUp_Fragment3();
                transaction.replace(R.id.frameLayout1,fragment_3);
                transaction.commit();



            }
        });

        return rootView;
    }

}
