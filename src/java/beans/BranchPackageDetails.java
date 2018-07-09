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
public class BranchPackageDetails {
    int bp_id;
    int b_id;
    int p_id;
    String package_name;
    float price;
    float discount;
    float total;

    public BranchPackageDetails() {
    }

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

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
        this.setTotal(this.price);
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
        setTotal(this.price-this.discount);
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BranchPackageDetails{" + "bp_id=" + bp_id + ", b_id=" + b_id + ", p_id=" + p_id + ", package_name=" + package_name + ", price=" + price + ", discount=" + discount + ", total=" + total + '}';
    }
    
    
}
