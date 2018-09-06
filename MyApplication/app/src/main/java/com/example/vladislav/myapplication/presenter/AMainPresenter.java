package com.example.vladislav.myapplication.presenter;

import com.example.vladislav.myapplication.Interfaces.view.MainMvpView;
import com.example.vladislav.myapplication.app.BasePresenter;

import org.reactivestreams.Publisher;

import io.reactivex.processors.BehaviorProcessor;

public class AMainPresenter extends BasePresenter<MainMvpView> {

    public AMainPresenter(BehaviorProcessor<Boolean> eventProcessor, MainMvpView view) {
        super(eventProcessor, view);
    }

    @Override
    public void init() {

    }

    @Override
    protected void bindEvents() {

    }

}
