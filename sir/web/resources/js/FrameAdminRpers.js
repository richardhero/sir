		
		function enviar(){
			let cc = document.getElementById('n-i').value;
			let nom = document.getElementById('nom').value;
			let ape = document.getElementById('ape').value;
			let tel = document.getElementById('tel').value;
			let dir = document.getElementById('dir').value;
			var a = document.getElementById('rol').value;
			var b = document.getElementById('sucu').value;
			var c = document.getElementById('no-co').value;
			var d = document.getElementById('especialidad').value;
		if (isNaN(cc)) {
		
		swal({
  			text: "La cedula ingresada no es un numero",
		});
		return false;
		}
		if (nom =="" || ape=="" || cc== "" || dir=="") {
		swal({
  			text: "Complete todos los datos",
			
		});
		return false;
		}
		if (a=="Seleccione") {
		swal({
  			text: "Seleccione un rol",
		});
		return false;
		} else{
									swal({
					icon: "success",
  			text: "Registro Completado",
  			button: "Aceptar",
			
		});
		}
	
			if (b=="Seleccione") {
			swal({
  			text: "Seleccione una surcursal",
			});
			return false;
			}
		
		if (a=="Cocinero") {
			if (c=="Seleccione" || d=="") {
		swal({
  			text: "Complete todos los datos",
			
		});
		return false;
			}
		}


		}
		

		function mostrar(a){
			
			if (a=="Administrador") {
				document.getElementById('sucu').style.visibility="visible";
				document.getElementById('noc').style.visibility="hidden";
				document.getElementById('esp').style.visibility="hidden";
			}
			if (a=="Cocinero") {
				document.getElementById('noc').style.visibility="visible";
				document.getElementById('esp').style.visibility="visible";
				document.getElementById('sucu').style.visibility="hidden";
			}
			if (a=="Cajero") {
				document.getElementById('noc').style.visibility="hidden";
				document.getElementById('esp').style.visibility="hidden";
				document.getElementById('sucu').style.visibility="hidden";
			}
			if (a=="Seleccione") {
				document.getElementById('noc').style.visibility="hidden";
				document.getElementById('esp').style.visibility="hidden";
				document.getElementById('sucu').style.visibility="hidden";
			}

		}

		