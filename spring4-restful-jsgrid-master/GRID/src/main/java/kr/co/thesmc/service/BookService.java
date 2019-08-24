package kr.co.thesmc.service;

import java.util.List;
import java.util.Map;

import kr.co.thesmc.model.Book;

public interface BookService {
	List<Book> getBookList(Map<String, String> filter) throws Exception;
	void getBookInsert(Book vo) throws Exception;
	void getBookUpdate(Book vo) throws Exception;
	void getBookDelete(String id) throws Exception;
}
