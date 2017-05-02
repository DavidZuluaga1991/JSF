function objetoAjax(){
	var xmlhttp=false;
	try {
		xmlhttp = new ActiveXObject("Msxml2.XMLHTTP");
	} catch (e) {
		try {
		   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		} catch (E) {
			xmlhttp = false;
  		}
	}

	if (!xmlhttp && typeof XMLHttpRequest!=='undefined') {
		xmlhttp = new XMLHttpRequest();
	}
	return xmlhttp;
}


function MostrarConsulta(datos){
        alert(datos);
	divResultado = document.getElementById('container4');
	ajax=objetoAjax();
        ajax.open("GET","view/formulary2.xhtml");
	//ajax.open("GET", datos);
	ajax.onreadystatechange=function() {
		if (ajax.readyState===4) {
			divResultado.innerHTML = ajax.responseText;
		}
	};
	ajax.send(null);
}