
package gui.complements.jPanels;

import data.CountData;

public class JpHogar extends javax.swing.JPanel {

    public JpHogar() {
        
        initComponents();
        NCategorias.setText(CountData.getNCategoria() + "");
        NClientes.setText(CountData.getNCliente()+ "");
        NCompra.setText(CountData.getNCompra()+ "");
        NProductos.setText(CountData.getNProducto()+ "");
        NProveedores.setText(CountData.getNProveedor()+ "");
        NVenta.setText(CountData.getNVenta()+ "");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        NProductos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        btnProductos = new gui.styles.button.ButtonClass();
        jPanel6 = new javax.swing.JPanel();
        NCategorias = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        btnCategorias = new gui.styles.button.ButtonClass();
        jPanel7 = new javax.swing.JPanel();
        NVenta = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        btnVenta = new gui.styles.button.ButtonClass();
        jPanel8 = new javax.swing.JPanel();
        NCompra = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        btnCompra = new gui.styles.button.ButtonClass();
        jPanel9 = new javax.swing.JPanel();
        NProveedores = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        btnProveedores = new gui.styles.button.ButtonClass();
        jPanel10 = new javax.swing.JPanel();
        NClientes = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        buttonClass11 = new gui.styles.button.ButtonClass();

        setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(17, 84, 160));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hogar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.GridLayout(5, 3, 5, 5));

        jPanel5.setBackground(new java.awt.Color(241, 196, 15));
        jPanel5.setLayout(new java.awt.GridLayout(1, 3));

        NProductos.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        NProductos.setForeground(new java.awt.Color(255, 255, 255));
        NProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NProductos.setText("0");
        jPanel5.add(NProductos);

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Productos");
        jPanel5.add(jLabel3);

        jPanel11.setBackground(new java.awt.Color(241, 196, 15));

        btnProductos.setBackground(new java.awt.Color(241, 196, 15));
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/IconCatego.png"))); // NOI18N
        btnProductos.setColorHover(new java.awt.Color(241, 196, 15));
        btnProductos.setColorNormal(new java.awt.Color(241, 196, 15));
        btnProductos.setColorPressed(new java.awt.Color(241, 196, 15));
        btnProductos.setFocusable(false);
        btnProductos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.add(jPanel11);

        jPanel4.add(jPanel5);

        jPanel6.setBackground(new java.awt.Color(39, 174, 97));
        jPanel6.setLayout(new java.awt.GridLayout(1, 3));

        NCategorias.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        NCategorias.setForeground(new java.awt.Color(255, 255, 255));
        NCategorias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NCategorias.setText("0");
        jPanel6.add(NCategorias);

        jLabel6.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Categorias");
        jPanel6.add(jLabel6);

        jPanel12.setBackground(new java.awt.Color(39, 174, 97));

        btnCategorias.setBackground(new java.awt.Color(39, 174, 97));
        btnCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/IconCatego.png"))); // NOI18N
        btnCategorias.setColorHover(new java.awt.Color(39, 174, 97));
        btnCategorias.setColorNormal(new java.awt.Color(39, 174, 97));
        btnCategorias.setColorPressed(new java.awt.Color(39, 174, 97));
        btnCategorias.setFocusable(false);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.add(jPanel12);

        jPanel4.add(jPanel6);

        jPanel7.setBackground(new java.awt.Color(41, 127, 184));
        jPanel7.setLayout(new java.awt.GridLayout(1, 3));

        NVenta.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        NVenta.setForeground(new java.awt.Color(255, 255, 255));
        NVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NVenta.setText("0");
        jPanel7.add(NVenta);

        jLabel9.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText(" Venta");
        jPanel7.add(jLabel9);

        jPanel15.setBackground(new java.awt.Color(41, 127, 184));

        btnVenta.setBackground(new java.awt.Color(41, 127, 184));
        btnVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/IconVenta.png"))); // NOI18N
        btnVenta.setColorHover(new java.awt.Color(41, 127, 184));
        btnVenta.setColorNormal(new java.awt.Color(41, 127, 184));
        btnVenta.setColorPressed(new java.awt.Color(41, 127, 184));
        btnVenta.setFocusable(false);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVenta, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.add(jPanel15);

        jPanel4.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(232, 76, 61));
        jPanel8.setLayout(new java.awt.GridLayout(1, 3));

        NCompra.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        NCompra.setForeground(new java.awt.Color(255, 255, 255));
        NCompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NCompra.setText("0");
        jPanel8.add(NCompra);

        jLabel12.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Compra");
        jPanel8.add(jLabel12);

        jPanel13.setBackground(new java.awt.Color(232, 76, 61));

        btnCompra.setBackground(new java.awt.Color(232, 76, 61));
        btnCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/IconCompra.png"))); // NOI18N
        btnCompra.setColorHover(new java.awt.Color(232, 76, 61));
        btnCompra.setColorNormal(new java.awt.Color(232, 76, 61));
        btnCompra.setColorPressed(new java.awt.Color(232, 76, 61));
        btnCompra.setFocusable(false);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel8.add(jPanel13);

        jPanel4.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(141, 68, 173));
        jPanel9.setLayout(new java.awt.GridLayout(1, 3));

        NProveedores.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        NProveedores.setForeground(new java.awt.Color(255, 255, 255));
        NProveedores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NProveedores.setText("0");
        jPanel9.add(NProveedores);

        jLabel15.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Proveedores");
        jPanel9.add(jLabel15);

        jPanel16.setBackground(new java.awt.Color(141, 68, 173));

        btnProveedores.setBackground(new java.awt.Color(141, 68, 173));
        btnProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/IconProveedor.png"))); // NOI18N
        btnProveedores.setColorHover(new java.awt.Color(141, 68, 173));
        btnProveedores.setColorNormal(new java.awt.Color(141, 68, 173));
        btnProveedores.setColorPressed(new java.awt.Color(141, 68, 173));
        btnProveedores.setFocusable(false);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.add(jPanel16);

        jPanel4.add(jPanel9);

        jPanel10.setBackground(new java.awt.Color(45, 62, 80));
        jPanel10.setLayout(new java.awt.GridLayout(1, 3));

        NClientes.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 36)); // NOI18N
        NClientes.setForeground(new java.awt.Color(255, 255, 255));
        NClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NClientes.setText("0");
        jPanel10.add(NClientes);

        jLabel18.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Clientes");
        jPanel10.add(jLabel18);

        jPanel14.setBackground(new java.awt.Color(45, 62, 80));

        buttonClass11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/IconCliente.png"))); // NOI18N
        buttonClass11.setColorHover(new java.awt.Color(45, 62, 80));
        buttonClass11.setColorNormal(new java.awt.Color(45, 62, 80));
        buttonClass11.setColorPressed(new java.awt.Color(45, 62, 80));
        buttonClass11.setFocusable(false);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(buttonClass11, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonClass11, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel10.add(jPanel14);

        jPanel4.add(jPanel10);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NCategorias;
    private javax.swing.JLabel NClientes;
    private javax.swing.JLabel NCompra;
    private javax.swing.JLabel NProductos;
    private javax.swing.JLabel NProveedores;
    private javax.swing.JLabel NVenta;
    private gui.styles.button.ButtonClass btnCategorias;
    private gui.styles.button.ButtonClass btnCompra;
    private gui.styles.button.ButtonClass btnProductos;
    private gui.styles.button.ButtonClass btnProveedores;
    private gui.styles.button.ButtonClass btnVenta;
    private gui.styles.button.ButtonClass buttonClass11;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
