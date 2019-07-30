package winds.com.androidtutorial.recyclerviewplaces;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import winds.com.androidtutorial.R;

public class PlacesAdapter extends RecyclerView.Adapter<PlacesAdapter.PlacesViewHolder> {
    Context context;
    ArrayList<Places> data;

    @NonNull
    @Override
    public PlacesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.placesitemlayout, viewGroup, false);
        PlacesViewHolder placesViewHolder = new PlacesViewHolder(view);

        return placesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PlacesViewHolder placesViewHolder, int i) {
        Places places = data.get(i);
        placesViewHolder.tvAddress.setText(places.getAddress());
        placesViewHolder.tvPlaceName.setText(places.getPlaceName());
        placesViewHolder.tvCategoryID.setText(places.getCategoryID());
        placesViewHolder.tvIsPromotion.setText(places.getIsPromotion()+"");
        if (places.isPromotion == 0){
            placesViewHolder.tvIsPromotion.setVisibility(View.INVISIBLE);
        }else{
            placesViewHolder.tvIsPromotion.setVisibility(View.VISIBLE);

        }



        placesViewHolder.tvIsMoreDetail.setText(places.getIsMoreDetail()+"");
        if (places.isMoreDetail == 1){
            placesViewHolder.tvIsMoreDetail.setVisibility(View.INVISIBLE);
            placesViewHolder.llPlacesitem.setBackgroundColor(Color.RED);
        }else{
            placesViewHolder.tvIsMoreDetail.setVisibility(View.INVISIBLE);
            placesViewHolder.llPlacesitem.setBackgroundColor(Color.YELLOW);
        }


       //Picasso.get().load(places.getUrlLogoPlace()).into(placesViewHolder.urlLogoPlace);







    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class PlacesViewHolder extends RecyclerView.ViewHolder {
        TextView tvAddress, tvPlaceName, tvCategoryID, tvIsPromotion,tvIsMoreDetail;
        CircleImageView urlLogoPlace;
        LinearLayout llPlacesitem;


        public PlacesViewHolder(@NonNull View itemView) {
            super(itemView);
            tvAddress = itemView.findViewById(R.id.tv_adress);
            tvPlaceName = itemView.findViewById(R.id.tv_placeName);
            tvCategoryID = itemView.findViewById(R.id.tv_categoryID);
            urlLogoPlace = itemView.findViewById(R.id.img_urlLogoPlace);
            tvIsPromotion = itemView.findViewById(R.id.tv_isPromotion);
            llPlacesitem = itemView.findViewById(R.id.ll_placesitem);
            tvIsMoreDetail = itemView.findViewById(R.id.tv_isMoreDetail);



        }
    }
}
