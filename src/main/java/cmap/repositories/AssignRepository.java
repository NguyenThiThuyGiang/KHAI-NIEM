package cmap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cmap.entity.Assign;
 
@Repository
public interface AssignRepository extends JpaRepository<Assign, Integer> {
	public Assign findById(int id);
}
