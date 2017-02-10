<%@ page language="java" import="java.security.Principal" pageEncoding="ISO-8859-1"%>
<%
    Principal principal = request.getUserPrincipal();
    System.out.println("use getUserPrincipal() OR getRemoteUser() to get userID===="+request.getRemoteUser());
    if(principal!=null){
        String username = principal.getName();
        out.println(username);
    }else{
        out.println("not login");
    }


%>