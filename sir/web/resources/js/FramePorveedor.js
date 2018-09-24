		
		function enviar(){
			let nom = document.getElementById('nom').value;
			
			let tel = document.getElementById('tel').value;
			let dir = document.getElementById('dir').value;

		if (isNaN(tel)) {
		
		swal({
  			text: "El telefono ingresado no es un numero",
		});
		return false;
		}
		if (nom =="" || tel=="") {
		swal({
  			text: "El nombre o Telefono no estan ingresados",
			
		});
		return false;
		} else{
					swal({
  			text: "as",
			
		});
		}


		}
		


		