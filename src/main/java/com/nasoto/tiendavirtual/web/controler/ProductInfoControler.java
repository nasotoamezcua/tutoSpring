package com.nasoto.tiendavirtual.web.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nasoto.tiendavirtual.dto.ProductInfoDto;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IProductInfoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("productInfoControler")
@RequestMapping(value = {"/admin"})
public class ProductInfoControler {
	
	@Autowired
	private IProductInfoService productInfoService;
	
	@RequestMapping(value = {"/productInfo"}, method = RequestMethod.GET)
	public String adminProductInfoShow(Model model){
		
		try{
			List<ProductInfoDto> productInfoDtoList = productInfoService.findAll();
			
			model.addAttribute("productInfoDtoList", productInfoDtoList);
			
		}catch (ServiceException e) {
			log.info("Error adminProductInfo page ------------------");
		}
		
		return "admin/adminProductInfo";
	}
	
	
	@RequestMapping(value = "/productInfo/update/{idProduct}", method = RequestMethod.GET)
	public String adminProductInfoUpdate(
				@PathVariable("idProduct") Long idProduct,
				@RequestParam(value = "active") String active){
		try{
			ProductInfoDto producInfoDto = productInfoService.find(idProduct);
			if(active.trim().equals("A"))	producInfoDto.setProductAvail("Y");
			else	producInfoDto.setProductAvail("N");
			
			productInfoService.update(producInfoDto);
			
		}catch(ServiceException e){
			log.info("Error adminProductInfoUpdate page ------------------");
		}
		
		return "redirect:/admin/productInfo";
	}

}
