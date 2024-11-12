package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.vo.BookStoreVO;

@Mapper
public interface BookStoreRepository {
	
	@Delete("""
			TRUNCATE TABLE bookStore;
			""")
	void truncateTable();

	@Insert("""
			INSERT INTO bookStore
				SET `name` = #{name}
			""")
	void insertStore(String name);


	@Select("""
			SELECT `name`
				FROM bookStore
			""")
	List<BookStoreVO> selectBookStores();

	@Update("""
			ALTER TABLE bookStore
				CHANGE 아이티문고 #{sting} VARCHAR(20);
			""")
	void modifyStoreName(int i, String string);
	
}
