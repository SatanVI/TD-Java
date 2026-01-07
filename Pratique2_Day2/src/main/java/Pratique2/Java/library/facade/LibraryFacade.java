package Pratique2.Java.library.facade;

import Pratique2.Java.library.core.Role;
import Pratique2.Java.library.facade.services.CatalogService;
import Pratique2.Java.library.facade.services.NotificationService;
import Pratique2.Java.library.facade.services.PaymentService;

public class LibraryFacade {
    private final CatalogService catalog = new CatalogService();
    private final PaymentService payment = new PaymentService();
    private final NotificationService notification = new NotificationService();

    public void borrowBook(String title, Role role) {
        if (!catalog.isAvailable(title)) {
            System.out.println("Indisponible : " + title);
            return;
        }
        payment.chargeUser(role, 0.0);
        notification.notifyUser("Emprunté : " + title);
    }
}
