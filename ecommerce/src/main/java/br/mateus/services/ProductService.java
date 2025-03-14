package br.mateus.services;

import br.mateus.entity.Product;
import br.mateus.exception.InvalidInputException;
import br.mateus.exception.ResourceNotFoundException;
import br.mateus.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product createProduct(Product product) {
        if (product.getName() == null || product.getPrice() <= 0) {
            throw new InvalidInputException("Invalid product details");
        }
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
    }

    public Product updateProduct(Long id, Product productDetails) {
        if (productDetails.getName() == null || productDetails.getPrice() <= 0) {
            throw new InvalidInputException("Invalid product details");
        }
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setDescription(productDetails.getDescription());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
