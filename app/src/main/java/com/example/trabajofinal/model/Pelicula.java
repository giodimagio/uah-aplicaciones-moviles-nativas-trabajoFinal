package com.example.trabajofinal.model;

import androidx.annotation.NonNull;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Pelicula {

    public int uid;

    private Integer idPelicula;

    private String titulo;
    private Integer anho;
    private LocalDate fechaVisionado;
    private String ciudadVisionado;
    private Integer valoracion;
    private Integer duracion;
    private String pais;
    private String directorPrincipal;
    private String genero;
    private String sinopsis;
    private String imagen;
    private List<String> actorPrincipal;

    public Pelicula() {
    }

    public Pelicula(Integer idPelicula, String titulo, Integer anho, LocalDate fechaVisionado,
                    String ciudadVisionado, Integer valoracion, Integer duracion, String pais,
                    String directorPrincipal, String genero, String sinopsis, String imagen,
                    List<String> actorPrincipal) {
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

    public LocalDate getFechaVisionado() {
        return fechaVisionado;
    }

    public void setFechaVisionado(LocalDate fechaVisionado) {
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

    public List<String> getActorPrincipal() {
        return actorPrincipal;
    }

    public void setActorPrincipal(List<String> actorPrincipal) {
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
