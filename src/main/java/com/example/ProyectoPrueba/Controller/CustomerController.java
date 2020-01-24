package com.example.ProyectoPrueba.Controller;

import com.example.ProyectoPrueba.Exception.CustomerNotFoundException;
import com.example.ProyectoPrueba.Model.Customer;
import com.example.ProyectoPrueba.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;


    @GetMapping("/Customer")
    public List<Customer> getAll(){
        return service.devolverTodo();
    }



    @GetMapping("/Customer/id/{id}")
    public Customer getById (@PathVariable(value = "id") int id) throws CustomerNotFoundException {
        return service.buscarPorId(id);
    }

    @GetMapping("/Customer/Nombre/{name}")
        public List<Customer> getByNombre(@PathVariable(value = "name")String nombre) {
        return service.buscarPorNombre(nombre);
    }

    @PutMapping("/Customer/update/{id}")
    public String updateByid(@PathVariable (value = "id") int id, @Valid @RequestBody Customer cus){
        return service.actualizarPorId(id, cus);
    }

    @PostMapping("/Customer/Insert")

    public Customer addCustomer (@Valid @RequestBody Customer cus){
        return service.añadirCustomer(cus);
    }

    @DeleteMapping("/Customer/Borrar/{id}")

    public String deleteById (@PathVariable(value = "id")int id){
        return service.borrarCustomerPorId(id);
    }
}
