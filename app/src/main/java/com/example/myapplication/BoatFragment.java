package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.fragment.app.Fragment;

public class BoatFragment extends Fragment implements BoatContract.IBoatView {

    private BoatContract.IBoatPresenter boatPresenter;
    private SwitchCompat motorBoat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {

        boatPresenter = new BoatPresenter(this, this.getActivity());

        View view = inflater.inflate(R.layout.fragment_boat, container, false);

        motorBoat = view.findViewById(R.id.motor_boat);

        boatPresenter.onFindSwitch();

        motorBoat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                boatPresenter.onButtonClicked(isChecked);
            }
        });

        return view;
    }

    @Override
    public void showSettings(boolean settings) {
        motorBoat.setChecked(settings);
    }
}
