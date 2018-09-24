		function entrada(){
			document.getElementById('entrada').style.visibility='hidden';
			document.getElementById('salida').style.visibility='visible';

			swal('Entrada Marcada Satisfactoriamente',{icon:'success',});
		}
		function salida(){
			document.getElementById('entrada').style.visibility='visible';
			document.getElementById('salida').style.visibility='hidden';
			swal('Salida Marcada Satisfactoriamente',{icon:'success',});
		}