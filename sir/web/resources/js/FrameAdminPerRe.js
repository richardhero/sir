		$(document).ready(function() {
    $('#dataProductos').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
} );



function save_row(no)
{
	var pro_val=document.getElementById("producto_text"+no).value;
	var can_val=document.getElementById("cantidad_text"+no).value;
	var pla_val=document.getElementById("plato_text"+no).value;

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