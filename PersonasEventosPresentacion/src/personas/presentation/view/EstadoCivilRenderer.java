/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personas.presentation.view;

public class EstadoCivilRenderer extends javax.swing.JLabel implements javax.swing.ListCellRenderer {

  protected java.awt.Color background = java.awt.Color.black;
  Object estadoCivil;

  public EstadoCivilRenderer() {
    super();
    setOpaque(true);
    setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.MatteBorder(2, 10, 2, 10, java.awt.Color.white), new javax.swing.border.LineBorder(java.awt.Color.black)));
  }

  public java.awt.Component getListCellRendererComponent( javax.swing.JList list, Object obj,
      int row, boolean sel, boolean hasFocus) {
      estadoCivil =  obj;
      if (estadoCivil.toString().equals("Soltero")) background = java.awt.Color.pink;
      else if (estadoCivil.toString().equals("Casado")) background = java.awt.Color.red;
      else if (estadoCivil.toString().equals("Viudo")) background = java.awt.Color.gray;
      else if (estadoCivil.toString().equals("Divorciado")) background = java.awt.Color.ORANGE;
      else background = java.awt.Color.yellow;
    setBackground(background);
    setText(estadoCivil.toString());
    if (sel) setForeground(java.awt.Color.WHITE);
    else setForeground(java.awt.Color.BLACK);
    return this;
  }
}
