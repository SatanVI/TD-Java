package Controllers;

import DTO.ProductDTO;
import Services.ProductService;

public class ProductController {
    private final ProductService service = new ProductService();

    public void createProduct(ProductDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("Body manquant.");
        }

        service.createProduct(dto);
        System.out.println("[HTTP 201] Produit créé ✅");
    }
}
