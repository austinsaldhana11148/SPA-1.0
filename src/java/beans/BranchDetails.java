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
public class BranchDetails {
    private int b_id;
    private String name;
    private String mobile;
    private String address;
    private int bm_id;

    public BranchDetails(int b_id, String name, String mobile, String address, int bm_id) {
        this.b_id = b_id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.bm_id = bm_id;
    }

    public BranchDetails() {
    }

    public int getB_id() {
        return b_id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    public int getBm_id() {
        return bm_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBm_id(int bm_id) {
        this.bm_id = bm_id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.b_id;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.mobile);
        hash = 47 * hash + Objects.hashCode(this.address);
        hash = 47 * hash + this.bm_id;
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
        final BranchDetails other = (BranchDetails) obj;
        if (this.b_id != other.b_id) {
            return false;
        }
        if (this.bm_id != other.bm_id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.mobile, other.mobile)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BranchDetails{" + "b_id=" + b_id + ", name=" + name + ", mobile=" + mobile + ", address=" + address + ", bm_id=" + bm_id + '}';
    }
    
    
    
}
