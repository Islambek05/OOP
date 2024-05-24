package family;

public class Family extends Phone{

    private String name;
    private int age;
    private String city;
    private String university;


    public Family(String name, int age, String city, String university) {
        super("brand","model", "color", 0);
        this.name = name;
        this.age = age;
        this.city = city;
        this.university = university;
    }

    public interface Job{ String getSpecialtyName(); }

    public interface Country{  String getCountryName(); }

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getUniversity() { return university; }
    public void setUniversity(String university) { this.university = university; }
}
