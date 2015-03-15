package com.grayhound.CriminalIntent;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;

import java.util.ArrayList;

/**
 * Created by Слава on 15.03.2015.
 */
public class CrimeListFragment extends ListFragment {
    private ArrayList<Crime> mCrimes;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crimes_title);
        mCrimes = CrimeLab.get(getActivity()).getCrimes();
    }
}
