import java.sql.SQLException;

public class AccessStudent {

    public static void main(String[] args) throws SQLException {

        StudentDao studentDao = new StudentImpl();
        ConnectionToBd connectionToBd = new ConnectionToBd();

        //Показать всех студентов в таблице student
        for (Students st : studentDao.getAllStudents()) {
            System.out.println("id="+st.getId() + ",name=" + st.getStudentName() + ",phone=" + st.getPhone() + ",email=" + st.getEmail() + ",age=" + st.getAge());
        }
        System.out.println("----------------------------------------------------------");

        //studentDao.getStudentById(8);// Показать студента из таблицы по его id
        //studentDao.deleteStudent(8);//удалить студента из таблицы по его id
        //добавить студента в таблицу student
        //studentDao.saveStudent("Dron","+3809","dron#i.ua",15);


    }
}