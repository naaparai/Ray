package com.netforce.ray.dashboard.category.electronics;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.koushikdutta.ion.Ion;
import com.netforce.ray.R;
import com.netforce.ray.home.product_detail.ProductDetailsActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by John on 9/7/2016.
 */
public class ElectronicsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int SIMPLE_TYPE = 0;
    private static final int IMAGE_TYPE = 1;
    private final LayoutInflater inflater;
    private List<ElectronicsData> itemList;
    private Context context;
    ElectronicsHolder viewHolder;
    public ElectronicsAdapter(Context context, List<ElectronicsData> itemList) {
        this.itemList = itemList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {

        View view = inflater.inflate(R.layout.row_home, parent, false);
         viewHolder = new ElectronicsHolder(view);





        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position)
    {

        ElectronicsHolder homeHolder = (ElectronicsHolder) holder;

        //System.out.println("image===============" + itemList.get(position).image);

        String n = itemList.get(position).image.toString().substring(1,itemList.get(position).image.toString().length()-1);

        System.out.println("n============="+ n);

        Ion.with(homeHolder.product_image).load(n);

        ((ElectronicsHolder) holder).product_name.setText(itemList.get(position).title);

        homeHolder.product_price.setText(itemList.get(position).title);



        viewHolder.materialRippleLayout.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context,ProductDetailsActivity.class);
                context.startActivity(i);
            }
        });


    }

    private void showMessage(String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }


    @Override
    public int getItemCount() {
        return itemList.size();
//        return itemList.size();
    }

    public String getCurrentTimeStamp() {
        return new SimpleDateFormat("dd MMM yyyy HH:mm").format(new Date());
    }
}
