<%@ page language="java" import="java.util.*" contentType="text/html" pageEncoding="UTF-8"%>
<%
	String useName=request.getParameter("username");
	String outStr="thanks";
	outStr+=useName;
	out.println(outStr);
%>