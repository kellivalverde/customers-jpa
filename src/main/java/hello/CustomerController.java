package hello;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@Resource
	CustomerRepository customerRepo;

	@RequestMapping("/customers")
	public String showAllCustomers(Model model) {
		model.addAttribute("customers", customerRepo.findAll());
		return "/customers"; // template

	}
	
	@RequestMapping("/sorted-customers")
	public String showAllSortedCustomers(Model model) {
		model.addAttribute("customers", customerRepo.findAllByOrderByLastNameAsc());
		return "/customers"; // template

	}
	
	@RequestMapping("/sorted-three")
	public String show3SortedCustomers(Model model) {
		model.addAttribute("customers", customerRepo.findFirst3ByOrderByLastNameAsc());
		return "/customers"; // template

	}
	

}
