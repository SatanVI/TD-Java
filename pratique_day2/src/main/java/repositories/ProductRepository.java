package repositories;

import Modele.Product;

public class ProductRepository {
    public void save(Product product) {
        // Code to save product to a database or data structure (simulé)
        System.out.println("Sauvegarde -> " + product.getName() + " " + product.getPrice() + " dhs");
    }
}
