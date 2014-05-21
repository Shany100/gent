package com.gent.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gent.bean.Event;
import com.gent.dao.LoadDriver;

public class EventAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4559500077262654085L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//
		
		PrintWriter writer = resp.getWriter();
		resp.setCharacterEncoding("utf-8");
		List<Event> list = null;
		list  = LoadDriver.load();
		if(list == null && list.size() > 0){
			writer.write("无事件相关数据。");
		}else{
			StringBuffer sb = new StringBuffer();
			sb.append("{");
			Field[] fields = Event.class.getDeclaredFields();
			for(int j=0, size = list.size(); j < size; j++){
				Event evt = list.get(j);
				for(int i=0, len = fields.length; i < len; i++){
					String name = fields[i].getName();
					sb.append("'"+ name +":'");
					String str = name.replaceFirst(name.substring(0, 1), name.substring(0, 1).toUpperCase())  ;
					try {
						Method method = Event.class.getDeclaredMethod("get"+str, null);
						System.out.println(method.getName());
						Object o = method.invoke(evt, null);
						if(o == null){
							sb.append(""+ null +"");
						}else{
							sb.append("'"+ o.toString() +"'");
						}
						if((i+1)<len){
							sb.append(",");
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
				
			}
			sb.append("}");
			writer.write(sb.toString());
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
