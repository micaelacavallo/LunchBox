package com.example.micaelacavallo.lunchbox;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class LunchSummaryFragment extends Fragment implements LunchOptionsFragment.ChangeListener {

    TextView textView;
    public static final String SUMMARY_TEXT = "SUMMARY TEXT";
    public LunchSummaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_lunch_summary, container, false);
         displaySummaryFromArguments(rootView);
        return rootView;
    }

    private void displaySummaryFromArguments(View rootView) {
        String summary = "";
        if (getArguments() != null) {
            if (getArguments().containsKey(SUMMARY_TEXT)) {
                summary = getArguments().getString(SUMMARY_TEXT);
                displaySummary(rootView, summary);
            }
        }
    }

     private void displaySummary (View rootView, String summary) {
         textView = (TextView) rootView.findViewById(R.id.text_view_summary);
         textView.setText(summary);
     }

    @Override
    public void onLunchChange(String options) {
        View rootView = getView();
        if (rootView!= null)
        {
            displaySummary(rootView, options);
        }
    }
}
