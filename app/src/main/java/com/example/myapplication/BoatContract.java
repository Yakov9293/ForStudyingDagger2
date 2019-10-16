package com.example.myapplication;

import androidx.appcompat.widget.SwitchCompat;

public interface BoatContract {
    interface IBoatView{
        void showSettings(boolean settings);
    }
    interface IBoatPresenter{
        void onButtonClicked(boolean switchValue);
        void onFindSwitch();
    }
    interface IBoatModel{
        boolean getSettings();
        void setSettings(boolean settings);
    }
}
