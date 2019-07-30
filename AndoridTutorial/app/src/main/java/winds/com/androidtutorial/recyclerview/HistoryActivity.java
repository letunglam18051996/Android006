package winds.com.androidtutorial.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import winds.com.androidtutorial.R;
import winds.com.androidtutorial.util.Util;

public class HistoryActivity extends AppCompatActivity {
    RecyclerView rvHistory;
    ArrayList<History> data = new ArrayList<>();
    TextView tvTitle, tvPoint;
    CircleImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        init();
        prepareData();
        configRv();
    }
    void init(){
        rvHistory = findViewById(R.id.rv_history);
        tvTitle = findViewById(R.id.tv_titleHistory);
        tvPoint = findViewById(R.id.tv_point);
        imgIcon = findViewById(R.id.img_icon);





    }
    void prepareData(){
        // đọc file hisstory.json

        JSONObject jsonHistory = Util.fileToJson(R.raw.history,this);


        try {
            //lấy jsonarray: resut
            JSONArray jsonArrayResult = jsonHistory.getJSONArray("result");

            //for jsonArray ->
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                JSONObject jsonObject = jsonArrayResult.getJSONObject(i);
                String title = jsonObject.getString("title");
                String icon = jsonObject.getString("icon");
                int point = jsonObject.getInt("point");
                History history = new History(title, point, icon);
                data.add(history);

            }

            //add đối tuowjgn history vừa tạo vào data

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("","prepareData");



       /* data = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            History history = new History("Title" + i, i);
           data.add(history);}*/




    }
    void configRv(){
        HistoryAdapter historyAdapter = new HistoryAdapter();
        historyAdapter.data = data;
        historyAdapter.context = this;

        //hiển thị danh sách theo chiều ngang dọc từ dưới lên

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvHistory.setLayoutManager(linearLayoutManager);


        rvHistory.setAdapter(historyAdapter);

    }



}
