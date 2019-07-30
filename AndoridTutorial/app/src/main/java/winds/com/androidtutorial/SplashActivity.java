package winds.com.androidtutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import winds.com.androidtutorial.recyclerview.HistoryActivity;
import winds.com.androidtutorial.recyclerviewplaces.PlacesActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        router();
    }

    void router() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                SharedPreferences sharedPreferences = getSharedPreferences("dekko", MODE_PRIVATE);
                boolean isLogin = sharedPreferences.getBoolean("isLogin", false);
                if (isLogin) {
                    Intent intent = new Intent(SplashActivity.this, PlacesActivity.class);
                    startActivity(intent);
                    finish();

                } else {

                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                    //Do something after 100ms
                }
                }
            },1000);
        }
    }
