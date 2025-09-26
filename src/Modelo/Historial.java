package Modelo;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private static final List<String> apuestas = new ArrayList<>();

    public static void agregar(String apuesta) {
        if (apuesta!=null && !apuesta.isBlank()){
            apuestas.add(apuesta);
        }
    }

    public static List<String> getApuestas() {
        return new ArrayList<>(apuestas);
    }

    public static void limpiar() {
        apuestas.clear();
    }
}
