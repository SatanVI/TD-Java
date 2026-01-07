package Pratique2.Java.library.proxy;

import Pratique2.Java.library.core.BookReader;
import Pratique2.Java.library.core.Role;

public class SecureBookReaderProxy implements BookReader {
    private final BookReader delegate;
    private final Role role;

    public SecureBookReaderProxy(BookReader delegate, Role role) {
        this.delegate = delegate;
        this.role = role;
    }

    @Override
    public String readBook(String title) {
        if (role != Role.ADMIN && title != null && title.contains("Restricted")) {
            throw new SecurityException("Accès refusé au contenu restreint");
        }
        return delegate.readBook(title);
    }
}
