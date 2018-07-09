/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;
/**
 *
 * @author Austin
 */
public class CustomerPackage {
    private int cp_id;
    private int c_id;
    private int package_id;
    private Timestamp start_date;
    private int services_left;

    public CustomerPackage(int cp_id, int c_id, int package_id, Timestamp start_date, int services_left) {
        this.cp_id = cp_id;
        this.c_id = c_id;
        this.package_id = package_id;
        this.start_date = start_date;
        this.services_left = services_left;
    }

    public CustomerPackage() {
    }

    public int getCp_id() {
        return cp_id;
    }

    public int getC_id() {
        return c_id;
    }

    public int getPackage_id() {
        return package_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public int getServices_left() {
        return services_left;
    }

    public void setCp_id(int cp_id) {
        this.cp_id = cp_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public void setServices_left(int services_left) {
        this.services_left = services_left;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.cp_id;
        hash = 23 * hash + this.c_id;
        hash = 23 * hash + this.package_id;
        hash = 23 * hash + Objects.hashCode(this.start_date);
        hash = 23 * hash + this.services_left;
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
        final CustomerPackage other = (CustomerPackage) obj;
        if (this.cp_id != other.cp_id) {
            return false;
        }
        if (this.c_id != other.c_id) {
            return false;
        }
        if (this.package_id != other.package_id) {
            return false;
        }
        if (this.services_left != other.services_left) {
            return false;
        }
        if (!Objects.equals(this.start_date, other.start_date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CustomerPackage{" + "cp_id=" + cp_id + ", c_id=" + c_id + ", package_id=" + package_id + ", start_date=" + start_date + ", services_left=" + services_left + '}';
    }
    
    
    
}
