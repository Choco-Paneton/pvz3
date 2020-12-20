
package gui.profe;

import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class AccionTableCellRenderer implements TableCellRenderer {
    private AddDelProductPanel comp;

    public AccionTableCellRenderer(final JPanel ifr) {
       comp = new AddDelProductPanel(ifr);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        comp.setTabla(table);        
        return comp;
    }
    
    
}