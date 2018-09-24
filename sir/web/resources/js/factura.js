$(document).ready(function() {
	$('#tabla_pro').DataTable();
} );


var producto=[];
var cantidad=[];
var precio=[];
var ivat=[];
var subtotal=[];
var total=[];
var conteo=2;
var posicion=0;
var boton= '<button type="button" class="btn btn-danger borrar" onclick="borrar();"><i class="icofont icofont-trash"></i></button>'
var botonfin= '<button type="button" class="btn btn-secondary" onclick="return finVenta();"><i class="icofont icofont-money-bag"></i></button>'
var prod = [];
var pre = [];
var cantp = [];

 
var can = document.getElementById("cant");
var tab = document.getElementById("tabla_pro");

prod[0] = "jugo de mango";
pre[0]  = 5000;


prod[1] = "Arepa Vaquera";
pre[1]  = 4500;


prod[2] = "Arepa Tierna";
pre[2]  = 5500;


prod[3] = "Arepa Sirena";
pre[3]  = 2300;


prod[4] = "Arepa Concentida";
pre[4]  = 10000;


prod[5] = "Arepa Trozuda";
pre[5]  = 6000;


prod[6] = "Arepa Intrepida";
pre[6]  = 5000;


prod[7] = "jugo de mango";
pre[7]  = 5000;

document.getElementById("pro1").innerHTML =prod[0];
document.getElementById("pre1").innerHTML =pre[0];


document.getElementById("pro2").innerHTML =prod[1];
document.getElementById("pre2").innerHTML =pre[1];


document.getElementById("pro3").innerHTML =prod[2];
document.getElementById("pre3").innerHTML =pre[2];


document.getElementById("pro4").innerHTML =prod[3];
document.getElementById("pre4").innerHTML =pre[3];


document.getElementById("pro5").innerHTML =prod[4];
document.getElementById("pre5").innerHTML =pre[4];


document.getElementById("pro6").innerHTML =prod[5];
document.getElementById("pre6").innerHTML =pre[5];


document.getElementById("pro7").innerHTML =prod[6];
document.getElementById("pre7").innerHTML =pre[6];




