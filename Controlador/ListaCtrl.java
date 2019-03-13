
package Controlador;
import Vista.ListaJframe;
import Modelo.Lista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * @author leobm
 */
public class ListaCtrl implements ActionListener{
    
    ListaJframe vista;
    Lista lista;
    
    public ListaCtrl(ListaJframe vista, Lista lista){
        
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnMostrar.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnReiniciar.addActionListener(this);
        this.vista.opcioncbx.addActionListener(this);
        
        this.lista = lista;
        
    }

    public void limpiarCampos(){
        this.vista.InputNombre.setText("");
        this.vista.InputApellido.setText("");
        this.vista.InputEdad.setText("");
        this.vista.InputMatricula.setText("");
        this.vista.InputNombre.requestFocus();
    }    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == this.vista.btnAgregar) {
            if (this.vista.opcioncbx.getSelectedItem().equals("Lista")) {
                this.lista.agregarLista_Cola(this.vista.InputNombre.getText(), this.vista.InputApellido.getText(),
                                                Integer.parseInt(this.vista.InputEdad.getText()),
                                                Integer.parseInt(this.vista.InputMatricula.getText()));
                this.lista.irInicio();
            } else if (this.vista.opcioncbx.getSelectedItem().equals("Pila")) {
                this.lista.agregarPila(this.vista.InputNombre.getText(), this.vista.InputApellido.getText(),
                                            Integer.parseInt(this.vista.InputEdad.getText()),
                                            Integer.parseInt(this.vista.InputMatricula.getText()));
                this.lista.irInicio();
            } else if (this.vista.opcioncbx.getSelectedItem().equals("Cola")){
                this.lista.agregarLista_Cola(this.vista.InputNombre.getText(), this.vista.InputApellido.getText(),
                                                Integer.parseInt(this.vista.InputEdad.getText()),
                                                Integer.parseInt(this.vista.InputMatricula.getText()));
                this.lista.irInicio();
            }
            limpiarCampos();
        }
        
        if (ae.getSource() == this.vista.btnMostrar) {
            this.vista.imprimir.setText(this.lista.imprimir());
        }
        
        if (ae.getSource() == this.vista.btnBuscar) {
            if (this.vista.opcioncbx.getSelectedItem().equals("Lista")) {
                this.vista.imprimir.setText(this.lista.buscar(Integer.parseInt(this.vista.InputMatricula.getText())));
            } else if (this.vista.opcioncbx.getSelectedItem().equals("Pila")) {
                this.vista.imprimir.setText(this.lista.buscar(Integer.parseInt(this.vista.InputMatricula.getText())));
            } else if (this.vista.opcioncbx.getSelectedItem().equals("Cola")){
                this.vista.imprimir.setText(this.lista.buscar(Integer.parseInt(this.vista.InputMatricula.getText())));
            }
        }
        
        if (ae.getSource() == this.vista.btnEliminar) {
            if (this.vista.opcioncbx.getSelectedItem().equals("Lista")) {
                int Eliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la matricula del alumno a eliminar: "));
                this.lista.eliminarLista(Eliminar);
                this.vista.imprimir.setText("");
            } else if (this.vista.opcioncbx.getSelectedItem().equals("Pila")) {
                this.lista.eliminarPila();
                this.vista.imprimir.setText("");
            } else if (this.vista.opcioncbx.getSelectedItem().equals("Cola")){
                this.lista.eliminarCola();
                this.vista.imprimir.setText("");
            }  
        }
        
        if (ae.getSource() == this.vista.btnReiniciar) {
            this.lista.reiniciar();
            this.vista.imprimir.setText("");
            limpiarCampos();
            JOptionPane.showMessageDialog(null, "Reinicio Exitoso");
        }
        
    }
}
