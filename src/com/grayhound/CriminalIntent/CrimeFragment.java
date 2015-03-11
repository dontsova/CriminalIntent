package com.grayhound.CriminalIntent;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by slava on 11.03.15.
 */
public class CrimeFragment extends Fragment {

    private Crime mCrime;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mCrime = new Crime();
    }
}
