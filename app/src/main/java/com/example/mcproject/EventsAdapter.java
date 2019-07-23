package com.example.mcproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mcproject.database.database;
import com.example.mcproject.database.events.event;
import com.example.mcproject.database.places.Places;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {
    private List<event> mDataset;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public LinearLayout LinearView;

        public MyViewHolder(LinearLayout v) {
            super(v);
            LinearView = v;
        }
    }

    public EventsAdapter(List<event> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public EventsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.event_view, parent, false);
        EventsAdapter.MyViewHolder vh = new EventsAdapter.MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(EventsAdapter.MyViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView title = holder.LinearView.findViewById(R.id.event_title);
        TextView description = holder.LinearView.findViewById(R.id.event_description);
        TextView date_time = holder.LinearView.findViewById(R.id.event_date_time);
        TextView venue = holder.LinearView.findViewById(R.id.event_venue);

        title.setText(mDataset.get(position).getEvent_name());
        description.setText(mDataset.get(position).getEvent_Description());
        date_time.setText(mDataset.get(position).getEvent_date()+" "+mDataset.get(position).getEvent_time());
        Places place = database.getAppDatabase(holder.LinearView.getContext()).placeDAO().loadById(mDataset.get(position).getPlace_id());
        venue.setText(place.getPlace_name());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
