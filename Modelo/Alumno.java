
package Modelo;

/**
 * @author leobm
 */
public class Alumno {
    
    String nombre, apellido;
    int edad, matricula;

    public Alumno(String nombre, String apellido, int edad, int matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
 
}
