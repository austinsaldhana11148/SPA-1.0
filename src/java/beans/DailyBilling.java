/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.DbDao;
import java.sql.Timestamp;

/**
 *
 * @author Administrator
 */
public class DailyBilling {
    private int ch_id;
    private int cust_id;
    private String cust_name;
    private String mobile;
    private int id;
    private String item_type;
    private String service_package_name;
    private float duration;
    private Timestamp time;
    private String pay_method;
    private float amount;
    private int e_id;
    private String emp_name;
    private String client_detail; // walkin or regular
    private int b_id;

    public DailyBilling() {
    }

    public int getCh_id() {
        return ch_id;
    }

    public void setCh_id(int ch_id) {
        this.ch_id = ch_id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
        Customer c = new DbDao().getCustomer(cust_id);
        this.setCust_name(c.getName());
        this.setMobile(c.getMobile());
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        
        if(this.item_type.equalsIgnoreCase("service")) {
            Service s = new DbDao().getService(this.id);
            this.setService_package_name(s.getService_name());
            this.setDuration(s.getService_time());
        } else if(this.item_type.equalsIgnoreCase("package")) {
            Package p = new DbDao().getPackage(this.id);
            this.setService_package_name(p.getPackage_name());
            this.setDuration(p.getNo_of_services());
        } 
    }

    public String getService_package_name() {
        return service_package_name;
    }

    public void setService_package_name(String service_package_name) {
        this.service_package_name = service_package_name;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getPay_method() {
        return pay_method;
    }

    public void setPay_method(String pay_method) {
        this.pay_method = pay_method;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
        Employee e = new DbDao().getEmployee(e_id);
        this.setEmp_name(e.getName());
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getClient_detail() {
        return client_detail;
    }

    public void setClient_detail(String client_detail) {
        this.client_detail = client_detail;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public int getB_id() {
        return b_id;
    }


    public String getItem_type() {
        return item_type;
    }

    public void setItem_type(String item_type) {
        this.item_type = item_type;
    }
    
    @Override
    public String toString() {
        return "DailyBilling{" + "ch_id=" + ch_id + ", cust_id=" + cust_id + ", cust_name=" + cust_name + ", mobile=" + mobile + ", id=" + id + ", item_type=" + item_type + ", service_package_name=" + service_package_name + ", duration=" + duration + ", time=" + time + ", pay_method=" + pay_method + ", amount=" + amount + ", e_id=" + e_id + ", emp_name=" + emp_name + ", client_detail=" + client_detail + ", b_id=" + b_id + '}';
    }
}
