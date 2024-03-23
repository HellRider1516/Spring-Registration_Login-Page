package in.mahesh.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	private EmailSend mailSended;
	
	@EventListener
	
	@Override
	public boolean saveInstrgram(Instrgram i) {
		Instrgram saved = repo.save(i);
		if(saved.getId() != null) {
			mailSended.mailSend(saved.getMail(), "Instrgram Account", "Congrations your Instragram account has been Created Sucessfully..");
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

	@Override
	public Optional<Instrgram> checkExsitOrNot(String mailId) {
		 Optional<Instrgram> byMail = repo.findByMail(mailId);
		return byMail;
	}

	@Override
	public boolean forgotPassword(String mail) {
		Optional<Instrgram> byMail = repo.findByMail(mail);
		Instrgram instrgram = byMail.get();
		
		if(byMail != null) {
			mailSended.mailSend(instrgram.getMail(), "Forget Password request","hey..."+instrgram.getName()+"your password is"+instrgram.getPassword());
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	
	
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

}
