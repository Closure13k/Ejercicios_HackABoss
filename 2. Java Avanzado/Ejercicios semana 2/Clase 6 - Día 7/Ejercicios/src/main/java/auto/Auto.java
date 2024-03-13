package auto;

public record Auto(String marca, String modelo, int anio, double precio) {
    public String getDetails() {
        return String.format("%s %s de %d por %,.2f€", marca, modelo, anio, precio);
    }
}
