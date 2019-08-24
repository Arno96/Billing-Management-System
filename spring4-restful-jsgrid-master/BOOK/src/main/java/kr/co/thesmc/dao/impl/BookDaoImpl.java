package kr.co.thesmc.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.thesmc.dao.BookDao;
import kr.co.thesmc.model.Book;

@Repository("bookDao")
public class BookDaoImpl implements BookDao{

    @Autowired
    private SqlSession sqlSession;
 
    public void setSqlSession(SqlSession sqlSession){
        this.sqlSession = sqlSession;
    }
 
    @Override
    public List<Book> getBookList(Map<String, String> filter) {
        return sqlSession.selectList("getBookList",filter);
    }

	@Override
	public void getBookInsert(Book vo) throws Exception {
		 sqlSession.insert("getBookInsert",vo);
	}

	@Override
	public void getBookUpdate(Book vo) throws Exception {
		 sqlSession.update("getBookUpdate",vo);
	}

	@Override
	public void getBookDelete(String id) throws Exception {
		sqlSession.delete("getBookDelete",id);
		
	}
}
