package xml.reformas;

import java.io.Serializable;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ferran
 */
public class Cliente implements Serializable{
      private String nombre;
    private String apellido;
    private int tel; //unique
    private boolean VIP;
    private ListaPresupuestos listaPres;

    public Cliente(String nombre, String apellido, int tel, boolean VIP) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tel = tel;
        this.VIP = VIP;
        listaPres = new ListaPresupuestos();
    }

    public Cliente() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public ListaPresupuestos getListaPres() {
        return listaPres;
    }

    public void setListaPres(ListaPresupuestos listaPres) {
        this.listaPres = listaPres;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.apellido);
        hash = 41 * hash + this.tel;
        hash = 41 * hash + (this.VIP ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.listaPres);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.tel != other.tel) {
            return false;
        }
        if (this.VIP != other.VIP) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.listaPres, other.listaPres)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", tel=" + tel + ", VIP=" + VIP + ", listaPres=" + listaPres + '}';
    }

    
}
