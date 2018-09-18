package com.example.vladislav.myapplication.presenter;

import com.example.vladislav.myapplication.Interfaces.view.MvpView;
import com.example.vladislav.myapplication.app.BasePresenter;

import io.reactivex.processors.BehaviorProcessor;

public class ASignInPresenter extends BasePresenter {

    public ASignInPresenter(BehaviorProcessor eventProcessor, MvpView view) {
        super(eventProcessor, view);
    }

    @Override
    public void init() {

    }

    @Override
    protected void bindEvents() {

    }
}
