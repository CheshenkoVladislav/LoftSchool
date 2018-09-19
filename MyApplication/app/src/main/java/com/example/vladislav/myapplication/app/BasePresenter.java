package com.example.vladislav.myapplication.app;

import com.example.vladislav.myapplication.Interfaces.view.MvpView;
import com.michaelflisar.rxbus2.interfaces.IRxBusQueue;
import com.michaelflisar.rxbus2.rx.RxDisposableManager;

import org.reactivestreams.Publisher;

import io.reactivex.processors.BehaviorProcessor;

public abstract class BasePresenter<V extends MvpView> implements IRxBusQueue{

    protected final V view;
    private boolean isBinded;
    private BehaviorProcessor<Boolean> eventProcessor;

    public BasePresenter(BehaviorProcessor<Boolean> eventProcessor, V view) {
        this.view = view;
        this.eventProcessor = eventProcessor;
    }

    public abstract void init();

    protected abstract void bindEvents();

    protected void unbindEvents() {
        RxDisposableManager.unsubscribe(this);
    }

    @Override
    public boolean isBusResumed() {
        return eventProcessor.getValue();
    }

    @Override
    public Publisher<Boolean> getResumeObservable() {
        return eventProcessor;
    }

    private void rebindEvents() {
        unbindEvents();
        bindEvents();
    }

    public void startEvent() {
        rebindEvents();
        if (isBinded)
            eventProcessor.onNext(true);
    }

    public void pauseEvent() {
        if (isBinded)
            eventProcessor.onNext(false);
    }

    public void stopEvent() {
        if (isBinded) {
            eventProcessor.onNext(false);
            unbindEvents();
        }
    }
}
