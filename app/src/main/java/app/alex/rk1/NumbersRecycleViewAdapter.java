package app.alex.rk1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NumbersRecycleViewAdapter extends RecyclerView.Adapter<NumbersRecycleViewAdapter.NumberViewHolder> {
    private List<Integer> items;
    private Context mContext;

    NumbersRecycleViewAdapter(Context context, List<Integer> items) {
        this.mContext = context;
        this.items = items;
    }

    class NumberViewHolder  extends RecyclerView.ViewHolder {
        private NumbersRecycleViewAdapter adapter;

        private TextView numberTextView;
        private int position;

        NumberViewHolder(final View itemView, final NumbersRecycleViewAdapter adapter) {
            super(itemView);

            this.adapter = adapter;

            numberTextView = itemView.findViewById(R.id.number_text_view);

            //increase click-listener
            itemView.findViewById(R.id.inc_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.incItem(position);
                    updateValue();
                }
            });
            //decrease click-listener
            itemView.findViewById(R.id.dec_btn).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.decItem(position);
                    updateValue();
                }
            });
        }

        private void updateValue(){
            int value = adapter.getItem(position);
            numberTextView.setText(String.valueOf(value));
            if(value < 0 ) {
                itemView.setBackgroundColor(
                        mContext.getResources().getColor(R.color.red)
                );
            } else {
                itemView.setBackgroundColor(
                        mContext.getResources().getColor(R.color.white)
                );
            }
        }

        void bind(int position) {
            this.position = position;
            updateValue();
        }
    }

    @NonNull
    @Override
    public NumberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.number_panel_view, parent, false);
        return new NumberViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull NumberViewHolder numberViewHolder, int position) {
        numberViewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }

    private int getItem(int position) {
        return items.get(position);
    }

    private void incItem(int position) {
        items.set(position, items.get(position) + 1);
    }

    private void decItem(int position) {
        items.set(position, items.get(position) - 1);
    }

}
