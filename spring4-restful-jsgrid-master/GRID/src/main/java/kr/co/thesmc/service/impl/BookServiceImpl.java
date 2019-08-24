package kr.co.thesmc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.co.thesmc.dao.BookDao;
import kr.co.thesmc.model.Book;
import kr.co.thesmc.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Resource(name="bookDao")
    private BookDao bookDao;
 
    @Override
    public List<Book> getBookList(Map<String, String> filter) throws Exception {
        return bookDao.getBookList(filter);
    }

	@Override
	public void getBookInsert(Book vo) throws Exception {
		  bookDao.getBookInsert(vo);
		
	}

	@Override
	public void getBookUpdate(Book vo) throws Exception {
		 bookDao.getBookUpdate(vo);
	}

	@Override
	public void getBookDelete(String id) throws Exception {
		bookDao.getBookDelete(id);
		
	}
}
