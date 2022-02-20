package com.mindsoft.immobilierproject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.mindsoft.immobilierproject.model.Propriete;
import com.mindsoft.immobilierproject.repository.ProprieteRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProprieteTests {
	
	@Autowired 
	private ProprieteRepository proprieteRepository;
	
	@Test
	public void testListProprietes() {
		
		List<Propriete> proprietes = proprieteRepository.findAll();
		
		assertThat(proprietes).size().isGreaterThan(0);
	}
	
	@Test
	public void testDeletePropriete() {
		Long id = 6L;
		
		//Verify if Propriete exist before deleting
		boolean isExistBeforeDeleting = proprieteRepository.findById(id).isPresent();
		
		proprieteRepository.deleteById(id);
		
		//Verify if Propriete exist after deleting
		boolean isNotExistAfterDeleting = proprieteRepository.findById(id).isPresent();
				
		assertTrue(isExistBeforeDeleting);
		assertFalse(isNotExistAfterDeleting);
		
		
	}
	
	

}
