public class Students {
    private int id;
    private String studentName;
    private String phone;
    private String email;
    private int age;

    public Students() {
    }

    public Students(int id, String studentName) {
        this.id = id;
        this.studentName = studentName;
    }

    public Students(int id, String studentName, String phone, String email, int age) {
        this.id = id;
        this.studentName = studentName;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
