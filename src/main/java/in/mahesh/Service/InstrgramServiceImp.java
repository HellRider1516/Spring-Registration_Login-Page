package in.mahesh.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import in.mahesh.Repo.InstragramRepo;
import in.mahesh.entity.Instrgram;
import in.mahesh.mail.EmailSend;

@Service

public class InstrgramServiceImp implements InstrgramService {
	@Autowired
	private InstragramRepo repo;
	@Autowired
	private EmailSend mail;
	
	@EventListener
	
	@Override
	public boolean saveInstrgram(Instrgram i) {
		Instrgram saved = repo.save(i);
		if(saved.getId() != null) {
			mail.mailSend(saved.getMail(), "Instrgram Account", "Congrations your Instragram account has been Created Sucessfully..");
		}else {
			return false;
		}
		return true;
	}

	@Override
	public Instrgram checkLoginDetails(String mailId , String password) {
		Instrgram obj = repo.findByMailAndPassword(mailId,password);
		return obj;
	}
	

	

}
