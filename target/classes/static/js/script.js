/**
 * 
 */

$(document).ready(function() {
	consultation = $('#consultation').val();
	
	$.get('../GetParametreUser',{consultation:consultation},function(dat2){
    	$('#pv').html(dat2);
    });
			/*   Parametre Vital     */
	
	$('#btnparametrevital').click(function(){
		
        $.get('../AjouterMesure',function(dat){ 
	                $('#div_info').html(dat);
	                $("#myModal").modal('show');
	                
	                $('#addparametre').click(function(){
			                valeur= $('#valeur').val();
			                parametre = $('#parametre').val();
			                consultation = $('#consultation').val();
			                $.get('../AddParametreUser',{valeur:valeur,parametre:parametre,consultation:consultation},function(dat2){
					                	
				                	$('#pv').html(dat2);
				                });
			                $("#myModal").attr('data-dismiss','modal');
			                $("#myModal").click();
	                	}); 
            	});
			});
        			

        $('#btnsymptome').click(function(){
     		
            $.get('../AjoutSymptome',function(dat){ 
                    $('#div_info').html(dat);
                    $("#myModal").modal('show');
                    $('#addsymptome').click(function(){
                    	libelle= $('#libelle').val();
	                        consultation = $('#consultation').val();
	                        $.get('../AddSymptomeUser',{libelle:libelle,consultation:consultation},function(dat2){
	                        	
	                        	$('#sp').html(dat2);
	                        });
		                    $("#myModal").attr('data-dismiss','modal');
		                    $("#myModal").click();
                    	});
                	});  
        		}); 
        
            $('#btnexamen').click(function(){
         		
                $.get('../examen',function(dat){ 
                        $('#div_info').html(dat);
                        $("#myModal").modal('show');
                        $('#addexamen').click(function(){
	                            libelle= $('#libelle').val();
	                            consultation = $('#consultation').val();
	                            $.get('../AddExamenUser',{libelle:libelle,consultation:consultation},function(dat2){
	                            	
	                            	$('#sp').html(dat2);
	                            });
	                   
		                        $("#myModal").attr('data-dismiss','modal');
		                        $("#myModal").click();
	                        });
                    	});
            		});
   
    		
	
	 
   
	$('.nbtn, .table .eBtn ').on('click', function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		var text = $(this).text();
		if (text == "Edit") {
			$.get(href, function(patient, status) {
				
				$('.myForm #nom').val(patient.nom);
				$('.myForm #prenom').val(patient.prenom);
				$('.myForm #dateNaissance').val(patient.dateNaissance);
				$('.myForm #lieuNaissance').val(patient.lieuNaissance);
				$('.myForm #sexe').val(patient.sexe);
				$('.myForm #telephone').val(patient.telephone);
				$('.myForm #adresse').val(patient.adresse);
				$('.myForm #profession').val(patient.profession);
				

			});

			$('.myForm #exampleModal').modal();
		} else {

			$('.myForm #nom').val('');
			$('.myForm #prenom').val('');
			$('.myForm #dateNaissance').val('');
			$('.myForm #lieuNaissance').val('');
			$('.myForm #sexe').val('');
			$('.myForm #telephone').val('');
			$('.myForm #adresse').val('');
			$('.myForm #profession').val('');
			$('.myForm #exampleModal').modal();

		}
	});
	
	$('.table .delBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#myModel #delRef').attr('href',href);
		$('#myModel').modal();
		
		
		
	});

	
	$('.table .MBtn').on('click',function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#ModalConst').attr('href',href);
		$('#ModalConst').modal();
	
	});


	
});