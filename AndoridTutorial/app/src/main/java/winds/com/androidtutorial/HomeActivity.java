package winds.com.androidtutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

public class HomeActivity extends AppCompatActivity {

    TextView tvName, btLogout, tvPhone, tvFirstTittle;

    ImageView imgFirstView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        getData();

    }

    void init() {
        tvName = findViewById(R.id.tv_name);
        tvPhone = findViewById(R.id.tv_phone);
        tvFirstTittle = findViewById(R.id.tv_title);
        imgFirstView  = findViewById(R.id.img_FirstView);

        btLogout = findViewById(R.id.bt_Logout);
        btLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences myPrefs = getSharedPreferences("dekko", MODE_PRIVATE);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.clear();
                editor.commit();


                Intent intent;
                intent = new Intent(HomeActivity.this, SplashActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                startActivity(intent);

            }
        });
    }

    void getData() {
        try {
            Resources res = getResources();
            InputStream in_s = res.openRawResource(R.raw.home);

            byte[] b = new byte[in_s.available()];
            in_s.read(b);
            String strData = new String(b);
            Log.d("StringData", strData);
            JSONObject homeJSON = stringToJson(strData);
            JSONObject resultJSON = homeJSON.getJSONObject("result");
            JSONObject cusDetaiJSON = resultJSON.getJSONObject("customerDetail");
            String phone = cusDetaiJSON.getString("phone");
            String name = cusDetaiJSON.getString("customerName");
            tvName.setText(name);
            tvPhone.setText(phone);

            JSONArray listNewJSON = resultJSON.getJSONArray("listNews");
            JSONObject firstNewsJSON = listNewJSON.getJSONObject(0);
            String urlImage = firstNewsJSON.getString("urlImage");
            tvFirstTittle.setText(firstNewsJSON.getString("title"));
            Picasso.get().load(urlImage).into(imgFirstView);






        } catch (Exception e) {
             e.printStackTrace();

        }
    }


    JSONObject stringToJson(String strData){
        JSONObject homeJson;
        try {
            homeJson = new JSONObject(strData);
            return homeJson;

        } catch (JSONException e){
            e.printStackTrace();
        }
        return null;

    }
}
