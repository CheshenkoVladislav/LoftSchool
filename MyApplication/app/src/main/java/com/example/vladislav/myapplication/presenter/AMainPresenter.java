package com.example.vladislav.myapplication.presenter;

import com.example.vladislav.myapplication.Interfaces.view.AMainMvpView;
import com.example.vladislav.myapplication.app.BasePresenter;

import io.reactivex.processors.BehaviorProcessor;

public class AMainPresenter extends BasePresenter<AMainMvpView> {

    public AMainPresenter(BehaviorProcessor<Boolean> eventProcessor, AMainMvpView view) {
        super(eventProcessor, view);
    }

    @Override
    public void init() {

    }

    @Override
    protected void bindEvents() {

    }

}
