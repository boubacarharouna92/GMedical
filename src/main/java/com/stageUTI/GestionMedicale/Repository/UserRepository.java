package com.stageUTI.GestionMedicale.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stageUTI.GestionMedicale.Beans.User;


public interface UserRepository extends JpaRepository<User, String> {

	List<User> findByNameLike(String name);

}
