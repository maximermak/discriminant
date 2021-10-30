package com.my.discriminant.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.my.discriminant.App;
import com.my.discriminant.R;
import com.my.discriminant.activities.Details;
import com.my.discriminant.room.DetailsDao;
import com.my.discriminant.room.DetailsModel;

import java.util.List;

public class DiscriminantAdapter extends RecyclerView.Adapter<DiscriminantAdapter.DetailsViewHolder> {

    List<DetailsModel> list = App.getInstance().getDatabase().detailsDao().getAll();

    public void RefreshData()
    {
        list = App.getInstance().getDatabase().detailsDao().getAll();
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_answer, parent, false);

        return new DetailsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        holder.getTextView().setText(list.get(position).getValueForList());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    static class DetailsViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;

        public DetailsViewHolder(@NonNull View itemView) {


            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv);
        }

        public TextView getTextView() {
            return textView;
        }
    }
}
