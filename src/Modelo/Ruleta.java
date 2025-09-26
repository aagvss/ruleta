package Modelo;
import java.util.Random;

public class Ruleta {
    private final Random random = new Random();

    public int girar(){
        return random.nextInt(37);
    }
    public boolean evaluarResultado(int numeroGanador, int numeroApostado) {
        return numeroGanador == numeroApostado;
    }
    public boolean evaluarResultado(int numeroGanador, TipoApuesta tipo) {
        return switch (tipo){
            case ROJO -> esRojo(numeroGanador);
            case NEGRO  -> !esRojo(numeroGanador);
            case PAR  -> numeroGanador % 2 == 0;
            case IMPAR -> numeroGanador % 2 != 0;
        };
    }
    private boolean esRojo(int numero){
        return numero % 2 == 0;
    }
}
