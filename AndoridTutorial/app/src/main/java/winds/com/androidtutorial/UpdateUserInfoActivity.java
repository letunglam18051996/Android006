package winds.com.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class UpdateUserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_info);
        init();
    }
    void init(){
        RelativeLayout rlSave;
        rlSave = findViewById(R.id.rl_save);
        rlSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prepareData();
            }
        });


    }
    void prepareData(){
        Intent intent;
        intent = new Intent(UpdateUserInfoActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
