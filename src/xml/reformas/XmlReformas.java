/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.reformas;

import java.io.Serializable;
import tools.Fichero;
import tools.InputData;
import java.util.ArrayList;

/**
 *
 * @author ferran
 */
public class XmlReformas implements Serializable {

    
        private static ListaClientes listaClientes;
    //la classe fichero viene de tools
    private static Fichero Clientes;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Clientes = new Fichero("bbdd.xml");
         //carrego les dades
         listaClientes = (ListaClientes) Clientes.leer();
         // Si nohi ha dades ho inicialitzo
        if (listaClientes == null) {
            listaClientes = new ListaClientes();
        }
           
         int opcion;
        do {
            mostrarMenu();
            opcion = InputData.pedirEntero("Escoge una opción");
            switch (opcion) {
                case 1:
                    newCliente();
                    break;
                case 2:
                    //nuevoPresupuesto();
                    break;
                case 3:
                    //mostrarPendientes();
                    break;
                case 4:
                    //presupuestosCliente();
                    break;
                case 5:
                    //presupuestosRechazados();
                    break;
                case 6:
                    //clientesNPres();
                    break;
                case 7:
                    //estadoPresupuesto();
                    break;
                case 0:
                    System.out.println("Hasta luego!!");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("*** GESTION REFORMAS ***");
        System.out.println("1.- Alta Cliente");
        System.out.println("2.- Nuevo Presupuesto");
        System.out.println("3.- Presupuestes pendientes (de aceptar o rechazar)");
        System.out.println("4.- Listado presupuestos de un cliente determinado");
        System.out.println("5.- Listado de presupuestos rechazados");
        System.out.println("6.- Listado de clientes, con total de presupuestos");
        System.out.println("7.- Cambiar estado presupuesto");
        System.out.println("0.- Salir");
    }
    
        private static void newCliente() {
        String nombre;
        String apellido;
        int tel;
        String vip;
        boolean vipb = false;
        Cliente newcliente = new Cliente();
        nombre = InputData.pedirCadena("Nombre :");
        apellido = InputData.pedirCadena("Apellido: ");
        tel = InputData.pedirEntero("Telefono :");
        newcliente = listaClientes.encontrarTel(tel);
        if (newcliente == null) {
            vip = InputData.pedirCadena("El cliente es vip? s- SI n-NO");
            if (vip.equals("s")) {
                vipb = true;
            }
            newcliente = new Cliente(nombre, apellido, tel, vipb);
            listaClientes.altaCliente(newcliente);
            Clientes.grabar(listaClientes);
        } else {
            System.out.println("Cliente :" +nombre +" no creado, ya hay un cliente con el mesmo numero de telefono");
        }

    }
    
}
