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
public class ListaPresupuestos implements Serializable{
      public ArrayList<Presupuesto> listaPres;
    
    public ListaPresupuestos(){
        listaPres = new ArrayList<>();
    }
    
    public void registrarPresupuesto (Presupuesto n){
        listaPres.add(n);
    }

    public ArrayList<Presupuesto> getLista() {
        return listaPres;
    }

    public void setLista(ArrayList<Presupuesto> lista) {
        this.listaPres = lista;
    }  
    
}
