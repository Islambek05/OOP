package family;

public class Islambek extends Family implements Family.Job, Family.Country {

    public Islambek(final String name, final int age, final String city, final String university) {
        super(name, age, city, university);
    }

    @Override
    public String getBrand() {
        return "Samsung";
    }

    @Override
    public String getModel() { return "Galaxy S22 plus"; }

    @Override
    public String getColor() { return "green"; }

    @Override
    public int getStorage() {
        return 128;
    }

    @Override
    public String getSpecialtyName() { return "Digtal Engenering"; }

    @Override
    public String getCountryName() { return "Qazaqstan"; }
}