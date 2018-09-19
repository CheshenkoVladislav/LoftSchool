package com.example.vladislav.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.vladislav.myapplication.Interfaces.view.ASignInMvpView;
import com.example.vladislav.myapplication.api.RealApiLoftSchool;
import com.example.vladislav.myapplication.R;
import com.example.vladislav.myapplication.app.App;
import com.example.vladislav.myapplication.app.BaseActivity;
import com.example.vladislav.myapplication.presenter.ASignInPresenter;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;

import java.util.List;

import javax.inject.Inject;

import butterknife.OnClick;
import dagger.android.AndroidInjection;
import timber.log.Timber;

public class SignInActivity extends BaseActivity implements ASignInMvpView {

    public static final int RC_SIGN_IN = 456;

    @Inject
    ASignInPresenter presenter;

    @OnClick(R.id.sign_in_btn)
    public void onCliCickSignIn() {
        presenter.requestToStartAuth();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        bindViews();
        Timber.d("onCREATE: ");
        presenter.init();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.handleResult(requestCode, resultCode, data);
    }

    @Override
    public void startAuth(Intent signInIntent) {
        Timber.d("Start auth : ");
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    public void startMainActivity() {
        startActivity(MainActivity.class, true);
    }

    private void showAccess() {
        Toast.makeText(this,"Login success!",Toast.LENGTH_SHORT).show();
    }

    private void showError(String error) {
        Toast.makeText(this,"Login failed!",Toast.LENGTH_SHORT).show();
    }
}
