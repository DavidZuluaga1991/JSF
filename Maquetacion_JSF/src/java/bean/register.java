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
 
    String mensajeErrorEmail = "";
    String mensajeErrorNit = "";
    String mensajeErrorName = "";
    private usuario usu = new usuario();
    private ArrayList<usuario> usuarios =  new ArrayList<>();
    private ArrayList<usuario> tempusuarios =  new ArrayList<>();

    public usuario getUsu() {
        return usu;
    }

    public void setUsu(usuario usu) {
        this.usu = usu;
    }

    public ArrayList<usuario> getTempusuarios() {
        return tempusuarios;
    }

    public void setTempusuarios(ArrayList<usuario> tempusuarios) {
        this.tempusuarios = tempusuarios;
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
        usuario usua = new usuario();
        usua.addusuario("David", "david.l.zuluaga@hotmail.com", "123456789Dz", "123456789Dz", 1143941345);
        usuarios.add(usua);
        usua = new usuario();
        usua.addusuario("Angelica", "david.l.zuluaga@hotmail.com", "123456789Dz", "123456789Dz", 1234567891);
        usuarios.add(usua);
        //usu = new usuario();
        
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

    public void edit(int nit){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getNit() == nit){
                tempusuarios.add(usuarios.get(i));
                usuarios.get(i).setEdit(true);
            }
            else{
                usuarios.get(i).setEdit(false);
            }
        }
    }
    public void eliminar(int nit){
        int j = 0;
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getNit() == nit){
                j = i;
            }
        }
        usuarios.remove(j);
    }
    public void editsave (int nit){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getNit() == nit){
                if(usuarios.get(i).isEdit()){
                    usuarios.get(i).setEdit(false);
                }
            }
        }
    }
    public void cancelsave(int nit){
        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getNit() == nit){
                if(usuarios.get(i).isEdit()){
                    usuarios.get(i).setNit(tempusuarios.get(0).getNit());
                    usuarios.get(i).setNameUser(tempusuarios.get(0).getNameUser());
                    usuarios.get(i).setPassword(tempusuarios.get(0).getPassword());
                    usuarios.get(i).setConfirmpassword(tempusuarios.get(0).getConfirmpassword());
                    /*usuarios.remove(i);
                    usuarios.add(i, tempusu);*/
                    usuarios.get(i).setEdit(false);
                }
            }
        }
    }
}
