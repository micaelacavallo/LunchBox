package com.example.micaelacavallo.lunchbox;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
* Created by micaela.cavallo on 03/02/2015.
*/
public class LoginFragment extends Fragment {

    EditText mEditTextUsername;
    EditText mEditTextPassword;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        mEditTextPassword = (EditText)rootView.findViewById(R.id.edit_text_password);
        mEditTextUsername = (EditText)rootView.findViewById(R.id.edit_text_username);
        Button button = (Button)rootView.findViewById(R.id.button_login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Activity activity = getActivity();
                if (mEditTextUsername.getText().toString().equals("bond@mi6.go.uk") &&
                        mEditTextPassword.getText().toString().equals("s3cr3t")) {
                    activity.setResult(Activity.RESULT_OK);
                }
                activity.finish();
            }
        });
        return rootView;
    }
}
