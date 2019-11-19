package in.insideandroid.sessioninandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart() {
        super.onStart();

        checkSession();
    }

    private void checkSession() {
        //check if user is logged in
        //if user is logged in --> move to mainActivity

        SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
        int userID = sessionManagement.getSession();

        if(userID != -1){
            //user id logged in and so move to mainActivity
            moveToMainActivity();
        }
        else{
            //do nothing
        }
    }

    public void login(View view) {
        // 1.log in to app and save session of user
        // 2. move to mainActivity

        //1. login and save session
        User user = new User(12,"Ankit");
        SessionManagement sessionManagement = new SessionManagement(LoginActivity.this);
        sessionManagement.saveSession(user);

        //2. step
        moveToMainActivity();
    }

    private void moveToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
