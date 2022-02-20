/**
 * 
 */

$('document').ready(function() {
	
	$('#editButton').on('click',function(event){		
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(profile, status){
			$('#idEdit').val(profile.id);
			$('#txtUsernameEdit').val(profile.username);
			$('#txtBioEdit').val(profile.bio);
			$('#txtTelephoneEdit').val(profile.telephone);
			$('#ddlDepartementEdit').val(profile.departement);
			$('#txtCommuneEdit').val(profile.commune);
			$('#txtAddressEdit').val(profile.adresse);
			$('#ddProfessionEdit').val(profile.profession);
			
/*			var dateNaissance = profile.dateNaissance.substr(0,10);
			$('#dateNaissanceEdit').val(dateNaissance);*/
			
			
			$('#txtEmailEdit').val(profile.email);
			$('#txtSiteEdit').val(profile.site);
			$('#txtLinkedinEdit').val(profile.linkedin);
			$('#txtFacebookEdit').val(profile.facebook);
			$('#txtImageEdit').val(profile.photo);

		});			
		$('#editModal').modal();		
	});
	
	$('.table #detailsButton').on('click',function(event) {
		event.preventDefault();		
		var href= $(this).attr('href');		
		$.get(href, function(country, status){
			$('#idDetails').val(country.id);
			$('#descriptionDetails').val(country.description);
			$('#codeDetails').val(country.code);
			$('#lastModifiedByDetails').val(country.lastModifiedBy);
			$('#lastModifiedDateDetails').val(country.lastModifiedDate.substr(0,19).replace("T", " "));
		});			
		$('#detailsModal').modal();		
	});	
	
	$('#deleteButton').on('click',function(event) {
		event.preventDefault();
		var href = $(this).attr('href');
		$('#deleteModal #delRef').attr('href', href);
		$('#deleteModal').modal();		
	});	
	
	$('#photoButton').on('click', function(event){
		event.preventDefault();
		var href = $(this).attr('href');
		$('#photoModal #employeePhoto').attr('src', href);
		$('#photoModal').modal();		
	});
});



