package com.uah.trabajofinal.domain.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

/**
 * @author Jorge Romero
 *
 * @clase Pelicula
 * @descripcion Clase entidad que representa la entidad de Pelicula
 */
@Entity(tableName = "peliculasTabla")
public class Pelicula {

    @ColumnInfo(name = "uid")
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @Nullable
    @ColumnInfo(name = "idPelicula")
    private Integer idPelicula;

    @Nullable
    @ColumnInfo(name = "titulo")
    private String titulo;

    @Nullable
    @ColumnInfo(name = "anio")
    private Integer anio;

    @Nullable
    @ColumnInfo(name = "fechaVisionado")
    private String fechaVisionado;

    @Nullable
    @ColumnInfo(name = "ciudadVisionado")
    private String ciudadVisionado;

    @Nullable
    @ColumnInfo(name = "valoracion")
    private Integer valoracion;

    @Nullable
    @ColumnInfo(name = "duracion")
    private Integer duracion;

    @Nullable
    @ColumnInfo(name = "pais")
    private String pais;

    @Nullable
    @ColumnInfo(name = "directorPrincipal")
    private String directorPrincipal;

    @Nullable
    @ColumnInfo(name = "actorPrincipal")
    private String actorPrincipal;

    @Nullable
    @ColumnInfo(name = "genero")
    private String genero;

    @Nullable
    @ColumnInfo(name = "sinopsis")
    private String sinopsis;

    @Nullable
    @ColumnInfo(name = "imagen")
    private String imagen;

    public Pelicula() {}

    public Pelicula(@Nullable Integer idPelicula, @Nullable String titulo, @Nullable Integer anio, @Nullable String fechaVisionado,
                    @Nullable String ciudadVisionado, @Nullable Integer valoracion, @Nullable Integer duracion, @Nullable String pais,
                    @Nullable String directorPrincipal, @Nullable String genero, @Nullable String sinopsis, @Nullable String imagen,
                    @Nullable String actorPrincipal) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.anio = anio;
        this.fechaVisionado = fechaVisionado;
        this.ciudadVisionado = ciudadVisionado;
        this.valoracion = valoracion;
        this.duracion = duracion;
        this.pais = pais;
        this.directorPrincipal = directorPrincipal;
        this.genero = genero;
        this.sinopsis = sinopsis;
        this.imagen = imagen;
        this.actorPrincipal = actorPrincipal;
    }

    @Nullable
    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(@Nullable Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Nullable
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(@Nullable String titulo) {
        this.titulo = titulo;
    }

    @Nullable
    public Integer getAnio() {
        return anio;
    }

    public void setAnio(@Nullable Integer anio) {
        this.anio = anio;
    }

    @Nullable
    public String getFechaVisionado() {
        return fechaVisionado;
    }

    public void setFechaVisionado(@Nullable String fechaVisionado) {
        this.fechaVisionado = fechaVisionado;
    }

    @Nullable
    public String getCiudadVisionado() {
        return ciudadVisionado;
    }

    public void setCiudadVisionado(@Nullable String ciudadVisionado) {
        this.ciudadVisionado = ciudadVisionado;
    }

    @Nullable
    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(@Nullable Integer valoracion) {
        this.valoracion = valoracion;
    }

    @Nullable
    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(@Nullable Integer duracion) {
        this.duracion = duracion;
    }

    @Nullable
    public String getPais() {
        return pais;
    }

    public void setPais(@Nullable String pais) {
        this.pais = pais;
    }

    @Nullable
    public String getDirectorPrincipal() {
        return directorPrincipal;
    }

    public void setDirectorPrincipal(@Nullable String directorPrincipal) {
        this.directorPrincipal = directorPrincipal;
    }

    @Nullable
    public String getGenero() {
        return genero;
    }

    public void setGenero(@Nullable String genero) {
        this.genero = genero;
    }

    @Nullable
    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(@Nullable String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Nullable
    public String getImagen() {
        return imagen;
    }

    public void setImagen(@Nullable String imagen) {
        this.imagen = imagen;
    }

    @Nullable
    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(@Nullable String actorPrincipal) {
        this.actorPrincipal = actorPrincipal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pelicula)) return false;
        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(idPelicula, pelicula.idPelicula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula);
    }

    @NonNull
    @Override
    public String toString() {
        return "Pelicula{" +
                "idPelicula=" + idPelicula +
                ", titulo='" + titulo + '\'' +
                ", anio=" + anio +
                ", fechaVisionado=" + fechaVisionado +
                ", ciudadVisionado='" + ciudadVisionado + '\'' +
                ", valoracion=" + valoracion +
                ", duracion=" + duracion +
                ", pais='" + pais + '\'' +
                ", directorPrincipal='" + directorPrincipal + '\'' +
                ", genero='" + genero + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                ", imagen='" + imagen + '\'' +
                ", actorPrincipal=" + actorPrincipal +
                '}';
    }
}
