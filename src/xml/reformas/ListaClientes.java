/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.reformas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author ferran
 */
public class ListaClientes implements Serializable {
      private ArrayList<Cliente> lista;
    
    public ListaClientes(){
        lista = new ArrayList<>();
    }

    public ArrayList<Cliente> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Cliente> lista) {
        this.lista = lista;
    }
    
    public Cliente encontrarTel(int tel){
    for(Cliente cliente : lista){
        if(cliente.getTel() == tel){
            return cliente;
        }
    }
        return null;
    }
    
     public void altaCliente(Cliente newcliente){
     lista.add(newcliente);
 }

    
    
}
