package com.amcs31.jsonfragmenttest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amcs31.jsonfragmenttest.R;
import com.amcs31.jsonfragmenttest.adapter.PlaceAdapter;
import com.amcs31.jsonfragmenttest.model.PlaceItem;
import com.amcs31.jsonfragmenttest.util.ParseUtils;

import java.util.List;


public class JsonFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_json_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView recyclerView = (RecyclerView)getView().findViewById(R.id.recycler_view);
        List<PlaceItem> content = ParseUtils.parsePlaces("test.json", getContext());
        PlaceAdapter placeAdapter = new PlaceAdapter(content);
        recyclerView.setAdapter(placeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }
}
