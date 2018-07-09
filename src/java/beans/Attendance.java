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
 * @author Administrator
 */
public class Attendance {

    public int a_id, e_id;
    public Timestamp date;
    public int present;

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public Attendance() {
    }

    public int getA_id() {
        return a_id;
    }

    public Timestamp getDate() {
        return date;
    }

    public int getPresent() {
        return present;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setPresent(int present) {
        this.present = present;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.a_id;
        hash = 59 * hash + Objects.hashCode(this.date);
        hash = 59 * hash + this.present;
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
        final Attendance other = (Attendance) obj;
        if (this.a_id != other.a_id) {
            return false;
        }
        if (this.present != other.present) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Attendance{" + "a_id=" + a_id + ", e_id=" + e_id + ", date=" + date + ", present=" + present + '}';
    }


}
