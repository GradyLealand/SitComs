package com.mobileapp.grady.sitcomsitdown.database;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobileapp.grady.sitcomsitdown.R;
import com.mobileapp.grady.sitcomsitdown.activitys.DetailsActivity;
import com.mobileapp.grady.sitcomsitdown.models.Sitcom;
import com.mobileapp.grady.sitcomsitdown.models.SitcomCharacter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.ViewHolder>
{
    private List<SitcomCharacter> mCharacterList;
    private Context mContext;
    private RecyclerView mRecyclerView;

    /**
     * Constructor for DetailsAdaptor
     * @param characters A list of Characters
     * @param context The app context
     * @param recyclerView A recycler view
     */
    public DetailsAdapter(List<SitcomCharacter> characters, Context context, RecyclerView recyclerView)
    {
        mCharacterList = characters;
        mContext = context;
        mRecyclerView = recyclerView;
    }

    /**
     * A view for each individual character
     */
    public class ViewHolder extends  RecyclerView.ViewHolder
    {
        public TextView tvCharacterName;
        public TextView tvCharacterDetails;
        public ImageView ivCharacterImage;

        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            tvCharacterName = v.findViewById(R.id.tv_details_name);
            tvCharacterDetails = v.findViewById(R.id.tv_details_details);
            ivCharacterImage = v.findViewById(R.id.iv_details_image);
        }
    }

    /**
     * On Create for a DetailAdaptor view holder
     * @param parent Recycler view
     * @param viewType Type of view
     * @return ViewHolder
     */
    @NonNull
    @Override
    public DetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        LayoutInflater inflater = LayoutInflater.from( parent.getContext());
        View v = inflater.inflate(R.layout.title_card, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsAdapter.ViewHolder holder, int position)
    {
        final SitcomCharacter character = mCharacterList.get(position);
        holder.tvCharacterName.setText(character.getName());
        holder.tvCharacterDetails.setText(character.getDetails());
        Picasso.with(mContext).load(character.getImage()).placeholder(R.mipmap.ic_launcher).into(holder.ivCharacterImage);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

























