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
    private static final String PATTERN_MIN = "[a-z]", PATTERN_MAY = "[A-Z]";
    String mensajeErrorEmail = "";
    String mensajeErrorNit = "";
    String mensajeErrorName = "";
    String mensajeErrorPassword = "";
    String mensajeErrorConfirmPassword = "";
    private usuario usu = new usuario();
    private ArrayList<usuario> usuarios = new ArrayList<>();
    private ArrayList<usuario> tempusuarios = new ArrayList<>();

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

    public String getMensajeErrorPassword() {
        return mensajeErrorPassword;
    }

    public void setMensajeErrorPassword(String mensajeErrorPassword) {
        this.mensajeErrorPassword = mensajeErrorPassword;
    }

    public String getMensajeErrorConfirmPassword() {
        return mensajeErrorConfirmPassword;
    }

    public void setMensajeErrorConfirmPassword(String mensajeErrorConfirmPassword) {
        this.mensajeErrorConfirmPassword = mensajeErrorConfirmPassword;
    }

    public register() {
        usuario usua = new usuario();
        usua.addusuario("David", "david.l.zuluaga@hotmail.com", "123456789Dz", "123456789Dz", "1143941345");
        usuarios.add(usua);
        usua = new usuario();
        usua.addusuario("Angelica", "david.l.zuluaga@hotmail.com", "123456789Dz", "123456789Dz", "1234567891");
        usuarios.add(usua);
        //usu = new usuario();

    }

    /**
     * Comprueba que la longitud del nombre este en el rango correcto
     *
     * @param evento
     */
    public void validarName(AjaxBehaviorEvent evento) {
        if (usu.getNameUser() == null || "".equals(usu.getNameUser())) {
            mensajeErrorName = "por favor digitar el nombre";
        } else {
            mensajeErrorName = "";
        }
    }

    /**
     * Comprueba que la longitud del nombre este en el rango correcto
     *
     * @param evento
     */
    public void validarNit(AjaxBehaviorEvent evento) {
        if ((usu.getNit() + "").length() < 8) {
            mensajeErrorNit = "El nit se debe digitar como minimo 8 caracteres";
        } else {
            if ((usu.getNit() + "").length() > 10) {
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

    /**
     * Comprueba que la longitud del nombre este en el rango correcto
     *
     * @param evento
     */
    public void validarPassword(AjaxBehaviorEvent evento) {
        //Pattern pattern = Pattern.compile(""+PATTERN_MIN+"");
        /*Pattern patmin = Pattern.compile(PATTERN_MIN);
        Pattern patmay = Pattern.compile(PATTERN_MAY);

        // Match the given input against this pattern
        Matcher matcherpatmin = patmin.matcher(usu.getPassword());
        Matcher matcherpatmay = patmay.matcher(usu.getPassword());*/
        /*if (password.value === "" || !(password.value !== "" && (password.value.length > 8 && (password.value.match(minusculas).length > 0) && (password.value.match(mayusculas).length > 0)))) 
    {
        intpassword = 0;
    }*/
        //usu.getPassword()

        // Match the given input against this pattern
        /*if (!matcherpatmay.matches()) {
            mensajeErrorPassword = "Por Favor Validar Nuevamente la Contraseña";
        } else {
            mensajeErrorPassword = "";
        }*/
        Pattern pattern = Pattern.compile("[0-9]+");

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(usu.getPassword());
        boolean min = false,may = false;
        for (int i = 0; i < usu.getPassword().length(); i++) {
            if(usu.getPassword().charAt(i) == Character.toLowerCase(usu.getPassword().charAt(i))){
                min = true;
            }
            if(usu.getPassword().charAt(i) == Character.toUpperCase(usu.getPassword().charAt(i))){
                may = true;
            }
        }
        if (!min || !may || !(usu.getPassword().length()>=8) ) {
            mensajeErrorPassword = "Por Favor Validar Nuevamente la Contraseña";
        } else {
            mensajeErrorPassword = "";
        }
    }

    /**
     * Comprueba que la longitud del nombre este en el rango correcto
     *
     * @param evento
     */
    public void validarConfirmPassword(AjaxBehaviorEvent evento) {
        if (!usu.getPassword().equals(usu.getConfirmpassword())) {
            mensajeErrorConfirmPassword = "Por Favor Validar Nuevamente la Contraseña confirmar";
        } else {
            mensajeErrorConfirmPassword = "";
        }
    }

    public void guardar() {
        boolean save = true;
        /* ----- Validación para el nombre de usuario ----- */
        if (usu.getNameUser() == null || "".equals(usu.getNameUser())) {
            mensajeErrorName = "por favor digitar el nombre";
            save = false;
        }
        /* ----- Validación para el Nit ------ */
        if ((usu.getNit() + "").length() < 8) {
            mensajeErrorNit = "El nit se debe digitar como minimo 8 caracteres";
            save = false;
        } else {
            if ((usu.getNit() + "").length() > 10) {
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

        if (save) {
            //se agrega el objeto con los datos ingresados al arraylist
            usuarios.add(usu);
            //reinicializar el objeto
            usu = new usuario();
        } else {

        }
    }

    public void edit(String nit) {
        int init = Integer.parseInt(nit);
        for (int i = 0; i < usuarios.size(); i++) {
            if (Integer.parseInt(usuarios.get(i).getNit()) == init) {
                tempusuarios.add(usuarios.get(i));
                usuarios.get(i).setEdit(true);
            } else {
                usuarios.get(i).setEdit(false);
            }
        }
    }

    public void eliminar(String nit) {
        int init = Integer.parseInt(nit);
        int j = 0;
        for (int i = 0; i < usuarios.size(); i++) {
            if (Integer.parseInt(usuarios.get(i).getNit()) == init) {
                j = i;
            }
        }
        usuarios.remove(j);
    }

    public void editsave(String nit) {
        int init = Integer.parseInt(nit);
        for (int i = 0; i < usuarios.size(); i++) {
            if (Integer.parseInt(usuarios.get(i).getNit()) == init) {
                if (usuarios.get(i).isEdit()) {
                    usuarios.get(i).setEdit(false);
                }
            }
        }
    }

    public void cancelsave(String nit) {
        int init = Integer.parseInt(nit);
        for (int i = 0; i < usuarios.size(); i++) {
            if (Integer.parseInt(usuarios.get(i).getNit()) == init) {
                if (usuarios.get(i).isEdit()) {
                    usuarios.get(i).setEdit(false);
                }
            }
        }
    }
}
