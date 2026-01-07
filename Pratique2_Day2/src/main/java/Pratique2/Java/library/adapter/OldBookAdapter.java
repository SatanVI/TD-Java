package Pratique2.Java.library.adapter;

import Pratique2.Java.library.core.BookReader;

public class OldBookAdapter implements BookReader {
    private final OldBookSystem adaptee;

    public OldBookAdapter(OldBookSystem adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public String readBook(String title) {
        return adaptee.getBook(title);
    }
}
