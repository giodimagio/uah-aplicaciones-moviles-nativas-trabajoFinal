package com.uah.trabajofinal.ui.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.uah.trabajofinal.R;
import com.uah.trabajofinal.domain.model.Pelicula;
import com.google.android.material.imageview.ShapeableImageView;

public class PeliculaCardViewHolder extends RecyclerView.ViewHolder {

    private final ShapeableImageView peliculaCardCoverImage;
    private final TextView peliculaCardTitleText, peliculaCardAnioText, peliculaCardDuracionText,
            peliculaCardActorPrincipalText, peliculaCardSinopsisText;

    public PeliculaCardViewHolder(View itemView) {
        super(itemView);

        peliculaCardCoverImage = itemView.findViewById(R.id.peliculaCardCoverImage);
        peliculaCardTitleText = itemView.findViewById(R.id.peliculaCardTitleText);
        peliculaCardAnioText = itemView.findViewById(R.id.peliculaCardAnioText);
        peliculaCardDuracionText = itemView.findViewById(R.id.peliculaCardDuracionText);
        peliculaCardActorPrincipalText = itemView.findViewById(R.id.peliculaCardActorPrincipalText);
        peliculaCardSinopsisText = itemView.findViewById(R.id.peliculaCardSinopsisText);
    }

    public void bind(Pelicula pelicula) {
        peliculaCardCoverImage.setImageResource(R.drawable.play_store_512);
        peliculaCardTitleText.setText(pelicula.getTitulo());
        peliculaCardAnioText.setText(String.valueOf(pelicula.getAnio()));
        peliculaCardDuracionText.setText(String.valueOf(pelicula.getDuracion()));
        peliculaCardActorPrincipalText.setText(pelicula.getActorPrincipal());
        peliculaCardSinopsisText.setText(pelicula.getSinopsis());
    }
}