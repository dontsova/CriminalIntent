package com.grayhound.CriminalIntent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.EditText;

/**
 * Created by slava on 11.03.15.
 */
public class CrimeFragment extends Fragment {

    private Crime mCrime;
    private EditText mTitleView;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fagment_crime, parent, false);

        mTitleView = (EditText)v.findViewById(R.id.crime_title);
        mTitleView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence c, int start, int before, int count) {
                //mCrime.setTitle(c.toString());

            }

            @Override
            public void onTextChanged(
                    CharSequence c, int start, int before, int count) {
                mCrime.setTitle(c.toString());

            }

            @Override
            public void afterTextChanged(Editable c) {

            }
        });

        return v;
    }
}
