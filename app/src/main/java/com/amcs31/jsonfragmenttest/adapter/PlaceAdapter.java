package com.amcs31.jsonfragmenttest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.amcs31.jsonfragmenttest.R;
import com.amcs31.jsonfragmenttest.model.PlaceItem;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceHolder>{
    private List<PlaceItem> mContent;

    public PlaceAdapter(List<PlaceItem> content) {
        mContent = content;
    }

    @Override
    public PlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_place_item, parent, false);
        return new PlaceHolder(view);
    }

    @Override
    public void onBindViewHolder(PlaceHolder holder, int position) {
        PlaceItem placeItem = mContent.get(position);
        holder.name.setText(placeItem.getName());
        holder.address.setText(placeItem.getAddress());
    }

    @Override
    public int getItemCount() {
        return mContent.size();
    }

    class PlaceHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView address;
        
        public PlaceHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.name);
            address = (TextView)itemView.findViewById(R.id.address);
        }
    }
}
