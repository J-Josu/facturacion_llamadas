package ar.edu.unlp.info.oo2.refactor_22;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

    private final List<Llamada> llamadasEfectuadas = new ArrayList<Llamada>();
    private final String nombreYApellido;
    private final String telefono;

    public String getTelefono() {
        return this.telefono;
    }

    public Cliente(String nombreYApellido, String telefono) {
        this.nombreYApellido = nombreYApellido;
        this.telefono = telefono;
    }

    public boolean tieneMismoTelefonoQue(Cliente otroCliente) {
        return this.telefono.equals(otroCliente.telefono);
    }

    public void agregarLlamada(Llamada nuevaLlamada) {
        this.llamadasEfectuadas.add(nuevaLlamada);
    }

    protected abstract double getDescuento();

    private double computarMontoLlamada(Llamada llamada) {
        return llamada.calcularMontoLlamada() * (1 - this.getDescuento());
    }

    public double calcularMontoTotalLlamadas() {
        return this.llamadasEfectuadas
                .stream()
                .mapToDouble(llamada -> this.computarMontoLlamada(llamada))
                .sum();
    }
}
