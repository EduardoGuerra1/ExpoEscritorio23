package View.glasspanepopup;

import java.awt.Component;
import java.awt.Dimension;
import net.miginfocom.layout.BoundSize;
import net.miginfocom.layout.ComponentWrapper;
import net.miginfocom.layout.LayoutCallback;
import net.miginfocom.layout.UnitValue;

public class DefaultLayoutCallBack extends LayoutCallback {

    // Referencia al componente padre.
    public Component getParent() {
        return parent;
    }

    private final Component parent;

    // Constructor que recibe el componente padre como argumento.
    public DefaultLayoutCallBack(Component parent) {
        this.parent = parent;
    }

    @Override
    public BoundSize[] getSize(ComponentWrapper cw) {
        // Obtener las dimensiones del componente padre.
        Dimension ps = parent.getSize();
        // Obtener las dimensiones preferidas del componente hijo.
        Dimension s = ((Component) cw.getComponent()).getPreferredSize();
        // Margen utilizado para ajustar el tamaño del hijo en relación con el padre.
        int margin = 50;
        int w = s.width;
        int h = s.height;
        
        // Ajustar el ancho del hijo si excede el ancho del padre menos el margen.
        if (s.getWidth() > ps.getWidth() - margin) {
            w = Math.max(ps.width - margin, cw.getMinimumWidth(0));
        }
        
        // Ajustar la altura del hijo si excede la altura del padre menos el margen.
        if (s.getHeight() > ps.getHeight() - margin) {
            h = Math.max(ps.height - margin, cw.getMinimumHeight(0));
        }
        
        // Devolver las dimensiones ajustadas como BoundSize.
        return new BoundSize[]{new BoundSize(new UnitValue(w), ""), new BoundSize(new UnitValue(h), "")};
    }
}

