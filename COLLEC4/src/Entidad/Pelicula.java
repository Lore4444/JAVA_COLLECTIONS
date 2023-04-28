/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

import java.util.Comparator;



/**
 *
 * @author lorena
 */
public class Pelicula implements Comparable<Pelicula> {
    
// Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
//tendremos una clase Pelicula con el título, director y duración de la película (en horas).
//Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
//que se pide a continuación:
    
   private String titulo;
   private String director;
   private int duracion;

    public Pelicula() {
    }

    public Pelicula(String titulo, String director, int duracion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public static Comparator<Pelicula> getOrdenTitulo() {
        return ordenTitulo;
    }

    public static void setOrdenTitulo(Comparator<Pelicula> ordenTitulo) {
        Pelicula.ordenTitulo = ordenTitulo;
    }

    public static Comparator<Pelicula> getOrdenDirector() {
        return ordenDirector;
    }

    public static void setOrdenDirector(Comparator<Pelicula> ordenDirector) {
        Pelicula.ordenDirector = ordenDirector;
    }

    public static Comparator<Pelicula> getOrdenDuracion() {
        return ordenDuracion;
    }

    public static void setOrdenDuracion(Comparator<Pelicula> ordenDuracion) {
        Pelicula.ordenDuracion = ordenDuracion;
    }

    public static Comparator<Pelicula> getMayorMenor() {
        return mayorMenor;
    }

    public static void setMayorMenor(Comparator<Pelicula> mayorMenor) {
        Pelicula.mayorMenor = mayorMenor;
    }

    

   
    @Override
    public String toString() {
        return " * PELICULA " + "Titulo: " + titulo + ", Director: " + director + ", Duracion: " + duracion+ " horas"+" * ";
    }
  
    //Comparar con TreeSet, de acuerdo al atributo que colocamos
    @Override
    public int compareTo(Pelicula o) {
        return this.titulo.compareTo(o.titulo);
    }

    //Comparar con metodo Comparator (TITULO)
     public static Comparator<Pelicula> ordenTitulo = new Comparator<Pelicula>() {

        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getTitulo().toLowerCase().compareTo(o2.getTitulo().toLowerCase());

        }
    };
     
    //Comparar con metodo Comparator (DIRECTOR)
    public static Comparator<Pelicula> ordenDirector = new Comparator<Pelicula>() {

        public int compare(Pelicula o1, Pelicula o2) {
            return o1.getDirector().toLowerCase().compareTo(o2.getDirector().toLowerCase());

        }
    };

    //Comparar con metodo Comparator (DURACION DE MENOR A MAYOR)
    public static Comparator<Pelicula> ordenDuracion = new Comparator<Pelicula>() {
        
        public int compare(Pelicula o1, Pelicula o2) {

            //cuando puse el atributo duracion como double:
//            double a = o1.getDuracion();
//            double b = o2.getDuracion();
//
//            int c = (int) a;
//            int d = (int) b;
//            //return c - d;
//
//            return Integer.compare(c, d);

//return o1.getDuracion().compareTo(o2.getDuracion());// Esta forma no funciona

            //dos formas que se pueden poner para el return:
//1
//return o1.getDuracion()-o2.getDuracion();
//2
return Integer.compare(o1.getDuracion(), o2.getDuracion());
        }
    };

  
    public static Comparator<Pelicula> mayorMenor=new Comparator<Pelicula>(){
        
        public int compare(Pelicula s1,Pelicula s2){
            int a=(int)s1.getDuracion();
            int b=(int)s2.getDuracion();
            return b-a;
        }
        
    } ;
    
}
