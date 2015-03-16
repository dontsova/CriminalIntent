package com.grayhound.CriminalIntent;

import android.support.v4.app.Fragment;

/**
 * Created by slava on 16.03.15.
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
