package Pratique2.Java.library.decorator;

import Pratique2.Java.library.core.BookReader;

public class LoggingBookReader implements BookReader {
    private final BookReader delegate;

    public LoggingBookReader(BookReader delegate) {
        this.delegate = delegate;
    }

    @Override
    public String readBook(String title) {
        System.out.println("[JOURNAL] lecture: " + title);
        return delegate.readBook(title);
    }
}
