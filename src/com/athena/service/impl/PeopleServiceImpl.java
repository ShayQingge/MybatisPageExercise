package com.athena.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.athena.pojo.PageInfo;
import com.athena.service.PeopleService;

public class PeopleServiceImpl implements PeopleService{

	@Override
	public PageInfo showPage(int curNum, int pageSize) throws IOException {
		InputStream is = Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageStart", pageSize*(curNum-1));
		map.put("pageSize", pageSize);
		
		List<?> list = session.selectList("com.athena.mapper.PeopleMapper.selPage", map);
		PageInfo pi = new PageInfo();
		pi.setCurNum(curNum);
		pi.setPageSize(pageSize);
		
		pi.setList(list);
		long count = session.selectOne("com.athena.mapper.PeopleMapper.selTotolPage");
		pi.setTotalPage(count%pageSize==0?count/pageSize:count/pageSize+1);
		return pi;
	}
	
}
