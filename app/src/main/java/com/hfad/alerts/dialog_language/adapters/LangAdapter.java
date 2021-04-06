package com.hfad.alerts.dialog_language.adapters;
import android.content.Context;
import java.util.List;

public class LangAdapter extends BaseRadioAdapter<String> {
    public LangAdapter(Context context, List<String> items){
        super(context, items);
    }

    @Override
    public void onBindViewHolder(BaseRadioAdapter.ViewHolder viewHolder, int i) {
        super.onBindViewHolder(viewHolder, i);
        viewHolder.mRadio.setText(mItems.get(i));
    }
}