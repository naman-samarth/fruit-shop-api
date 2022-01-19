package com.naman.springmvcrest.bootstrap;

import com.naman.springmvcrest.domain.Category;
import com.naman.springmvcrest.domain.Customer;
import com.naman.springmvcrest.domain.Vendor;
import com.naman.springmvcrest.repositories.CategoryRepository;
import com.naman.springmvcrest.repositories.CustomerRepository;
import com.naman.springmvcrest.repositories.VendorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public DataLoader(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) {
        loadCategories();
        loadCustomers();
        loadVendors();
    }

    private void loadVendors() {
        String[] vendors = {
                "Western Tasty Fruits Ltd.",
                "Exotic Fruits Company",
                "Home Fruits",
                "Fun Fresh Fruits Ltd.",
                "Nuts for Nuts Company"
        };

        for (String name : vendors) {
            Vendor vendor = new Vendor();
            vendor.setName(name);
            vendorRepository.save(vendor);
        }
        log.info(vendorRepository.count() + " vendors loaded");

    }

    private void loadCustomers() {
        String[] customers = {
                "Jake Peralta",
                "Amy Santiago",
                "Raymond Hold",
                "Charles Boyle",
                "Gina Linetti",
                "Terry Jeffords"
        };

        for (String customerFullName : customers) {
            String[] fullNameArray = customerFullName.split(" ");
            Customer customer = new Customer();
            customer.setFirstName(fullNameArray[0]);
            customer.setLastName(fullNameArray[1]);
            customerRepository.save(customer);
        }
        log.info(customerRepository.count() + " customers loaded");
    }

    private void loadCategories() {
        String[] categories = {"Fruits", "Dried", "Fresh", "Exotic", "Nuts"};

        for (String name : categories) {
            Category category = new Category();
            category.setName(name);
            categoryRepository.save(category);
        }
        log.info(categoryRepository.count() + " categories loaded");
    }
}
