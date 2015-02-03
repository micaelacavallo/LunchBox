package com.example.micaelacavallo.lunchbox;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;


public class LunchOptionsFragment extends Fragment {

    public interface  ChangeListener {
        void onLunchChange(String options);
    }
    Button mPackLunch;
    CheckBox mShoker, mHindu, mMuslim, mVegetarian, mDiabetic, mGlutenFree;

    public LunchOptionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lunch_options, container, false);
        preparePackLunchButton(rootView);
        prepareCheckboxs(rootView);
        return rootView;
    }

    private void preparePackLunchButton(View rootView) {
        mPackLunch = (Button)rootView.findViewById(R.id.button_pack_lunch);
        mPackLunch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChangeListener listener;
                if (getTargetFragment() != null) {
                    listener = (ChangeListener) getTargetFragment();
                } else {
                    listener = (ChangeListener) getActivity();
                }
                listener.onLunchChange(generateOptionsSummary());
            }
        });
    }

    private void prepareCheckboxs(View rootView) {
        mShoker = (CheckBox)rootView.findViewById(R.id.checkbox_kosher);
        mHindu = (CheckBox)rootView.findViewById(R.id.checkbox_hindu);
        mMuslim = (CheckBox)rootView.findViewById(R.id.checkbox_muslim);
        mVegetarian = (CheckBox)rootView.findViewById(R.id.checkbox_vegetarian);
        mDiabetic = (CheckBox)rootView.findViewById(R.id.checkbox_diabetic);
        mGlutenFree = (CheckBox)rootView.findViewById(R.id.checkbox_gluten_free);
    }


    private String generateOptionsSummary() {
        String options = "Lunch: ";
        if (mShoker.isChecked())
        {
            options += mShoker.getText().toString();
        }
        if (mHindu.isChecked())
        {
            options +=  ", " + mHindu.getText().toString();
        }
        if (mMuslim.isChecked())
        {
            options += ", " + mMuslim.getText().toString();
        }
        if (mVegetarian.isChecked())
        {
            options += ", " + mVegetarian.getText().toString();
        }
        if (mDiabetic.isChecked())
        {
            options += ", " + mDiabetic.getText().toString();
        }
        if (mGlutenFree.isChecked())
        {
            options += ", " + mGlutenFree.getText().toString();
        }
        return options;
    }


    public void enableAuthorizedOptions(Boolean enable) {
        int[] ids = {R.id.checkbox_vegetarian, R.id.checkbox_diabetic, R.id.checkbox_gluten_free};
        View rootView = getView();
        if (rootView != null) {
            for (int checkboxId : ids) {
                CheckBox checkBox = (CheckBox)rootView.findViewById(checkboxId);
                if (checkBox != null)
                {
                    checkBox.setEnabled(enable);
                }

            }
        }
    }


}
