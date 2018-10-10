package com.nasoto.tiendavirtual.web.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("loginControler")
public class LoginControler {
	
	@RequestMapping(value = {"","/","/login"} , method = RequestMethod.GET )
	public String showLoginPage(Model model,
			@RequestParam(required = false, value = "error") boolean error,
			@RequestParam(required = false, value = "sesion") boolean sesion ){
		
		log.info("show login page ------------------");
		
		if(error){
			model.addAttribute("errorMessage","Nombre de usuario o password incorrectos.");
		}if(sesion){
			model.addAttribute("errorMessage","Session Finalizada.");
		}
		
		/*
		try {
			List<ProductInfoDto> piDtoList = piService.getProductListAvailService();
			model.addAttribute("piDtoList",piDtoList);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			log.info("Error login page ------------------");
		}
		*/
		
		return  "login/login";
	}
	
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDenied(){
		return "error/403";
	}
	

}
