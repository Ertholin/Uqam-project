package com.mindsoft.immobilierproject;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mindsoft.immobilierproject.model.Proprietaire;
import com.mindsoft.immobilierproject.repository.ProprietaireRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProprietaireTests {

	@Autowired
	private ProprietaireRepository proprietaireRepository;	
	
	@Test
	public void testCreateProprietaire() {
		Proprietaire prop = new Proprietaire();
		prop.setId(7L);
		prop.setNom("Dorcelin");
		prop.setPrenom("Victorine");
		prop.setAdresse("Marin 26");
		prop.setSexe("Féminin");
		prop.setTelephone("50943432431");
		prop.setPhoto(null);
		
		Proprietaire createProp = proprietaireRepository.save(prop);
		assertNotNull(createProp);
	}
	
}





