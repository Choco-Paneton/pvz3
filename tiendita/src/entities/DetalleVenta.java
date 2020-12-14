/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Jhoselyn
 */
public class DetalleVenta {
    
    private int id_detallevetna;
    private int cantidad;
    private float precio_unitario;
    private float precio_total_producto;
    private int venta_id;
    public int producto_id;

    public int getId_detallevetna() {
        return id_detallevetna;
    }

    public void setId_detallevetna(int id_detallevetna) {
        this.id_detallevetna = id_detallevetna;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(float precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public float getPrecio_total_producto() {
        return precio_total_producto;
    }

    public void setPrecio_total_producto(float precio_total_producto) {
        this.precio_total_producto = precio_total_producto;
    }

    public int getVenta_id() {
        return venta_id;
    }

    public void setVenta_id(int venta_id) {
        this.venta_id = venta_id;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public void setId_detalleventa(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
