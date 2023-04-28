/*
 Crear una clase llamada Alumno que mantenga información sobre las notas de distintos
alumnos. La clase Alumno tendrá como atributos, su nombre y una lista de tipo Integer
con sus 3 notas.
En el servicio de Alumno deberemos tener un bucle que crea un objeto Alumno. Se pide
toda la información al usuario y ese Alumno se guarda en una lista de tipo Alumno y se le
pregunta al usuario si quiere crear otro Alumno o no.
Después de ese bucle tendremos el siguiente método en el servicio de Alumno:
Método notaFinal(): El usuario ingresa el nombre del alumno que quiere calcular su nota
final y se lo busca en la lista de Alumnos. Si está en la lista, se llama al método. Dentro
del método se usará la lista notas para calcular el promedio final de alumno. Siendo este
promedio final, devuelto por el método y mostrado en el main..
 */
package Servicio;

import Entidad.Alumno;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author lorena
 */
public class servicioAlumno {

    private final Scanner leer = new Scanner(System.in);

    private final ArrayList<Alumno> listaAlumnos = new ArrayList<>();

    public void crearAlumno() {

        int opc;

        do {

            opc = menu();

            switch (opc) {

                case 1:
                    Alumno alumnos = new Alumno();
                    System.out.println("Ingrese el nombre del alumno");

                    alumnos.setNombre(leer.next());

                    for (int i = 0; i < 3; i++) {

                        System.out.println("Ingrese la nota numero " + (i + 1) + " del alumno");

                        alumnos.getNotas().add(leer.nextDouble());

                    }

                    listaAlumnos.add(alumnos);

                    break;

                case 2:
                    System.out.println("Salir");
                    break;

                default:
                    System.out.println("Opcion incorrecta");

            }

        } while (opc != 2);

    }

    public static int menu() {

        Scanner leer = new Scanner(System.in);
        System.out.println("QUIERE CREAR UN ALUMNO");
        System.out.println("1-Si");
        System.out.println("2-No");

        return leer.nextInt();

    }

    public void mostrarAlumnos() {

//      System.out.println(listaAlumnos);   //Sale el lugar pero no el dato
//        Iterator<Alumno> iteratorAlumnos = listaAlumnos.iterator();
//
//        while (iteratorAlumnos.hasNext()) {
//
//            Alumno a = iteratorAlumnos.next();
//
//            System.out.println(a.getNombre());
//            System.out.println(a.getNotas());
//           
//        }
//        
        for (Alumno lista : listaAlumnos) {
            System.out.println(lista.getNombre());
            System.out.println(lista.getNotas());
        }

    }

    public void notaFinal() {

        Iterator<Alumno> iteratorAlumnos = listaAlumnos.iterator();

        System.out.println("Ingrese el nombre del alumno para calcular su nota final");
        String nombreAlumno = leer.next();
        double sumaNotas = 0;
        double promedio = 0;
        double cantidad=0;


        while (iteratorAlumnos.hasNext()) {

            Alumno a = iteratorAlumnos.next();
            cantidad = a.getNotas().size();
            if (a.getNombre().equals(nombreAlumno)) {

                for (Double notas : a.getNotas()) {
                    sumaNotas += notas;
                }

            }

        }

        if (sumaNotas == 0) {
            System.out.println("El nombre ingresado no es un alumno");
        } else {
            promedio = sumaNotas / cantidad;

            System.out.println("El promedio de las notas es " + promedio);
        }
    }
}
