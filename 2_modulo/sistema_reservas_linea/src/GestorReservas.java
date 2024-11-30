import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorReservas {
    private static volatile GestorReservas instancia; // volatile para la inicialización segura en múltiples hilos.
    private final List<Reserva> reservas;

    // Constructor privado para evitar instanciación directa
    private GestorReservas() {
        reservas = new ArrayList<>();
    }

    // Método para obtener la única instancia de la clase (thread-safe con double-checked locking)
    public static GestorReservas obtenerInstancia() {
        if (instancia == null) {
            synchronized (GestorReservas.class) {
                if (instancia == null) {
                    instancia = new GestorReservas();
                }
            }
        }
        return instancia;
    }

    // Método para agregar una reserva al registro
    public void agregarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva no puede ser nula");
        }
        reservas.add(reserva);
    }

    // Método para obtener todas las reservas registradas (copia inmutable)
    public List<Reserva> obtenerReservas() {
        return Collections.unmodifiableList(reservas);
    }
}
