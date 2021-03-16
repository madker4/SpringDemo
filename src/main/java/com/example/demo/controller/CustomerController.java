package com.example.demo.controller;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Gender;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> index(){

        final List<Customer> customers = customerService.index();

        if (customers != null && customers.size() != 0)
        {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(customers, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> show(@PathVariable("id") Integer id)
    {
        final Customer customer = customerService.read(id);

        return customer != null
                ? new ResponseEntity<>(customer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/new")
//    public String newCustomer(Model model)
//    {
//        model.addAttribute("customer", new Customer());
//        model.addAttribute("genders", Gender.values());
//        return "customer/new";
//
//    }
    @PostMapping()
    public ResponseEntity<?> create(@RequestBody Customer customer)
    {
        customerService.create(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

//    @GetMapping("/{id}/edit")
//    public String edit(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("customer", custDAO.show(id));
//        List<Gender> genders = Arrays.asList(Gender.values().clone());
//
//        model.addAttribute("genders", genders);
//        return "customer/edit";
//    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Customer customer)
    {
        final boolean upd = customerService.update(customer,id);

        return upd
                ? new ResponseEntity<>(customer, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        final boolean deleted = customerService.delete(id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
