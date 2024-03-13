package auto;

import java.util.ArrayList;
import java.util.List;

public class InventarioAutos<T extends Auto> {
    private List<T> autos;

    public InventarioAutos() {
        this.autos = new ArrayList<>();
    }

    public InventarioAutos(List<T> autos) {
        this.autos = autos;
    }

    public T agregarAuto(T auto) {
        autos.add(auto);
        return auto;
    }

    public List<T> buscarAuto(String marca) {
        return autos.stream()
                .filter(auto -> auto.marca().equals(marca))
                .toList();
    }

    public List<T> buscarAuto(int anio) {
        return autos.stream()
                .filter(auto -> auto.anio() == anio)
                .toList();
    }

    public double calcularValorTotal() {
        return autos.stream()
                .mapToDouble(Auto::precio)
                .sum();
    }

}
