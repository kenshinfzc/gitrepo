

package com.czf.action;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.TransactionManager;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.ExceptionMappings;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.czf.service.BookService;

import com.opensymphony.xwork2.ActionSupport;

import com.czf.entity.Book;

@ParentPackage("struts-default") 

@Namespace("/book") 

@Results( { @Result(name = "success", location = "/views/main.jsp"), 

        @Result(name = "error", location = "/views/error.jsp") }) 

@ExceptionMappings( { @ExceptionMapping(exception = "java.lange.RuntimeException", result = "error") }) 
public class BookAction extends ActionSupport{
	private String username;
	@Resource
	private BookService bookService;
    
    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    @Action(value="test")
    public String test(){
        this.setUsername("strutsTest");
        return SUCCESS;
    }
    
    
    @Action(value = "bookView", results = { @Result(name = "success", location = "/index.jsp") })  
    public String bookView(){
        return SUCCESS;
    }
    
    @Action(value = "czfTest")
    @Transactional(propagation=Propagation.REQUIRED)
    public String czf(){
//    	List l = this.bookService.getBookList();
    	Book book = new Book();
    	this.bookService.saveBook(book);
    	return SUCCESS;
    }
}

