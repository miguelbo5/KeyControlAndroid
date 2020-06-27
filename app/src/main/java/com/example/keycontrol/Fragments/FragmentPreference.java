package com.example.keycontrol.Fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.keycontrol.R;

public class FragmentPreference extends PreferenceFragmentCompat {


    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {

        addPreferencesFromResource(R.xml.preferences_fragment);

    }

    public static FragmentPreference newInstance(){

        FragmentPreference fragmentPreference = new FragmentPreference();

        return fragmentPreference;

    }
}
