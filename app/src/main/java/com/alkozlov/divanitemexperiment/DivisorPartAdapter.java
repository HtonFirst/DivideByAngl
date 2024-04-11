package com.alkozlov.divanitemexperiment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DivisorPartAdapter
        extends RecyclerView.Adapter<DivisorPartAdapter.DivisorPartViewHolder> {

    int sizeOfList;
    int numbersOfColumns;

    List<String> listForBinding;

    public DivisorPartAdapter(int sizeOfList, int numbersOfColumns, List<String> listForBinding) {

        this.sizeOfList = sizeOfList;
        this.numbersOfColumns = numbersOfColumns;
        this.listForBinding = listForBinding;
    }


    @NonNull
    @Override
    public DivisorPartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int itemListForDivisorPart = R.layout.item_list_of_numbers;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(itemListForDivisorPart, parent, false );
        DivisorPartViewHolder divisorPartViewHolder = new DivisorPartViewHolder(view);
        return divisorPartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull DivisorPartViewHolder holder, int position) {
        holder.bind(position);

    }

    @Override
    public int getItemCount() {
        return sizeOfList;
    }

    class DivisorPartViewHolder extends RecyclerView.ViewHolder {

        TextView numberItemView;
        TextView lineView;

        public DivisorPartViewHolder(@NonNull View itemView) {
            super(itemView);

            numberItemView = itemView.findViewById(R.id.tv_item_list_of_numbers);
            lineView = itemView.findViewById(R.id.tv_item_list_bottom_line);


        }
        void bind(int listIndex) {

            String value = listForBinding.get(listIndex);

            numberItemView.setText(value);
            if (listIndex< sizeOfList)  {
                lineView.setBackgroundResource(R.color.purple_700);
            }

        }

    }
}
