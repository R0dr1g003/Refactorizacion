import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IReservas fachada = new IReservas() {
            @Override
            public void realizarReserva(String cliente, String telefono, List<String> servicios, boolean tieneSeguro) {
                
            }

            @Override
            public void mostrarReservas() {

            }
        };
        Menu menu = new Menu(scanner, fachada);

        menu.mostrarMenuPrincipal();
    }
}

interface IReservas {
    void realizarReserva(String cliente, String telefono, List<String> servicios, boolean tieneSeguro);
    void mostrarReservas();
}

class Menu {
    private final Scanner scanner;
    private final IReservas fachada;
    private final InputValidator validator = new InputValidator();
    private final ServicioSelector selector = new ServicioSelector();

    public Menu(Scanner scanner, IReservas fachada) {
        this.scanner = scanner;
        this.fachada = fachada;
    }

    public void mostrarMenuPrincipal() {
        System.out.println("Bienvenido al sistema de reservas.");
        while (true) {
            System.out.println("\nMenú principal:");
            System.out.println("1. Ingresar nueva reserva");
            System.out.println("2. Mostrar todas las reservas existentes");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");

            String opcion = scanner.nextLine();
            switch (opcion) {
                case "1":
                    crearNuevaReserva();
                    break;
                case "2":
                    System.out.println("\nMostrando todas las reservas existentes:");
                    fachada.mostrarReservas();
                    break;
                case "3":
                    System.out.println("Gracias por usar el sistema de reservas. ¡Hasta luego!");
                    return;
                default:
                    System.out.println("Opción inválida. Por favor ingrese '1', '2' o '3'.");
            }
        }
    }

    private void crearNuevaReserva() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();

        String telefono = validator.validarTelefono(scanner);
        List<String> servicios = selector.seleccionarServicios(scanner);
        boolean tieneSeguro = validator.validarRespuestaSiNo(scanner, "¿Desea añadir seguro? (si/no): ");

        fachada.realizarReserva(nombre + " " + apellido, telefono, servicios, tieneSeguro);
    }
}

class InputValidator {
    public String validarTelefono(Scanner scanner) {
        while (true) {
            System.out.print("Ingrese el teléfono del cliente (solo números): ");
            String telefono = scanner.nextLine();
            if (telefono.matches("[0-9]+")) {
                return telefono;
            }
            System.out.println("El teléfono solo puede contener números. Intente nuevamente.");
        }
    }

    public boolean validarRespuestaSiNo(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String respuesta = scanner.nextLine().toLowerCase();
            if (respuesta.equals("si")) return true;
            if (respuesta.equals("no")) return false;
            System.out.println("Entrada inválida. Por favor ingrese 'si' o 'no'.");
        }
    }
}

class ServicioSelector {
    public List<String> seleccionarServicios(Scanner scanner) {
        List<String> serviciosDisponibles = new ArrayList<>(List.of("hotel", "vuelo"));
        List<String> seleccionados = new ArrayList<>();
        while (true) {
            System.out.println("Seleccione un tipo de servicio:");
            for (int i = 0; i < serviciosDisponibles.size(); i++) {
                if (!seleccionados.contains(serviciosDisponibles.get(i))) {
                    System.out.println((i + 1) + ": " + serviciosDisponibles.get(i));
                }
            }
            System.out.println("0: Finalizar selección");

            String entrada = scanner.nextLine();
            if (entrada.equals("0")) {
                if (seleccionados.isEmpty()) {
                    System.out.println("Debe seleccionar al menos un servicio.");
                } else {
                    break;
                }
            } else {
                try {
                    int opcion = Integer.parseInt(entrada);
                    if (opcion > 0 && opcion <= serviciosDisponibles.size()) {
                        String servicio = serviciosDisponibles.get(opcion - 1);
                        if (!seleccionados.contains(servicio)) {
                            seleccionados.add(servicio);
                            System.out.println("Servicio '" + servicio + "' añadido.");
                            if (seleccionados.size() == serviciosDisponibles.size()) {
                                System.out.println("Todos los servicios disponibles han sido seleccionados.");
                                break;
                            }
                        } else {
                            System.out.println("El servicio '" + servicio + "' ya ha sido seleccionado.");
                        }
                    } else {
                        System.out.println("Opción inválida. Por favor seleccione un número válido.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor ingrese un número.");
                }
            }
        }
        return seleccionados;
    }
}
