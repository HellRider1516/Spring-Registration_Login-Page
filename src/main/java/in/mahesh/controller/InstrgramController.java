package in.mahesh.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.mahesh.Repo.InstragramRepo;
import in.mahesh.Service.InstrgramServiceImp;
import in.mahesh.entity.Instrgram;

@Controller
public class InstrgramController {
	@Autowired
	private InstrgramServiceImp service;
	
	@Autowired
	private InstragramRepo repo;
	
	@GetMapping("/loginPage")
	public String loadTheDetails(Model model) {
		model.addAttribute("loginobj", new Instrgram());
		return "login";
	}
	
	@PostMapping("/loginPage")
	public String handleTheData(Model model , Instrgram i) {
		Instrgram status = service.checkLoginDetails(i.getMail(),i.getPassword());
		if(status != null) {
			model.addAttribute("loginobj", new Instrgram());
			model.addAttribute("msg", "welcom to my world.................." );
			return "dashboard";
		}else {
			model.addAttribute("loginobj", new Instrgram());
			model.addAttribute("error", "Invaild Creditals");
		}
		return "login";
	}
	
	
	@GetMapping("/page")
	public String loadTheRegistration(Model model) {
		model.addAttribute("obj", new Instrgram());
		return "register";
	}
	
	@PostMapping("/page")
	public String handleTheRegistration(Instrgram i , Model model) {
		
		Optional<Instrgram> check = service.checkExsitOrNot(i.getMail());
		
		if(check.isPresent()) {
			model.addAttribute("msg", "Already Account has been created with mail Id");
			model.addAttribute("obj", new Instrgram());
			return "register";
		}
		boolean status = service.saveInstrgram(i);
		if(status) {
			model.addAttribute("sucess", "Account Created");
			model.addAttribute("obj", new Instrgram());
			return "register";
		}else {
			model.addAttribute("error", "Invaild Creditals");
			model.addAttribute("obj", new Instrgram());
			return "register";
		}
		
	}
	
	
	@GetMapping("/dashboard")
	public String logout(Model model) {
		model.addAttribute("msg", "welcom to my world.................." );
		return "dashboard";
	}
	
	
	
	
	@GetMapping("/forgot")
	public String loadForgotPasswordData(Model model) {
		model.addAttribute("forgotobj", new Instrgram());
		return "forgot";
	}
	
	
	@PostMapping("/forgot")
	public String handleForgotPasswordData(@RequestParam("mail") String mail, Model model) {
		boolean status = service.forgotPassword(mail);
		if(status) {
			model.addAttribute("sucess", "Password has been sended to your Email...");
			model.addAttribute("forgotobj", new Instrgram());
			return "forgot";
			
		}else{
			model.addAttribute("error", "Incorrect Creditals");
			model.addAttribute("forgotobj", new Instrgram());
			return "forgot";
		}
		
		
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
