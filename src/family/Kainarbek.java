package family;

public class Kainarbek extends Family implements Family.Job, Family.Country {

    public Kainarbek(final String name, final int age, final String city, final String university) {
        super(name, age, city, university);
    }

    @Override
    public String getBrand() { return "Apple"; }

    @Override
    public String getModel() { return "iPhone 11"; }

    @Override
    public String getColor() { return "white"; }

    @Override
    public int getStorage() { return 128; }

    @Override
    public String getSpecialtyName() { return "Digtal Engenering"; }

    @Override
    public String getCountryName() { return "Qazaqstan"; }
}
