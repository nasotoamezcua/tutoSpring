package com.nasoto.tiendavirtual.web.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nasoto.tiendavirtual.dto.OrderDto;
import com.nasoto.tiendavirtual.dto.UserDto;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.IOrderItemsService;
import com.nasoto.tiendavirtual.service.api.IOrderService;
import com.nasoto.tiendavirtual.service.api.IUserService;
import com.nasoto.tiendavirtual.web.utils.AuthenticationUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("CuentaControler")
@RequestMapping(value = "/cuentaUser")
public class CuentaControler {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IOrderService orderService;
	
	@Autowired
	private IOrderItemsService orderItemService;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	private String showCuentaUser(Model model){
		log.info("show showCuentaUser page ------------------");
		
		try{
			
			UserDto userDto = userService.getUserByNameService(AuthenticationUser.authenticationUser());
			model.addAttribute("userDto",userDto);
			
			List<OrderDto> orderDtoList = orderService.getOrderCustomerByUserIdService(userDto.getIdUser());
				if(orderDtoList != null && orderDtoList.size()>0){
					for(OrderDto oDto: orderDtoList){
						oDto.setOrderItemsDto(orderItemService.getOrderItemsFindByIdOrder(oDto.getIdOrder()));
					}
				}
			
			model.addAttribute("orderDtoList",orderDtoList);
			
			
		}catch(ServiceException e){
			log.info("Error showCuentaUser page ------------------");
		}
		
		return "userCuenta/showCuenta";
	}
	
	

}
