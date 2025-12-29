package com.example.chatnew;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PartnerAdapter extends RecyclerView.Adapter<PartnerAdapter.ViewHolder> {
    private List<PartnerItem> partnerList;
    private Context context;

    public PartnerAdapter(Context context, List<PartnerItem> partnerList) {
        this.context = context;
        this.partnerList = partnerList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_partner, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PartnerItem item = partnerList.get(position);
        holder.bind(item, position);
    }

    @Override
    public int getItemCount() {
        return partnerList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewAvatar;
        TextView textViewName;
        TextView textViewIdentity;
        TextView textViewPartnerType;
        ProgressBar progressBarLocation;
        ProgressBar progressBarInterest;
        TextView textViewRecommendReason;
        TextView textViewCommonTags;
        Button btnSkip;
        Button btnViewMatch;
        Button btnAdd;
        Button btnChat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAvatar = itemView.findViewById(R.id.image_view_avatar);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewIdentity = itemView.findViewById(R.id.text_view_identity);
            textViewPartnerType = itemView.findViewById(R.id.text_view_partner_type);
            progressBarLocation = itemView.findViewById(R.id.progress_bar_location);
            progressBarInterest = itemView.findViewById(R.id.progress_bar_interest);
            textViewRecommendReason = itemView.findViewById(R.id.text_view_recommend_reason);
            textViewCommonTags = itemView.findViewById(R.id.text_view_common_tags);
            btnSkip = itemView.findViewById(R.id.btn_skip);
            btnViewMatch = itemView.findViewById(R.id.btn_view_match);
            btnAdd = itemView.findViewById(R.id.btn_add);
            btnChat = itemView.findViewById(R.id.btn_chat);
        }

        public void bind(PartnerItem item, int position) {
            // Bind data to views
            textViewName.setText(item.getName());
            textViewIdentity.setText(item.getIdentity());
            textViewPartnerType.setText(item.getPartnerType());
            progressBarLocation.setProgress(item.getLocationMatch());
            progressBarInterest.setProgress(item.getInterestMatch());
            textViewRecommendReason.setText(item.getRecommendReason());
            textViewCommonTags.setText(item.getCommonTags());

            // Set click listeners
            btnSkip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "已跳过 " + item.getName(), Toast.LENGTH_SHORT).show();
                    // In a real app, you would remove this item from the list
                }
            });

            btnViewMatch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "查看 " + item.getName() + " 的匹配详情", Toast.LENGTH_SHORT).show();
                    // In a real app, you would navigate to a detailed match page
                }
            });

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "已添加 " + item.getName() + " 为搭子", Toast.LENGTH_SHORT).show();
                    // In a real app, you would add this person to the user's partner list
                }
            });

            btnChat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Start chat activity
                    Intent intent = new Intent(v.getContext(), ChatActivity.class);
                    intent.putExtra("name", item.getName());
                    intent.putExtra("avatar", R.drawable.ic_launcher_foreground); // In real app, use actual avatar
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}