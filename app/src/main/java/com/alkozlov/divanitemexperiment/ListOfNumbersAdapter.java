package com.alkozlov.divanitemexperiment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOfNumbersAdapter
        extends RecyclerView.Adapter<ListOfNumbersAdapter.NumberListItemViewHolder> {

    int sizeOfList;
    int numberOfColumns;

    int space;

    int high;
    List<String> listForBinding;



    public ListOfNumbersAdapter(int sizeOfList, int numberOfColumns, List<String> listForBinding ) {

        this.sizeOfList = sizeOfList;
        this.numberOfColumns = numberOfColumns;
        this.listForBinding = listForBinding;
        this.high = sizeOfList/numberOfColumns;
    }

    @NonNull
    @Override
    public NumberListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int itemListOfNumbersId = R.layout.item_for_recycler;

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(itemListOfNumbersId, parent, false );
        NumberListItemViewHolder numberListItemViewHolder = new NumberListItemViewHolder(view);
        return numberListItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NumberListItemViewHolder holder, int position) {
      holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return sizeOfList;
    }

    class NumberListItemViewHolder extends RecyclerView.ViewHolder {

    TextView numberItemView;
    TextView bottomLineView;

    TextView verticalLineView;
    TextView topLineView;

    public NumberListItemViewHolder(@NonNull View itemView) {
        super(itemView);

        numberItemView = itemView.findViewById(R.id.tv_item_number);
        bottomLineView = itemView.findViewById(R.id.tv_item_bottom_line);
        verticalLineView = itemView.findViewById(R.id.tv_item_end_line);
        topLineView = itemView.findViewById(R.id.tv_item_top_line);



    }
        void bind(int listIndex) {

            String value = listForBinding.get(listIndex);


            numberItemView.setText(value);

            if (listIndex > numberOfColumns / 2 && listIndex < numberOfColumns) {
                bottomLineView.setBackgroundResource(R.color.ink_color);
            }
            if (listIndex == numberOfColumns / 2 || listIndex == (numberOfColumns / 2 + numberOfColumns)) {
                verticalLineView.setBackgroundResource(R.color.ink_color);
            }

        if (listIndex > numberOfColumns*2 - 1) {

            int d = listIndex / numberOfColumns;

            if (d % 2 == 0 && !value.equals(" ")) {
                topLineView.setBackgroundResource(R.color.ink_color);
            }
            if (d % 2 == 0
                    && !listForBinding.get(listIndex - numberOfColumns).equals(" ")
                    && listIndex % numberOfColumns < numberOfColumns/2) {
                topLineView.setBackgroundResource(R.color.ink_color);

            }


        }

        }
  }


}
