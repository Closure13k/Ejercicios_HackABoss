package mascota;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

public class RegistroMascotas {

    private static String[] nombres = {"Firulais", "Rex", "Boby", "Luna", "Pelusa", "Michi", "Felix", "Garfield", "Tom", "Jerry"};

    private Set<Mascota<? extends Especie>> mascotas;

    public void agregarMascota(Mascota<? extends Especie> mascota) {
        mascotas.add(mascota);
    }

    public Mascota<? extends Especie> buscarMascotaPorNombre(String nombre) {
        return mascotas.stream()
                .filter(mascota -> mascota.getNombre().equals(nombre))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No se encontró la mascota con el nombre " + nombre));
    }

    public List<Mascota<? extends Especie>> buscarMascotaPorEspecie(Especie especie) {
        return mascotas.stream()
                .filter(mascota -> mascota.getEspecie().equals(especie))
                .toList();
    }

    public int contarMascotas() {
        return mascotas.size();
    }

    public Set<Mascota<? extends Especie>> generarDatosAleatorios() {
        Random random = new Random();
        IntStream.range(0, 10).forEach(i -> mascotas.add(crearMascota(i, random)));
        return mascotas;
    }

    private static Mascota<? extends Especie> crearMascota(int i, Random random) {
        Mascota<? extends Especie> mascota = new Mascota<>();
        mascota.setId(i);
        mascota.setNombre(nombres[random.nextInt(nombres.length)]);
        mascota.setEdad(random.nextInt(15));
        Especie especie = switch (random.nextInt(4)) {
            case 0 -> new Especie.Perro();
            case 1 -> new Especie.Gato();
            case 2 -> new Especie.Ave();
            default -> new Especie.Reptil();
        };
        mascota.setEspecie(especie);
        return mascota;
    }


}
