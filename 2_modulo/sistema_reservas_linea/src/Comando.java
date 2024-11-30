// Patron de comportamiento - Command
// Solicitudes de reserva
/*
Función:
* representan un comando o acción ejecutable.
* Implementar por cualquier clase que desee ejecutar una acción específica.

Responsabilidad:
* Su responsabilidad es proporcionar una interfaz común para que el sistema ejecute diversas acciones
    sin necesidad de conocer los detalles de implementación de cada acción.
 */
public interface Comando {
    void ejecutar();
}


