

import DTO.StudentDTO;
import org.apache.commons.lang3.StringUtils;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "InfoServlet", value = "/info")
public class InfoServlet extends HttpServlet {

    public static final String FIO = "fio";
    public static final String AGE = "age";
    public static final String STUDENTS = "students";
    public static final String STUDENTS_JSP = "/students.jsp";
    public static final String ID = "id";
    public static final String ACTION = "action";
    private StudentService service = new StudentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        fio=Vacia&age=2
        String fio = getParam(req, FIO);
        String age = getParam(req, AGE);

        String id = getParam(req, ID);
        String action = getParam(req, ACTION);
        if ("delete".equals(action)){
//            service.delete(id);
            System.out.println(id);
        }

        List<StudentDTO> studentDTOList = service.findALL(fio,age);

//        String browser = String.valueOf(getParam(req, "browser"));
//        System.out.println(browser);

        req.setAttribute(STUDENTS, studentDTOList);

//        System.out.println(fio + age);
//        HttpSession session = req.getSession();
//        session.setAttribute("fioage", fio + age);

//        PrintWriter writer = resp.getWriter();
//        writer.println("<html>");


//        super.doGet(req,resp);
        RequestDispatcher requestDispatcher = req
                .getRequestDispatcher(STUDENTS_JSP);
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req,resp);

        String fio = req.getParameter("fio");
        System.out.println(fio);
        RequestDispatcher requestDispatcher = req
                .getRequestDispatcher("/example2.jsp");
        requestDispatcher.forward(req, resp);
    }

    private String getParam(HttpServletRequest req, String nameField) {
        return Optional.ofNullable(req.getParameter(nameField))
                .filter(StringUtils::isNotBlank)
                .orElse(null);
    }

}
