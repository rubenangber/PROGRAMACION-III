public class Fruta {
    private int cantidad;
    private float precio;
    private final float IVA = 0.04f;
    
    public Fruta(int cantidad, float precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getPrecio() {
        return precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float precioSinIVA(){
        float precio;

        precio = getCantidad() * getPrecio();

        return precio;
    }

    public float precioIVA() {
        float precio;

        precio = getPrecio() * IVA;

        return precio;
    }
    
    public float precioConIVA(){
        float precio;

        precio = getCantidad() * getPrecio() * (1 + IVA);
        
        return precio;
    }
}
