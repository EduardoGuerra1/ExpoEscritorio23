package View.menu;

// Definición de la clase MenuAction
public class MenuAction {

    // Declaración de una variable booleana llamada 'cancel' con valor inicial 'false'
    private boolean cancel = false;

    // Método protegido que permite verificar si la acción ha sido cancelada
    protected boolean isCancel() {
        return cancel;
    }

    // Método público para marcar la acción como cancelada
    public void cancel() {
        this.cancel = true; // Establece el valor de 'cancel' como 'true'
    }
}
