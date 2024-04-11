package com.alkozlov.divanitemexperiment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DividerAdapter
        extends RecyclerView.Adapter<DividerAdapter.DividerListItemViewHolder>{

    private int sizeOfList;
    private int numberOfColumns;
    private List<String> listForBinding;


    public DividerAdapter(int sizeOfList, int numberOfColumns, List<String> listForBinding ) {

        this.sizeOfList = sizeOfList;
        this.numberOfColumns = numberOfColumns;
        this.listForBinding = listForBinding;
    }


    @NonNull
    @Override
    public DividerListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int itemDividerId = R.layout.item_for_recycler;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(itemDividerId, parent, false );
        DividerAdapter.DividerListItemViewHolder dividerListItemViewHolder =
                new DividerAdapter.DividerListItemViewHolder(view);
        return dividerListItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DividerListItemViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return sizeOfList;
    }

    class DividerListItemViewHolder extends RecyclerView.ViewHolder {

        TextView bottomLineView;
        TextView verticalLineVeiw;

        TextView subjectView;

        public DividerListItemViewHolder(@NonNull View itemView) {
            super(itemView);


            subjectView = itemView.findViewById(R.id.tv_item_number);
            verticalLineVeiw = itemView.findViewById(R.id.tv_item_end_line);
            bottomLineView = itemView.findViewById(R.id.tv_item_bottom_line);


        }
        void bind(int listIndex) {

            String value = listForBinding.get(listIndex);


            if (!value.equals(" ") && (listIndex/ numberOfColumns >= 1)) {

                bottomLineView.setBackgroundResource(R.color.purple_700);
                verticalLineVeiw.setBackgroundResource(R.color.purple_700);
            }

        }

    }
}
