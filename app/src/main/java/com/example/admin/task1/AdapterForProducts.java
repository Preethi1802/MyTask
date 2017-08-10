package com.example.admin.task1;

/**
 * Created by Admin on 7/26/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterForProducts extends RecyclerView.Adapter<AdapterForProducts.ViewHolder>
{
    public ArrayList<Products> itemList =new ArrayList<Products>();
    Context mContext;


    public AdapterForProducts(Context context, ArrayList<Products> itemList) {
        this.itemList= itemList;
        this.mContext=context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent ,false);
        ViewHolder viewHolder= new ViewHolder(view, mContext, itemList);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Products products = itemList.get(position);
        holder.imageView.setImageResource(products.getImage());
        holder.textMob1.setText(products.getMobileName());
        holder.version.setText(products.getVersion());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("##","onCLick: Position"+position);
                Intent intent= new Intent(mContext,SingleItemDesc.class);
                intent.putExtra(Constants.KEY_POSITION,position);
                intent.putParcelableArrayListExtra("itemList",itemList);
                mContext.startActivity(intent);
                Log.i("####","hkkkkkkkkkk");
            }
        });


    }


    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imageView;
         TextView textMob1,version;

        ImageView imageView1,imageView2,imageView3,imageView4;
        TextView mobPrize, mobRating, ratingInWords;

        ArrayList<Products> items = new ArrayList<Products>();
        Context ctx ;
        public ViewHolder(View itemView, Context ctx, ArrayList<Products> items)
         {
             super(itemView);
             this.items = items;
             imageView = (ImageView)itemView.findViewById(R.id.s1_mob1);
             textMob1 = (TextView)itemView.findViewById(R.id.card_text1);
             version = (TextView)itemView.findViewById(R.id.version);
             imageView1 =(ImageView)itemView.findViewById(R.id.view1);
             imageView2 =(ImageView)itemView.findViewById(R.id.view2);
             imageView3=(ImageView)itemView.findViewById(R.id.view3);
             imageView4 =(ImageView)itemView.findViewById(R.id.view4);
             mobPrize =(TextView)itemView.findViewById(R.id.prize);
             mobRating =(TextView)itemView.findViewById(R.id.rating);
             ratingInWords =(TextView)itemView.findViewById(R.id.ratingInWords);
         }


     }


}