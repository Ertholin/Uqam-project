$("document").ready(function(){

	$('table #editButton').on('click', function(event){
		event.preventDefault();
		
		// /countries/findById/?id=1
		
		var href = $(this).attr('href');
		$.get(href, function(propriete, status){
			$('#idEdit').val(propriete.id);
			$('#typeProprieteEdit').val(propriete.typePropriete);
			$('#prixEdit').val(propriete.prix);
			$('#descriptionEdit').val(propriete.description);
			$('#statutEdit').val(propriete.statut);
			$('#localisationEdit').val(propriete.localisation);
			$('#proprietaireIdEdit').val(propriete.proprietaire.id);
			
			var date = propriete.date.substr(0,10);
			$('#dateEdit').val(date);
			
			$('#photoEdit').val(propriete.photo);
		});
		$('#editModal').modal();
	});
	
	$('table #deleteButton').on('click', function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		$('#confirmDeleteButton').attr('href', href);
		$('#deleteModal').modal();
	});
	
});