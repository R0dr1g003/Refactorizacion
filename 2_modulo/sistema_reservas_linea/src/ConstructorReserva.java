// Patron creacional - Builder

/*
Funcion:
* creacion de objeto Reserva, encadenable para la reserva (nombre, teléfono, servicios, seguro) antes de construir el objeto final Reserva.

Responsabilidad:
* Facilitar la creacion del objeto de Reserva
 */

import java.util.ArrayList;
import java.util.List;

public class ConstructorReserva {
    private String nombreCliente;
    private String telefono;
    private List<String> servicios = new ArrayList<>();
    private boolean tieneSeguro; // Nuevo campo

    public ConstructorReserva establecerNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        return this;
    }

    public ConstructorReserva establecerTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public ConstructorReserva agregarServicio(String servicio) {
        servicios.add(servicio);
        return this;
    }

    public ConstructorReserva establecerSeguro(boolean tieneSeguro) {
        this.tieneSeguro = tieneSeguro;
        return this;
    }

    public Reserva construir() {
        Reserva reserva = new Reserva(nombreCliente, telefono, servicios, tieneSeguro);
        GestorReservas.obtenerInstancia().agregarReserva(reserva);
        return reserva;
    }
}
