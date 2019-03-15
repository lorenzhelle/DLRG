package com.example.loren.dlrg;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.loren.dlrg.Model.Kurs;
import com.example.loren.dlrg.KursFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 *
 */
public class MyPersonRecyclerViewAdapter extends RecyclerView.Adapter<MyPersonRecyclerViewAdapter.ViewHolder> {

    private final List<Kurs> mKurse;
    private final OnListFragmentInteractionListener mListener;

    public MyPersonRecyclerViewAdapter(List<Kurs> items, OnListFragmentInteractionListener listener) {
        mKurse = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_person, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mKurs = mKurse.get(position);
        holder.mIdView.setText(String.valueOf(mKurse.get(position).getID()));
        holder.mWochentag.setText(mKurse.get(position).getWochentag());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mKurs);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mKurse.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mWochentag;
        public Kurs mKurs;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.kurs_id);
            mWochentag = (TextView) view.findViewById(R.id.kurs_wochentag);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mWochentag.getText() + "'";
        }
    }
}
