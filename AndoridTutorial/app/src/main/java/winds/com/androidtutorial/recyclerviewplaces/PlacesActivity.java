package winds.com.androidtutorial.recyclerviewplaces;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import winds.com.androidtutorial.R;
import winds.com.androidtutorial.util.Util;

public class PlacesActivity extends AppCompatActivity {
    RecyclerView rvPlaces;
    ArrayList<Places> data = new ArrayList<>();
    TextView tvAddress, tvPlaceName, tvCategoryID, tvIsPromotion;
    CircleImageView urlLogoPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        init();
        prepareData();
        configRv();
    }

    void init() {
        rvPlaces = findViewById(R.id.rv_places);
        tvAddress = findViewById(R.id.tv_adress);
        tvPlaceName = findViewById(R.id.tv_placeName);
        tvCategoryID = findViewById(R.id.tv_categoryID);
        urlLogoPlace = findViewById(R.id.img_urlLogoPlace);
        tvIsPromotion = findViewById(R.id.tv_isPromotion);

    }

    void prepareData() {
        JSONObject jsonPlaces = Util.fileToJson(R.raw.places, this);

        try {
            JSONArray jsonArrayResult = jsonPlaces.getJSONArray("result");

            for (int i = 0; i < jsonArrayResult.length(); i++) {
                JSONObject jsonObject = jsonArrayResult.getJSONObject(i);
                String address = jsonObject.getString("address");
                String placeName = jsonObject.getString("placeName");
                String urlLogoPlace = jsonObject.getString("urlLogoPlace");
                String categoryID = jsonObject.getString("categoryID");
                int isPromotion = jsonObject.getInt("isPromotion");
                int isMoreDetail = jsonObject.getInt("isMoreDetail");
                Places places = new Places(address, placeName, categoryID, urlLogoPlace, isPromotion, isMoreDetail);
                data.add(places);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    void configRv() {
        PlacesAdapter placesAdapter = new PlacesAdapter();
        placesAdapter.data = data;
        placesAdapter.context = this;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvPlaces.setLayoutManager(linearLayoutManager);

        rvPlaces.setAdapter(placesAdapter);

    }


}
