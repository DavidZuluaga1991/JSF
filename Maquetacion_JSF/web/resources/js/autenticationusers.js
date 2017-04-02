function validatename() {
    var name = document.getElementById("textboxname");
    var intname = 1;
    if (name.value === "") {
        intname = 0;
    }
    if (intname === 0) {
        name.style.borderColor = "#F78181";
    }
    if (intname === 1) {
        name.style.borderColor = "#81F79F";
    }
    return true;
}
function validateemail() {
    var email = document.getElementById("textboxemail");
    var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    var intemail = 1;
    if (email.value === "") {
        intemail = 0;
    }
    if (expr.test(email.value)) {
        intemail = 1;
    } else {
        intemail = 0;
    }
    if (intemail === 0) {
        email.style.borderColor = "#F78181";
    }
    if (intemail === 1) {
        email.style.borderColor = "#81F79F";
    }
    return true;
}
function validatepassword() {
    var password = document.getElementById("textboxpassword");
    var intpassword = 1;
    var minusculas=/[a-z]/g; 
    var mayusculas=/[A-Z]/g; 
    if (password.value === "" || !(password.value !== "" && (password.value.length > 8 && (password.value.match(minusculas).length > 0) && (password.value.match(mayusculas).length > 0)))) 
    {
        intpassword = 0;
    }
    if (intpassword === 0) {
        password.style.borderColor = "#F78181";
    }
    if (intpassword === 1) {
        password.style.borderColor = "#81F79F";
    }
    return true;
}
function validateconfirmpassword() {
    var password = document.getElementById("textboxpassword");
    var confirmpassword = document.getElementById("textboxconfirmpassword");
    var intconfirmpassword = 1;
    var intpassword = 1;
    if (confirmpassword.value === "") {
        intconfirmpassword = 0;
    } else {
        if (confirmpassword.value !== password.value) {
            intconfirmpassword = 0;
            intpassword = 0;
        }
    }
    if (intconfirmpassword === 0) {
        confirmpassword.style.borderColor = "#F78181";
        if (intpassword === 0) {
            password.style.borderColor = "#F78181";
        }
    }
    if (intconfirmpassword === 1) {
        confirmpassword.style.borderColor = "#81F79F";
    }
    return true;
}
function validarCampos() {
    var name = document.getElementById("textboxname");
    var email = document.getElementById("textboxemail");
    var password = document.getElementById("textboxpassword");
    var confirmpassword = document.getElementById("textboxconfirmpassword");
    //var campos = document.getElementById("campos");
    //var boton = document.getElementById("register");
    /*var intname = 1;
    var intemail = 1;
    var intpassword = 1;
    var intconfirmpassword = 1;*/
    var camp = "Por Favor digitar \n";
    var cont = 0;
    var minusculas=/[a-z]/g; 
    var mayusculas=/[A-Z]/g; 
    var expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    
    if (name.value === "") {
        //intname = 0;
        camp += "- Nombre de usuario \n";
        cont = cont+1;
    }
    if (email.value === "") {
        //intemail = 0;
        camp += "- Correo del usuario \n";
        cont = cont+1;
    }
    if (expr.test(email.value)) {
        //intemail = 1;
    } else {
        //intemail = 0;
        camp += "- Verificar el correo del usuario si esta correcto \n";
        cont = cont+1;
    }
    if (password.value === "" || !(password.value !== "" && (password.value.length > 8 && (password.value.match(minusculas).length > 0) && (password.value.match(mayusculas).length > 0)))) 
    {
        //intpassword = 0;
        camp += "- Verificar la contraseña del usuario si esta correcta \n";
        cont = cont+1;
    }
    if (confirmpassword.value === "") {
        //intconfirmpassword = 0;
        cont = cont+1;
    } else {
        if (confirmpassword.value !== password.value) {
            //intconfirmpassword = 0;
            //intpassword = 0;
        camp += "- Verificar la contraseña del usuario son iguales \n";
            cont = cont+1;
        }
    }
    if(cont !== 0){
        alert(camp);
    }
    else{
        alert("El Usuario se ah registrado Exitosamente!!");
    }
        /*campos.innerHTML=" --------------------------------------------------------------- pro";
     alert("Pasa");*/
    //document.nombreform.nombreboton.disabled=true;
    return true;
}

