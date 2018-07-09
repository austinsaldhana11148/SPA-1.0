/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Timestamp;

/**
 *
 * @author Administrator
 */
public class CustomerPackagesInfo {
    private int cp_id;
    private int c_id;
    private int package_id;
    private Timestamp start_date;
    private int services_left;
    private String package_name;
    private int s_id;
    private int no_of_services;
    private int duration;
    private float rate;

    public CustomerPackagesInfo() {
    }

    public int getCp_id() {
        return cp_id;
    }

    public void setCp_id(int cp_id) {
        this.cp_id = cp_id;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public int getPackage_id() {
        return package_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public int getServices_left() {
        return services_left;
    }

    public void setServices_left(int services_left) {
        this.services_left = services_left;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public int getNo_of_services() {
        return no_of_services;
    }

    public void setNo_of_services(int no_of_services) {
        this.no_of_services = no_of_services;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "CustomerPackagesInfo{" + "cp_id=" + cp_id + ", c_id=" + c_id + ", package_id=" + package_id + ", start_date=" + start_date + ", services_left=" + services_left + ", package_name=" + package_name + ", s_id=" + s_id + ", no_of_services=" + no_of_services + ", duration=" + duration + ", rate=" + rate + '}';
    }
    
    
}
