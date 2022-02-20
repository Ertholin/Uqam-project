package com.mindsoft.immobilierproject;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mindsoft.immobilierproject.model.Profile;
import com.mindsoft.immobilierproject.repository.ProfileRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProfileTests {
	
	@Autowired private ProfileRepository profileRepository;
	
	@Test
	public void testEnregistrerProfile() {
		
	Profile profile = new Profile(1L,"Nehemie",
				"Enseignante en Fondamentale","Ouest",
				"Nehemie Francois",
				"www.nehemiefrancois.com","Nehoue",
				"Nehemie.francois","Nehemie","Nehemie");
		
		Profile saveProfile = profileRepository.save(profile);
		
		assertNotNull(saveProfile);
		
	}
	
//	@Test
//	public void testCreateRoles() {
//		Role user = new Role("User");
//		Role admin = new Role("Admin");
//		Role proprietaire = new Role("Proprietaire");
//		Role professionnel = new Role("Professionnel");
//		
//		roleRepository.saveAll(List.of(user, admin, proprietaire, professionnel));
//	
//		List<Role> listRoles = roleRepository.findAll();
//		
//		assertThat(listRoles.size()).isEqualTo(4);
//	} 

}
