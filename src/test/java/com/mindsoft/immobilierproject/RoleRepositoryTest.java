package com.mindsoft.immobilierproject;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.mindsoft.immobilierproject.model.Role;
import com.mindsoft.immobilierproject.model.User;
import com.mindsoft.immobilierproject.repository.RoleRepository;
import com.mindsoft.immobilierproject.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTest {
	
	@Autowired RoleRepository roleRepository;
	
	@Autowired UserRepository userRepository;
	
	@Autowired TestEntityManager entityManager;
	
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
	
	@Test
	public void testFindUserByEmail() {
		
		String username = "Ertholin";
		
		User user = userRepository.findByUsername(username);
		
		assertThat(user).isNotNull();
		
	}
	
	@Test
	public void addRoleToUser() {
		User user = new User();
		user.setEmail("junior1996@gmail.com");
		user.setPassword("junior19962021");
		user.setUsername("Junior1996");
		
		Role roleUser = roleRepository.findByName("User");
		
		user.addRole(roleUser);
		
		User savedUser = userRepository.save(user);
		
		assertThat(savedUser.getRoles().size()).isEqualTo(1);
	}
	
	@Test
	public void testAddRolesToExistingUser() {
		
		User user = userRepository.findByUsername("Ertholin");
		
		Role roleUser = roleRepository.findByName("User");
		user.addRole(roleUser);
		
		Role roleAdmin = new Role(2L);
		user.addRole(roleAdmin);
		
		User savedUser = userRepository.save(user);
		
		assertThat(savedUser.getRoles().size()).isEqualTo(2);
		
		
	}
	
	
}








