$(document).ready(function() {
	$('#tabla_pro').DataTable();
} );
function guardar(no){
	let can = document.getElementById('form'+no).value;
	let ca = parseFloat(can);
	let to = document.getElementById('toEx'+no).innerHTML;
	let toEx =  parseFloat(to);

	if (isNaN(can)) {
		alert('La cantidad ingresada no es un numero');
		return false;
	}
	if (ca>toEx) {
		alert('La cantidad ingresada es mayor a la existente');
		return false;
	} 
	if (ca<toEx) {
		let td = document.getElementById('tb1_'+no).innerHTML;
		let td1 = parseFloat(td);
		let res = to - ca;
		let res1 = ca + td1;
		document.getElementById('toEx'+no).innerHTML=res;
		document.getElementById('tb1_'+no).innerHTML=res1;
		document.getElementById("miform"+no).reset();

	}
}