package dragon;

public class Student {
    private int id;
    private String name;
    private int courseId;
    private int age;

    public Student(int id, String name, int courseId, int age) {
        this.id = id;
        this.name = name;
        this.courseId = courseId;
        this.age = age;
    }

    public Student() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", courseId=" + courseId +
                ", age=" + age +
                '}';
    }
}