function pasaDatos(){



	let productoc = prod[0];
	let cantidadc = document.getElementById("canti").value;
	let valorunt = pre[0];
	let iva = valorunt*cantidadc*0.19;
	let subtotal = valorunt*cantidadc-iva;
	let total = valorunt*cantidadc;

	if (isNaN(cantidadc) || cantidadc.length>2) {
		alert('La cantidad ingresada no es un numero o es muy grande');
		return false;
	}
	if ( cantidadc != "") {

		let i = can.rows.length;
		let fila = can.insertRow(0+1);

		let celda1 = fila.insertCell(0);
		let celda2 = fila.insertCell(1);
		let celda3 = fila.insertCell(2);
		let celda4 = fila.insertCell(3);
		let celda5 = fila.insertCell(4);
		let celda6 = fila.insertCell(5);
		let celda7 = fila.insertCell(6);

		celda1.innerHTML = '<p name="prducto[]" class="non-margin">'+productoc+'</p>';
		celda2.innerHTML = '<p name="cantidad[]" class="non-margin">'+cantidadc+'</p>';
		celda3.innerHTML = valorunt;
		celda4.innerHTML = '<p name="iva[]" class="non-margin">'+iva+'</p>';
		celda5.innerHTML = '<p name="sub[]" class="non-margin">'+subtotal+'</p>';
		celda6.innerHTML = '<p name="total[]" class="non-margin">'+total+'</p>';
		celda7.innerHTML = boton;

		producto[conteo] = productoc;
		cantidad[conteo] = cantidadc;
		precio[conteo] = valorunt;
		ivat[conteo] = iva;
		subtotal[conteo] = subtotal;
		total[conteo] = total;


		conteo++;
	} else{
		alert("ingrese una cantidad");
	}


}
function pasaDatos1(){



	let productoc = prod[1];
	let cantidadc = document.getElementById("canti").value;
	let valorunt = pre[1];
	let iva = valorunt*cantidadc*0.19;
	let subtotal = valorunt*cantidadc-iva;
	let total = valorunt*cantidadc;

	if (isNaN(cantidadc) || cantidadc.length>2) {
		alert('La cantidad ingresada no es un numero o es muy grande');
		return false;
	}
	if ( cantidadc != "") {

		let i = can.rows.length;
		let fila = can.insertRow(0+1);

		let celda1 = fila.insertCell(0);
		let celda2 = fila.insertCell(1);
		let celda3 = fila.insertCell(2);
		let celda4 = fila.insertCell(3);
		let celda5 = fila.insertCell(4);
		let celda6 = fila.insertCell(5);
		let celda7 = fila.insertCell(6);

		celda1.innerHTML = '<p name="prducto[]" class="non-margin">'+productoc+'</p>';
		celda2.innerHTML = '<p name="cantidad[]" class="non-margin">'+cantidadc+'</p>';
		celda3.innerHTML = valorunt;
		celda4.innerHTML = '<p name="iva[]" class="non-margin">'+iva+'</p>';
		celda5.innerHTML = '<p name="sub[]" class="non-margin">'+subtotal+'</p>';
		celda6.innerHTML = '<p name="total[]" class="non-margin">'+total+'</p>';
		celda7.innerHTML = boton;

		producto[conteo] = productoc;
		cantidad[conteo] = cantidadc;
		precio[conteo] = valorunt;
		ivat[conteo] = iva;
		subtotal[conteo] = subtotal;
		total[conteo] = total;


		conteo++;
	} else{
		alert("ingrese una cantidad");
	}

}
function pasaDatos2(){



	let productoc = prod[2];
	let cantidadc = document.getElementById("canti").value;
	let valorunt = pre[2];
	let iva = valorunt*cantidadc*0.19;
	let subtotal = valorunt*cantidadc-iva;
	let total = valorunt*cantidadc;

	if (isNaN(cantidadc) || cantidadc.length>2) {
		alert('La cantidad ingresada no es un numero o es muy grande');
		return false;
	}
	if ( cantidadc != "") {

		let i = can.rows.length;
		let fila = can.insertRow(0+1);

		let celda1 = fila.insertCell(0);
		let celda2 = fila.insertCell(1);
		let celda3 = fila.insertCell(2);
		let celda4 = fila.insertCell(3);
		let celda5 = fila.insertCell(4);
		let celda6 = fila.insertCell(5);
		let celda7 = fila.insertCell(6);

		celda1.innerHTML = '<p name="prducto[]" class="non-margin">'+productoc+'</p>';
		celda2.innerHTML = '<p name="cantidad[]" class="non-margin">'+cantidadc+'</p>';
		celda3.innerHTML = valorunt;
		celda4.innerHTML = '<p name="iva[]" class="non-margin">'+iva+'</p>';
		celda5.innerHTML = '<p name="sub[]" class="non-margin">'+subtotal+'</p>';
		celda6.innerHTML = '<p name="total[]" class="non-margin">'+total+'</p>';
		celda7.innerHTML = boton;

		producto[conteo] = productoc;
		cantidad[conteo] = cantidadc;
		precio[conteo] = valorunt;
		ivat[conteo] = iva;
		subtotal[conteo] = subtotal;
		total[conteo] = total;


		conteo++;
	} else{
		alert("ingrese una cantidad");
	}


}
function pasaDatos3(){



	let productoc = prod[3];
	let cantidadc = document.getElementById("canti").value;
	let valorunt = pre[3];
	let iva = valorunt*cantidadc*0.19;
	let subtotal = valorunt*cantidadc-iva;
	let total = valorunt*cantidadc;

	if (isNaN(cantidadc) || cantidadc.length>2) {
		alert('La cantidad ingresada no es un numero o es muy grande');
		return false;
	}
	if ( cantidadc != "") {

		let i = can.rows.length;
		let fila = can.insertRow(0+1);

		let celda1 = fila.insertCell(0);
		let celda2 = fila.insertCell(1);
		let celda3 = fila.insertCell(2);
		let celda4 = fila.insertCell(3);
		let celda5 = fila.insertCell(4);
		let celda6 = fila.insertCell(5);
		let celda7 = fila.insertCell(6);

		celda1.innerHTML = '<p name="prducto[]" class="non-margin">'+productoc+'</p>';
		celda2.innerHTML = '<p name="cantidad[]" class="non-margin">'+cantidadc+'</p>';
		celda3.innerHTML = valorunt;
		celda4.innerHTML = '<p name="iva[]" class="non-margin">'+iva+'</p>';
		celda5.innerHTML = '<p name="sub[]" class="non-margin">'+subtotal+'</p>';
		celda6.innerHTML = '<p name="total[]" class="non-margin">'+total+'</p>';
		celda7.innerHTML = boton;

		producto[conteo] = productoc;
		cantidad[conteo] = cantidadc;
		precio[conteo] = valorunt;
		ivat[conteo] = iva;
		subtotal[conteo] = subtotal;
		total[conteo] = total;


		conteo++;
	} else{
		alert("ingrese una cantidad");
	}


}
function pasaDatos4(){



	let productoc = prod[4];
	let cantidadc = document.getElementById("canti").value;
	let valorunt = pre[4];
	let iva = valorunt*cantidadc*0.19;
	let subtotal = valorunt*cantidadc-iva;
	let total = valorunt*cantidadc;
	if (isNaN(cantidadc) || cantidadc.length>2) {
		alert('La cantidad ingresada no es un numero o es muy grande');
		return false;
	}	

	if ( cantidadc != "") {

		let i = can.rows.length;
		let fila = can.insertRow(0+1);

		let celda1 = fila.insertCell(0);
		let celda2 = fila.insertCell(1);
		let celda3 = fila.insertCell(2);
		let celda4 = fila.insertCell(3);
		let celda5 = fila.insertCell(4);
		let celda6 = fila.insertCell(5);
		let celda7 = fila.insertCell(6);

		celda1.innerHTML = '<p name="prducto[]" class="non-margin">'+productoc+'</p>';
		celda2.innerHTML = '<p name="cantidad[]" class="non-margin">'+cantidadc+'</p>';
		celda3.innerHTML = valorunt;
		celda4.innerHTML = '<p name="iva[]" class="non-margin">'+iva+'</p>';
		celda5.innerHTML = '<p name="sub[]" class="non-margin">'+subtotal+'</p>';
		celda6.innerHTML = '<p name="total[]" class="non-margin">'+total+'</p>';
		celda7.innerHTML = boton;

		producto[conteo] = productoc;
		cantidad[conteo] = cantidadc;
		precio[conteo] = valorunt;
		ivat[conteo] = iva;
		subtotal[conteo] = subtotal;
		total[conteo] = total;


		conteo++;
	} else{
		alert("ingrese una cantidad");
	}


}
function pasaDatos5(){



	let productoc = prod[5];
	let cantidadc = document.getElementById("canti").value;
	let valorunt = pre[5];
	let iva = valorunt*cantidadc*0.19;
	let subtotal = valorunt*cantidadc-iva;
	let total = valorunt*cantidadc;

	if (isNaN(cantidadc) || cantidadc.length>2) {
		alert('La cantidad ingresada no es un numero o es muy grande');
		return false;
	}
	if ( cantidadc != "") {

		let i = can.rows.length;
		let fila = can.insertRow(0+1);

		let celda1 = fila.insertCell(0);
		let celda2 = fila.insertCell(1);
		let celda3 = fila.insertCell(2);
		let celda4 = fila.insertCell(3);
		let celda5 = fila.insertCell(4);
		let celda6 = fila.insertCell(5);
		let celda7 = fila.insertCell(6);

		celda1.innerHTML = '<p name="prducto[]" class="non-margin">'+productoc+'</p>';
		celda2.innerHTML = '<p name="cantidad[]" class="non-margin">'+cantidadc+'</p>';
		celda3.innerHTML = valorunt;
		celda4.innerHTML = '<p name="iva[]" class="non-margin">'+iva+'</p>';
		celda5.innerHTML = '<p name="sub[]" class="non-margin">'+subtotal+'</p>';
		celda6.innerHTML = '<p name="total[]" class="non-margin">'+total+'</p>';
		celda7.innerHTML = boton;

		producto[conteo] = productoc;
		cantidad[conteo] = cantidadc;
		precio[conteo] = valorunt;
		ivat[conteo] = iva;
		subtotal[conteo] = subtotal;
		total[conteo] = total;


		conteo++;
	} else{
		alert("ingrese una cantidad");
	}


}
function pasaDatos6(){



	var productoc = prod[6];
	var cantidadc = document.getElementById("canti").value;
	var valorunt = pre[6];
	var iva = valorunt*cantidadc*0.19;
	var subtotal = valorunt*cantidadc-iva;
	var total = valorunt*cantidadc;

	if (isNaN(cantidadc) || cantidadc.length>2) {
		alert('La cantidad ingresada no es un numero o es muy grande');
		return false;
	}
	if ( cantidadc != "") {

		let i = can.rows.length;
		let fila = can.insertRow(0+1);

		let celda1 = fila.insertCell(0);
		let celda2 = fila.insertCell(1);
		let celda3 = fila.insertCell(2);
		let celda4 = fila.insertCell(3);
		let celda5 = fila.insertCell(4);
		let celda6 = fila.insertCell(5);
		let celda7 = fila.insertCell(6);

		celda1.innerHTML = '<p name="prducto[]" class="non-margin">'+productoc+'</p>';
		celda2.innerHTML = '<p name="cantidad[]" class="non-margin">'+cantidadc+'</p>';
		celda3.innerHTML = valorunt;
		celda4.innerHTML = '<p name="iva[]" class="non-margin">'+iva+'</p>';
		celda5.innerHTML = '<p name="sub[]" class="non-margin">'+subtotal+'</p>';
		celda6.innerHTML = '<p name="total[]" class="non-margin">'+total+'</p>';
		celda7.innerHTML = boton;

		producto[conteo] = productoc;
		cantidad[conteo] = cantidadc;
		precio[conteo] = valorunt;
		ivat[conteo] = iva;
		subtotal[conteo] = subtotal;
		total[conteo] = total;


		conteo++;
	} else{
		alert("ingrese una cantidad");
	}


}

