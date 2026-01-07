package Pratique2.Java.library.core;

import Pratique2.Java.library.adapter.OldBookAdapter;
import Pratique2.Java.library.adapter.OldBookSystem;
import Pratique2.Java.library.decorator.LoggingBookReader;
import Pratique2.Java.library.decorator.ValidationBookReader;
import Pratique2.Java.library.facade.LibraryFacade;
import Pratique2.Java.library.proxy.SecureBookReaderProxy;

public class Main {
    public static void main(String[] args) {
        BookReader reader = new OldBookAdapter(new OldBookSystem());
        reader = new LoggingBookReader(reader);
        reader = new ValidationBookReader(reader);
        reader = new SecureBookReaderProxy(reader, Role.USER);

        System.out.println(reader.readBook("Le Petit Prince"));

        LibraryFacade facade = new LibraryFacade();
        facade.borrowBook("Les Misérables", Role.USER);
    }
}
