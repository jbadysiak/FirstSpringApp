package com.packt.webstore.domain.repository.impl;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.*;

@Repository
public class InMemoryProductRepository implements ProductRepository{

    private List<Product> listOfProducts = new ArrayList<Product>();

    public InMemoryProductRepository() {
        Product iPhone = new Product("P1234","iPhone 6s",new BigDecimal(600));
        iPhone.setDescription("Apple iPhone 6s, mega zajebisty smartphone");
        iPhone.setCategory("SmartPhone");
        iPhone.setManufacturer("Apple");
        iPhone.setUnitsInStock(1000);

        Product laptop_dell = new Product("D1234", "Dell Inspiron 15",new BigDecimal(500));
        laptop_dell.setDescription("Dell Inspiron 15, 15-calowy laptop itd.");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setUnitsInStock(976);
        laptop_dell.setManufacturer("Dell");

        Product tablet_Nexus = new Product("N1234", "Nexus 7", new BigDecimal(279));
        tablet_Nexus.setDescription("Google Nexus 7 jest lekkim, 7-calowym tabletem itd.");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setUnitsInStock(243);

        listOfProducts.add(iPhone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
    }
    public List<Product> getAllProducts(){
        return listOfProducts;
    }

    public Product getProductById(String productId) {
        Product productById = null;
        for(Product product : listOfProducts){
            if (product != null && product.getProductId() != null && product.getProductId().equals(productId)){
                productById = product;
                break;
            }
        }
        if (productById == null){
            throw new IllegalArgumentException("Brak produktu o wskazanym id: "+productId);
        }
        return productById;
    }

    public List<Product> getProductByCategory(String category) {
        List <Product> productsByCategory = new ArrayList<Product>();
        for(Product product : listOfProducts){
            if (category.equalsIgnoreCase(product.getCategory())){
                productsByCategory.add(product);
            }
        }
        return productsByCategory;
    }

    public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();
        Set<String> criterias = filterParams.keySet();

        if (criterias.contains("brand")){
            for (String brandName : filterParams.get("brand")){
                for (Product product : listOfProducts){
                    if (brandName.equalsIgnoreCase(product.getManufacturer())){
                        productsByBrand.add(product);
                    }
                }
            }
        }

        if (criterias.contains("category")){
            for (String category : filterParams.get("category")){
                productsByCategory.addAll(this.getProductByCategory(category));
            }
        }
        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;
    }
}
