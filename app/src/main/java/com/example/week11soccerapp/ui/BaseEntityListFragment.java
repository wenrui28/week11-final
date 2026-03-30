package com.example.week11soccerapp.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week11soccerapp.R;
import com.example.week11soccerapp.data.Repository;
import com.example.week11soccerapp.model.SoccerEntity;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public abstract class BaseEntityListFragment<T extends SoccerEntity> extends Fragment implements FilterableTab {

    protected Repository<T> repository;
    private EntityAdapter<T> adapter;
    private TextView tvSummary;
    private TextView tvEmpty;
    private String currentQuery = "";
    private int currentSortMode = 0;

    protected abstract Repository<T> createRepository();
    protected abstract String getSubtitle(T item);
    protected abstract String getEntityLabel();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entity_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        tvSummary = view.findViewById(R.id.tvSummary);
        tvEmpty = view.findViewById(R.id.tvEmpty);

        repository = createRepository();
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        adapter = new EntityAdapter<>(this::getSubtitle,
                item -> Toast.makeText(requireContext(), item.getName(), Toast.LENGTH_SHORT).show());
        recyclerView.setAdapter(adapter);

        applyControls(currentQuery, currentSortMode);
        return view;
    }

    @Override
    public void applyControls(String query, int sortMode) {
        currentQuery = query == null ? "" : query.trim().toLowerCase(Locale.ROOT);
        currentSortMode = sortMode;

        // Fragments receive filter/sort events very early from MainActivity.
        // Before onCreateView runs, repository and adapter are still null.
        // In that case we only store the requested state and apply it later.
        if (repository == null || adapter == null || tvSummary == null || tvEmpty == null) {
            return;
        }

        List<T> visibleItems = repository.filter(item ->
                currentQuery.isEmpty() || item.getSearchText().contains(currentQuery));

        Comparator<T> comparator = sortMode == 1
                ? (a, b) -> b.getName().compareToIgnoreCase(a.getName())
                : (a, b) -> a.getName().compareToIgnoreCase(b.getName());

        visibleItems = repository.sort(visibleItems, comparator);
        adapter.submitList(visibleItems);
        updateSummary(visibleItems);
    }

    protected void updateSummary(List<T> visibleItems) {
        if (visibleItems.isEmpty()) {
            tvSummary.setText(getEntityLabel() + ": 0");
            tvEmpty.setVisibility(View.VISIBLE);
            tvEmpty.setText(getString(R.string.no_results));
            return;
        }

        tvEmpty.setVisibility(View.GONE);
        String preview = visibleItems.stream()
                .limit(3)
                .map(SoccerEntity::getName)
                .collect(Collectors.joining(", "));
        tvSummary.setText(getEntityLabel() + ": " + visibleItems.size() + " | " + preview);
    }
}
