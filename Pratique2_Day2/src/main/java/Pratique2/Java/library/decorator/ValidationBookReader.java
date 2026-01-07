package Pratique2.Java.library.decorator;

import Pratique2.Java.library.core.BookReader;

public class ValidationBookReader implements BookReader {
    private final BookReader delegate;

    public ValidationBookReader(BookReader delegate) {
        this.delegate = delegate;
    }

    @Override
    public String readBook(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Le titre ne doit pas être vide");
        }
        return delegate.readBook(title);
    }
}
