package family;

public class Mama extends Family implements Family.Job, Family.Country {

    public Mama(final String name, final int age, final String city, final String university) {
        super(name, age, city, university);
    }

    @Override
    public String getBrand() {
        return "Samsung";
    }

    @Override
    public String getModel() { return "Galaxy A24"; }

    @Override
    public String getColor() {
        return "white";
    }

    @Override
    public int getStorage() {
        return 128;
    }

    @Override
    public String getSpecialtyName() { return "Lector"; }

    @Override
    public String getCountryName() { return "Qazaqstan"; }
}
