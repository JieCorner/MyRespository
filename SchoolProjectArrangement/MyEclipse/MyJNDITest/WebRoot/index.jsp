<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>
<%@ page import="javax.naming.*"%>
<%!
    final String JNDINAME = "java:comp/env/jdbc/test" ;
%>
<%
    Connection conn = null ;
    try
    {
        // 初始化查找命名空间
        Context ctx =new InitialContext() ;
        // 找到DataSource
        DataSource ds = (DataSource)ctx.lookup(JNDINAME) ;
        conn = ds.getConnection() ;
        out.print("success");
        System.out.println("success");
    }
    catch(Exception e)
    {
        //System.out.println(e);
        out.print("fail");
        System.out.println("fail");
    }
%>
 
<%=conn
%>

<%conn.close() ;
%>

