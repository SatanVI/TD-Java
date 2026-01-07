package Main;

import Controllers.ProductController;
import DTO.ProductDTO;

public class Main {
    public static void main(String[] args) {
        ProductController controller = new ProductController();

        // Scénario 1: Produit OK
        runScenario(controller, new ProductDTO("Laptop", 9000));

        // Scénario 2: Erreur - nom vide
        runScenario(controller, new ProductDTO("", 100));

        // Scénario 3: Erreur - prix négatif
        runScenario(controller, new ProductDTO("Mouse", -10));
    }

    private static void runScenario(ProductController controller, ProductDTO dto) {
        try {
            controller.createProduct(dto);
        } catch (Exception e) {
            System.out.println("Erreur: " + e.getMessage());
        }
        System.out.println("---");
    }
}











