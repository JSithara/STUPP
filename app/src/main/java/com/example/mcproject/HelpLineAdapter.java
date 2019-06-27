package com.example.mcproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.TreeMap;

public class HelpLineAdapter extends RecyclerView.Adapter<HelpLineAdapter.MyViewHolder> {
    private TreeMap<String,String> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public MyViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    public HelpLineAdapter(TreeMap<String,String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public HelpLineAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_text_view, parent, false);

        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final String key = mDataset.keySet().toArray()[position].toString();
        holder.textView.setText(mDataset.keySet().toArray()[position].toString());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:"+mDataset.get(key)));
                if (ActivityCompat.checkSelfPermission(v.getContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                ActivityCompat.startActivity(v.getContext(),phoneIntent,null);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
