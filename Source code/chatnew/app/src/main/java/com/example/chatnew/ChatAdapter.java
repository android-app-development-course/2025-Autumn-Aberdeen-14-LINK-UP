package com.example.chatnew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    private List<ChatMessage> messages;

    public ChatAdapter(List<ChatMessage> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChatMessage message = messages.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewMessage;

        ViewHolder(View itemView) {
            super(itemView);
            textViewMessage = itemView.findViewById(R.id.text_view_message);
        }

        void bind(ChatMessage message) {
            textViewMessage.setText(message.getSender() + ": " + message.getMessage());
            
            // Apply different styles for sent vs received messages
            if (message.isFromPartner()) {
                // Received message - left aligned
                textViewMessage.setBackgroundResource(R.drawable.message_bubble_left);
                textViewMessage.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_START);
            } else {
                // Sent message - right aligned
                textViewMessage.setBackgroundResource(R.drawable.message_bubble_right);
                textViewMessage.setTextAlignment(View.TEXT_ALIGNMENT_TEXT_END);
            }
        }
    }
}