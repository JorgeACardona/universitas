package co.poli.edu.ces.universitas.servlet;

import co.poli.edu.ces.universitas.model.Student;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "studentServlet", value = "/student")
public class StudentServlet extends MyServlet {
    private String message;

    private GsonBuilder gsonBuilder;

    private Gson gson;

    private ArrayList<Student> students;

    public void init() {

        students = new ArrayList<>();

        gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

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
        resp.setContentType("application/json");
        JsonObject body = this.getParamsFromPost(req);

        Student std = new Student(
                body.get("id").getAsInt(),
                body.get("document").getAsString(),
                body.get("name").getAsString()
        );

        this.students.add(std);
        out.print(gson.toJson(std));
        out.print("<b>Hello from post method</b>");
        out.flush();


    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");


        String studentId = request.getParameter("studentid");

        PrintWriter out = response.getWriter();

        if(studentId == null){
            out.println(gson.toJson(students));
        } else {
            Student studentSearch = null;
            for(Student s: students){
                if (s.getId() == Integer.parseInt(studentId)){
                   studentSearch = s;
                   break;
                }
            }
            out.println(gson.toJson(studentSearch));
        }


    }




    public void destroy() {
    }
}