import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    Calculadora calculadora;

    // Código que se va a ejecutar ANTES de cada caso de prueba
    // Así evitamos tener que crear un objeto en cada pruebq
    // Esto instanciaría la clase calculadora antes de cada prueba
    @BeforeEach
    public void antes() {
        calculadora = new Calculadora();
    }


    @Test
    void testSuma() {

        assertAll(
                "Suma dos numeros",
                () -> assertEquals(9, calculadora.suma(2,7)),
                () -> assertEquals(4, calculadora.suma(-5,9)),
                () -> assertEquals(62.6, calculadora.suma(2.1,60.5)),
                () -> assertEquals(9, calculadora.suma(9,0)),
                () -> assertEquals(0, calculadora.suma(0,0), 0.00000001),
                () -> assertEquals(-3, calculadora.suma(0,-3)),
                () -> assertEquals(168.5, calculadora.suma(160,8.5)),
                () -> assertEquals(26, calculadora.suma(13.33,12.67))
        );
    }

    @Test
    void testSumaAns() {
        assertAll(
                "Suma de memoria (ans) + numero",
                () -> assertEquals(4, calculadora.suma(4)),
                () -> assertEquals(9, calculadora.suma(5)),
                () -> assertEquals(4.5, calculadora.suma(-4.5)),
                () -> assertEquals(21, calculadora.suma(16.5)),
                () -> assertEquals(22, calculadora.suma(1)),
                () -> assertEquals(25.33, calculadora.suma(3.33)),
                () -> assertEquals(25.33, calculadora.suma(0)),
                () -> assertEquals(71, calculadora.suma(45.67))
        );
    }


    @Test
    void testResta() {
        assertAll(
                "Resta de dos numeros",
                () -> assertEquals(2, calculadora.resta(6, 4)),
                () -> assertEquals(9, calculadora.resta(13,4)),
                () -> assertEquals(6, calculadora.resta(10.5, 4.5)),
                () -> assertEquals(21.4, calculadora.resta(14, -7.4)),
                () -> assertEquals(0, calculadora.resta(26.33, 26.33), 0.00000001),
                () -> assertEquals(-16, calculadora.resta(-7, 9)),
                () -> assertEquals(160, calculadora.resta(-10, -170)),
                () -> assertEquals(32.89, calculadora.resta(78.56, 45.67))
        );
    }

    @Test
    void testRestaAns() {
        assertAll(
                "Resta de memoria (ans) - numero",
                () -> assertEquals(-4, calculadora.resta(4)),
                () -> assertEquals(-9, calculadora.resta(5)),
                () -> assertEquals(4.5, calculadora.resta(-13.5)),
                () -> assertEquals(0, calculadora.resta(4.5), 0.00000001),
                () -> assertEquals(-5, calculadora.resta(5)),
                () -> assertEquals(-8.33, calculadora.resta(3.33)),
                () -> assertEquals(-7, calculadora.resta(-1.33)),
                () -> assertEquals(33, calculadora.resta(-40))
        );
    }



    @Test
    void testMultiplica() {
        assertAll(
                "Multiplicación de dos numeros",
                () -> assertEquals(12, calculadora.multiplica(4, 3)),
                () -> assertEquals(-38.08, calculadora.multiplica(5.6, -6.8)),
                () -> assertEquals(8, calculadora.multiplica(8, 1)),
                () -> assertEquals(0, calculadora.multiplica(-5, 0), 0.00000001),
                () -> assertEquals(22.5, calculadora.multiplica(5, 4.5)),
                () -> assertEquals(19.98, calculadora.multiplica(3.33, 6))
        );
    }

    @Test
    void testMultiplicaAns() {
        // sumamos uno a ans, ya que entonces el test siempre daría cero
        calculadora.suma(1);
        assertAll(
                "Multiplicación de memoria (ans) por numero",
                () -> assertEquals(4, calculadora.multiplica(4)),
                () -> assertEquals(12, calculadora.multiplica(3)),
                () -> assertEquals(-36, calculadora.multiplica(-3)),
                () -> assertEquals(18, calculadora.multiplica(-0.5)),
                () -> assertEquals(4.5, calculadora.multiplica(0.25)),
                () -> assertEquals(0, calculadora.multiplica(0), 0.00000001),
                () -> assertEquals(0, calculadora.multiplica(8), 0.00000001),
                () -> assertEquals(0, calculadora.multiplica(-2.5), 0.00000001)
                );
    }




    @Test
    void testDivide() {
        assertAll(
                "Division de dos numeros",
                () -> assertEquals(2, calculadora.divide(4,2)),
                () -> assertEquals(12, calculadora.divide(6, 0.5)),
                () -> assertEquals(-32, calculadora.divide(8, -0.25)),
                () -> assertEquals(6.72, calculadora.divide(26.88, 4)),
                () -> assertEquals(2.5, calculadora.divide(5, 2)),
                () -> assertEquals(0, calculadora.divide(0, 5), 0.00000001)
        );
    }

    @Test
    void testDivideAns() {
        // sumamos uno a ans, ya que entonces el test siempre daría cero
        calculadora.suma(1);
        assertAll(
                "Division de memoria (ans) entre numero",
                () -> assertEquals(-4, calculadora.divide(-0.25)),
                () -> assertEquals(2, calculadora.divide(-2)),
                () -> assertEquals(20, calculadora.divide(0.1)),
                () -> assertEquals(2.5, calculadora.divide(8)),
                () -> assertEquals(-1.25, calculadora.divide(-2)),
                () -> assertEquals(5, calculadora.divide(-0.25)),
                // Debería capturar el error y mostrar la excepcion y por tanto no modificar ans
                () -> assertThrows(ArithmeticException.class, () -> {calculadora.divide(8, 0);}),
                // Entonces la division deberia ser el ans anterior 5 , entre 8
                // Gracias al hacer assertAll, capturará el error de la division entre cero y se mostrará, pero también se muestra si hay más errores o no, a parte de ese
                () -> assertEquals(0.625, calculadora.divide(8))
        );
    }



    @Test
    void testDivideEntreCero() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.divide(8, 0);
        });
    }


    @Test
    void testBorrar() {
        calculadora.suma(2);
        assertEquals(2, calculadora.getAns());
        calculadora.borrar();
        assertEquals(0, calculadora.getAns());

        calculadora.resta(8);
        assertEquals(-8, calculadora.getAns(), 0.00000001);
        calculadora.borrar();
        assertEquals(0, calculadora.getAns(), 0.00000001);
    }


    @Test
    void testSumaERROR() {
        assertEquals(2, calculadora.suma(2, 0.5));
    }
    @Test
    void testRestaERROR() {
        assertEquals(1, calculadora.resta(2, -3));
    }
    @Test
    void testDivideERROR() {
        assertEquals(1.5, calculadora.multiplica(2, 0.5));
    }
    @Test
    void testMultiplicaERROR() {
        assertEquals(2, calculadora.divide(2, 0.5));
    }

}