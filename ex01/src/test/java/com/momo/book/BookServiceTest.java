package com.momo.book;

import static org.junit.Assume.assumeNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;

import com.momo.service.BookService;
import com.momo.vo.BookVO;
import com.momo.vo.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BookServiceTest {
	
	@Autowired
	BookService bookService;
	
	@Test
	public void getList(Criteria cri, Model model) {
		assumeNotNull(bookService);
		List<BookVO> list = bookService.getList(cri, model);
		
		list.forEach(book->{
			log.info("=========");
			log.info("book: " + book);
		});
	}
	
	
	@Test
	public void getOne() {
		assumeNotNull(bookService);
		BookVO book = bookService.getOne(49, null);
	}
	
}
