package mates;

import java.util.concurrent.ThreadLocalRandom;

public class MatesRecursiva {

    /**
     * Genera una aproximación al número pi mediante el método de Montecarlo de
     * forma recursiva.
     *
     * @param n el número de pasos para realizar la aproximación.
     * @return una aproximación al número pi.
     */
    public static double generarPiRecursivo(double n) {
        return generarPiRecursivoAux(n, 0, 0);
    }

    /**
     * Función auxiliar para generar una aproximación al número pi de forma recursiva.
     *
     * @param n          el número de pasos para realizar la aproximación.
     * @param dentroCirculo  el número de puntos dentro del círculo.
     * @param totalPuntos    el número total de puntos generados.
     * @return una aproximación al número pi.
     */
    private static double generarPiRecursivoAux(double n, long dentroCirculo, long totalPuntos) {
        if (totalPuntos == n) {
            return 4.0 * dentroCirculo / n;
        } else {
            double x = ThreadLocalRandom.current().nextDouble() * 2 - 1;
            double y = ThreadLocalRandom.current().nextDouble() * 2 - 1;

            if (x * x + y * y <= 1) {
                return generarPiRecursivoAux(n, dentroCirculo + 1, totalPuntos + 1);
            } else {
                return generarPiRecursivoAux(n, dentroCirculo, totalPuntos + 1);
            }
        }
    }
}

