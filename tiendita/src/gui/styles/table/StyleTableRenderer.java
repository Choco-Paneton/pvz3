
package gui.styles.table;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

public class StyleTableRenderer extends DefaultTableCellRenderer{

    private JCheckBox check = new JCheckBox();
    
    @Override
    public Component getTableCellRendererComponent(
        JTable table, Object value, boolean selected, boolean focused, int row, int column
    ) {
        
        table.setBackground(Color.WHITE);
        
        if (value instanceof String) {
            this.setText((String)value);
            this.setOpaque(true);
            this.setBackground( Color.white);
            this.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 13));
            this.setToolTipText("Tabla ");
            this.setForeground(new Color(40, 40, 40));
        }
        if(value instanceof Integer){
            this.setHorizontalAlignment(SwingConstants.CENTER);
            this.setText(""+(Integer)value);  
            this.setOpaque(true);
            this.setBackground( Color.white);
            this.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
            this.setForeground(new Color(40, 40, 40));
        }
        if (value instanceof Float) {
            this.setHorizontalAlignment(SwingConstants.CENTER);
            this.setText(""+(Float)value);  
            this.setOpaque(true);
            this.setBackground( Color.white);
            this.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 13));
            this.setForeground(new Color(40, 40, 40));
        }
        if (value instanceof Boolean) {
            Boolean bol = Boolean.valueOf(String.valueOf(value));
            if( value == null  )
            {             
                return null;
            }
            else
            {   
                check = new JCheckBox();                                
                check.setHorizontalAlignment( JLabel.CENTER );                
                check.setSelected(bol); 
                return check;
            }             
        }
        
        //this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        
        if(selected){
            this.setBackground(new Color(30,136,229));
            this.setForeground(Color.WHITE);
        }
        return this;
    }
}
