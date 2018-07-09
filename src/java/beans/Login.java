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
public class Login {
    private int l_id;
    private String username;
    private String password;
    private String user_type;
    private int e_id;

    public Login(int l_id, String username, String password, String user_type, int e_id) {
        this.l_id = l_id;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        this.e_id = e_id;
    }

    

    public Login() {
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }
    
    

    public int getL_id() {
        return l_id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setL_id(int l_id) {
        this.l_id = l_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.l_id;
        hash = 97 * hash + Objects.hashCode(this.username);
        hash = 97 * hash + Objects.hashCode(this.password);
        hash = 97 * hash + Objects.hashCode(this.user_type);
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
        final Login other = (Login) obj;
        if (this.l_id != other.l_id) {
            return false;
        }
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.user_type, other.user_type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Login{" + "l_id=" + l_id + ", username=" + username + ", password=" + password + ", user_type=" + user_type + '}';
    }
  
      
}
