package View.menu;

import com.formdev.flatlaf.util.Animator;
import java.util.HashMap;

// Definición de la clase MenuAnimation
public class MenuAnimation {
    // HashMap que almacena objetos MenuItem y objetos Animator
    private static final HashMap<MenuItem, Animator> hash = new HashMap<>();

    // Método estático para animar un MenuItem (menú) con una transición de mostrar u ocultar
    public static void animate(MenuItem menu, boolean show) {
        // Verifica si ya existe una animación en curso para el mismo MenuItem y la detiene si es el caso
        if (hash.containsKey(menu) && hash.get(menu).isRunning()) {
            hash.get(menu).stop();
        }

        // Configura si el menú se debe mostrar u ocultar
        menu.setMenuShow(show);

        // Crea un nuevo objeto Animator para gestionar la animación
        Animator animator = new Animator(400, new Animator.TimingTarget() {
            // Implementa el método timingEvent para actualizar la animación en cada paso
            @Override
            public void timingEvent(float f) {
                if (show) {
                    // Si show es true, establece el progreso de la animación en el menú
                    menu.setAnimate(f);
                } else {
                    // Si show es false, establece el progreso inverso de la animación en el menú
                    menu.setAnimate(1f - f);
                }
                // Revalida el menú para que se repinte con los cambios
                menu.revalidate();
            }

            // Implementa el método end para eliminar el MenuItem del HashMap cuando la animación termina
            @Override
            public void end() {
                hash.remove(menu);
            }
        });

        // Configura la resolución de la animación
        animator.setResolution(1);

        // Configura el interpolador para controlar la velocidad de la animación
        animator.setInterpolator((float f) -> (float) (1 - Math.pow(1 - f, 3)));

        // Inicia la animación
        animator.start();

        // Agrega el MenuItem y su animador correspondiente al HashMap
        hash.put(menu, animator);
    }
}
