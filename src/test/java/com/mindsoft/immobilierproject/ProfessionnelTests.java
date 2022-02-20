package com.mindsoft.immobilierproject;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mindsoft.immobilierproject.model.Professionnel;
import com.mindsoft.immobilierproject.repository.ProfessionnelRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProfessionnelTests {
	
	@Autowired
	private ProfessionnelRepository professionnelRepository;
	
	
	@Test
	public void testCreerCompteProfessionnel() {
		
		Professionnel professionnel = new Professionnel();
		professionnel.setId(1L);
		professionnel.setNom("Louis");
		professionnel.setPrenom("Bernard");
		professionnel.setAdresse("Canaan 33");
		professionnel.setSexe("Masculin");
		professionnel.setTelephone("50931258978");
		
		Professionnel saveProf = professionnelRepository.save(professionnel);
		assertNotNull(saveProf);
	}
		

}
