import model.Verdura;
import org.junit.jupiter.api.*;
import view.Main;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Se probará el método de filtrado hecho en {@link view.Main}
 */
public class MainTest {
    Verdura[] verduras;

    /**
     * Antes de cada test, se aplica este código.
     */
    @BeforeEach
    protected void setUp() {
        verduras = new Verdura[]{
                new Verdura(1, "Zanahoria", "naranja", 25),
                new Verdura(2, "Espinaca", "verde", 7),
                new Verdura(3, "Tomate", "rojo", 16),
                new Verdura(4, "Brócoli", "verde", 31),
                new Verdura(5, "Pimiento", "rojo oscuro", 18),
                new Verdura(6, "Remolacha", "rojo", 43),
                new Verdura(7, "Coliflor", "blanco", 25),
                new Verdura(8, "Calabacín", "un poco verde", 33)
        };
    }

    /**
     * Tras cada test, se aplica este código.
     */
    @AfterEach
    protected void tearDown() {
        verduras = null;
    }

    /**
     * Se aplican todos los test. Los test en cuestión serán:
     * <ul>
     *     <li>Color coincide</li>
     *     <li>Coincide sin importar mayúsculas</li>
     *     <li>Color no encontrado</li>
     *     <li>Parámetro recibido nulo</li>
     * </ul>
     */
    @Test
    protected void getVeggiesByColour_AllTestCases() {
        assertAll(
                this::givenGreen_CountsThree,
                this::givenCapitalCaseGreen_CountsThree,
                this::givenUnknown_CountsZero,
                this::givenNull_ThrowsException
        );
    }

    private void givenGreen_CountsThree() {
        assertEquals(
                3,
                Main.getVeggiesByColour(verduras, "verde").count(),
                "Dado el color verde, se devolverán 3 elementos."
        );
    }

    private void givenCapitalCaseGreen_CountsThree() {
        assertEquals(
                3,
                Main.getVeggiesByColour(verduras, "VERDE").count(),
                "Dado el color verde, incluso con mayúsculas, se devolverán 3 elementos."
        );
    }

    private void givenUnknown_CountsZero() {
        assertEquals(
                0,
                Main.getVeggiesByColour(verduras, "AYAYAYAYA").count(),
                "Dado un color no registrado, se devolverán 0 elementos."
        );
    }

    private void givenNull_ThrowsException() {
        assertThrows(
                IllegalArgumentException.class,
                () -> Main.getVeggiesByColour(verduras, null).count(),
                "Dado una recepción nula, devuelve un IllegalArgumentException."
        );
    }


}
