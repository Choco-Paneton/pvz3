
package gui.main;

import gui.complements.jDialogs.JdAsojito;
import gui.complements.jPanels.JpCategorias;
import gui.complements.jPanels.JpClientes;
import gui.complements.jPanels.JpCompraProceso;
import gui.complements.jPanels.JpHogar;
import gui.complements.jPanels.JpProductos;
import gui.complements.jPanels.JpProveedor;
import gui.profe.VentasPanel;
import gui.profe.clientes.ClientesPanel;
import gui.profe.productos.ProductosPanel;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import util.ChangePanel;

public class Tiendita extends javax.swing.JFrame {

    public Tiendita() {     
        Login login = new Login();
        initComponents();
        ChangePanel change = new ChangePanel(jpMainChange, new JpHogar());
        setLocationRelativeTo(null);
        btnIcon.setIcon(imageIcon("/icons/android.png", btnIcon));
        btnIcon.setPressedIcon(imageIconPressed("/icons/android.png", btnIcon, 3, 3));
        login.setVisible(false);
    }
    
    public Icon imageIcon(String url, JButton button) {
          ImageIcon icono = new ImageIcon(getClass().getResource(url));
          int ancho = button.getWidth();
          int alto = button.getHeight();
          ImageIcon icon = new ImageIcon(icono.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
          return icon;
    }
    
    public Icon imageIconPressed(String url, JButton button, int alto, int ancho) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int width = button.getWidth() - ancho;
        int height = button.getHeight() - alto;
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        return icono;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMain = new javax.swing.JPanel();
        jpMenu = new javax.swing.JPanel();
        jpCliente = new javax.swing.JPanel();
        btnUser = new gui.styles.button.ButtonClass();
        lblCorreo1 = new javax.swing.JLabel();
        btnIcon = new gui.styles.button.ButtonClass();
        jpMenuButtons = new javax.swing.JPanel();
        btnHogar = new gui.styles.button.ButtonClass();
        btnProductos = new gui.styles.button.ButtonClass();
        btnCategorias = new gui.styles.button.ButtonClass();
        btnVenta = new gui.styles.button.ButtonClass();
        btnCompra = new gui.styles.button.ButtonClass();
        btnCliente = new gui.styles.button.ButtonClass();
        btnProveedores = new gui.styles.button.ButtonClass();
        btnVenta1 = new gui.styles.button.ButtonClass();
        btnVenta2 = new gui.styles.button.ButtonClass();
        jpMainChange = new javax.swing.JPanel();
        jpDefault = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpMain.setLayout(new java.awt.BorderLayout());

        jpMenu.setBackground(new java.awt.Color(30, 136, 229));

        jpCliente.setBackground(new java.awt.Color(13, 71, 161));

        btnUser.setBackground(new java.awt.Color(13, 71, 161));
        btnUser.setText("Asojito");
        btnUser.setColorHover(new java.awt.Color(12, 67, 152));
        btnUser.setColorNormal(new java.awt.Color(13, 71, 161));
        btnUser.setFocusable(false);
        btnUser.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });

        lblCorreo1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 12)); // NOI18N
        lblCorreo1.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCorreo1.setVerifyInputWhenFocusTarget(false);
        lblCorreo1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        btnIcon.setBackground(new java.awt.Color(13, 71, 161));
        btnIcon.setColorHover(new java.awt.Color(12, 67, 152));
        btnIcon.setColorNormal(new java.awt.Color(13, 71, 161));
        btnIcon.setColorPressed(new java.awt.Color(13, 71, 161));
        btnIcon.setFocusable(false);
        btnIcon.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnIcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIconActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpClienteLayout = new javax.swing.GroupLayout(jpCliente);
        jpCliente.setLayout(jpClienteLayout);
        jpClienteLayout.setHorizontalGroup(
            jpClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnUser, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
            .addComponent(lblCorreo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpClienteLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpClienteLayout.setVerticalGroup(
            jpClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUser, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpMenuButtons.setBackground(new java.awt.Color(13, 71, 161));
        jpMenuButtons.setLayout(new java.awt.GridLayout(10, 1));

        btnHogar.setBackground(new java.awt.Color(11, 61, 140));
        btnHogar.setText("Hogar");
        btnHogar.setBorderPainted(false);
        btnHogar.setColorHover(new java.awt.Color(12, 67, 152));
        btnHogar.setColorNormal(new java.awt.Color(11, 61, 140));
        btnHogar.setFocusable(false);
        btnHogar.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnHogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHogarActionPerformed(evt);
            }
        });
        jpMenuButtons.add(btnHogar);

        btnProductos.setBackground(new java.awt.Color(11, 61, 140));
        btnProductos.setText("Productos");
        btnProductos.setBorderPainted(false);
        btnProductos.setColorHover(new java.awt.Color(12, 67, 152));
        btnProductos.setColorNormal(new java.awt.Color(11, 61, 140));
        btnProductos.setFocusable(false);
        btnProductos.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        jpMenuButtons.add(btnProductos);

        btnCategorias.setBackground(new java.awt.Color(11, 61, 140));
        btnCategorias.setText("Categorias");
        btnCategorias.setBorderPainted(false);
        btnCategorias.setColorHover(new java.awt.Color(12, 67, 152));
        btnCategorias.setColorNormal(new java.awt.Color(11, 61, 140));
        btnCategorias.setFocusable(false);
        btnCategorias.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });
        jpMenuButtons.add(btnCategorias);

        btnVenta.setBackground(new java.awt.Color(11, 61, 140));
        btnVenta.setText("Ventas");
        btnVenta.setBorderPainted(false);
        btnVenta.setColorHover(new java.awt.Color(12, 67, 152));
        btnVenta.setColorNormal(new java.awt.Color(11, 61, 140));
        btnVenta.setFocusable(false);
        btnVenta.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentaActionPerformed(evt);
            }
        });
        jpMenuButtons.add(btnVenta);

        btnCompra.setBackground(new java.awt.Color(11, 61, 140));
        btnCompra.setText("Compra");
        btnCompra.setBorderPainted(false);
        btnCompra.setColorHover(new java.awt.Color(12, 67, 152));
        btnCompra.setColorNormal(new java.awt.Color(11, 61, 140));
        btnCompra.setFocusable(false);
        btnCompra.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompraActionPerformed(evt);
            }
        });
        jpMenuButtons.add(btnCompra);

        btnCliente.setBackground(new java.awt.Color(11, 61, 140));
        btnCliente.setText("Clientes");
        btnCliente.setBorderPainted(false);
        btnCliente.setColorHover(new java.awt.Color(12, 67, 152));
        btnCliente.setColorNormal(new java.awt.Color(11, 61, 140));
        btnCliente.setFocusable(false);
        btnCliente.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        jpMenuButtons.add(btnCliente);

        btnProveedores.setBackground(new java.awt.Color(11, 61, 140));
        btnProveedores.setText("Proveedores");
        btnProveedores.setBorderPainted(false);
        btnProveedores.setColorHover(new java.awt.Color(12, 67, 152));
        btnProveedores.setColorNormal(new java.awt.Color(11, 61, 140));
        btnProveedores.setFocusable(false);
        btnProveedores.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });
        jpMenuButtons.add(btnProveedores);

        btnVenta1.setBackground(new java.awt.Color(11, 61, 140));
        btnVenta1.setText("Clientes PRO ");
        btnVenta1.setBorderPainted(false);
        btnVenta1.setColorHover(new java.awt.Color(12, 67, 152));
        btnVenta1.setColorNormal(new java.awt.Color(11, 61, 140));
        btnVenta1.setFocusable(false);
        btnVenta1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnVenta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenta1ActionPerformed(evt);
            }
        });
        jpMenuButtons.add(btnVenta1);

        btnVenta2.setBackground(new java.awt.Color(11, 61, 140));
        btnVenta2.setText("Productos PRO");
        btnVenta2.setBorderPainted(false);
        btnVenta2.setColorHover(new java.awt.Color(12, 67, 152));
        btnVenta2.setColorNormal(new java.awt.Color(11, 61, 140));
        btnVenta2.setFocusable(false);
        btnVenta2.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        btnVenta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenta2ActionPerformed(evt);
            }
        });
        jpMenuButtons.add(btnVenta2);

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpMenuButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addComponent(jpCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jpMenuButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jpMain.add(jpMenu, java.awt.BorderLayout.LINE_START);

        jpMainChange.setLayout(new java.awt.CardLayout());

        jpDefault.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jpDefaultLayout = new javax.swing.GroupLayout(jpDefault);
        jpDefault.setLayout(jpDefaultLayout);
        jpDefaultLayout.setHorizontalGroup(
            jpDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 965, Short.MAX_VALUE)
        );
        jpDefaultLayout.setVerticalGroup(
            jpDefaultLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jpMainChange.add(jpDefault, "card2");

        jpMain.add(jpMainChange, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, 1127, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHogarActionPerformed
        ChangePanel change = new ChangePanel(jpMainChange, new JpHogar());
    }//GEN-LAST:event_btnHogarActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        ChangePanel change = new ChangePanel(jpMainChange, new JpProductos());
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnIconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnIconActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        ChangePanel change = new ChangePanel(jpMainChange, new JpClientes());
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        ChangePanel change = new ChangePanel(jpMainChange, new JpCategorias());
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentaActionPerformed

      //ChangePanel change = new ChangePanel(jpMainChange, new JpVentas());
      ChangePanel change = new ChangePanel(jpMainChange, new VentasPanel());
    }//GEN-LAST:event_btnVentaActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        JpProductos jpProducts = new JpProductos();
        Window parentWindow = SwingUtilities.windowForComponent(jpProducts);
        Frame parentFrame = null;
        if (parentWindow instanceof Tiendita) {
            parentFrame = (Tiendita)parentWindow;
        }
        JdAsojito jdNewProduct = new JdAsojito(parentFrame, true);
        jdNewProduct.setVisible(true);
    }//GEN-LAST:event_btnUserActionPerformed

    private void btnCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompraActionPerformed
        ChangePanel change = new ChangePanel(jpMainChange, new JpCompraProceso());
    }//GEN-LAST:event_btnCompraActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        ChangePanel change = new ChangePanel(jpMainChange, new JpProveedor());
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnVenta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenta1ActionPerformed
        ChangePanel change = new ChangePanel(jpMainChange, new ClientesPanel());
    }//GEN-LAST:event_btnVenta1ActionPerformed

    private void btnVenta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenta2ActionPerformed
        ChangePanel change = new ChangePanel(jpMainChange, new ProductosPanel());
    }//GEN-LAST:event_btnVenta2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tiendita.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tiendita().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static gui.styles.button.ButtonClass btnCategorias;
    public static gui.styles.button.ButtonClass btnCliente;
    public static gui.styles.button.ButtonClass btnCompra;
    public static gui.styles.button.ButtonClass btnHogar;
    private gui.styles.button.ButtonClass btnIcon;
    public static gui.styles.button.ButtonClass btnProductos;
    public static gui.styles.button.ButtonClass btnProveedores;
    private gui.styles.button.ButtonClass btnUser;
    public static gui.styles.button.ButtonClass btnVenta;
    public static gui.styles.button.ButtonClass btnVenta1;
    public static gui.styles.button.ButtonClass btnVenta2;
    private javax.swing.JPanel jpCliente;
    private javax.swing.JPanel jpDefault;
    private javax.swing.JPanel jpMain;
    public static javax.swing.JPanel jpMainChange;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpMenuButtons;
    public static javax.swing.JLabel lblCorreo1;
    // End of variables declaration//GEN-END:variables
}
