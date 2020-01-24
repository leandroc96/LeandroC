package com.example.ProyectoPrueba.RepositorioCustomer;


import com.example.ProyectoPrueba.Exception.CustomerNotFoundException;
import com.example.ProyectoPrueba.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository

public class RepositorioCustomer {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Devuelve todos la tabla completa
    public List<Customer> getAllCustomers(){
        String sql= "SELECT * FROM customer";

        return  jdbcTemplate.query(sql, (rs, rowNum)
        -> new Customer (rs.getInt(1),
                         rs.getString(2),
                        rs.getString(3)));

    }
    // Filtra por id

    public Customer getCustomerById(int id) throws CustomerNotFoundException {
        String sql= "SELECT * FROM customer WHERE id = ? ";


        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum)
        -> new Customer( rs.getInt(1),
                         rs.getString(2),
                         rs.getString(3)));

    }

    //Filtra por nombre
    public List<Customer> getCustomerByNombre(String nombre) {
        String sql = "SELECT * FROM customer WHERE first_name= ?";
                return jdbcTemplate.query(sql, new Object[]{nombre}, (rs, rowNum)
        -> new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)));
    }
    //Actualiza valores por id
    public String updateCustomerById (int id, Customer cus){
        String sql = "UPDATE customer SET first_name = ?, last_name = ? WHERE id=?";

         jdbcTemplate.update(sql, cus.getFirstName(), cus.getLastName(), cus.getId() );

        return "Se ha actualizado el nombre("+cus.getFirstName()+") y apellido ("+cus.getLastName() +"), del customer con id"+ id;


    }

    //Agrega Customer
    public Customer addCustomer(Customer cus){
        String sql ="INSERT INTO customer (first_name, last_name) values (?,?)";
        jdbcTemplate.update(sql, cus.getFirstName(), cus.getLastName());

        return cus;
    }


    //Borra un customer
    public String deleteCustomerById (int id){
        String sql = "DELETE FROM customer WHERE id=?";
         jdbcTemplate.update(sql, id);
         return "Se ha eliminado el customer con id "+id;
    }

}
