package com.hfad.alerts.dialog_language.adapters;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    private final int space;

    public GridSpacingItemDecoration(int space) { this.space = space;}

    @Override
    public void getItemOffsets(Rect outRect,
                               @NonNull View view,
                               @NonNull RecyclerView parent,
                               @NonNull RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
    }
}
