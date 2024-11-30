/*
Funcion:
* Realizar una reserva de un servicio, como hotel o vouela
* metodo ejecutar() llama el metodo de de reserva
 */

class ComandoReserva implements Comando {
    private ServicioReserva servicio;

    public ComandoReserva(ServicioReserva servicio) {
        this.servicio = servicio;
    }

    public void ejecutar() {
        servicio.reservar();
    }
}