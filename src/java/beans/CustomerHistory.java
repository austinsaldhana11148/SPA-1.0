/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.sql.Timestamp;
import java.util.Objects;
/**
 *
 * @author Austin
 */
public class CustomerHistory {
    private int ch_id;
    private int c_id;
    private int b_id;
    private int e_id;
    private Timestamp date;
    private float total_price;

    public CustomerHistory(int ch_id, int c_id, int b_id, int e_id, Timestamp date, float total_price) {
        this.ch_id = ch_id;
        this.c_id = c_id;
        this.b_id = b_id;
        this.e_id = e_id;
        this.date = date;
        this.total_price = total_price;
    }

    public CustomerHistory() {
    }

    
    public int getCh_id() {
        return ch_id;
    }

    public int getC_id() {
        return c_id;
    }

    public int getB_id() {
        return b_id;
    }

    public int getE_id() {
        return e_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setCh_id(int ch_id) {
        this.ch_id = ch_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.ch_id;
        hash = 41 * hash + this.c_id;
        hash = 41 * hash + this.b_id;
        hash = 41 * hash + this.e_id;
        hash = 41 * hash + Objects.hashCode(this.date);
        hash = 41 * hash + Float.floatToIntBits(this.total_price);
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
        final CustomerHistory other = (CustomerHistory) obj;
        if (this.ch_id != other.ch_id) {
            return false;
        }
        if (this.c_id != other.c_id) {
            return false;
        }
        if (this.b_id != other.b_id) {
            return false;
        }
        if (this.e_id != other.e_id) {
            return false;
        }
        if (Float.floatToIntBits(this.total_price) != Float.floatToIntBits(other.total_price)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerServiceHistory{" + "ch_id=" + ch_id + ", c_id=" + c_id + ", b_id=" + b_id + ", e_id=" + e_id + ", date=" + date + ", total_price=" + total_price + '}';
    }
    
}
