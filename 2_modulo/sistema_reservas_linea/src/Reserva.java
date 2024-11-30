import java.util.List;

public class Reserva {
    private final String nombreCliente;
    private final String telefono;
    private final List<String> servicios;
    private boolean tieneSeguro;

    public Reserva(String nombreCliente, String telefono, List<String> servicios, boolean tieneSeguro) {
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.servicios = List.copyOf(servicios); // Evitar modificaciones externas
        this.tieneSeguro = tieneSeguro;
    }

    // Getters
    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public List<String> getServicios() {
        return servicios;
    }

    public boolean isTieneSeguro() {
        return tieneSeguro;
    }

    // Setter solo para el campo mutable
    public void setTieneSeguro(boolean tieneSeguro) {
        this.tieneSeguro = tieneSeguro;
    }

    @Override
    public String toString() {
        return formatReserva();
    }

    // Método privado para formatear la información de la reserva
    private String formatReserva() {
        return "Reserva:\n" +
                "- Cliente: " + nombreCliente + "\n" +
                "- Teléfono: " + telefono + "\n" +
                "- Servicios: " + String.join(", ", servicios) + "\n" +
                "- Seguro: " + (tieneSeguro ? "Sí" : "No");
    }
}