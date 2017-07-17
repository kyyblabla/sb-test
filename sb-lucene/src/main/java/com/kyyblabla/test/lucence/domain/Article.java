package com.kyyblabla.test.lucence.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by kyy on 2017/7/17.
 */
@Data
public class Article {

    private Integer id;
    private String title;
    private String author;
    private String content;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
    private List<String> tags;

}
