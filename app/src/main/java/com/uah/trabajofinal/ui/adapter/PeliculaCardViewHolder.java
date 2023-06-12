package com.uah.trabajofinal.ui.adapter;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.uah.trabajofinal.R;
import com.uah.trabajofinal.domain.model.Pelicula;
import com.google.android.material.imageview.ShapeableImageView;
import com.uah.trabajofinal.utils.logger.Logger;

/**
 * @author Jorge Romero
 *
 * @clase PeliculaCardViewHolder
 * @descripcion ViewHolder que se encarga de inflar la vista de cada card fragment de pelicula
 * @see RecyclerView.ViewHolder
 */
public class PeliculaCardViewHolder extends RecyclerView.ViewHolder {

    /**
     * Atributos, constantes y constructor del ViewHolder
     */
    private final ShapeableImageView peliculaCardCoverImage;
    private final TextView peliculaCardTitleText, peliculaCardAnioText, peliculaCardDuracionText,
            peliculaCardActorPrincipalText, peliculaCardSinopsisText;
    private final MaterialButton materialButton1, materialButton2;
    private static final Logger logger = new Logger(PeliculaCardViewHolder.class);

    /**
     * @descripcion Constructor del ViewHolder
     * @param itemView Vista de cada card fragment de pelicula
     * @param clickListener Listener para los botones de cada card fragment de pelicula
     */
    public PeliculaCardViewHolder(View itemView, PeliculaCardListAdapter.OnMaterialButtonClickListener clickListener) {
        super(itemView);

        peliculaCardCoverImage = itemView.findViewById(R.id.peliculaCardCoverImage);
        peliculaCardTitleText = itemView.findViewById(R.id.peliculaCardTitleText);
        peliculaCardAnioText = itemView.findViewById(R.id.peliculaCardAnioText);
        peliculaCardDuracionText = itemView.findViewById(R.id.peliculaCardDuracionText);
        peliculaCardActorPrincipalText = itemView.findViewById(R.id.peliculaCardActorPrincipalText);
        peliculaCardSinopsisText = itemView.findViewById(R.id.peliculaCardSinopsisText);
        materialButton1 = itemView.findViewById(R.id.peliculaCardMaterialButton1);
        materialButton2 = itemView.findViewById(R.id.peliculaCardMaterialButton2);

        materialButton1.setOnClickListener(v -> {
            int posicion = getAdapterPosition();
            if (posicion != RecyclerView.NO_POSITION) {
                clickListener.onMaterialButtonClick(posicion, 1);
                logger.i("Botón '" + materialButton1.getText() + "' presionado sobre la película " +
                        "en posición " + posicion);
            }
        });

        materialButton2.setOnClickListener(v -> {
            int posicion = getAdapterPosition();
            if (posicion != RecyclerView.NO_POSITION) {
                clickListener.onMaterialButtonClick(posicion, 2);
                logger.i("Botón '" + materialButton2.getText() + "' presionado sobre la película " +
                        "en posición " + posicion);
            }
        });
    }

    /**
     * @descripcion Metodo para enlazar los datos de una pelicula con su vista correspondiente
     * @param pelicula Pelicula
     */
    public void bind(Pelicula pelicula) {
        peliculaCardCoverImage.setImageResource(R.drawable.play_store_512);
        peliculaCardTitleText.setText(pelicula.getTitulo());
        peliculaCardAnioText.setText(String.valueOf(pelicula.getAnio()));
        peliculaCardDuracionText.setText(String.valueOf(pelicula.getDuracion()));
        peliculaCardActorPrincipalText.setText(pelicula.getActorPrincipal());
        peliculaCardSinopsisText.setText(pelicula.getSinopsis());
    }
}