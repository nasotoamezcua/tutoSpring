package com.nasoto.tiendavirtual.service.api;

import com.nasoto.tiendavirtual.dto.CustomerDto;
import com.nasoto.tiendavirtual.entities.Customer;
import com.nasoto.tiendavirtual.service.IGenericService;

public interface ICustomerService extends IGenericService<Customer, CustomerDto, Long> {

}
