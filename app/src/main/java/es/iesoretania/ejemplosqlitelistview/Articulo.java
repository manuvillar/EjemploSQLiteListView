package es.iesoretania.ejemplosqlitelistview;

public class Articulo {
    int codigo;
    String producto;
    double precio;

    public Articulo(int codigo, String producto, double precio) {
        this.codigo = codigo;
        this.producto = producto;
        this.precio = precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo + ", Producto: " + producto + ", Precio: " + precio;
    }

}

