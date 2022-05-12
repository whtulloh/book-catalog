package com.verint.demo.catalog.service.impl;

import com.verint.demo.catalog.form.BookForm;
import com.verint.demo.catalog.model.Book;
import com.verint.demo.catalog.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private List<Book> books = new ArrayList();

    public BookServiceImpl() {
        Book book1 = new Book();
        book1.setId("1");
        book1.setTitle("MY book 1");
        book1.setAuthor("Sir Conan");
        book1.setDescription("Lorem ipsum sit amet dolor van van");

        Book book2 = new Book();
        book2.setId("2");
        book2.setTitle("MY book 2");
        book2.setAuthor("Sir Leblanc");
        book2.setDescription("Lorem ipsum sit amet dolor van van");

        books.add(book1);
        books.add(book2);
    }

    @Override
    public List<Book> findBookAll() {

        return books;
    }

    @Override
    public void createANewBook(BookForm bookForm) {
        Book book = new Book();
        book.setTitle(bookForm.getTitle());
        book.setAuthor(bookForm.getAuthor());
        book.setDescription(bookForm.getDescription());
        book.setId(UUID.randomUUID().toString());
        books.add(book);
    }

}
