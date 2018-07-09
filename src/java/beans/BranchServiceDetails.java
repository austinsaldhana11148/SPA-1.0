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
public class BranchServiceDetails {
    int bs_id;
    int b_id;
    int s_id;
    String service_name;
    float price;
    float discount;
    float total;

    public BranchServiceDetails() {
    }

    public int getBs_id() {
        return bs_id;
    }

    public void setBs_id(int bs_id) {
        this.bs_id = bs_id;
    }

    public int getB_id() {
        return b_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
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
        setTotal(this.price - this.discount);
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "BranchServiceDetails{" + "bs_id=" + bs_id + ", b_id=" + b_id + ", s_id=" + s_id + ", service_name=" + service_name + ", price=" + price + ", discount=" + discount + ", total=" + total + '}';
    }
    
}
