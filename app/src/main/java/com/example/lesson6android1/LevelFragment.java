package com.example.lesson6android1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;


public class LevelFragment extends Fragment implements LevelAdapter.ItemListener {
    LevelAdapter adapter;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_level, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initAdapter(view);

    }
    public ArrayList<GameModel> getList(){
        ArrayList<GameModel> list = (ArrayList<GameModel>) getArguments().getSerializable("model");
        return list;
    }

    private void initAdapter(View view) {
        recyclerView = view.findViewById(R.id.level_recycler);
        adapter = new LevelAdapter( getList(),this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void itemClick(GameModel model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("model",model);
        GameFragment fragment = new GameFragment();
        fragment.setArguments(bundle);

        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, fragment)
                .commit();
    }
}