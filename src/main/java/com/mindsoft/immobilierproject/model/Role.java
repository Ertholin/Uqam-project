package com.mindsoft.immobilierproject.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    @ManyToMany
    private Set<Privilege> privileges;
    
    public Role() {
	}
    
    public Role(Long id) {
		this.id = id;
	}
    
    public Role(String name) {
		this.name = name;
	}

    public Role(Long id, String name) {
		this.id = id;
		this.name = name;
	}
    
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Privilege> getPrivileges() {
        return privileges;
    }

    public void setPrivileges(Set<Privilege> privileges) {
        this.privileges = privileges;
    }

	@Override
	public String toString() {
		return this.name;
	}
    
    
}
