package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.BookVO;

@Mapper
public interface BookRepository {

	@Delete("""
			TRUNCATE TABLE book;
			""")
	void truncateTable();
	
	@Insert("""
			INSERT INTO book
				SET title = #{title}
					, author = #{author}
					, storeID = #{storeId}
			""")
	void insertBook(String title, String author, int storeId);

	@Select("""
			SELECT *
				FROM book;
			""")
	List<BookVO> selectBooks();
	
	@Select("""
			SELECT *
				FROM book b
				INNER JOIN bookStore bs
				ON b.storeId = bs.Id
				WHERE bs.name = #{storeName}
			""")
	List<BookVO> koreaBooks(String storeName);

	@Delete("""
			DELETE FROM book
				WHERE author = #{author}
			""")
	void deleteBookByAuthor(String author);
	

}
