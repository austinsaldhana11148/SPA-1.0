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
public class Customer {
    private int c_id;
    private String name;
    private String mobile;
    private String address;
    private String email_address;
    private String gender;

    public Customer(int c_id, String name, String mobile, String address, String email_address, String gender) {
        this.c_id = c_id;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.email_address = email_address;
        this.gender = gender;
    }

     public Customer() {
    }
     
    public int getC_id() {
        return c_id;
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

    public String getEmail_address() {
        return email_address;
    }

    public String getGender() {
        return gender;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
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

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.c_id;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.mobile);
        hash = 83 * hash + Objects.hashCode(this.address);
        hash = 83 * hash + Objects.hashCode(this.email_address);
        hash = 83 * hash + Objects.hashCode(this.gender);
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
        final Customer other = (Customer) obj;
        if (this.c_id != other.c_id) {
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
        if (!Objects.equals(this.email_address, other.email_address)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Customer{" + "c_id=" + c_id + ", name=" + name + ", mobile=" + mobile + ", address=" + address + ", email_address=" + email_address + ", gender=" + gender + '}';
    }
    
    
}
