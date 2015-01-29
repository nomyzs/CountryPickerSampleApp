package com.example.aim.jarosz.szymon.countrypicker.fragment;

import android.app.Fragment;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aim.jarosz.szymon.countrypicker.R;
import com.example.aim.jarosz.szymon.countrypicker.adapter.CountryFlagAdapter;
import com.example.aim.jarosz.szymon.countrypicker.model.CountryFlags;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Szymon on 29-Jan-15.
 */
public class CountryFlagFragment extends Fragment {
    private RecyclerView rvCountryFlag;
    private CountryFlagAdapter countryFlagAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_phone_country_code, container, false);
        rvCountryFlag = (RecyclerView) root.findViewById(R.id.country_flag_feed);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvCountryFlag.setLayoutManager(llm);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (countryFlagAdapter == null) {
            try {
                AssetManager assetManager = getActivity().getAssets();
                Reader reader = new InputStreamReader(assetManager.open("CountryPhoneCodes.json"));
                Gson gson = new Gson();
                CountryFlags codes = gson.fromJson(reader, CountryFlags.class);
                countryFlagAdapter = new CountryFlagAdapter(codes.getCountryFlags());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        rvCountryFlag.setAdapter(countryFlagAdapter);
    }

}
