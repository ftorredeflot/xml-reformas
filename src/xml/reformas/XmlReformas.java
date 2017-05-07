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
                    newPresupuesto();
                    break;
                case 3:
                    mostrarPendientes();
                    break;
                case 4:
                    presupuestosCliente();
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
        System.out.println("*** GESTION REFORMAS  by torrafa***");
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
            System.out.println("Cliente :" + nombre + " no creado, ya hay un cliente con el mesmo numero de telefono");
        }

    }

    private static void newPresupuesto() {
        int ok = 0;
        int tel;
        String crear;
        Cliente clientepres = new Cliente();
        tel = InputData.pedirEntero("Introduce el Telefono de el cliente: ");
        clientepres = listaClientes.encontrarTel(tel);
        if (clientepres == null) {
            crear = InputData.pedirCadena("El cliente no existe, quieres crearlo? s = SI");
            if (crear.equals("s")) {
                newCliente();
            } else {
                return;
            }
        } else {
            String concepto;
            int precioneto;
            String estado;
            concepto = InputData.pedirCadena("Concepto: ");
            precioneto = InputData.pedirEntero("Precio Neto: ");
            do {
                estado = InputData.pedirCadena("Estado: ");
                if (estado.equals("pendiente") || estado.equals("aceptado") || estado.equals("rechazado")) {
                    ok = 1;
                }
                if (ok == 0) {
                    System.out.println("Opcion icorrecta, las opciones son: pendiente/aceptado/rechazado");
                }
            } while (ok == 0);
            Presupuesto c = new Presupuesto(concepto, precioneto, estado);
            clientepres.getListaPres().registrarPresupuesto(c);
            Clientes.grabar(listaClientes);
        }
    }

    private static void mostrarPendientes() {
        int num = 1;
        for (Cliente cliente : listaClientes.getLista()) {
            for (Presupuesto presupuesto : cliente.getListaPres().getLista()) {
                if (presupuesto.getEstado().equalsIgnoreCase("pendiente")) {
                    System.out.println("Presupuesto pendiente nº " + num);
                    System.out.println("**********************************");
                    System.out.println("Datos Cliente:");
                    System.out.println("Nombre :" + cliente.getNombre());
                    System.out.println("Apellido :" + cliente.getApellido());
                    System.out.println("Telefono :" + cliente.getTel());
                    System.out.println("**********************************");
                    System.out.println("Concepto: " + presupuesto.getConcepto());
                    System.out.println("Precio neto: " + presupuesto.getPrecioN());
                    System.out.println("----------------------------------------------");
                    num++;
                }
            }

        }
    }

    private static void presupuestosCliente() {
        int tel;
        String crear;
        Cliente clientepres = new Cliente();
        tel = InputData.pedirEntero("Introduce el Telefono del cliente: ");
        clientepres = listaClientes.encontrarTel(tel);
        if (clientepres == null) {
            crear = InputData.pedirCadena("El cliente no existe, quieres crearlo? s = SI");
            if (crear.equals("s")) {
                newCliente();
            } else {
                return;
            }
        } else {
            System.out.println("Cliente: " + clientepres.getNombre());
            System.out.println("Presupuestos: ");
            for (Presupuesto presupuesto : clientepres.getListaPres().getLista()) {
                System.out.println("Concepto: " + presupuesto.getConcepto());
                System.out.println("Precio Neto: " + presupuesto.getPrecioN());
                System.out.println("Estado: " + presupuesto.getEstado());
                System.out.println("----------------------------------------------");
            }
        }
    }
}
