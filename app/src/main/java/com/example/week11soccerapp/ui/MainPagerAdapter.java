package com.example.week11soccerapp.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.Arrays;
import java.util.List;

public class MainPagerAdapter extends FragmentStateAdapter {
    private final List<Fragment> fragments = Arrays.asList(
            new TeamsFragment(),
            new PlayersFragment(),
            new MatchesFragment()
    );

    public MainPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }

    public Fragment getFragment(int position) {
        return fragments.get(position);
    }
}
