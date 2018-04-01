package com.example.vladislav.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.vladislav.myapplication.Data.Login;
import com.example.vladislav.myapplication.Interfaces.RealApiLoftSchool;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    private static final String TAG = "SignInActivity";
    static GoogleSignInAccount account;
    GoogleSignInClient client;
    Button signInBtn;
    RealApiLoftSchool apiLoftSchool;
    public static final int RC_SIGN_IN = 456;
    App app;

    @Override
    protected void onStart() {
        super.onStart();
        account = GoogleSignIn.getLastSignedInAccount(this);
        if (account != null) updateUI(account);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        apiLoftSchool = App.getApiLoftSchool();
        signInBtn = findViewById(R.id.signInBtn);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        app = (App)getApplication();
        client = GoogleSignIn.getClient(this, gso);
        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RC_SIGN_IN && resultCode == RESULT_OK){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }

    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // TODO(developer): send ID Token to server and validate
            updateUI(account);
        } catch (ApiException e) {
            Log.w(TAG, "handleSignInResult:error", e);
            updateUI(null);
        }

    }

    private void signIn() {
        Intent signInIntent = client.getSignInIntent();
        startActivityForResult(signInIntent,RC_SIGN_IN);
    }

    private void updateUI(GoogleSignInAccount account) {
        if (account == null){
            showError("Account is null");
            return;
        }
        showAccess();
        String idToken = account.getId();
        apiLoftSchool.getAuth(idToken).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Log.d(TAG, "STATUS : " + response.body().getStatus());
                Login login = response.body();
                app.saveAuthToken(login.getToken());
                finish();
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                showError("Auth failed");
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

    }

    private void showAccess() {
        Toast.makeText(this,"Login success!",Toast.LENGTH_SHORT).show();
    }

    private void showError(String error) {
        Toast.makeText(this,"Login failed!",Toast.LENGTH_SHORT).show();
    }
}
