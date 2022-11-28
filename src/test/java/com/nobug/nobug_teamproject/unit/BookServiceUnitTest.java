package com.nobug.nobug_teamproject.unit;


import com.nobug.nobug_teamproject.mapper.BookMapper;
import com.nobug.nobug_teamproject.models.Book;
import com.nobug.nobug_teamproject.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceUnitTest {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookMapper bookMapper;

    @Test
    void testGetBook() {
        int testBookID = 1000;
        Book book = new Book(testBookID, "mock book", "mock category");
        List<Book> books = new ArrayList<>();
        books.add(book);

        Mockito.when(bookMapper.getBookId(testBookID)).thenReturn(books);

        assertEquals("mock book", (bookService.getBookId(testBookID)).get(0).getBookName());
    }

    @Test
    void testGetBookID() {
        int testBookID = 1000;
        Book book = new Book(testBookID, "mock book", "mock category");
        List<Book> books = new ArrayList<>();
        books.add(book);

        Mockito.when(bookMapper.getBookId(testBookID)).thenReturn(books);

        assertEquals(testBookID, (bookService.getBookId(testBookID)).get(0).getBookID());
    }

    @Test
    void testGetBookCategory() {
        int testBookID = 1000;
        Book book = new Book(testBookID, "mock book", "mock category");
        List<Book> books = new ArrayList<>();
        books.add(book);

        Mockito.when(bookMapper.getBookId(testBookID)).thenReturn(books);

        assertEquals("mock category", (bookService.getBookId(testBookID)).get(0).getCategory());
    }

    @Test
    void testDeleteBook() {
        int testBookID = 1000;
        Book book = new Book(testBookID, "mock book", "mock category");

        Mockito.doNothing().when(bookMapper).deleteBookId(testBookID);

        bookService.deleteBookId(testBookID);

        Mockito.verify(bookMapper).deleteBookId(testBookID);
    }

    @Test
    void testUpdateBookName() {
        int testBookID = 1000;
        String bookNewName = "new name";
        Book book = new Book(testBookID, "mock book", "mock category");

        Mockito.doNothing().when(bookMapper).updateBookName(testBookID, bookNewName);

        bookService.updateBookName(testBookID, bookNewName);

        Mockito.verify(bookMapper).updateBookName(testBookID, bookNewName);
    }

    @Test
    void testUpdateBookCategory() {
        int testBookID = 1000;
        String bookNewCategory = "new category";
        Book book = new Book(testBookID, "mock book", "new category");

        Mockito.doNothing().when(bookMapper).updateBookName(testBookID, bookNewCategory);

        bookService.updateBookName(testBookID, bookNewCategory);

        Mockito.verify(bookMapper).updateBookName(testBookID, bookNewCategory);
    }
}
