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
package Servicio;

import Entidad.Paises;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author lorena
 */
public class servicioPais {
    
    HashSet<Paises> listaPaises=new HashSet();
    
    Scanner leer=new Scanner (System.in);
    
    public void ingresarPaises(){
//        Paises paises=new Paises();
        String opcion="";
        
        
        do {
            Paises paises=new Paises();
//            String a=leer.nextLine();
            System.out.println("Ingrese el nombre del pais");
            paises.setPais(leer.next());
             listaPaises.add(paises);
            System.out.println("Desdea agregar otro pais? s/n");
            opcion=leer.next();
            
            
        } while (opcion.equalsIgnoreCase("s"));
        
//        listaPaises.add(paises);
    }
    
    public void mostrarPaises(){
        System.out.println("PAISES ");
        for(Paises paises:listaPaises){
            System.out.println(paises);
        }
    }
    
    public void ordenarPaises(){
        System.out.println("PAISES ORDENADOS");
        ArrayList<Paises>ordenPais=new ArrayList(listaPaises);
        Collections.sort(ordenPais,Paises.ordenPaises);
        
        for(Paises listaOrdenada:ordenPais){
            System.out.println(listaOrdenada);
        }
        
    }
    
    public void eliminarPais(){
        
        System.out.println("Ingresar el nombre del pais a eliminar");
        String nombre=leer.next();
        
        Iterator<Paises> paisEliminar = listaPaises.iterator();
        int a=0;
        while (paisEliminar.hasNext()) {

            Paises b=paisEliminar.next();
            if(b.getPais().equals(nombre)){
                paisEliminar.remove();
                a++;
            }
       
        }
        
        if(a==0){
            System.out.println("El pais no se encontro");
        }else{
            System.out.println("Los paises actualizados son");
            
            for(Paises listaPaisesActualizadas:listaPaises){
                System.out.println(listaPaisesActualizadas);
            }
        }
    }
}
