package com.example.vladislav.myapplication.presenter;

import android.content.Intent;

import com.example.vladislav.myapplication.Interfaces.view.ASignInMvpView;
import com.example.vladislav.myapplication.Interfaces.view.SettingsDataSource;
import com.example.vladislav.myapplication.app.BasePresenter;
import com.example.vladislav.myapplication.managers.FirebaseAuthManager;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import io.reactivex.processors.BehaviorProcessor;
import timber.log.Timber;

import static android.app.Activity.RESULT_OK;
import static com.example.vladislav.myapplication.activity.SignInActivity.RC_SIGN_IN;

public class ASignInPresenter extends BasePresenter<ASignInMvpView> {

    private final SettingsDataSource settingsDataSource;
    private final FirebaseAuthManager authManager;

    public ASignInPresenter(BehaviorProcessor<Boolean> eventProcessor,
                            ASignInMvpView view,
                            SettingsDataSource settingsDataSource,
                            FirebaseAuthManager authManager) {
        super(eventProcessor, view);
        this.settingsDataSource = settingsDataSource;
        this.authManager = authManager;
    }

    @Override
    public void init() {
    }

    public void requestToStartAuth() {
        if (view != null)
            view.startAuth(authManager.getSignInIntent());
    }

    @Override
    protected void bindEvents() {

    }

    public void handleResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);
            if (response != null) {
                if (resultCode == RESULT_OK) {
                    // Successfully signed in
                    Timber.d("RESPONSE SUCCESS: = %s", response);
                    Timber.d("TOKEN: = %s", response.getIdpToken());
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        settingsDataSource.saveUserId(user.getUid());
                        settingsDataSource.saveToken(response.getIdpToken());
                        view.startMainActivity();
                    } else
                        Timber.d("USER NULL");
                } else {
                    Timber.d(response.getError());
                    // Sign in failed. If response is null the user canceled the
                    // sign-in flow using the back button. Otherwise check
                    // response.getError().getErrorCode() and handle the error.
                    // ...
                }
            }
        }

    }
}
