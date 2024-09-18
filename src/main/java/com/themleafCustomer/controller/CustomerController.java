package com.themleafCustomer.controller;

import com.themleafCustomer.model.Customer;
import com.themleafCustomer.service.CustomerService;
import com.themleafCustomer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {

    private final ICustomerService customerService = new CustomerService();
    @GetMapping("")
    public String showList(Model model){
          List<Customer> customers= customerService.findAll();
          model.addAttribute("customers", customers);
          return "list";
    }
    @GetMapping("/{id}/edit")
    public String update(@PathVariable Long id,Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "edit";
    }
    @PostMapping("/update")
    public String update(Customer customer){
        customerService.Update(customer.getId(), customer);
        return "redirect:/customers";
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirect) {
        customerService.Remove(customer.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customers";
    }
    @GetMapping("/{id}/view")
    public String findById(@PathVariable Long id, Model model){
        model.addAttribute("customer", customerService.findById(id));
        return "view";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }
   @PostMapping("/save")
    public String save(Customer customer){
        customerService.save(customer);
        return "redirect:/customers";
   }
}
