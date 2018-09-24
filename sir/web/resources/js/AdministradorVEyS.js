$(document).ready(function() {
	$('#dataProductos').DataTable();
} );
function guardar(no){
	var b = document.getElementById("b1_"+no).value;
	var b2 = document.getElementById("b2_"+no).value;
	if (b==b2) {
		alert('las bodegas son la misma');
		return false;
	}
	var tb1 = document.getElementById("tb1_"+no).innerHTML;
	var tb11 = parseFloat(tb1);
	var tb2 = document.getElementById("tb2_"+no).innerHTML;
	var tb21 = parseFloat(tb2);
	var can = document.getElementById("form"+no).value;
	if (can=="") {
		alert("Ingrese una cantidad");
		return false;
	}
	if (isNaN(can)) {
				alert("La cantidad no es un numero");
		return false;
	}
	var ca = parseFloat(can);

	if (b=="Bodega 1") {
		if (ca>tb11) {
			alert('La cantidad ingresada es mayor a la existente');
			return false;
		}	
		let can1 = ca + tb21;
		let can2 = tb11 - ca;
	document.getElementById("tb2_"+no).innerHTML=can1;	
	document.getElementById("tb1_"+no).innerHTML=can2;
	document.getElementById("miform"+no).reset();
}
	var b = document.getElementById("b1_"+no).value;
	var b2 = document.getElementById("b2_"+no).value;
	var tb1 = document.getElementById("tb1_"+no).innerHTML;
	var tb11 = parseFloat(tb1);
	var tb2 = document.getElementById("tb2_"+no).innerHTML;
	var tb21 = parseFloat(tb2);
	var can = document.getElementById("form"+no).value;
	var ca = parseFloat(can);
	if (b=="Bodega 2") {
		if (ca>tb21) {
			alert('La cantidad ingresada es mayor a la existente');
			return false;
		}
		let can1 = ca + tb11;
		let can2 = tb21 - ca;
	document.getElementById("tb1_"+no).innerHTML=can1;	
	document.getElementById("tb2_"+no).innerHTML=can2;
	document.getElementById("miform"+no).reset();


	}

}