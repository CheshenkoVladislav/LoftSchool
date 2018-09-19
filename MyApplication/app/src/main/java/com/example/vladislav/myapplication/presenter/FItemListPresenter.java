package com.example.vladislav.myapplication.presenter;

import android.support.annotation.NonNull;

import com.example.vladislav.myapplication.Interfaces.view.FItemListMvpView;
import com.example.vladislav.myapplication.app.BasePresenter;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import io.reactivex.processors.BehaviorProcessor;

public class FItemListPresenter extends BasePresenter<FItemListMvpView> implements OnSuccessListener<Void>,
        OnFailureListener, ValueEventListener{

    private final DatabaseReference database;

    public FItemListPresenter(BehaviorProcessor<Boolean> eventProcessor,
                              FItemListMvpView view,
                              DatabaseReference database) {
        super(eventProcessor, view);
        this.database = database;
    }

    @Override
    public void init() {
        database.addValueEventListener(this);
    }

    @Override
    protected void bindEvents() {

    }


    /**
     * DATABASE WRITEN CALLBACKS
     * @param aVoid
     */

    @Override
    public void onSuccess(Void aVoid) {

    }

    @Override
    public void onFailure(@NonNull Exception e) {

    }

    /**
     * VALUE EVENT CALLBACKS
     * @param dataSnapshot
     */
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
}
