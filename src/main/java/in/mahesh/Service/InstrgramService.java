package in.mahesh.Service;

import java.util.Optional;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import in.mahesh.entity.Instrgram;

public interface InstrgramService {
	@EventListener(ApplicationReadyEvent.class)
	public boolean saveInstrgram(Instrgram i);
	
	public Instrgram checkLoginDetails(String mailId , String password);
	
	public Optional<Instrgram> checkExsitOrNot(String mailId);
	
	public boolean forgotPassword(String mail);

}
