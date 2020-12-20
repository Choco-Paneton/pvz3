
package gui.complements.jPanels;

import data.CategoriaData;
import entities.Categoria;
import gui.complements.jDialogs.JdEliminarCategoria;
import gui.complements.jDialogs.JdNuevoCategoria;
import gui.main.Tiendita;
import gui.model.CategoriaModel;
import java.awt.Frame;
import java.awt.Window;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class JpCategorias extends javax.swing.JPanel {
     
    public CategoriaModel categoriaModel;
    
    public JpCategorias() {
        initComponents();
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);
        table.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        categoriaModel = new CategoriaModel();
        paintTable(categoriaModel);
    }
    private void resetForm() {
        TextNombre.requestFocus();
        TextNombre.setText("");
        TextNombre.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));

        ModificarButton.setText("REGISTRAR");
        ModificarButton.setToolTipText("REGISTRAR");
    }
    
    public void paintTable(CategoriaModel tableModel) {
        this.categoriaModel = tableModel;
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setMaxWidth(100);
    }
    private void paintForm() {
        if (table.getSelectedRow() != -1) {
            Categoria filax = (Categoria) categoriaModel.getRow(table.getSelectedRow());
            Categoria c = CategoriaData.getByPId(filax.getId_categoria());
            TextNombre.setText(c.getNombre_categoria());
            TextNombre.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));

            System.out.printf("getId:%d getSelectedRow:%d \n", c.getId_categoria(), table.getSelectedRow());

            ModificarButton.setText("MODIFICAR");
            ModificarButton.setToolTipText("MODIFICAR");
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        buttonClass1 = new gui.styles.button.ButtonClass();
        jLabel2 = new javax.swing.JLabel();
        buscarField = new javax.swing.JTextField();
        EliminarButton = new gui.styles.button.ButtonClass();
        ModificarButton = new gui.styles.button.ButtonClass();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        TextNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.CardLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(17, 84, 160));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Categoria");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 630, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        buttonClass1.setBackground(new java.awt.Color(13, 71, 161));
        buttonClass1.setText("Agregar");
        buttonClass1.setColorNormal(new java.awt.Color(13, 71, 161));
        buttonClass1.setFocusable(false);
        buttonClass1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonClass1.setVerifyInputWhenFocusTarget(false);
        buttonClass1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonClass1MouseClicked(evt);
            }
        });
        buttonClass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonClass1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("icon");

        buscarField.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        buscarField.setForeground(new java.awt.Color(51, 51, 51));
        buscarField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        buscarField.setBorder(null);
        buscarField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarFieldActionPerformed(evt);
            }
        });
        buscarField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarFieldKeyReleased(evt);
            }
        });

        EliminarButton.setBackground(new java.awt.Color(13, 71, 161));
        EliminarButton.setText("Eliminar");
        EliminarButton.setColorNormal(new java.awt.Color(13, 71, 161));
        EliminarButton.setFocusable(false);
        EliminarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        EliminarButton.setVerifyInputWhenFocusTarget(false);
        EliminarButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                EliminarButtonMouseClicked(evt);
            }
        });
        EliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarButtonActionPerformed(evt);
            }
        });

        ModificarButton.setBackground(new java.awt.Color(13, 71, 161));
        ModificarButton.setText("Modificar");
        ModificarButton.setColorNormal(new java.awt.Color(13, 71, 161));
        ModificarButton.setFocusable(false);
        ModificarButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ModificarButton.setVerifyInputWhenFocusTarget(false);
        ModificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator2)
                    .addComponent(buscarField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(ModificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonClass1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonClass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ModificarButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buscarField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        TextNombre.setBorder(null);
        TextNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextNombreKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TextNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addGap(20, 20, 20))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(TextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel5.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void buscarFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscarFieldKeyReleased
        CategoriaModel tableModel = new CategoriaModel(buscarField.getText());
        paintTable(tableModel);
    }//GEN-LAST:event_buscarFieldKeyReleased

    private void buscarFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarFieldActionPerformed
        CategoriaModel tableModel = new CategoriaModel(buscarField.getText());
        paintTable(tableModel);
    }//GEN-LAST:event_buscarFieldActionPerformed

    private void buttonClass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonClass1ActionPerformed
        JpCategorias jpCategorys = new JpCategorias();
        Window parentWindow = SwingUtilities.windowForComponent(jpCategorys);
        Frame parentFrame = null;
        if (parentWindow instanceof Tiendita) {
            parentFrame = (Tiendita)parentWindow;
        }
        JdNuevoCategoria jpNewCategorys = new JdNuevoCategoria(parentFrame, true);
        jpNewCategorys.setVisible(true);
        paintTable(new CategoriaModel());
    }//GEN-LAST:event_buttonClass1ActionPerformed

    private void EliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarButtonActionPerformed
        // TODO add your handling code here:
        if (table.getSelectedRow() != -1) {
            try {
                int opc = JOptionPane.showConfirmDialog(this, "¿Realmente desea eliminar?", "Quitar", JOptionPane.YES_NO_OPTION);
                if (opc == JOptionPane.OK_OPTION) {
                    Categoria fila = (Categoria) categoriaModel.getRow(table.getSelectedRow());
                    System.out.printf("EliminarButtomActionPerformed getId:%d getSelectedRow:%d \n", fila.getId_categoria(), table.getSelectedRow());

                    int opcion = CategoriaData.delete(fila.getId_categoria());
                    if (opcion != 0) {
                        //tableModel.removeRow(table.getSelectedRow());
                        paintTable(new CategoriaModel());
                        resetForm();
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "No se puede eliminar: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registo de la tabla");
        }
    }//GEN-LAST:event_EliminarButtonActionPerformed

    private void ModificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarButtonActionPerformed
        if (TextNombre.getText().trim().isEmpty()) {
            TextNombre.requestFocus();
            TextNombre.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 3));

        } else {
            Categoria s = new Categoria();
            s.setNombre_categoria(TextNombre.getText());

            if (table.getSelectedRow() != -1) {// ha seleccionado, update
                try {
                    Categoria fila = (Categoria) categoriaModel.getRow(table.getSelectedRow());
                    s.setId_categoria(fila.getId_categoria());
                    System.out.println("id:" + s.getId_categoria());
                    if (s.getId_categoria() > 0) {
                        int returnId = CategoriaData.update(s);
                        if (returnId != 0) {
                            paintTable(new CategoriaModel());
                            resetForm();
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se puede editar: " + ex.getMessage());
                }
            } else { // sin seleccionar, insert
                try {
                    int returnId = CategoriaData.create(s);
                    if (returnId != 0) {
                        paintTable(new CategoriaModel());
                        // s.setId(returnId);//necesitamos subir el id, ya no
                        //tableModel.addRow(s);
                        resetForm();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se puede insertar: " + ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_ModificarButtonActionPerformed

    private void EliminarButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_EliminarButtonMouseClicked
        
    }//GEN-LAST:event_EliminarButtonMouseClicked

    private void buttonClass1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonClass1MouseClicked
        
    }//GEN-LAST:event_buttonClass1MouseClicked

    private void TextNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextNombreKeyReleased
        if (!TextNombre.getText().trim().isEmpty()) { //reset
            TextNombre.setBorder(new LineBorder(new java.awt.Color(0, 0, 0), 1));
        } else {
            TextNombre.setBorder(new LineBorder(new java.awt.Color(255, 0, 0), 3));
        }
    }//GEN-LAST:event_TextNombreKeyReleased

    private void tableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyReleased
        paintForm();
    }//GEN-LAST:event_tableKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        paintForm();
    }//GEN-LAST:event_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.styles.button.ButtonClass EliminarButton;
    private gui.styles.button.ButtonClass ModificarButton;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JTextField buscarField;
    private gui.styles.button.ButtonClass buttonClass1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
