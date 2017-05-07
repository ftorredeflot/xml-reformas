/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml.reformas;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ferran
 */
public class Presupuesto implements Serializable {

    private int idPres; //autogenerado (unique)
    private String concepto;
    private double precioN;
    private String estado;
    private double iva = 1.21;
    private double vip = 0.95;
    private int cont = 0;

    public Presupuesto(String concepto, double precioN, String estado) {
        cont++;
        this.idPres = cont;
        this.concepto = concepto;
        this.precioN = precioN;
        this.estado = estado;
    }

    public int getIdPres() {
        return idPres;
    }

    public void setIdPres(int idPres) {
        this.idPres = idPres;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getPrecioN() {
        return precioN;
    }

    public void setPrecioN(double precioN) {
        this.precioN = precioN;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioVip() {                    //Precio vip
        double vipP;
        vipP = precioN * vip;
        return vipP;
    }

    public double getIva() {                            //Precio IVA Normal
        double ivaP;
        ivaP = precioN * iva;
        return ivaP;
    }

    public double getIvaVip() {                            //Precio IVA VIP
        double ivaPV;
        ivaPV = (precioN * vip) * iva;
        return ivaPV;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Presupuesto other = (Presupuesto) obj;
        if (this.idPres != other.idPres) {
            return false;
        }
        if (Double.doubleToLongBits(this.precioN) != Double.doubleToLongBits(other.precioN)) {
            return false;
        }
        if (!Objects.equals(this.concepto, other.concepto)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        return true;
    }

    public Presupuesto() {
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}
