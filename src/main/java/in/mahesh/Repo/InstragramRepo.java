package in.mahesh.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mahesh.entity.Instrgram;


public interface InstragramRepo extends JpaRepository<Instrgram, Integer> {
	
	public Instrgram findByMailAndPassword(String mail,String password);

	
	public Optional<Instrgram>  findByMail(String mail);
	
	
	
	
}
