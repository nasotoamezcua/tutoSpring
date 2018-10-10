package com.nasoto.tiendavirtual.web.controler.jQueryAjax;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.nasoto.tiendavirtual.dto.CustomerDto;
import com.nasoto.tiendavirtual.dto.OrderComboboxDTO;
import com.nasoto.tiendavirtual.dto.OrderDto;
import com.nasoto.tiendavirtual.dto.UserDto;
import com.nasoto.tiendavirtual.dto.jQueryAjax.CutomerUserOrders;
import com.nasoto.tiendavirtual.service.ServiceException;
import com.nasoto.tiendavirtual.service.api.ICustomerService;
import com.nasoto.tiendavirtual.service.api.IOrderService;
import com.nasoto.tiendavirtual.service.api.IUserService;



@Controller("comboboxDependiemtes")
@RequestMapping("/jQueryAjax")
public class ComboboxDependiemtes {
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	IUserService userService;
	
	@Autowired
	IOrderService orderService;
	
	
	@RequestMapping(value = "/comboboxDependiemtes", method = RequestMethod.GET)
	public String comboboxDependiemtesForm(Model modelo){
		
		modelo.addAttribute("cutomerUserOrders", new CutomerUserOrders());
		
		return "jquery_ajax/comboboxDependiemtes";
	}
	
	@RequestMapping(value = "/selectCreateTable", method = RequestMethod.GET)
	public String selectCreateTable(Model model){
		
		model.addAttribute("cutomerUserOrders", new CutomerUserOrders());
		
		return "jquery_ajax/selectCreateTable";
	}
	
	
	@RequestMapping(value = "/comboboxOrdenIdCustomerProduces/{idCustomer}", method = RequestMethod.GET)
	@ResponseBody
	public List<OrderDto> comboboxOrdenIdCustomerProduces(@PathVariable("idCustomer") Long  idCustomer){
		
		List<OrderComboboxDTO> orderComboboxDTO = new ArrayList<OrderComboboxDTO>();
		List<OrderDto> orders = null;
		
		try {
			orders = orderService.getOrderFindByIdCustomerService(idCustomer);
			for(OrderDto o: orders){
				orderComboboxDTO.add(new OrderComboboxDTO(o.getIdOrder(),o.getIdOrder()) );
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return orders;
	}
	
	
	
	/**
	 * LLenar combobox "order" por idCustomer con Ajax/jQuery
	 * @param idCustomer
	 * @return
	 */
	@RequestMapping(value = "/comboboxOrdenIdCustomer/{idCustomer}", method = RequestMethod.GET)
	@ResponseBody
	public String comboboxOrdenIdCustomer(@PathVariable("idCustomer") Long  idCustomer){
		
		Gson gson = new Gson();
		List<OrderComboboxDTO> orderComboboxDTO = new ArrayList<OrderComboboxDTO>();
		
		try {
			List<OrderDto> orders = orderService.getOrderFindByIdCustomerService(idCustomer);
			for(OrderDto o: orders){
				orderComboboxDTO.add(new OrderComboboxDTO(o.getIdOrder(),o.getIdOrder()) );
			}
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return gson.toJson(orderComboboxDTO);
	}
	
	/**
	 * Generar Tabla "order" por idCustomer con Ajax/JQuery
	 * @param idCustomer
	 * @return
	 */
	@RequestMapping(value = "tableOrderIdCustomer/{idCustomer}", method = RequestMethod.GET )
	@ResponseBody
	public String tableOrderIdCustomer(@PathVariable("idCustomer") Long idCustomer){
		
		Gson gson = new Gson();
		
		List<OrderDto> orders = null;
		
		try{
			orders = orderService.getOrderFindByIdCustomerService(idCustomer);
		}catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return gson.toJson(orders);
	}
	
	/**
	 * LLenar combobox "order" por idCustomer con Ajax/jQuery
	 * @param idUser
	 * @return
	 */
	@RequestMapping(value = "/comboboxOrdenIdUser/{idUser}", method = RequestMethod.GET)
	@ResponseBody
	public String comboboxOrdenIdUser(@PathVariable("idUser") Long idUser){
		
		Gson gson = new Gson();
		List<OrderComboboxDTO> orderComboboxDTO = new ArrayList<OrderComboboxDTO>();
		
		try{
			List<OrderDto> orders = orderService.getOrderCustomerByUserIdService(idUser);
			for(OrderDto o : orders){
				orderComboboxDTO.add(new OrderComboboxDTO(o.getIdOrder(), o.getIdOrder()));
			}
		}catch(ServiceException e){
			e.printStackTrace();
		}
		
		return gson.toJson(orderComboboxDTO);
	}
	
	/**
	 *  Generar Tabla "order" por idUser con Ajax/JQuery
	 * @param idUser
	 * @return
	 */
	@RequestMapping(value = "tableOrdenIdUser/{idUser}", method = RequestMethod.GET)
	@ResponseBody
	public String tableOrdenIdUser(@PathVariable("idUser") Long idUser){
		
		Gson gson = new Gson();
		
		List<OrderDto> orders = null;
		
		try{
			orders = orderService.getOrderCustomerByUserIdService(idUser);
		}catch (ServiceException e) {
			e.printStackTrace();
		}
		
		return gson.toJson(orders);
	}
	
	
	@ModelAttribute("customers")
	public List<CustomerDto> customers() throws ServiceException{
		List<CustomerDto> customers = customerService.findAll();
		return customers;
	}
	
	@ModelAttribute("users")
	public List<UserDto> users() throws ServiceException{
		List<UserDto> users = userService.findAll();
		return users;
	}

}
