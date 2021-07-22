package com.example.cristianneyraev2.Utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* Clase que extiende la funcionalidad del RecyclerView para poder definir el espacio vertical entre dos CardView */

public class CardViewSeparator extends RecyclerView.ItemDecoration {

    private final int verticalSpaceHeight;

    public CardViewSeparator(int verticalSpaceHeight) {
        this.verticalSpaceHeight = verticalSpaceHeight;
    }

    @Override
    public void getItemOffsets(@NonNull @org.jetbrains.annotations.NotNull Rect outRect, @NonNull @org.jetbrains.annotations.NotNull View view, @NonNull @org.jetbrains.annotations.NotNull RecyclerView parent, @NonNull @org.jetbrains.annotations.NotNull RecyclerView.State state) {
        outRect.bottom = verticalSpaceHeight;

    }
}
