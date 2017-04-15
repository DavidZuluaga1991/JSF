/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.*;
import javax.faces.event.AjaxBehaviorEvent;
import logica.usuario;

/**
 *
 * @author David Zuluaga
 */
@Named(value = "register")
@SessionScoped
public class register implements Serializable {
    
 private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    /**
     * Creates a new instance of register
     */
    String mensajeErrorEmail = "";
    String mensajeErrorNit = "";
    String mensajeErrorName = "";
    private usuario usu = new usuario();
    private ArrayList<usuario> usuarios =  new ArrayList<usuario>();

    public usuario getUsu() {
        return usu;
    }

    public void setUsu(usuario usu) {
        this.usu = usu;
    }

    public ArrayList<usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<usuario> usuarios) {
        this.usuarios = usuarios;
    }
 


    public String getMensajeErrorNit() {
        return mensajeErrorNit;
    }

    public void setMensajeErrorNit(String mensajeErrorNit) {
        this.mensajeErrorNit = mensajeErrorNit;
    }

    public String getMensajeErrorEmail() {
        return mensajeErrorEmail;
    }

    public void setMensajeErrorEmail(String mensajeErrorEmail) {
        this.mensajeErrorEmail = mensajeErrorEmail;
    }

    public String getMensajeErrorName() {
        return mensajeErrorName;
    }

    public void setMensajeErrorName(String mensajeErrorName) {
        this.mensajeErrorName = mensajeErrorName;
    }
    
    public register() {
        usu = new usuario();
    }
    /**
     * Comprueba que la longitud del nombre este en el rango correcto
     * 
     * @param evento 
     */
    public void validarName(AjaxBehaviorEvent evento) {
        if(usu.getNameUser() == null || "".equals(usu.getNameUser())){
            mensajeErrorName = "por favor digitar el nombre";
        }
        else {
            mensajeErrorName = "";
        }
    }
    /**
     * Comprueba que la longitud del nombre este en el rango correcto
     * 
     * @param evento 
     */
    public void validarNit(AjaxBehaviorEvent evento) {
        if ( (usu.getNit()+"").length()  < 8) {
            mensajeErrorNit = "El nit se debe digitar como minimo 8 caracteres";
        } else {
            if ((usu.getNit()+"").length() > 10) {
                mensajeErrorNit = "El nit se debe digitar como maximo digitar hasta 10 caracteres";
            } else {
                mensajeErrorNit = "";
            }
        }
    }
    /**
     * Comprueba que la longitud del nombre este en el rango correcto
     * 
     * @param evento 
     */
    public void validarEmail(AjaxBehaviorEvent evento) {
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(usu.getEmail());
        if (!matcher.matches()) {
            mensajeErrorEmail = "Por Favor Validar Nuevamente el Email";
        } else {
           mensajeErrorEmail = "";
        }
    }
    public void guardar(){
        boolean save = true;
        /* ----- Validación para el nombre de usuario ----- */
        if(usu.getNameUser() == null || "".equals(usu.getNameUser())){
            mensajeErrorName = "por favor digitar el nombre";
            save = false;
        }
        /* ----- Validación para el Nit ------ */
        if ( (usu.getNit()+"").length()  < 8) {
            mensajeErrorNit = "El nit se debe digitar como minimo 8 caracteres";
            save = false;
        } else {
            if ((usu.getNit()+"").length() > 10) {
                mensajeErrorNit = "El nit se debe digitar como maximo digitar hasta 10 caracteres";
                save = false;
            } 
        }
        /*Validacion para el Email*/
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(usu.getEmail());
        if (!matcher.matches()) {
            mensajeErrorEmail = "Por Favor Validar Nuevamente el Email";
            save = false;
        } else {
           mensajeErrorEmail = "";
        }
        
        if(save){
            //se agrega el objeto con los datos ingresados al arraylist
            usuarios.add(usu);
            //reinicializar el objeto
            usu = new usuario();
        }
        else{
            
        }
    }
}
