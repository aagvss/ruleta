package Modelo;

public class Resultado {
    private final int numeroGanador;
    private final boolean acierto;
    private final int premio;
    private final String mensaje;

    public Resultado(int numeroGanador, boolean acierto, int premio, String mensaje) {
        this.numeroGanador = numeroGanador;
        this.acierto = acierto;
        this.premio = premio;
        this.mensaje = mensaje;
    }
    public int getNumeroGanador() {return numeroGanador;}
    public boolean isAcierto() {return acierto;}
    public int getPremio() {return premio;}
    public String getMensaje() {return mensaje;}
}
