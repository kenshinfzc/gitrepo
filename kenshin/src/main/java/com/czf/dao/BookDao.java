package com.czf.dao;

import java.util.List;

import com.czf.entity.Book;


public interface BookDao{

    public List<Book> getBookList();
    
    public void saveBook(Book book);
    
    public void deleteBook(int bookId);
    
    public void updateBook(Book book);
    
    public Book getBookByBookId(int bookId);
}

