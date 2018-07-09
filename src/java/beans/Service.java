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
public class Service {
    
    private int s_id;
    private String service_name;
    private float service_time;
    private float price;

    public Service(int s_id, String service_name, float service_time, float price) {
        this.s_id = s_id;
        this.service_name = service_name;
        this.service_time = service_time;
        this.price = price;
    }

    public Service() {
    }

    public int getS_id() {
        return s_id;
    }

    public String getService_name() {
        return service_name;
    }

    public float getService_time() {
        return service_time;
    }

    public float getPrice() {
        return price;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public void setService_time(float service_time) {
        this.service_time = service_time;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.s_id;
        hash = 53 * hash + Objects.hashCode(this.service_name);
        hash = 53 * hash + Float.floatToIntBits(this.service_time);
        hash = 53 * hash + Float.floatToIntBits(this.price);
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
        final Service other = (Service) obj;
        if (this.s_id != other.s_id) {
            return false;
        }
        if (Float.floatToIntBits(this.price) != Float.floatToIntBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.service_name, other.service_name)) {
            return false;
        }
        if (!Objects.equals(this.service_time, other.service_time)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service{" + "s_id=" + s_id + ", service_name=" + service_name + ", service_time=" + service_time + ", price=" + price + '}';
    }
    
    
}
