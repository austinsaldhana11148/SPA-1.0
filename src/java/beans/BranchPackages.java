/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Administrator
 */
public class BranchPackages {
    private int  bp_id;
    private int  b_id;
    private int  p_id;
    private float discount;

    public int getBp_id() {
        return bp_id;
    }

    public void setBp_id(int bp_id) {
        this.bp_id = bp_id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public BranchPackages() {
    }

    @Override
    public String toString() {
        return "BranchPackages{" + "bp_id=" + bp_id + ", b_id=" + b_id + ", p_id=" + p_id + ", discount=" + discount + '}';
    }
}
