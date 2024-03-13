package mascota;

public abstract class Especie {
    public abstract void emitirSonido();

    static class Perro extends Especie {
        @Override
        public void emitirSonido() {
            System.out.println("Guau guau");
        }
    }
    static class Gato extends Especie {
        @Override
        public void emitirSonido() {
            System.out.println("Miau miau");
        }
    }

    static class Reptil extends Especie {
        @Override
        public void emitirSonido() {
            System.out.println("Sssssss");
        }
    }

    static class Ave extends Especie {
        @Override
        public void emitirSonido() {
            System.out.println("Pio pio");
        }
    }


}



