<%@ page import="hello.servlet.domain.member.MemberRepo" %>
<%@ page import="hello.servlet.domain.member.Member" %>
 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    MemberRepo memberRepo = MemberRepo.getInstance();
    System.out.println("MemberSaveServlet.service");
    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username,age);
    memberRepo.save(member);
%>
 <html>
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>

    성공
 <ul>
    <li>id=<%=member.getId()%></li>
    <li>id=<%=member.getUsername()%></li>
    <li>id=<%=member.getAge()%></li>
 </ul>
<a href="/index.html">메인</a>
    </body>
    </html>