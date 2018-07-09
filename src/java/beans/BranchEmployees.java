/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Austin
 */
public class BranchEmployees {
    private int  be_id;
    private int  b_id;
    private int  e_id;

    public BranchEmployees(int be_id, int b_id, int e_id) {
        this.be_id = be_id;
        this.b_id = b_id;
        this.e_id = e_id;
    }

    public BranchEmployees() {
    }

    public int getBe_id() {
        return be_id;
    }

    public int getB_id() {
        return b_id;
    }

    public int getE_id() {
        return e_id;
    }

    public void setBe_id(int be_id) {
        this.be_id = be_id;
    }

    public void setB_id(int b_id) {
        this.b_id = b_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.be_id;
        hash = 17 * hash + this.b_id;
        hash = 17 * hash + this.e_id;
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
        final BranchEmployees other = (BranchEmployees) obj;
        if (this.be_id != other.be_id) {
            return false;
        }
        if (this.b_id != other.b_id) {
            return false;
        }
        if (this.e_id != other.e_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BranchEmployees{" + "be_id=" + be_id + ", b_id=" + b_id + ", e_id=" + e_id + '}';
    }
    
    
}
