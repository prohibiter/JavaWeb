import com.spring.bean.Book;
import com.spring.service.BookService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class BookTest {

    @Test
    public void bookTest(){
        Book book = new Book();
        book.setBookId("1234");
        book.setName("sdasdad");
        Book book1 = new Book();
        book1.setBookId("1235");
        book1.setName("sdasdad");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("druid.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
//        bookService.addBook(book);
        List<Object[]> books = new ArrayList<>();
        books.add(book.getString());
        books.add(book1.getString());
        bookService.batchAdd(books);
    }
}
