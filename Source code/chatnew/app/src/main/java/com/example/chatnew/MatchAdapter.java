package com.example.chatnew;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.ViewHolder> {
    private List<MatchItem> matchList;
    private Context context;

    public MatchAdapter(Context context, List<MatchItem> matchList) {
        this.context = context;
        this.matchList = matchList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_match, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MatchItem item = matchList.get(position);
        
        holder.imageViewAvatar.setImageResource(item.getAvatarResource());
        holder.textViewName.setText(item.getName());
        holder.textViewTags.setText(item.getTag());
        holder.textViewBio.setText(item.getReason());
        
        // Set click listener for view profile button
        holder.buttonViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start other profile activity
                Intent intent = new Intent(context, OtherHomeActivity.class);
                intent.putExtra("name", item.getName());
                intent.putExtra("match_percentage", item.getMatchPercentage());
                intent.putExtra("tag", item.getTag());
                intent.putExtra("avatar", item.getAvatarResource());
                context.startActivity(intent);
            }
        });
        
        // Set click listener for connect button
        holder.buttonConnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start chat activity
                Intent intent = new Intent(context, ChatActivity.class);
                intent.putExtra("name", item.getName());
                intent.putExtra("avatar", item.getAvatarResource());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewAvatar;
        TextView textViewName;
        TextView textViewTags;
        TextView textViewBio;
        Button buttonConnect;
        Button buttonViewProfile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAvatar = itemView.findViewById(R.id.image_view_avatar);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewTags = itemView.findViewById(R.id.text_view_tags);
            textViewBio = itemView.findViewById(R.id.text_view_bio);
            buttonConnect = itemView.findViewById(R.id.button_connect);
            buttonViewProfile = itemView.findViewById(R.id.button_view_profile);
        }
    }
}