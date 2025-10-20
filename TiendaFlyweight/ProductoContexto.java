class ProductoContexto {
    private final String tipo; // Comida o Ropa
    private final double descuento;
    private final String fechaCaducidad;
    private final String talla;

    public ProductoContexto(String tipo, double descuento, String fechaCaducidad, String talla) {
        this.tipo = tipo;
        this.descuento = descuento;
        this.fechaCaducidad = fechaCaducidad;
        this.talla = talla;
    }

    public String getTipo() { return tipo; }
    public double getDescuento() { return descuento; }
    public String getFechaCaducidad() { return fechaCaducidad; }
    public String getTalla() { return talla; }
}