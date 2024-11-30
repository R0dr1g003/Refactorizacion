// Patron Estructural - Decorator

/*
Funcion:
* actua como decorador de servicios
* delegar la accion de reservar un objeto ServicioReserva, sin modificar la logica base de la reserva

Responsabilidad
* proporcionar una esrtuctura comun para decorar un servicio de reserva
 */

public abstract class DecoradorReserva implements ServicioReserva {
    protected ServicioReserva servicioDecorado;

    public DecoradorReserva(ServicioReserva servicio) {
        this.servicioDecorado = servicio;
    }

    public void reservar() {
        servicioDecorado.reservar();
    }
}

class SeguroDecorador extends DecoradorReserva {
    public SeguroDecorador(ServicioReserva servicio) {
        super(servicio);
    }

    public void reservar() {
        super.reservar();
        System.out.println("Seguro añadido a la reserva.");
    }
}
