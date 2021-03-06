/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.syswave.forms.miempresa;

import com.syswave.entidades.miempresa.TipoPersona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class JTipoPersonasDetailView extends javax.swing.JInternalFrame
{
  ITipoPersonaMediator parent;
   boolean esNuevo, construidoArbol;
   TipoPersona elementoActual;
   
   //---------------------------------------------------------------------
   /**
    * Creates new form JTipoPersonaDetailView
    * @param owner
    */
   public JTipoPersonasDetailView(ITipoPersonaMediator owner)
   {
      initComponents();
      initEvents();
      parent = owner;
   }
   
   //---------------------------------------------------------------------
   private void initEvents()
   {
      ActionListener actionListenerManager
                     = new ActionListener()
      {
         @Override
         public void actionPerformed(ActionEvent evt)
         {
            finish_actionPerformed(evt);
         }
      };
      
      
      jbAceptar.addActionListener(actionListenerManager);
      jbCancelar.addActionListener(actionListenerManager);
   }

   
   //---------------------------------------------------------------------
   private void finish_actionPerformed (ActionEvent evt)
   {
      Object sender = evt.getSource();
      
      if (sender == jbAceptar)
      {
         if (readElement(elementoActual))
         {
            if (esNuevo)
               parent.onAcceptNewElement(elementoActual);

            else 
            {
               elementoActual.setModified();
               parent.onAcceptModifyElement(elementoActual);
            }
            
            close();
         }
      }
      
      else
         close ();
   }
   
   //---------------------------------------------------------------------
   public void prepareForNew ()
   {
      elementoActual = new TipoPersona();
      esNuevo = true;
      this.setTitle("Nueva localidad");
   }
   
   //---------------------------------------------------------------------
   public void prepareForModify (TipoPersona elemento)
   {
      this.elementoActual = elemento;
      esNuevo = false;
      this.setTitle(String.format("Modificando %s", elemento.getNombre()));
      writeElement(elemento);
   }
   
   //---------------------------------------------------------------------
   public void writeElement (TipoPersona elemento)
   {
      jtfNombre.setText(elemento.getNombre());
      jtfSiglas.setText(elemento.getSiglas());
      jckActivo.setSelected(elemento.esActivo());
      jchkMantenimiento.setSelected(elemento.esUsaMantenimiento());
      jchkPersonal.setSelected(elemento.esUsaPersonal());
   }
   
   //---------------------------------------------------------------------
   private boolean readElement (TipoPersona elemento)
   {
      boolean resultado= false;
      String mensaje = "";
      
      if (!jtfNombre.getText().isEmpty() /*&& !jtfSiglas.getText().isEmpty()*/)
      {
         resultado = true;
         elemento.setNombre(jtfNombre.getText());
         elemento.setSiglas(jtfSiglas.getText());
         elemento.setActivo(jckActivo.isSelected());
         elemento.setUsaMantenimiento(jchkMantenimiento.isSelected());
         elemento.setUsaPersonal(jchkPersonal.isSelected());
         if (!elemento.isSet())
            elemento.setModified();
      }
      
      else
         mensaje = "Asegurese de proporcionar el nombre";
      
      if (!resultado)
         JOptionPane.showMessageDialog(this, mensaje, "", JOptionPane.PLAIN_MESSAGE);
      
      return resultado;
   }
  
    //---------------------------------------------------------------------
   public void close ()
   {
      this.setVisible(false);
      this.dispose();
   }

   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jpEncabezado = new javax.swing.JPanel();
        jlbIcono = new javax.swing.JLabel();
        jpAreaMensajes = new java.awt.Panel();
        tpCuerpo = new javax.swing.JTabbedPane();
        jpGeneral = new javax.swing.JPanel();
        jpContenido = new javax.swing.JPanel();
        jlbUsuario = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlbClave = new javax.swing.JLabel();
        jtfSiglas = new javax.swing.JTextField();
        jckActivo = new javax.swing.JCheckBox();
        jchkMantenimiento = new javax.swing.JCheckBox();
        jchkPersonal = new javax.swing.JCheckBox();
        jpAcciones = new javax.swing.JPanel();
        jbCancelar = new javax.swing.JButton();
        jbAceptar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        jpEncabezado.setBackground(new java.awt.Color(70, 123, 152));
        jpEncabezado.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jpEncabezado.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 20, 5));

        jlbIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syswave/forms/resources/window.png"))); // NOI18N
        jlbIcono.setAlignmentX(0.5F);
        jlbIcono.setFocusTraversalPolicyProvider(true);
        jlbIcono.setFocusable(false);
        jlbIcono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jlbIcono.setIconTextGap(0);
        jlbIcono.setPreferredSize(new java.awt.Dimension(40, 50));
        jlbIcono.setRequestFocusEnabled(false);
        jpEncabezado.add(jlbIcono);

        jpAreaMensajes.setBackground(java.awt.SystemColor.desktop);
        jpAreaMensajes.setLayout(new java.awt.GridLayout(2, 1));
        jpEncabezado.add(jpAreaMensajes);

        getContentPane().add(jpEncabezado, java.awt.BorderLayout.PAGE_START);

        jpContenido.setPreferredSize(new java.awt.Dimension(250, 200));
        jpContenido.setLayout(new java.awt.GridLayout(8, 1));

        jlbUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbUsuario.setText("Nombre:");
        jlbUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jlbUsuario.setPreferredSize(new java.awt.Dimension(200, 15));
        jpContenido.add(jlbUsuario);
        jpContenido.add(jtfNombre);

        jlbClave.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlbClave.setText("Siglas:");
        jlbClave.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jpContenido.add(jlbClave);
        jpContenido.add(jtfSiglas);

        jckActivo.setText("Activo:");
        jckActivo.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jpContenido.add(jckActivo);

        jchkMantenimiento.setText("Usar para mantenimiento:");
        jchkMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jchkMantenimiento.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jpContenido.add(jchkMantenimiento);

        jchkPersonal.setText("Usar para personal:");
        jchkPersonal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jchkPersonal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jpContenido.add(jchkPersonal);

        jpGeneral.add(jpContenido);

        tpCuerpo.addTab("General", jpGeneral);

        getContentPane().add(tpCuerpo, java.awt.BorderLayout.CENTER);

        jpAcciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syswave/forms/resources/button-cross.png"))); // NOI18N
        jbCancelar.setText("Cancelar");
        jpAcciones.add(jbCancelar);

        jbAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syswave/forms/resources/button-tick.png"))); // NOI18N
        jbAceptar.setText("Aceptar");
        jpAcciones.add(jbAceptar);

        getContentPane().add(jpAcciones, java.awt.BorderLayout.SOUTH);

        setBounds(0, 0, 527, 377);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbAceptar;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JCheckBox jchkMantenimiento;
    private javax.swing.JCheckBox jchkPersonal;
    private javax.swing.JCheckBox jckActivo;
    private javax.swing.JLabel jlbClave;
    private javax.swing.JLabel jlbIcono;
    private javax.swing.JLabel jlbUsuario;
    private javax.swing.JPanel jpAcciones;
    private java.awt.Panel jpAreaMensajes;
    private javax.swing.JPanel jpContenido;
    private javax.swing.JPanel jpEncabezado;
    private javax.swing.JPanel jpGeneral;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfSiglas;
    private javax.swing.JTabbedPane tpCuerpo;
    // End of variables declaration//GEN-END:variables
}
