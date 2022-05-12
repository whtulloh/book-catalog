package com.verint.demo.catalog.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BookForm {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotBlank
    private String description;
}
