
package entities;

public class Producto {
    
    private int id_producto;
    private String descripcion;
    private String nombre_producto;
    private int cantidad;
    private boolean status;
    private boolean igv;
    private float precio_unitario;
    private float precio_sub_total;
    public int categoria_id;

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isIgv() {
        return igv;
    }

    public void setIgv(boolean igv) {
        this.igv = igv;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getPrecio_sub_total() {
        return precio_sub_total;
    }

    public void setPrecio_sub_total(float precio_sub_total) {
        this.precio_sub_total = precio_sub_total;
    }

    public int getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(int categoria_id) {
        this.categoria_id = categoria_id;
    }
   
}