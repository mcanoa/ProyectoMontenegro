package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.JToolBar.Separator;
import logica.dataConnection;
import logica.institutoMontenegro;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author user
 */
public class VentanaAdministrador extends JFrame {

     PreparedStatement pst;
    Connection cn;
    ResultSet result;
     institutoMontenegro instituto = new institutoMontenegro();
     
     public static VentanaAdministrador ventana;
     
    /**
     * Creates new form VentanaAdministrador
     */
    public VentanaAdministrador() {
        cn = dataConnection.conexion();
        initComponents();
        this.getContentPane().setBackground(Color.white);
        VentanaAdministrador.cambiarestado(true);
    }

    
    public static VentanaAdministrador getInstanceSingleton(){
        if(ventana==null){
            ventana=new VentanaAdministrador();
        }
        return ventana;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBarOpcionsAdmin = new JToolBar();
        jButtonCrearEstudiante = new JButton();
        jSeparador1 = new Separator();
        jButtonBuscarEstudiante = new javax.swing.JButton();
        jSeparador2 = new Separator();
        jButtonModificarEstudiante = new JButton();
        jSeparador3 = new Separator();
        jButtonEliminarEstudiante = new JButton();
        jSeparador4 = new Separator();
        jButtonModificarDatos = new JButton();
        jSeparador5 = new Separator();
        jButton1 = new javax.swing.JButton();
        jSeparador6 = new Separator();
        jButton2 = new javax.swing.JButton();
        jSeparador7 = new Separator();
        jButtonSalir = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(getIconImage());
        setName("VentanaAdministrador"); // NOI18N
        setResizable(false);

        jToolBarOpcionsAdmin.setRollover(true);

        jButtonCrearEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonCrearEstudiante.setText("Crear Estudiante");
        jButtonCrearEstudiante.setFocusable(false);
        jButtonCrearEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCrearEstudiante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonCrearEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCrearEstudianteActionPerformed(evt);
            }
        });
        jToolBarOpcionsAdmin.add(jButtonCrearEstudiante);
        jToolBarOpcionsAdmin.add(jSeparador1);

        jButtonBuscarEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonBuscarEstudiante.setText("Buscar Estudiante");
        jButtonBuscarEstudiante.setFocusable(false);
        jButtonBuscarEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBuscarEstudiante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonBuscarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarEstudianteActionPerformed(evt);
            }
        });
        jToolBarOpcionsAdmin.add(jButtonBuscarEstudiante);
        jToolBarOpcionsAdmin.add(jSeparador2);

        jButtonModificarEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonModificarEstudiante.setText("Modificar Estudiante");
        jButtonModificarEstudiante.setFocusable(false);
        jButtonModificarEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificarEstudiante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonModificarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarEstudianteActionPerformed(evt);
            }
        });
        jToolBarOpcionsAdmin.add(jButtonModificarEstudiante);
        jToolBarOpcionsAdmin.add(jSeparador3);

        jButtonEliminarEstudiante.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonEliminarEstudiante.setText("Eliminar Estudiante");
        jButtonEliminarEstudiante.setFocusable(false);
        jButtonEliminarEstudiante.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonEliminarEstudiante.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonEliminarEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarEstudianteActionPerformed(evt);
            }
        });
        jToolBarOpcionsAdmin.add(jButtonEliminarEstudiante);
        jToolBarOpcionsAdmin.add(jSeparador4);

        jButtonModificarDatos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonModificarDatos.setText("Modificar Datos");
        jButtonModificarDatos.setFocusable(false);
        jButtonModificarDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonModificarDatos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonModificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarDatosActionPerformed(evt);
            }
        });
        jToolBarOpcionsAdmin.add(jButtonModificarDatos);
        jToolBarOpcionsAdmin.add(jSeparador5);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Generar Informe");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBarOpcionsAdmin.add(jButton1);
        jToolBarOpcionsAdmin.add(jSeparador6);

        jButton2.setText("Cargar Archivo");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBarOpcionsAdmin.add(jButton2);
        jToolBarOpcionsAdmin.add(jSeparador7);

        jButtonSalir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButtonSalir.setText("Salir");
        jButtonSalir.setFocusable(false);
        jButtonSalir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSalir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jToolBarOpcionsAdmin.add(jButtonSalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBarOpcionsAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBarOpcionsAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarEstudianteActionPerformed

        
        if (v == true) {
            VentanaBuscarEstudiante ventana = new VentanaBuscarEstudiante();
            ventana.setVisible(true);
            v = false;

        } else {
            JOptionPane.showMessageDialog(null, "No puedes abrir otra ventana");
        }
    }//GEN-LAST:event_jButtonBuscarEstudianteActionPerformed

    private void jButtonCrearEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCrearEstudianteActionPerformed
        // TODO add your handling code here:
        if (v == true) {
            VentanaCrearEstudiante ventana = new VentanaCrearEstudiante();
            ventana.setVisible(true);
            v = false;
        } else {
            JOptionPane.showMessageDialog(null, "No puedes abrir otra ventana");
        }
    }//GEN-LAST:event_jButtonCrearEstudianteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (v == true) {
            VentanaGenerarInforme ventana = new VentanaGenerarInforme();
            ventana.setVisible(true);
            v = false;
        } else {
            JOptionPane.showMessageDialog(null, "No puedes abrir otra ventana");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonModificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarDatosActionPerformed
        // TODO add your handling code here:
        if (v == true) {
            VentanaModificarDatosAdmin ventana = new VentanaModificarDatosAdmin();
            ventana.setVisible(true);
            v = false;
        } else {
            JOptionPane.showMessageDialog(null, "No puedes abrir otra ventana");
        }

    }//GEN-LAST:event_jButtonModificarDatosActionPerformed

    private void jButtonEliminarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarEstudianteActionPerformed
        // TODO add your handling code here:

        if (v == true) {
            VentanaEliminarEstudiante ventana = new VentanaEliminarEstudiante();
            ventana.setVisible(true);
            v = false;
        } else {
            JOptionPane.showMessageDialog(null, "No puedes abrir otra ventana");
        }


    }//GEN-LAST:event_jButtonEliminarEstudianteActionPerformed

    private void jButtonModificarEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarEstudianteActionPerformed
        // TODO add your handling code here:
        if (v == true) {
            VentanaModificarEstudiante ventana = new VentanaModificarEstudiante();
            ventana.setVisible(true);
            v = false;
        } else {
            JOptionPane.showMessageDialog(null, "No puedes abrir otra ventana");
        }

    }//GEN-LAST:event_jButtonModificarEstudianteActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        if (v == false) {
            JOptionPane.showMessageDialog(null, "Para salir, primero debes cerrar todas las ventanas");
        } else {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jButtonSalirActionPerformed

    /**
     * Metodo que sirve para cargar los estudiantes desde un archivo en excel
     * @param evt 
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {     
            
            
            File archivo = new File("D:\\Documentos\\NetBeansProjects\\Leer_Probar_Excel\\gracie.xlsx");
            
            
            Workbook wb;
            List celdaDato = new ArrayList();
            
            try {
                
                FileInputStream fileInputStream = new FileInputStream(archivo);
                wb = WorkbookFactory.create(fileInputStream);
                Sheet hoja = wb.getSheetAt(0);
                
                Iterator filaIterator = hoja.rowIterator();
                
                while (filaIterator.hasNext()) {
                    
                    Row fila = (Row) filaIterator.next();
                    Iterator columnaIterador = fila.cellIterator();
                    List celdaTemporal = new ArrayList();
                    
                    while (columnaIterador.hasNext()) {
                        Cell celda = (Cell) columnaIterador.next();
                        celdaTemporal.add(celda);
                    }
                    celdaDato.add(celdaTemporal);
                }

            } catch (IOException e) {
            } catch (InvalidFormatException ex) {
                Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           
            obtener(celdaDato);
            
            System.out.println("ya");
            
            
        } catch (SQLException ex) {
             Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/Escudo.png"));

        return retValue;
    }

    public static void cambiarestado(boolean cambio) {
        v = cambio;
    }
    static boolean v = true;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonBuscarEstudiante;
    private javax.swing.JButton jButtonCrearEstudiante;
    private javax.swing.JButton jButtonEliminarEstudiante;
    private javax.swing.JButton jButtonModificarDatos;
    private javax.swing.JButton jButtonModificarEstudiante;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JToolBar.Separator jSeparador1;
    private javax.swing.JToolBar.Separator jSeparador2;
    private javax.swing.JToolBar.Separator jSeparador3;
    private javax.swing.JToolBar.Separator jSeparador4;
    private javax.swing.JToolBar.Separator jSeparador5;
    private javax.swing.JToolBar.Separator jSeparador6;
    private javax.swing.JToolBar.Separator jSeparador7;
    private javax.swing.JToolBar jToolBarOpcionsAdmin;
    // End of variables declaration//GEN-END:variables

 public void obtener(List listaDatosXCelda) throws SQLException {
        List numeros = null ;
        int contador=0;
        int contadorNegativo=0;
        for (int i = 1; i < listaDatosXCelda.size(); i++) {
            String cadena = new String();
            numeros = new ArrayList();
            List listaTemporalCeldas = (List) listaDatosXCelda.get(i);
            for (int j = 17; j < listaTemporalCeldas.size(); j++) {
                Cell celda = (Cell) listaTemporalCeldas.get(j);
                
                switch (celda.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        int valor = (int) Math.round(celda.getNumericCellValue());
                        
                        numeros.add(valor);
                        break;
                    case Cell.CELL_TYPE_STRING:
                        String valorString = celda.toString();
                        if (j == listaTemporalCeldas.size() - 1) {
                            cadena += valorString;
//                    insert += "'"+celda.toString() + "'";
                        } else {
//                 insert += "'"+celda.toString() + "',";
                            cadena += valorString + ",";
                        }
                        break;
                }

                

//                System.out.println(valorString + " ");
//                System.out.println(valorString + " ");
            }
//            insert += ")";
//            System.out.println(insert);
            int grupo = 0,documento = 0,nombreGrupo = 0;
            
            for (int a = 0; a < numeros.size(); a++) {
                if(a==0){
                    grupo= (int) numeros.get(a);
                }
                if(a==1){
                    documento= (int) numeros.get(a);
                }
                if(a==2){
                    nombreGrupo= (int) numeros.get(a);
                }
            }
            
            String[] partes = cadena.split(",");
            

            String grado = partes[0];
            String apellidos = partes[1];
            String nombres = partes[2];
            String zonaAlumno = partes[3];
            String jornada = partes[4];

            System.out.println(cadena);
            System.out.println(grupo+"");
            System.out.println(documento+"");
            System.out.println(nombreGrupo+"");
            
            if(!validarDoc(documento)){
            pst = cn.prepareStatement("insert into estudiante (grupo,grado,documento,apellidos,nombres,zonaAlumno,nombreGrupo,jornada) values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, grupo);
            pst.setString(2, grado);
            pst.setInt(3, documento);
            pst.setString(4, apellidos);
            pst.setString(5, nombres);
            pst.setString(6, zonaAlumno);
            pst.setInt(7, nombreGrupo);
            pst.setString(8, jornada);
            
            int res = pst.executeUpdate();
            if (res > 0) {
                Date fecha = fechaIncio();
                try {

                    instituto.insertarRegistro(documento, fecha, fecha);
                } catch (ParseException e1) {

                    e1.printStackTrace();
                }
                contador++;
//                System.out.println("poblado exitoso");
            }} else {
                contadorNegativo++;
//                System.out.println("poblado Fallido");
            }
            
//            System.out.println(cadena);
//            System.out.println();
        }
        JOptionPane.showMessageDialog(null,"Se han registrado"+" "+contador+" estudiantes");
        JOptionPane.showMessageDialog(null,"No se pudieron registrar"+" "+contadorNegativo+" estudiantes");
    }
 
   public boolean validarDoc(int documento) {
        try {
            
            pst = cn.prepareStatement("select documento from estudiante");
            result = pst.executeQuery();
            while (result.next()) {
                int a = result.getInt("documento");
                if (a == documento) {
                    return true;
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(VentanaAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

   
     /**
     * 
     * @return 
     */
    public Date fechaIncio() {
        String date1 = "1999-05-24";
        Date fecha = java.sql.Date.valueOf(date1);
        return fecha;
    }
}
