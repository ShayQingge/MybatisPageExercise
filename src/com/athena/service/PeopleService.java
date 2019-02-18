package com.athena.service;

import java.io.IOException;

import com.athena.pojo.PageInfo;

public interface PeopleService {
	PageInfo showPage(int curNum,int pageSize) throws IOException;
}
