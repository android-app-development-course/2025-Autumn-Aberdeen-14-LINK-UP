package com.example.chatnew;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {
    private List<PostItem> postList;
    private Context context;
    private boolean allowNavigationToUserSpace;

    public PostAdapter(Context context, List<PostItem> postList) {
        this(context, postList, true);
    }

    public PostAdapter(Context context, List<PostItem> postList, boolean allowNavigationToUserSpace) {
        this.context = context;
        this.postList = postList;
        this.allowNavigationToUserSpace = allowNavigationToUserSpace;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PostItem item = postList.get(position);

        holder.imageViewAvatar.setImageResource(R.drawable.ic_launcher_foreground);
        // textViewAuthor改为textViewUsername以匹配布局
        holder.textViewUsername.setText(item.getAuthor());
        holder.textViewTime.setText(item.getTime());
        // textViewContent改为textViewCaption以匹配布局
        holder.textViewCaption.setText(item.getContent());
        
        if (item.getImageResource() != 0) {
            holder.imageViewContent.setImageResource(item.getImageResource());
            holder.imageViewContent.setVisibility(View.VISIBLE);
        } else {
            holder.imageViewContent.setVisibility(View.GONE);
        }

        // Set click listener on avatar to navigate to user's space (if allowed)
        if (allowNavigationToUserSpace) {
            holder.imageViewAvatar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String author = item.getAuthor();
                    if (!"我".equals(author)) { // Don't navigate to own space from own posts
                        Intent intent = new Intent(context, OtherSpaceActivity.class);
                        // Pass user data to the other space activity
                        intent.putExtra("username", author);
                        intent.putExtra("identity", "互联网产品经理 · 3年经验");
                        
                        // Generate some random data for demo purposes
                        // In a real app, this would come from a database or API
                        int influenceIndex = 50 + (author.hashCode() % 50); // Random value between 50-99
                        intent.putExtra("influence_index", influenceIndex);
                        intent.putExtra("connections", 50 + (author.hashCode() % 100));
                        intent.putExtra("activities", 10 + (author.hashCode() % 20));
                        intent.putExtra("partners", 3 + (author.hashCode() % 10));
                        intent.putExtra("projects", 1 + (author.hashCode() % 6));
                        
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    } else {
                        // Navigate to my space
                        Intent intent = new Intent(context, MyHomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }
                }
            });
        } else {
            // Disable navigation to user space from other user space pages
            holder.imageViewAvatar.setOnClickListener(null);
        }

        holder.buttonLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点赞成功", Toast.LENGTH_SHORT).show();
            }
        });

        holder.buttonComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "评论功能占位", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public void filterPostsByUser(String username) {
        // This method would filter posts to show only those by the specified user
        // In a real implementation with a database, this would be more complex
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewAvatar;
        TextView textViewUsername;
        TextView textViewTime;
        TextView textViewCaption;
        ImageView imageViewContent;
        ImageButton buttonLike;
        ImageButton buttonComment;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAvatar = itemView.findViewById(R.id.image_view_avatar);
            textViewUsername = itemView.findViewById(R.id.text_view_username);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewCaption = itemView.findViewById(R.id.text_view_caption);
            imageViewContent = itemView.findViewById(R.id.image_view_content);
            buttonLike = itemView.findViewById(R.id.button_like);
            buttonComment = itemView.findViewById(R.id.button_comment);
        }
    }
}