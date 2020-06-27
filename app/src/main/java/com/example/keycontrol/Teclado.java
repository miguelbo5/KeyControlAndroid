package com.example.keycontrol;

import android.widget.ImageView;

public class Teclado {

    private int id;
    private String nombre;
    private double precio;
    private String colorLed;
    private int img;
    private String descripcion;


    public Teclado(int id, String nombre, double precio, String color, int img, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.colorLed = color;
        this.img = img;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Teclado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", colorLed='" + colorLed + '\'' +
                ", img=" + img +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public String toFile(){

        return id + ";" + nombre + ";" + precio + ";" + colorLed + ";" + img + ";" + descripcion;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getColorLed() {
        return colorLed;
    }

    public void setColorLed(String colorLed) {
        this.colorLed = colorLed;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}