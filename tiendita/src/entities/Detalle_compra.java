
package entities;

public class Detalle_compra {
    
    private int id_detalle_compra;
    private int id_compra;
    private int id_venta;
    private int cantidad;
    private float precio_unitario;
    private float precio_total_producto;

    public int getId_detalle_compra() {
        return id_detalle_compra;
    }

    public void setId_detalle_compra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
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
}
