package com.example.chatnew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecommendationAdapter extends RecyclerView.Adapter<RecommendationAdapter.ViewHolder> {
    private RecommendationItem[] recommendations;
    private boolean[] connectedStatus;

    public RecommendationAdapter(RecommendationItem[] recommendations) {
        this.recommendations = recommendations;
        this.connectedStatus = new boolean[recommendations.length];
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recommendation, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RecommendationItem item = recommendations[position];
        holder.bind(item, position, connectedStatus[position]);
    }

    @Override
    public int getItemCount() {
        return recommendations.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageViewAvatar;
        private TextView textViewName;
        private TextView textViewMatchPercentage;
        private TextView textViewTags;
        private Button buttonConnect;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAvatar = itemView.findViewById(R.id.image_view_avatar);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewMatchPercentage = itemView.findViewById(R.id.text_view_match_percentage);
            textViewTags = itemView.findViewById(R.id.text_view_tags);
            buttonConnect = itemView.findViewById(R.id.button_connect);
        }

        public void bind(RecommendationItem item, int position, boolean isConnected) {
            // Bind data to views
            textViewName.setText(item.getName());
            textViewMatchPercentage.setText(item.getMatchPercentage() + "%");
            textViewTags.setText(item.getTags());

            // Update button based on connection status
            if (isConnected) {
                buttonConnect.setText("已连接");
                buttonConnect.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.morandi_gray_light));
                buttonConnect.setTextColor(itemView.getContext().getResources().getColor(R.color.morandi_text_secondary));
            } else {
                buttonConnect.setText("立即连接");
                buttonConnect.setBackgroundResource(R.drawable.button_primary);
                buttonConnect.setTextColor(itemView.getContext().getResources().getColor(R.color.morandi_surface));
            }

            // Set click listener for connect button
            buttonConnect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!connectedStatus[position]) {
                        connectedStatus[position] = true;
                        // Update button appearance
                        buttonConnect.setText("已连接");
                        buttonConnect.setBackgroundColor(v.getContext().getResources().getColor(R.color.morandi_gray_light));
                        buttonConnect.setTextColor(v.getContext().getResources().getColor(R.color.morandi_text_secondary));
                        
                        // 在实际应用中，这里可能会发起连接请求
                    }
                }
            });
        }
    }
}