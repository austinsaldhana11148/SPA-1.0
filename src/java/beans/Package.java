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
public class Package {
    private int package_id;
    private String package_name;
    private int s_id;
    private int no_of_services;
    private int duration;
    private float rate;

    public Package(int package_id, String package_name, int s_id, int no_of_services, int duration, float rate) {
        this.package_id = package_id;
        this.package_name = package_name;
        this.s_id = s_id;
        this.no_of_services = no_of_services;
        this.duration = duration;
        this.rate = rate;
    }

    
    
    public Package() {
    }
    
    public int getPackage_id() {
        return package_id;
    }

    public String getPackage_name() {
        return package_name;
    }

    public int getS_id() {
        return s_id;
    }

    public int getNo_of_services() {
        return no_of_services;
    }

    public int getDuration() {
        return duration;
    }

    public float getRate() {
        return rate;
    }

    public void setPackage_id(int package_id) {
        this.package_id = package_id;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setNo_of_services(int no_of_services) {
        this.no_of_services = no_of_services;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.package_id;
        hash = 47 * hash + Objects.hashCode(this.package_name);
        hash = 47 * hash + this.s_id;
        hash = 47 * hash + this.no_of_services;
        hash = 47 * hash + this.duration;
        hash = 47 * hash + Float.floatToIntBits(this.rate);
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
        final Package other = (Package) obj;
        if (this.package_id != other.package_id) {
            return false;
        }
        if (this.s_id != other.s_id) {
            return false;
        }
        if (this.no_of_services != other.no_of_services) {
            return false;
        }
        if (this.duration != other.duration) {
            return false;
        }
        if (Float.floatToIntBits(this.rate) != Float.floatToIntBits(other.rate)) {
            return false;
        }
        if (!Objects.equals(this.package_name, other.package_name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Package{" + "package_id=" + package_id + ", package_name=" + package_name + ", s_id=" + s_id + ", no_of_services=" + no_of_services + ", duration=" + duration + ", rate=" + rate + '}';
    }
    
    
    
}
