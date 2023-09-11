package com.example.circkett20live;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.circkett20live.Playerdetils.Data;

import java.util.List;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchViewHolder> {
    private List<Data> matches;

    public void setMatches(List<Data> matches) {
        this.matches = matches;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Data match = matches.get(position);

      //holder.matchNameTextView.setText(match.getName());
       holder.matchDateTextView.setText(match.getStartDate());
        // Bind other match details to TextViews as needed
    }

    @Override
    public int getItemCount() {
        return matches != null ? matches.size() : 0;
    }

    public static class MatchViewHolder extends RecyclerView.ViewHolder {
        TextView matchNameTextView;
        TextView matchDateTextView;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
         //   matchNameTextView = itemView.findViewById(R.id.matchNameTextView);
             matchDateTextView = itemView.findViewById(R.id.matchDateTextViewsae);
            // Initialize other TextViews here
        }
    }
}
