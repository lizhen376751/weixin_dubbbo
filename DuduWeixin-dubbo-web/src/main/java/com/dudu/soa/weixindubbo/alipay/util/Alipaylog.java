package com.dudu.soa.weixindubbo.alipay.util;

import com.vangdo.ddhg.opendb.DB;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class Alipaylog {

	
	public void save(HttpServletRequest request,String shopcode){
		//System.out.println("鍙傛暟=="+shopcode);
		String out_trade_no=request.getParameter("out_trade_no");
		String trade_no=request.getParameter("trade_no");
		String trade_status=request.getParameter("trade_status");
		String is_success=request.getParameter("is_success");
		String notify_time=request.getParameter("notify_time");
		String buyer_email=request.getParameter("buyer_email");
		String total_fee=request.getParameter("total_fee");
		
		DB db = new DB();
		StringBuffer sbSql=new StringBuffer();
		try {
			sbSql.append("INSERT INTO DATA_alipay (")
			.append("shopcode,out_trade_no,trade_no,trade_status,is_success ,notify_time,buyer_email,total_fee")
			.append(") VALUES (")
			.append("'"+shopcode+"',")
			.append("'"+out_trade_no+"',")
			.append("'"+trade_no+"',")
			.append("'"+trade_status+"',")
			.append("'"+is_success+"',")
			.append("'"+notify_time+"',")
			.append("'"+buyer_email+"',")
			.append("'"+total_fee+"'")
			.append(")");
		
			db.update(sbSql.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			db.close();
		}
	}
}