function nuCliente(){
	var cc = document.getElementById("ced").value;
	if (cc=="") {
		alert('ingrese la cedula del cliente');
		return false;
	}
	if (isNaN(cc)) {
		alert('La cedula ingresada no es un numero');
		return false;
	}
	if (cc.length<7) {
		alert('la cedula ingresada es muy corta');
		return false;
	}
	if (cc.length>10) {
		alert('la cedula ingresada es muy larga');
		return false;
	}
	else{
		puntos=5000;
		document.getElementById("cedula").innerHTML=cc+'  puntos: '+puntos;
		document.getElementById('Mdepago').style.visibility='visible';
	}
}
function calcularTotal(){
	var ton=0;
	var array_tot=document.getElementsByName("total[]");
	for (var r=0; r<array_tot.length; r++) {
		ton+=parseFloat(array_tot[r].innerHTML);
	}

	if (ton==0) {
		alert("esta opcion solo es valida en una venta");
	}else { 
		var totalizado = 'Total in';
		document.getElementById("totalizado").innerHTML=totalizado;

		var tiva=0;
		var array_iva=document.getElementsByName("iva[]");
		for (var s=0; s<array_iva.length; s++) {
			tiva+=parseFloat(array_iva[s].innerHTML);
		}

		document.getElementById("tiva").innerHTML=tiva;

		var tsub=0;
		var array_sub=document.getElementsByName("sub[]");
		for (var t=0; t<array_sub.length; t++) {
			tsub+=parseFloat(array_sub[t].innerHTML);
		}
		document.getElementById("tsubtotal").innerHTML=tsub;

		var ton=0;
		var array_tot=document.getElementsByName("total[]");
		for (var r=0; r<array_tot.length; r++) {
			ton+=parseFloat(array_tot[r].innerHTML);
		}
		document.getElementById("tototal").innerHTML=ton;
		document.getElementById("final").innerHTML=botonfin;


	}

	
}
function calcularTotalOut(){
	var totalizado = 'Total out';
	document.getElementById("totalizado").innerHTML=totalizado;

	var tiva=0;
	var array_iva=document.getElementsByName("iva[]");
	for (var s=0; s<array_iva.length; s++) {
		tiva+=parseFloat(array_iva[s].innerHTML);
	}

	document.getElementById("tiva").innerHTML=tiva;

	var tsub=0;
	var array_sub=document.getElementsByName("sub[]");
	for (var t=0; t<array_sub.length; t++) {
		tsub+=parseFloat(array_sub[t].innerHTML);
	}
	document.getElementById("tsubtotal").innerHTML=tsub;

	var ton=0;
	var array_tot=document.getElementsByName("total[]");
	for (var r=0; r<array_tot.length; r++) {
		ton+=parseFloat(array_tot[r].innerHTML);
	}
	document.getElementById("tototal").innerHTML=ton;
	document.getElementById("final").innerHTML=botonfin;
}
function borrar(){
	$(document).on('click','.borrar', function (event) {
		event.preventDefault();
		$(this).closest('tr').remove();
	});


}

function finVenta(){
	swal("¿Desea finalizar la venta?", {
		buttons: [true, 'Si'],
		dangerMode: true,
	})

	.then((willDelete)=>
		{

		if (willDelete) {
			swal("La venta ha sido registrda",{
				icon:"success",}); 
						$("#cant1 td").remove();  
		document.getElementById('totalizado').innerHTML="";
		document.getElementById('tiva').innerHTML="";
		document.getElementById('tsubtotal').innerHTML="";
		document.getElementById('tototal').innerHTML="";
		document.getElementById('final').innerHTML="";
			document.getElementById('Mdepago').style.visibility='hidden';
		document.getElementById("cedula").innerHTML='';	 
		}else{
			return false;
		}
	});	

	}


