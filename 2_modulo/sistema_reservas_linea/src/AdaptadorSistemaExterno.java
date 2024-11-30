/*
Función:
* Adapta un ServicioReservaExterno para que sea compatible con la interfaz interna ServicioReserva.

Responsabilidad:
* Permitir que servicios externos sean utilizados dentro del sistema de reservas al traducir las llamadas entre interfaces incompatibles.
 */

class AdaptadorSistemaExterno implements ServicioReserva {
    private ServicioReservaExterno servicioExterno;

    public void reservar() {
        servicioExterno.hacerReserva();
    }
}