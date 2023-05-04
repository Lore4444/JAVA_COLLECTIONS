/*
 Se necesita una aplicación para una tienda en la cual queremos almacenar los distintos
productos que venderemos y el precio que tendrán. Además, se necesita que la
aplicación cuente con las funciones básicas.
Estas las realizaremos en el servicio. Como, introducir un elemento, modificar su precio,
eliminar un producto y mostrar los productos que tenemos con su precio (Utilizar
Hashmap). El HashMap tendrá de llave el nombre del producto y de valor el precio.
Realizar un menú para lograr todas las acciones previamente mencionadas.
 */
package Servicio;

import Entidad.Producto;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lorena
 */
public class servicioProducto {
    
    Scanner leer = new Scanner(System.in);
    Producto nuevoProducto=new Producto();
    
    
    public int menu(){
        System.out.println("**************************************************");
        System.out.println("ELIJA UNA OPCION");
        System.out.println("1-Ingresar un nuevo producto");
        System.out.println("2-Modificar el precio del producto");
        System.out.println("3-Eliminar un producto");
        System.out.println("4-Mostrar los productos con su precio");
        System.out.println("5-Salir");
        System.out.println("**************************************************");
        
        return leer.nextInt();
        
    }
    
    public void tienda() {

        int opcion;

        do {
            opcion = menu();

            switch (opcion) {

                case 1:
                    System.out.println("NUEVO PRODUCTO");
                    crearProducto();
                    break;
                case 2:
                    System.out.println("MODIFICAR PRECIO");
                    modificarPrecio();
                    break;
                case 3:
                    System.out.println("ELIMINAR PRODUCTO");
                    eliminarProducto();
                    break;
                case 4:
                    System.out.println("MOSTRAR PRODUCTOS");
                    mostrarProductos();
                    break;
                case 5:
                    System.out.println("GRACIAS POR SU VISITA");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
            } while (opcion != 5);

        }
        
  
    public void crearProducto(){
        String p=leer.nextLine();
        
        System.out.println("Ingrese un nuevo producto");
        String nombreP=leer.nextLine();
        
        
        System.out.println("Ingrese el valor del producto");
        double precio=leer.nextDouble();
        
        nuevoProducto.setProductoNuevo(nombreP, precio);
        System.out.println(nuevoProducto.toString());
    }
    
    public void modificarPrecio(){
        
        System.out.println("Ingrese el producto al cual desea modificar su precio");
        String producto=leer.next();
        
        //una forma
//        for (Map.Entry<String, Double> entry:nuevoProducto.getProductoNuevo().entrySet()){
//               if(entry.getKey().equals(producto)){
//                System.out.println("Ingrese el nuevo precio");
//                nuevoProducto.setProductoNuevo(producto, leer.nextDouble());
//            }
//        }
        
        //otra forma
        if(nuevoProducto.getProductoNuevo().containsKey(producto)){
            System.out.println("Ingrese el nuevo precio del producto");
            nuevoProducto.setProductoNuevo(producto, leer.nextDouble());
            
        }else{
            System.out.println("El producto no se encuentra");
        }
        
    }
    
    public void mostrarProductos(){
        
        int x=1;
        for (Map.Entry<String, Double> entry:nuevoProducto.getProductoNuevo().entrySet()){
            System.out.println("PRODUCTO N°: "+ x+" "+entry.getKey()+" valor: "+entry.getValue());
            x++;
        }
        
    }
    
    public void eliminarProducto(){
        
        System.out.println("Ingrese el producto que desea eliminar");
        String producto=leer.next();
        if(nuevoProducto.getProductoNuevo().containsKey(producto)){
            nuevoProducto.getProductoNuevo().remove(producto);
            
        }else{
            System.out.println("El producto no se encuentra");
        }
        
    }
}
