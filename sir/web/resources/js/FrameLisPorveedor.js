$(document).ready(function() {
    $('#dataProductos1').DataTable( {
        dom: 'Bfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ]
    } );
} );

function edit_row1(no)
{
	document.getElementById("edit_buttona"+no).style.display="none";
	document.getElementById("save_buttona"+no).style.display="block";
	
	var productoa=document.getElementById("P_rowa"+no);
	var cantidada=document.getElementById("C_rowa"+no);
	var emaila=document.getElementById("e_rowa"+no);
	var direcciona=document.getElementById("d_rowa"+no);
	var detallea=document.getElementById("de_rowa"+no);

	
	var producto_dataa=productoa.innerHTML;
	var cantidad_dataa=cantidada.innerHTML;
	var email_dataa=emaila.innerHTML;
	var direccion_dataa=direcciona.innerHTML;
	var detalle_dataa=detallea.innerHTML;
	
	
	productoa.innerHTML="<input type='text' id='producto_texta"+no+"' value='"+producto_dataa+"'>";
	cantidada.innerHTML="<input type='text' id='cantidad_texta"+no+"' value='"+cantidad_dataa+"''>";
	emaila.innerHTML="<input type='text' id='email_texta"+no+"' value='"+email_dataa+"''>";
	direcciona.innerHTML="<input type='text' id='direccion_texta"+no+"' value='"+direccion_dataa+"''>";
	detallea.innerHTML="<input type='text' id='detalle_texta"+no+"' value='"+detalle_dataa+"''>";
	
}

function save_row1(no)
{
	var pro_vala=document.getElementById("producto_texta"+no).value;
	var can_vala=document.getElementById("cantidad_texta"+no).value;
	var ema_vala=document.getElementById("email_texta"+no).value;
	var dir_vala=document.getElementById("direccion_texta"+no).value;
	var det_vala=document.getElementById("detalle_texta"+no).value;


	document.getElementById("P_rowa"+no).innerHTML=pro_vala;
	document.getElementById("C_rowa"+no).innerHTML=can_vala;
	document.getElementById("e_rowa"+no).innerHTML=ema_vala;
	document.getElementById("d_rowa"+no).innerHTML=dir_vala;
	document.getElementById("de_rowa"+no).innerHTML=det_vala;
	

	document.getElementById("edit_buttona"+no).style.display="block";
	document.getElementById("save_buttona"+no).style.display="none";
}

function delete_row1(no)
{
	document.getElementById("rowa"+no+"").outerHTML="";
}

function add_row1()
{

	var new_proa=document.getElementById("new_proa").value;
	var new_cana=document.getElementById("new_cana").value;
	
	
	var tablea=document.getElementById("dataProductos1");
	var table_lena=(tablea.rows.length)-1;
	var rowa = tablea.insertRow(table_lena).outerHTML="<tr id='rowa"+table_lena+"'><td id='P_rowa"+table_lena+"'>"+new_proa+"</td><td id='C_rowa"+table_lena+"'>$"+new_cana+"</td><td><span id='edit_buttona"+table_lena+"' value='Edit' class='icofont icofont-ui-edit edit' onclick='edit_row1("+table_lena+")'></span> <span id='save_buttona"+table_lena+"' value='Save' class='icofont icofont-save save save' style='display: none;' onclick='save_row1("+table_lena+")'></span> <span value='Delete' class='icofont icofont-ui-delete delete delete' onclick='delete_row1("+table_lena+")'></span></td></tr>";

	document.getElementById("new_proa").value="";
	document.getElementById("new_cana").value="";
	
}