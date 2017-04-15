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
@Named(value = "menu")
@SessionScoped
public class menu implements Serializable {
    private int option;
    private String url;

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Creates a new instance of menu
     */
    public menu() {
        obtenerurl(1);
    }
    
    public void obtenerurl(int option){
        this.option = option;
        
        switch (option){
            case 1 :
                url = "view/main.xhtml";
                break;
            case 4 :
                url = "view/formulary.xhtml";
                break;
            case 6 :
                url = "view/listusers.xhtml";
                break;
            
            default :
                url = "view/main.xhtml";
                break;
        }
    }
    
}
