package com.example.week11soccerapp.data;

import com.example.week11soccerapp.model.SoccerEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Repository<T extends SoccerEntity> {
    protected final List<T> items = new ArrayList<>();

    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        items.add(item);
    }

    public void addAll(List<T> newItems) {
        if (newItems == null) {
            throw new IllegalArgumentException("Item list cannot be null.");
        }
        for (T item : newItems) {
            add(item);
        }
    }

    public List<T> getAll() {
        return new ArrayList<>(items);
    }

    public List<T> filter(Predicate<T> predicate) {
        if (predicate == null) {
            throw new IllegalArgumentException("Filter predicate cannot be null.");
        }
        List<T> result = new ArrayList<>();
        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<T> sort(List<T> source, Comparator<T> comparator) {
        if (source == null || comparator == null) {
            throw new IllegalArgumentException("Source and comparator cannot be null.");
        }
        List<T> sorted = new ArrayList<>(source);
        sorted.sort(comparator);
        return sorted;
    }
}
