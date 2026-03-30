package com.example.week11soccerapp.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week11soccerapp.R;
import com.example.week11soccerapp.model.SoccerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class EntityAdapter<T extends SoccerEntity> extends RecyclerView.Adapter<EntityAdapter.EntityViewHolder> {

    private final List<T> items = new ArrayList<>();
    private final Function<T, String> subtitleProvider;
    private final Consumer<T> clickConsumer;

    public EntityAdapter(Function<T, String> subtitleProvider, Consumer<T> clickConsumer) {
        this.subtitleProvider = subtitleProvider;
        this.clickConsumer = clickConsumer;
    }

    public void submitList(List<T> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EntityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_entity, parent, false);
        return new EntityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntityViewHolder holder, int position) {
        T item = items.get(position);
        holder.tvTitle.setText(item.getName());
        holder.tvSubtitle.setText(subtitleProvider.apply(item));
        holder.itemView.setOnClickListener(v -> clickConsumer.accept(item));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class EntityViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvSubtitle;

        EntityViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSubtitle = itemView.findViewById(R.id.tvSubtitle);
        }
    }
}
