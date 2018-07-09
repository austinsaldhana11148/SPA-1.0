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
public class AttendanceReport {
    private int eid;
    private String ename;
    private int total_present;
    private int total_absent;
    private int total;

    public AttendanceReport() {
    }

    public int getEid() {
        return eid;
    }

    public String getEname() {
        return ename;
    }

    public int getTotal_present() {
        return total_present;
    }

    public int getTotal_absent() {
        return total_absent;
    }

    public int getTotal() {
        return total;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setTotal_present(int total_present) {
        this.total_present = total_present;
    }

    public void setTotal_absent(int total_absent) {
        this.total_absent = total_absent;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + this.eid;
        hash = 11 * hash + Objects.hashCode(this.ename);
        hash = 11 * hash + this.total_present;
        hash = 11 * hash + this.total_absent;
        hash = 11 * hash + this.total;
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
        final AttendanceReport other = (AttendanceReport) obj;
        if (this.eid != other.eid) {
            return false;
        }
        if (this.total_present != other.total_present) {
            return false;
        }
        if (this.total_absent != other.total_absent) {
            return false;
        }
        if (this.total != other.total) {
            return false;
        }
        if (!Objects.equals(this.ename, other.ename)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AttendanceReport{" + "eid=" + eid + ", ename=" + ename + ", total_present=" + total_present + ", total_absent=" + total_absent + ", total=" + total + '}';
    }
    
    
    
    
}
