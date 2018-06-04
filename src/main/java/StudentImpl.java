import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentImpl implements StudentDao {

    ConnectionToBd connectionToBd = new ConnectionToBd();
    private List<Students> students;

    @Override
    public List<Students> getAllStudents() {
        connectionToBd.myCreateConnection();
        students = new ArrayList<>();
        String script = "Select * FROM student";
        System.out.println("Вывод всех студентов таблицы student:");
        try {
            PreparedStatement pr = connectionToBd.getConnection().prepareStatement(script);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                students.add(new Students(rs.getInt("id"), rs.getString("name"), rs.getString("phone"), rs.getString("email"), rs.getInt("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void getStudentById(int id) {
        connectionToBd.myCreateConnection();
        int count = 0;
        try {
            PreparedStatement prep = connectionToBd.getConnection().prepareStatement("SELECT id FROM student");
            ResultSet res = prep.executeQuery();
            while (res.next()) {
                if (id == res.getInt(1)) {
                    count++;
                    String script = "SELECT * FROM student WHERE id=" + id;
                    System.out.println("Получение студента из таблицы по id=" + id + ":");
                    try {
                        PreparedStatement pr = connectionToBd.getConnection().prepareStatement(script);
                        ResultSet rs = pr.executeQuery();
                        while (rs.next()) {
                            System.out.println("id="+rs.getString(1) + ",name=" + rs.getString(2) + ",phone=" + rs.getString(3) + ",email=" + rs.getString(4) + ",age=" + rs.getString(5));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count == 0) {
            System.out.println("Данного id=" + id + " нет в таблице student");
        }
        System.out.println("----------------------------------------------------------");
    }

    @Override
    public void saveStudent(String name, String phone, String email, int age) {
        connectionToBd.myCreateConnection();
        String script = "INSERT INTO student(name, phone, email, age) VALUES (" + "'" + name + "','" + phone + "','" + email + "','" + age + "')";
        try {
            PreparedStatement pr = connectionToBd.getConnection().prepareStatement(script);
            ResultSet rs = pr.executeQuery();
        } catch (SQLException e) {
            System.out.println("Новый студент добавлен в таблицу!");
        }
    }

    @Override
    public void deleteStudent(int id) {
        int count = 0;
        connectionToBd.myCreateConnection();
        try {
            PreparedStatement pr = connectionToBd.getConnection().prepareStatement("SELECT id FROM student");
            ResultSet rk = pr.executeQuery();
            while (rk.next()) {
                if (id == rk.getInt(1)) {
                    count++;
                    String script = "DELETE FROM student WHERE id=" + id;
                    try {
                        PreparedStatement prep = connectionToBd.getConnection().prepareStatement(script);
                        ResultSet rs = prep.executeQuery();
                    } catch (SQLException e) {
                        System.out.println("Студент у которого id=" + id + " удален из таблицы!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count == 0) {
            System.out.println("Данного id=" + id + " нет в таблице student");
        }
    }
}
