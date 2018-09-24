function reset(){
    document.getElementById("form:form").reset();
}



function validar(){
	let correo=document.getElementById("us").value;
	let password= document.getElementById("pass").value;
	if (correo==='') {
		alert("Ingrese el correo");
		document.getElementById('us').style.borderColor= "red";
	return false;
}
	if (password==='') {
		alert("Ingrese la Contraseña");
		document.getElementById('pass').style.borderColor= "red";
	return false;
}
	if (correo=='correo@admin.com' || correo=='correo@cajero.com' || correo=='correo@cocinero.com' || correo=='correo@cliente.com') {
			document.getElementById('us').style.borderColor= "green";
		
	
	}else{
		alert("correo incorrecto");
		document.getElementById('us').style.borderColor= "red";
		return false;
}
	if (password==123456) {
		document.getElementById('pass').style.borderColor= "green";
		
	
	}
	if (password!=123456) {
		alert("Contraseña incorrecta");
		document.getElementById('pass').style.borderColor= "red";
		return false;
}
	if (correo=='correo@admin.com' && password==123456) {
		document.getElementById('us').style.borderColor= "green";
		document.getElementById('pass').style.borderColor= "green";
		window.location.replace("SI/Administrador/inicioAdmin.html");
	
	}
	//para cajero
	if (correo=='correo@cajero.com' && password==123456) {
		document.getElementById('us').style.borderColor= "green";
		document.getElementById('pass').style.borderColor= "green";
		window.location.replace("SI/Cajero/inicioCajero.html");
	
	}
	//para cocinero
	if (correo=='correo@cocinero.com' && password==123456) {
		document.getElementById('us').style.borderColor= "green";
		document.getElementById('pass').style.borderColor= "green";
		window.location.replace("SI/Cocinero/inicioCocinero.html");
	
	} 
	//para cliente
	if (correo=='correo@cliente.com' && password==123456) {
		document.getElementById('us').style.borderColor= "green";
		document.getElementById('pass').style.borderColor= "green";
		window.location.replace("SI/Cliente/inicioCliente.html");
	
	}
}


	function enviar(){
			let cc1 = document.getElementById('n-i').value;
			let nom = document.getElementById('nom').value;
			let ape = document.getElementById('ape').value;
		    let email = document.getElementById('email').value;
		    let pass2 = document.getElementById('pass1').value;
		if (isNaN(cc1)) {
		
		swal({
  			text: "Rellene todos los datos",
			
		});
		return false;
		}
		if (nom==="") {
			document.getElementById('nom').style.borderColor= "red";
		}else{
			document.getElementById('nom').style.borderColor= "green";
		}
		if (cc1==="") {
			document.getElementById('n-i').style.borderColor= "red";
		}else{
			document.getElementById('n-i').style.borderColor= "green";
		}
		if (ape==="") {
			document.getElementById('ape').style.borderColor= "red";
		}else{
			document.getElementById('ape').style.borderColor= "green";
		}	
		if (email==="") {
			document.getElementById('email').style.borderColor= "red";
		}else{
			document.getElementById('email').style.borderColor= "green";
		}				
		if (pass2==="") {
			document.getElementById('pass1').style.borderColor= "red";
		}else{
			document.getElementById('pass1').style.borderColor= "green";
		}		
		if (nom ==="" || ape==="" || cc1=== "" || email==="" || pass2==="") {
		swal({
  			text: "Rellene todos los datos",
			
		});
		return false;
		}
		alert('Se ha registrado');
		}
function env(){
	let cor =  document.getElementById('email2').value;
	if (cor === "") {
				swal({
  			text: "Ingrese el Correo electronico registrado",
			
		});
				document.getElementById('email2').style.borderColor= "red";
				return false;
	}
}