<%@ page import="java.util.List" %>
<%@ page import="DTO.StudentDTO" %>
<html>
<body>
<h2>Students!</h2>
<%=request.getAttribute("students")%>
<table
<%
    List<StudentDTO> studentDTO = (List<StudentDTO>) request.getAttribute("students");
    for (StudentDTO studentDTO1 : studentDTO) {
%>
<tr>
    <td><%=studentDTO1.getName()%>>
    </td>
    <td><%=studentDTO1.getAge()%>>
    </td>
    <td><%=studentDTO1.getMark()%>>
    </td>
<%--    <td>--%>
<%--        <form name="test"--%>
<%--    </td>--%>
</tr>
    }


<%--for (int i = 0;i < studentDTO.size();i++){--%>
<%--    final StudentDTO studentDTO1 = studentDTO.get(i);--%>

<%--}--%>
<%--//for (StudentDTO studentDTO1:studentDTO){--%>
<%--//    out.println(studentDTO1.getName());--%>
<%--//    out.println(studentDTO1.getAge());--%>
<%--//    out.println(studentDTO1.getMark());--%>
<%--//}--%>
<%
    }
%>
</table>
</body>
</html>
