
package Modelo;

/**
 * @author leobm
 */

public class Lista {
    
    Nodo ultimo;
    Nodo inicio;
    Nodo actual;
    int tamaño;

    public void agregarLista_Cola(String nombre, String apellido, int edad, int matricula){
        Alumno ObjAlumno= new Alumno(nombre,apellido,edad,matricula);
        Nodo nuevo = new Nodo(ObjAlumno);
        if (inicio == null) {
            ultimo = nuevo;
            inicio = ultimo;
            System.out.println("Lista_Cola");
            System.out.println(ObjAlumno);
            tamaño++;
        }else{
            ultimo.setSig(nuevo);
            nuevo.setAnt(ultimo);
            ultimo = nuevo;
            System.out.println("Lista_Cola");
            System.out.println(ObjAlumno);
            tamaño++;
        }
    }
    
    public void agregarPila(String nombre, String apellido, int edad, int matricula){
        Alumno ObjAlumno= new Alumno(nombre,apellido,edad,matricula);
        Nodo nuevo = new Nodo(ObjAlumno);
        if (inicio == null) {
            inicio = nuevo;
            ultimo = inicio;
            System.out.println("Pila");
            System.out.println(ObjAlumno);
            tamaño++;
        }else{
            inicio.setAnt(nuevo);
            nuevo.setSig(inicio);
            inicio = nuevo;
            System.out.println("Pila");
            System.out.println(ObjAlumno);
            tamaño++;
        }
    }
    
    public String buscar(int dato) {
        actual = inicio;
        boolean encontrado = false;
        String impresion = "";
        while (actual != null && encontrado != true) {
            if (actual.getDato().getMatricula() == dato) {
                impresion += "Nombre: " + actual.getDato().getNombre() + "\n";
                impresion += "Apellido: " + actual.getDato().getApellido() + "\n";
                impresion += "Edad: " + actual.getDato().getEdad() + "\n";
                impresion += "Matricula " + actual.getDato().getMatricula() + "\n";
                encontrado = true;
            } else {
                actual = actual.sig;
            }
        }
        return impresion;
    }
    
    public String eliminarLista(int dato) {
        actual = inicio;
        boolean encontrado = false;
        String impresion = "";
        while (actual != null && encontrado != true) {
            if (actual.getDato().getMatricula() == dato) {
                        if (actual.getDato().getMatricula() == inicio.getDato().getMatricula()) {
                        eliminarPila();
                    } else if (actual.getDato().getMatricula() == ultimo.getDato().getMatricula()) {
                        eliminarCola();
                    } else {
                        actual.getAnt().setSig(actual.getSig());
                        actual.getSig().setAnt(actual.getAnt());
                    }
                encontrado = true;
            } else {
                actual = actual.sig;
            }
        }
        return impresion;
    }       
    
    public int eliminarPila(){
        if (inicio == null) {
            return 1;
        }else{
            if (inicio.getSig() == null) {
                inicio = null;
                ultimo = inicio;
            }
            else{
                inicio = inicio.getSig();
                inicio.setAnt(null);
            }
            return 0;
        }
    }
    
    public int eliminarCola(){
        if (inicio == null) {
            return 1;
        }else{
            if (ultimo.getAnt() == null) {
                ultimo = null;
                inicio = ultimo;
            }
            else{
                ultimo = ultimo.getAnt();
                ultimo.setSig(null);
            }
            return 0;
        }
    }
    
    public String imprimir() {
        String cadena = "Lista:\n";
        Nodo aux = inicio;
        int n = 1;
        while (aux != null) {
            cadena += "No°: " + n + "\n";
            cadena += "Nombre: " + aux.getDato().getNombre() + "\n";
            cadena += "Apellido: " + aux.getDato().getApellido() + "\n";
            cadena += "Edad: " + aux.getDato().getEdad() + "\n";
            cadena += "Matricula:" + aux.getDato().getMatricula() + "\n\n";
            n++;
            aux = aux.getSig();
        }
        return cadena;
    }
   
    public void irInicio() {
        if (!(inicio == null)) {
            actual = inicio;
        }
    }
    
    public void reiniciar(){
        inicio = null;
        ultimo = null;
        actual = null;
    }
}
