package View.menu;

// Definición de la interfaz MenuEvent
public interface MenuEvent {
    
    // Método de la interfaz que se llama cuando se selecciona un elemento de menú
    // Toma tres parámetros: 'index', 'subIndex' y 'action'
    // 'index' representa el índice del elemento de menú principal seleccionado.
    // 'subIndex' representa el índice del subelemento del menú (si hay submenús) seleccionado.
    // 'action' representa una instancia de la clase MenuAction asociada a la acción del menú.
    public void menuSelected(int index, int subIndex, MenuAction action);
}
