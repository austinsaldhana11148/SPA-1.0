/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Austin
 */
public class BranchServices {
    
    private int  bs_id;
    private int  b_id;
    private int  s_id;
    private float discount;

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public BranchServices() {
    }

    
    public int getBs_id() {
        return bs_id;
    }

    public int getB_id() {
        return b_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setBs_id(int bs_id) {
        this.bs_id = bs_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.bs_id;
        hash = 53 * hash + this.b_id;
        hash = 53 * hash + this.s_id;
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
        final BranchServices other = (BranchServices) obj;
        if (this.bs_id != other.bs_id) {
            return false;
        }
        if (this.b_id != other.b_id) {
            return false;
        }
        if (this.s_id != other.s_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BranchServices{" + "bs_id=" + bs_id + ", b_id=" + b_id + ", s_id=" + s_id + ", discount=" + discount + '}';
    }


    
}
