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
public class Employee {
    private int e_id;
    private String name;
    private String email;
    private String gender;
    private String address;
    private String mobile;
    private int status;
    private int b_id;

    public Employee() {
    }

    public int getB_id() {
        return b_id;
    }

    public int getE_id() {
        return e_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.e_id;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.email);
        hash = 97 * hash + Objects.hashCode(this.gender);
        hash = 97 * hash + Objects.hashCode(this.address);
        hash = 97 * hash + Objects.hashCode(this.mobile);
        hash = 97 * hash + this.status;
        hash = 97 * hash + this.b_id;
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
        final Employee other = (Employee) obj;
        if (this.e_id != other.e_id) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.b_id != other.b_id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.mobile, other.mobile)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "e_id=" + e_id + ", name=" + name + ", email=" + email + ", gender=" + gender + ", address=" + address + ", mobile=" + mobile + ", status=" + status + ", b_id=" + b_id + '}';
    }
  
}
