package com.verint.demo.catalog.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.verint.demo.catalog.form.BookForm;
import com.verint.demo.catalog.model.Book;
import com.verint.demo.catalog.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/list")
    public String findBookList(Model model){
        List<Book> books = bookService.findBookAll();
        model.addAttribute("books",books);
        return "book/book-list";
    }

    @GetMapping("/new")
    public String loadBookForm(Model model){
        model.addAttribute("bookForm", new BookForm());
        return "book/book-create";
    }

    @PostMapping("/new")
    public String addNewBook(@ModelAttribute("bookForm")  @Valid BookForm bookForm,
                             BindingResult bindingResult,
                             Errors errors,
                             Model model){
        if (errors.hasErrors()){
            model.addAttribute("bookForm", bookForm);
            return "book/book-create";
        }
        bookService.createANewBook(bookForm);
        return "redirect:/book/list";
    }

}
