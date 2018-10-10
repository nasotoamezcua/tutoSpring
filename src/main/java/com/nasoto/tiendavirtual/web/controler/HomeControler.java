package com.nasoto.tiendavirtual.web.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nasoto.tiendavirtual.dto.ProductInfoDto;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IProductInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("homeControler")
@RequestMapping("/welcome")
public class HomeControler {
	
	@Autowired
	private IProductInfoService productService;
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String home(Model model){
		
		log.info("show home page ------------------");
		
		try{
			List<ProductInfoDto> piDtoList = productService.getProductListAvailService();
			model.addAttribute("piDtoList", piDtoList);
		}catch(ServiceException e){
			log.info("Error home page ------------------");
		}
		
		return "home/home";
	}

}
