package com.verint.demo.catalog.service;

import com.verint.demo.catalog.form.BookForm;
import com.verint.demo.catalog.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    public List<Book> findBookAll();

    public void createANewBook(BookForm bookForm);

}
