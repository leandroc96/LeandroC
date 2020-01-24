package com.example.ProyectoPrueba.Service;

import com.example.ProyectoPrueba.Exception.CustomerNotFoundException;
import com.example.ProyectoPrueba.Model.Customer;
import com.example.ProyectoPrueba.RepositorioCustomer.RepositorioCustomer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.List;
@Service
public class CustomerService {

    @Autowired
    RepositorioCustomer repo;

    public List<Customer> devolverTodo(){
        return repo.getAllCustomers();
    }


    public Customer buscarPorId(int id) throws CustomerNotFoundException {
        return repo.getCustomerById(id);
    }

    public List<Customer> buscarPorNombre(String nombre) {
        return repo.getCustomerByNombre(nombre);
    }
    public String actualizarPorId (int id, Customer cus){
        return repo.updateCustomerById(id, cus);
    }

    public Customer añadirCustomer (Customer cus){
        return repo.addCustomer(cus);
    }

    public String borrarCustomerPorId (int id){
        return repo.deleteCustomerById(id);
    }
}
