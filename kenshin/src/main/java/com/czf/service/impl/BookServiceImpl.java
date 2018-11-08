package com.czf.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czf.dao.BookDao;
import com.czf.entity.Book;
import com.czf.service.BookService;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> getBookList() {
        return bookDao.getBookList();
    }

    @Override
    public void saveBook(Book book) {
    	book.setName("ssh2");
    	book.setDescription("ssh2");
    	bookDao.saveBook(book);  

    	book.setName("book2");
    	book.setDescription("book2");
    	bookDao.saveBook(book);        
    }

    @Override
    public void deleteBook(int bookId) {
        bookDao.deleteBook(bookId);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);        
    }

    @Override
    public Book getBookByBookId(int bookId) {
        return bookDao.getBookByBookId(bookId);
    }
    
    
}

