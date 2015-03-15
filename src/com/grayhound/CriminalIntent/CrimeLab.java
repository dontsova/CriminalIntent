package com.grayhound.CriminalIntent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Слава on 15.03.2015.
 */
public class CrimeLab {
    private ArrayList<Crime> mCrimes;

    private  static CrimeLab sCrimeLab;
    private Context mAppContext;

    private CrimeLab(Context appContext){
        mAppContext = appContext;
        mCrimes = new ArrayList<Crime>();
        // генерируем сто обьектов
        for (int i = 0; i < 100; i++){
            Crime c = new Crime();
            c.setTitle("Crime #" +i);
            c.setSolved(i % 2 == 0);//для каждого второго обьекта
            mCrimes.add(c);
        }
    }

    public static CrimeLab get(Context c){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(c.getApplicationContext());
        }
        return sCrimeLab;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime c : mCrimes){
            if (c.getId().equals(id))
                return c;
        }

        return null;
    }
}
