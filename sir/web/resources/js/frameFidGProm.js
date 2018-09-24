$(document).ready(function() {
    $('#dataProductos').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
} );
function edit_row(no)
{
	document.getElementById("edit_button"+no).style.display="none";
	document.getElementById("save_button"+no).style.display="block";
	
	var producto=document.getElementById("P_row"+no);
	var cantidad=document.getElementById("C_row"+no);
	var plato=document.getElementById("Pl_row"+no);
	
	var producto_data=producto.innerHTML;
	var cantidad_data=cantidad.innerHTML;
	var plato_data=plato.innerHTML;
										

																 
												
												
												
																


	producto.innerHTML="<select id='producto_text"+no+"' value='"+producto_data+"'> <option value='"+producto_data+"'>"+producto_data+"</option> <option value='--'>--</option><option value='Frecuente'>Frecuente</option> <option value=' no Frecuente'> no Frecuente</option><option value='Ambos'>Ambos</option></select>";
	cantidad.innerHTML="<input type='text' id='cantidad_text"+no+"' value='"+cantidad_data+"'>";
	plato.innerHTML="<select id='plato_text"+no+"' value='"+plato_data+"'><option value='"+plato_data+"'>"+plato_data+"</option> <option value='--'>--</option> <option value='General'>General</option><option value='Preferencial'>Preferencial</option><option value='Ambos'>Ambos</option></select>";

}

function save_row(no)
{
	var pro_val=document.getElementById("producto_text"+no).value;
	var can_val=document.getElementById("cantidad_text"+no).value;
	var pla_val=document.getElementById("plato_text"+no).value;
		if (isNaN(can_val)) {
		swal({
  			text: "El precio no es un numero",
  			button: "Aceptar",
			
		});
		return false;
	}
			if (can_val=="") {
		swal({
  			text: "Ingrese un precio de promocion",
  			button: "Aceptar",
			
		});
		
	}
			
	if (pla_val=="General") {
		if (pro_val!="--") {
		swal({
  			text: "Si el tipo de promocion es General el Tipo de Cliente tiene que ser --",
  			button: "Aceptar",
			
		});
		return false;
		}
		
	}



	document.getElementById("P_row"+no).innerHTML=pro_val;
	document.getElementById("C_row"+no).innerHTML=can_val;
	document.getElementById("Pl_row"+no).innerHTML=pla_val;

	document.getElementById("edit_button"+no).style.display="block";
	document.getElementById("save_button"+no).style.display="none";
}

function delete_row(no)
{
	document.getElementById("row"+no+"").outerHTML="";
}

function add_row()
{

	var new_pro=document.getElementById("new_pro").value;
	var new_can=document.getElementById("new_can").value;
	var new_pla=document.getElementById("new_pla").value;
	var new_c=document.getElementById("new_c").value;
	if (new_pro=="--") {
		swal({
  			text: "Ingrese un producto",
  			button: "Aceptar",
			
		});
		return false;
	}	
	if (new_pla=="--") {
		swal({
  			text: "Ingrese un Tipo de promocion",
  			button: "Aceptar",
			
		});
		return false;
	}
	if (new_pla!="General" && new_c=="--") {
		swal({
  			text: "Ingrese un Tipo de Cliente",
  			button: "Aceptar",
			
		});
		return false;
	}
	if (isNaN(new_can)) {
		swal({
  			text: "El precio no es un numero",
  			button: "Aceptar",
			
		});
		return false;
	}
	if (new_can=="") {
		swal({
  			text: "Ingrese un precio de promocion",
  			button: "Aceptar",
			
		});
		return false;
	}	
	if (new_pla=="General") {
		if (new_c!="--") {
		swal({
  			text: "Si el tipo de promocion es General el Tipo de Cliente tiene que ser --",
  			button: "Aceptar",
			
		});
		return false;
		}
	}
	var table=document.getElementById("dataProductos");
	var table_len=(table.rows.length)-1;
	var row = table.insertRow(table_len).outerHTML="<tr id='row"+table_len+"'><td id='P_row"+table_len+"'>"+new_pro+"</td><td id='C_row"+table_len+"'>"+new_can+"</td><td id='Pl_row"+table_len+"'>"+new_pla+"</td><td id='c_row"+table_len+"'>"+new_c+"</td><td><span id='edit_button"+table_len+"' value='Edit' class='icofont icofont-ui-edit edit' onclick='edit_row("+table_len+")'></span> <span id='save_button"+table_len+"' value='Save' class='icofont icofont-save save save' style='display: none;' onclick='save_row("+table_len+")'></span> <span value='Delete' class='icofont icofont-ui-delete delete delete' onclick='delete_row("+table_len+")'></span></td></tr>";



	document.getElementById("new_pro").value="--";
	document.getElementById("new_can").value="";
	document.getElementById("new_pla").value="--";
	document.getElementById("new_c").value="--";
}
