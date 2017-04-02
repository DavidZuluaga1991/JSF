/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "register")
@SessionScoped
public class register implements Serializable {

    /**
     * Creates a new instance of register
     */
    String nameUser = "";

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
    public register() {
    }
    
}
