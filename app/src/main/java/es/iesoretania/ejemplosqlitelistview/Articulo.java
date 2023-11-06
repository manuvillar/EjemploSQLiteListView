package es.iesoretania.ejemplosqlitelistview;

public class Articulo {
    String codigo;
    String producto;
    String precio;

    public Articulo(String codigo, String producto, String precio) {
        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
