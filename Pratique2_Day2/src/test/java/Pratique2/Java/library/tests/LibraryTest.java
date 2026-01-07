package Pratique2.Java.library.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import Pratique2.Java.library.adapter.OldBookAdapter;
import Pratique2.Java.library.adapter.OldBookSystem;
import Pratique2.Java.library.core.Role;
import Pratique2.Java.library.decorator.ValidationBookReader;
import Pratique2.Java.library.proxy.SecureBookReaderProxy;

public class LibraryTest {
    @Test
    public void testReadBookFlow() {
        OldBookSystem sys = new OldBookSystem();
        OldBookAdapter adapter = new OldBookAdapter(sys);
        assertEquals("LivreAncien[ABC]", adapter.readBook("ABC"));

        ValidationBookReader valid = new ValidationBookReader(adapter);
        assertEquals("LivreAncien[ABC]", valid.readBook("ABC"));

        SecureBookReaderProxy proxy = new SecureBookReaderProxy(valid, Role.ADMIN);
        assertEquals("LivreAncien[ABC]", proxy.readBook("ABC"));
    }
}
