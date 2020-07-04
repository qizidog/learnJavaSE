package learnDynamicJava;

public class User {
    private String name;
    private int age;
    private int id;
    public String uname;
    public int uage;
    public int uid;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setUname(String uname, double pi) {
        this.uname = uname+pi;
    }
    public User() {
    }
    public User(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    
    @Override
    public String toString() {
        return this.name+"-->"+this.age+"-->"+this.id;
    }
}
