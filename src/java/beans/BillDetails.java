/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Objects;

/**
 *
 * @author Austin
 */
public class BillDetails {
    private int bsd_id;
    private int ch_id;
    private String item_type;
    private int id;
    private float price;

    public BillDetails() {
    }

    public int getBsd_id() {
        return bsd_id;
    }

    public int getCh_id() {
        return ch_id;
    }

    public int getId() {
        return id;
    }

    public float getPrice() {
        return price;
    }

    public void setBsd_id(int bsd_id) {
        this.bsd_id = bsd_id;
    }

    public void setCh_id(int ch_id) {
        this.ch_id = ch_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.bsd_id;
        hash = 59 * hash + this.ch_id;
        hash = 59 * hash + Objects.hashCode(this.item_type);
        hash = 59 * hash + this.id;
        hash = 59 * hash + Float.floatToIntBits(this.price);
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
        final BillDetails other = (BillDetails) obj;
        if (this.bsd_id != other.bsd_id) {
            return false;
        }
        if (this.ch_id != other.ch_id) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.item_type, other.item_type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BillServiceDetails{" + "bsd_id=" + bsd_id + ", ch_id=" + ch_id + ", item_type=" + item_type + ", id=" + id + ", price=" + price + '}';
    }

    
}
