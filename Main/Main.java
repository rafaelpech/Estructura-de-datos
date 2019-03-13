
package Main;
import Modelo.Lista;
import Vista.ListaJframe;
import Controlador.ListaCtrl;

/**
 *
 * @author leobm
 */

public class Main {
    
    public static void main(String[] args) {
        
        ListaJframe vista = new ListaJframe();
        Lista nuevaLista = new Lista();
        ListaCtrl ctrlListaAlumno = new ListaCtrl(vista, nuevaLista);
        
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);    
        
    }
}
