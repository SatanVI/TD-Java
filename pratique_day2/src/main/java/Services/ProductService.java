package Services;

import DTO.ProductDTO;
import Modele.Product;
import repositories.ProductRepository;

public class ProductService {
    private final ProductRepository repo = new ProductRepository();

    public void createProduct(ProductDTO dto) {
        // 1) Validation métier
        if (dto == null) {
            throw new IllegalArgumentException("Données du produit manquantes.");
        }
        if (dto.name == null || dto.name.isBlank()) {
            throw new IllegalArgumentException("Nom invalide.");
        }
        if (dto.price <= 0) {
            throw new IllegalArgumentException("Prix invalide.");
        }

        // 2) Transformation DTO → Domain
        Product product = new Product(dto.name, dto.price);

        // 3) Persistance
        repo.save(product);
    }
}




