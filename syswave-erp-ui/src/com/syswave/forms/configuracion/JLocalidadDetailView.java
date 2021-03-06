package com.syswave.forms.configuracion;

import com.syswave.entidades.configuracion.Localidad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor Manuel Bucio Vargas
 */
public class JLocalidadDetailView extends javax.swing.JInternalFrame
{
   ILocalidadMediator parent;
   boolean esNuevo, construidoArbol;
   Localidad elementoActual;
   
   //---------------------------------------------------------------------
   /**
    * Creates new form JLocalidadDetailView
    * @param owner
    */
   public JLocalidadDetailView(ILocalidadMediator owner)
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
      elementoActual = new Localidad();
      esNuevo = true;
      this.setTitle("Nueva localidad");
   }
   
   //---------------------------------------------------------------------
   public void prepareForModify (Localidad elemento)
   {
      this.elementoActual = elemento;
      esNuevo = false;
      this.setTitle(String.format("Modificando %s", elemento.getNombre()));
      writeElement(elemento);
   }
   
   //---------------------------------------------------------------------
   public void writeElement (Localidad elemento)
   {
      jtfNombre.setText(elemento.getNombre());
      jtfSiglas.setText(elemento.getSiglas());
      jckActivo.setSelected(elemento.esActivo());
   }
   
   //---------------------------------------------------------------------
   private boolean readElement (Localidad elemento)
   {
      boolean resultado= false;
      String mensaje = "";
      
      if (!jtfNombre.getText().isEmpty() /*&& !jtfSiglas.getText().isEmpty()*/)
      {
         resultado = true;
         elemento.setNombre(jtfNombre.getText());
         elemento.setSiglas(jtfSiglas.getText());
         elemento.setActivo(jckActivo.isSelected());
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
      jlbActivo = new javax.swing.JLabel();
      jpPermisos = new javax.swing.JPanel();
      jpAcciones = new javax.swing.JPanel();
      jbAceptar = new javax.swing.JButton();
      jbCancelar = new javax.swing.JButton();

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
      jpContenido.add(jlbActivo);

      jpGeneral.add(jpContenido);

      tpCuerpo.addTab("General", jpGeneral);

      jpPermisos.setLayout(new java.awt.BorderLayout());
      tpCuerpo.addTab("Idiomas", jpPermisos);

      getContentPane().add(tpCuerpo, java.awt.BorderLayout.CENTER);

      jpAcciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

      jbAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syswave/forms/resources/button-tick.png"))); // NOI18N
      jbAceptar.setText("Aceptar");
      jpAcciones.add(jbAceptar);

      jbCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/syswave/forms/resources/button-cross.png"))); // NOI18N
      jbCancelar.setText("Cancelar");
      jpAcciones.add(jbCancelar);

      getContentPane().add(jpAcciones, java.awt.BorderLayout.SOUTH);

      setSize(new java.awt.Dimension(525, 434));
   }// </editor-fold>//GEN-END:initComponents


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JButton jbAceptar;
   private javax.swing.JButton jbCancelar;
   private javax.swing.JCheckBox jckActivo;
   private javax.swing.JLabel jlbActivo;
   private javax.swing.JLabel jlbClave;
   private javax.swing.JLabel jlbIcono;
   private javax.swing.JLabel jlbUsuario;
   private javax.swing.JPanel jpAcciones;
   private java.awt.Panel jpAreaMensajes;
   private javax.swing.JPanel jpContenido;
   private javax.swing.JPanel jpEncabezado;
   private javax.swing.JPanel jpGeneral;
   private javax.swing.JPanel jpPermisos;
   private javax.swing.JTextField jtfNombre;
   private javax.swing.JTextField jtfSiglas;
   private javax.swing.JTabbedPane tpCuerpo;
   // End of variables declaration//GEN-END:variables
}
