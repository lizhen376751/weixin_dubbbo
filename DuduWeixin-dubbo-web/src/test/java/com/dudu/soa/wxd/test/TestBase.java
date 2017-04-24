package com.dudu.soa.wxd.test;


import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:conf/framework-spring.xml")
public abstract class TestBase {

	@Resource
	ApplicationContext ctx;

	public void init(){
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
