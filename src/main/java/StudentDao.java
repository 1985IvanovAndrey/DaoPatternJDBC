import java.util.List;

public interface StudentDao {

    List<Students> getAllStudents();

    void getStudentById(int id);

    void saveStudent(String name,String phone,String email,int age);

    void deleteStudent(int id);

}
