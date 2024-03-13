package mascota;

import java.util.*;
import java.util.stream.IntStream;

public class RegistroMascotas {

    private List<Mascota<?>> mascotas = new ArrayList<>();


    public void agregarMascota(Mascota<?> mascota) {
        mascotas.add(mascota);
    }

    public Mascota<?> buscar(String nombre) {
        return mascotas.stream()
                .filter(mascota -> mascota.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow();
    }

    public List<Mascota<?>> buscarPorEspecie(Object especie) {
        return mascotas.stream()
                .filter(mascota -> mascota.getEspecie().equals(especie))
                .toList();
    }

    public int cantidadMascotas() {
        return mascotas.size();
    }

    public void generarMascotasAleatorias(String... nombres) {
        Random random = new Random();
        IntStream.range(1, nombres.length + 1)
                .forEach(i -> mascotas.add(makeMascota(nombres, i, random)));
    }

    private static Mascota<String> makeMascota(String[] nombres, int i, Random random) {
        int edad = random.nextInt(10);
        int aleatorio = random.nextInt(4);
        Mascota<String> mascota = new Mascota<>(i, nombres[i - 1], edad, Mascota.ESPECIES.get(aleatorio + 1));
        return mascota;
    }


}
