import java.util.List;

public class FachadaReservas {

    // Método para realizar una nueva reserva
    public void realizarReserva(String nombreCliente, String telefono, List<String> servicios, boolean tieneSeguro) {
        validarParametros(nombreCliente, telefono, servicios);

        // Crear una reserva usando un constructor/factory
        ConstructorReserva constructor = new ConstructorReserva();
        for (String servicio : servicios) {
            constructor.agregarServicio(servicio);
        }
        Reserva reserva = constructor.establecerNombreCliente(nombreCliente)
                .establecerTelefono(telefono)
                .establecerSeguro(tieneSeguro)
                .construir();

        // Guardar la reserva en el gestor centralizado
        GestorReservas.obtenerInstancia().agregarReserva(reserva);

        System.out.println("Reserva creada exitosamente: " + reserva);
    }

    // Método para mostrar todas las reservas
    public void mostrarReservas() {
        List<Reserva> reservas = GestorReservas.obtenerInstancia().obtenerReservas();
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
        } else {
            System.out.println("Lista de reservas registradas:");
            reservas.forEach(System.out::println);
        }
    }

    // Método privado para validar los parámetros de entrada
    private void validarParametros(String nombreCliente, String telefono, List<String> servicios) {
        if (nombreCliente == null || nombreCliente.isBlank()) {
            throw new IllegalArgumentException("El nombre del cliente no puede estar vacío.");
        }
        if (telefono == null || !telefono.matches("\\d+")) {
            throw new IllegalArgumentException("El teléfono debe contener solo números.");
        }
        if (servicios == null || servicios.isEmpty()) {
            throw new IllegalArgumentException("Debe seleccionar al menos un servicio.");
        }
    }
}
