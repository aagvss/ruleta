package controlador;
import Modelo.*;

public class RuletaController {
    private final Ruleta ruleta = new Ruleta();

    public Resultado jugar(Usuario usuario, int numero, int monto) {
        int numeroGanador=ruleta.girar();
        boolean acierto=ruleta.evaluarResultado(numeroGanador,numero);

        if (!usuario.retirar(monto)){
            return new Resultado(numeroGanador, false, 0, usuario.getNombre() + " no tiene saldo suficiente para apostar $"+ monto);
        }
        if (acierto) {
            int premio=monto*36;
            usuario.depositar(premio+monto);
            return new Resultado(numeroGanador, true, premio, usuario.getNombre()+ " gano $" + premio + " apostando al " + numero);
        } else {
            usuario.retirar(monto);
            return new Resultado(numeroGanador, false, 0, usuario.getNombre() + " perdio $" + monto + " apostando al " + numero);
        }
    }
}
