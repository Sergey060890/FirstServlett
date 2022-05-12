<html>
<body>
<h2>Hello Info!</h2>
<%=request.getParameter("fio")%>
<%=request.getParameter("age")%>
<%=request.getAttribute("newFio")%>
<%=session.getAttribute("fioage")%>
</body>
</html>
