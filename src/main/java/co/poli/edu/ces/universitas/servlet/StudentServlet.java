package co.poli.edu.ces.universitas.servlet;

import co.poli.edu.ces.universitas.model.Student;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "studentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private String message;

    private ArrayList<Student> students;



    public void init() {

        students = new ArrayList<>();

        Student student1 = new Student();

        student1.id = 10;

        student1.setName("pedro");

        student1.setDocument("32421785");

        students.add(student1);

        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }

        message = "Hello Poli!!!";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream out = resp.getOutputStream();
        resp.setContentType("text/html");
        out.print("<b>Hello from post method</b>");
        out.flush();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}