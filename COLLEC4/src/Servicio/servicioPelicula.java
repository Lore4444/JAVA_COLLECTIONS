/*
 Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:

22

• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
pantalla.
• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package Servicio;


import Entidad.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


/**
 *
 * @author lorena
 */
public class servicioPelicula {
    
    private final Scanner leer=new Scanner(System.in);
    private ArrayList <Pelicula> listaDePeliculas=new ArrayList();
    
    
    public void cine(){
        
        System.out.println("*****************************************");
        
        System.out.println("******* BIENVENIDOS A CINEMAEGG *********");
        
        System.out.println("*****************************************");
        System.out.println("");
   
        int opc;
    do {
            
            opc=menu();
          switch (opc) {

                case 1:
                    System.out.println("");
                    Pelicula peli=crearPelicula();
                    listaDePeliculas.add(peli);
                    break;
                    
                case 2:
                    System.out.println("");
                    System.out.println("** CARTELERA DE PELICULAS **");
                    for (Pelicula peliList:listaDePeliculas) {
                        System.out.println(peliList);
                    }
                    break;
                    
                case 3:
                    System.out.println("");
                    pelisHora();
                    break;
                    
                case 4:
                    System.out.println("");
                    ordenarPorDuracionMayor();
                    break;
                    
                case 5:
                    System.out.println("");
                    ordenarPorDuracionMenor();
                    break;
                    
                case 6:
                    System.out.println("");
                    ordenarPorTitulo();
                    break;
                    
                case 7:
                    System.out.println("");
                    ordenarPorDirector();
                    break;
                    
                case 8:
                    System.out.println("");
                    System.out.println("GRACIAS POR VISITARNOS");
                    System.out.println("Hasta la proxima!!");
                    
    }
    
            
        } while (opc!=8);
        
    }
    
    
    
    public int menu(){
        
        System.out.println("");
        System.out.println("ELIJA UNA DE LAS OPCIONES");
        System.out.println("1-Crear una pelicula");
        System.out.println("2-Mostrar todas las peliculas");
        System.out.println("3-Mostrar las peliculas con una duracion mayor a 1 hora");
        System.out.println("4-Mostrar las peliculas en orden ascendente de duracion");
        System.out.println("5-Mostrar las peliculas en orden descendente de duracion");
        System.out.println("6-Mostrar las peliculas alfabeticamente por titulo");
        System.out.println("7-Mostrar las peliculas alfabeticamente por director");
        System.out.println("8-Salir");
        return leer.nextInt();
        
    }
    
    public Pelicula crearPelicula(){
        
        System.out.println("NUEVA PELICULA");
        
        Pelicula nuevaPelicula=new Pelicula();
        
        System.out.println("Ingrese el titulo de la pelicula");
        String a=leer.nextLine();
        nuevaPelicula.setTitulo(leer.nextLine());
        System.out.println("Ingrese el director de la pelicula");
        nuevaPelicula.setDirector(leer.nextLine());
        System.out.println("Ingrese la duracion de la pelicula en horas");
        nuevaPelicula.setDuracion(leer.nextInt());
        return nuevaPelicula;
        
    }
    
    //Peliculas con una duracion mayor a 1 hora
    
    public void pelisHora(){
        
        System.out.println("DURACION DE LAS PELICULAS");
        
        
        //forma con for each
//        ArrayList<Pelicula> listaPelisMasHora = new ArrayList();
//        
//        
//        boolean peli=false;
//        
//        
//        for (Pelicula pelisMasHora: listaDePeliculas){
//            
//            if (pelisMasHora.getDuracion()>=1) {
//                
//                listaPelisMasHora.add(pelisMasHora);
//                peli=true;
//                
//            }else{
//  
//                if(peli==false){
//                    System.out.println("No hay peliculas con una duracion mayor a 1 hora");
//                }else{
//                    System.out.println("Las peliculas con una duracion mayor a 1 hora son: ");
//                     for (Pelicula pelis: listaPelisMasHora){
////                         System.out.println(pelis);
//                         
//                         System.out.println(pelis.getTitulo());
//                     }
//                    
//                }
//            
//        }

            
            //Otra forma con iterator
            
        Iterator<Pelicula> pelisMasHora = listaDePeliculas.iterator();

        int cont = 0;
        ArrayList<Pelicula> listaPelisMasHora = new ArrayList();
        while (pelisMasHora.hasNext()) {

            Pelicula a = pelisMasHora.next();

            if (a.getDuracion() > 1) {
                cont = cont + 1;
                listaPelisMasHora.add(a);

            }

        }
        if (cont > 1) {
            System.out.println("Las peliculas con una duracion mayor a 1 hora son: ");

             for (Pelicula peliLista:listaPelisMasHora) {
                        System.out.println(peliLista);
                    }
            
        }else{
            System.out.println("No hay peliculas con una duracion mayor o de 1 hora");
    }
}

   //}
   
    
    //Ordenar alfabeticamente por titulo
    
    public void ordenarPorTitulo() {

        //Se puede usar el treeset para ordenar pero borra los titulos iguales
        
        //        Set<Pelicula> ordenTitulo = new TreeSet<>();
//
//        Iterator<Pelicula> pelisTitulo = listaDePeliculas.iterator();
//
//        while (pelisTitulo.hasNext()) {
//
//            Pelicula b = pelisTitulo.next();
//            ordenTitulo.add(b);
//
//        }
//
//        System.out.println("LISTA DE PELICULAS ORDENADAS POR TITULO ");
//        for (Pelicula lista : ordenTitulo) {
//            System.out.println(lista);
//        }
        Collections.sort(listaDePeliculas, Pelicula.ordenTitulo);
        System.out.println(" LISTA DE PELICULAS ORDENADAS POR TITULO ");
        for (Pelicula lista : listaDePeliculas) {
            System.out.println(lista);

        }
    }
    
    //Ordenar alfabeticamente por director
    
    public void ordenarPorDirector(){

        Collections.sort(listaDePeliculas, Pelicula.ordenDirector);
        System.out.println(" LISTA DE PELICULAS ORDENADAS POR DIRECTOR ");
        for (Pelicula lista : listaDePeliculas) {
//            System.out.println(lista);
            System.out.println(Pelicula.getOrdenDirector());
    }
//        System.out.println(Pelicula.getOrdenDirector());
}
    
    //Ordenar por duracion de menor a mayor
    
    public void ordenarPorDuracionMayor(){
        
        Collections.sort(listaDePeliculas, Pelicula.ordenDuracion);
        System.out.println(" LISTA DE PELICULAS ORDENADAS POR DURACION EN FORMA ASCENDENTE ");
        for (Pelicula lista : listaDePeliculas) {
            System.out.println(lista);
        
    }
}
    
    //Ordenar por duracion de mayor a menor
    
    public void ordenarPorDuracionMenor(){
        
        //no funciona bien con double
        
//        Collections.sort(listaDePeliculas, new OrdenDuracion2());
//        System.out.println(" LISTA DE PELICULAS ORDENADAS POR DURACION EN FORMA DESCENDENTE");
//        for (Pelicula lista : listaDePeliculas) {
//            System.out.println(lista);
//        
//    }


        Collections.sort(listaDePeliculas, Pelicula.mayorMenor);
 
        for (Pelicula lista : listaDePeliculas) {
            System.out.println(lista);
        }
        
        
}
}

