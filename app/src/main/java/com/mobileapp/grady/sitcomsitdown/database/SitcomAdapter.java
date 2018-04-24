package com.mobileapp.grady.sitcomsitdown.database;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileapp.grady.sitcomsitdown.R;
import com.mobileapp.grady.sitcomsitdown.activitys.DetailsActivity;
import com.mobileapp.grady.sitcomsitdown.activitys.MainActivity;
import com.mobileapp.grady.sitcomsitdown.models.Sitcom;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SitcomAdapter extends RecyclerView.Adapter<SitcomAdapter.ViewHolder>
{
    private List<Sitcom> mSitcomList;
    private Context mContext;
    private RecyclerView mRecyclerView;

    public SitcomAdapter(List<Sitcom> sitcoms, Context context, RecyclerView mRecyclerView)
    {
        mSitcomList = sitcoms;
        mContext = context;
        this.mRecyclerView = mRecyclerView;
    }

    /**
     * A view for each individual item
     */
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvSitcomName;
        public ImageView ivSitcomImage;

        public View layout;

        public ViewHolder(View v)
        {
            super(v);
            layout = v;
            tvSitcomName = v.findViewById(R.id.tv_sitcom_name);
            ivSitcomImage = v.findViewById(R.id.iv_sitcom_image);
        }
    }

    @NonNull
    @Override
    public SitcomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater inflater = LayoutInflater.from( parent.getContext());
        View v = inflater.inflate(R.layout.title_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SitcomAdapter.ViewHolder holder, int position)
    {
        final Sitcom sitcom = mSitcomList.get(position);
        holder.tvSitcomName.setText(sitcom.getName());
        Picasso.with(mContext).load(sitcom.getImage()).placeholder(R.mipmap.ic_launcher).into(holder.ivSitcomImage);

        //set onClick listener
        holder.layout.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                //go to details page
                Intent goToDetails = new Intent(mContext, DetailsActivity.class);
                goToDetails.putExtra("SITCOM_ID", sitcom.getId());
                int x = sitcom.getId();
                mContext.startActivity(goToDetails);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mSitcomList.size();
    }
}
