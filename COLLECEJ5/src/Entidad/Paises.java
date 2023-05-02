/*
 Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
los servicios en la clase correspondiente)
Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
cómo se ordena un conjunto.
Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
al usuario.
 */
package Entidad;

import java.util.Comparator;

/**
 *
 * @author lorena
 */
public class Paises {
    
    private String pais;

    public Paises() {
    }

    public Paises(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "PAISES: " + "pais= " + pais;
        
        
    }
    
    public static Comparator<Paises> ordenPaises = new Comparator<Paises>() {

        public int compare(Paises o1, Paises o2) {
            return o1.getPais().toLowerCase().compareTo(o2.getPais().toLowerCase());

        }
    };
    
}
