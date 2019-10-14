package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

public class BoatFragment extends Fragment {

    SharedPreferences preferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        preferences = this.getActivity().getSharedPreferences("SWITCH_BOAT", Context.MODE_PRIVATE);

        View view = inflater.inflate(R.layout.fragment_boat, container, false);

        SwitchCompat motorBoat = view.findViewById(R.id.motor_boat);

        motorBoat.setChecked(preferences.getBoolean("switchBoat", false));

        motorBoat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                preferences.edit().putBoolean("switchBoat", isChecked).commit();
            }
        });

        return view;
    }
}
