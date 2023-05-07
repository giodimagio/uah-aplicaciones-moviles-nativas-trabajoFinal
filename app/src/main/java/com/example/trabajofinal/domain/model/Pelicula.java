package com.example.trabajofinal.domain.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = "peliculasTabla")
public class Pelicula {

    @ColumnInfo(name = "uid")
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @NonNull
    @ColumnInfo(name = "idPelicula")
    private Integer idPelicula;

    @NonNull
    @ColumnInfo(name = "titulo")
    private String titulo;

    @NonNull
    @ColumnInfo(name = "anho")
    private Integer anho;

    @Nullable
    @ColumnInfo(name = "fechaVisionado")
    private String fechaVisionado;

    @Nullable
    @ColumnInfo(name = "ciudadVisionado")
    private String ciudadVisionado;

    @Nullable
    @ColumnInfo(name = "valoracion")
    private Integer valoracion;

    @NonNull
    @ColumnInfo(name = "duracion")
    private Integer duracion;

    @NonNull
    @ColumnInfo(name = "pais")
    private String pais;

    @NonNull
    @ColumnInfo(name = "directorPrincipal")
    private String directorPrincipal;

    @NonNull
    @ColumnInfo(name = "actorPrincipal")
    private String actorPrincipal;

    @NonNull
    @ColumnInfo(name = "genero")
    private String genero;

    @NonNull
    @ColumnInfo(name = "sinopsis")
    private String sinopsis;

    @Nullable
    @ColumnInfo(name = "imagen")
    private String imagen;

    public Pelicula(@NonNull Integer idPelicula, @NonNull String titulo, @NonNull Integer anho, @Nullable String fechaVisionado,
                    @Nullable String ciudadVisionado, @Nullable Integer valoracion, @NonNull Integer duracion, @NonNull String pais,
                    @NonNull String directorPrincipal, @NonNull String genero, @NonNull String sinopsis, @Nullable String imagen,
                    @NonNull String actorPrincipal) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.anho = anho;
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

    public Integer getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Integer idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public String getFechaVisionado() {
        return fechaVisionado;
    }

    public void setFechaVisionado(String fechaVisionado) {
        this.fechaVisionado = fechaVisionado;
    }

    public String getCiudadVisionado() {
        return ciudadVisionado;
    }

    public void setCiudadVisionado(String ciudadVisionado) {
        this.ciudadVisionado = ciudadVisionado;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDirectorPrincipal() {
        return directorPrincipal;
    }

    public void setDirectorPrincipal(String directorPrincipal) {
        this.directorPrincipal = directorPrincipal;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(String actorPrincipal) {
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
                ", año=" + anho +
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
