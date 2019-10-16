package com.example.myapplication;

import android.content.Context;

public class BoatPresenter implements BoatContract.IBoatPresenter {
    private BoatContract.IBoatModel boatModel;
    private BoatContract.IBoatView boatView;

    BoatPresenter(BoatContract.IBoatView boatView, Context context) {
        this.boatView = boatView;
        this.boatModel = new BoatModel(context);
    }

    @Override
    public void onButtonClicked(boolean switchValue) {
        boatModel.setSettings(switchValue);
    }

    @Override
    public void onFindSwitch() {
        boatView.showSettings(boatModel.getSettings());
    }

}
