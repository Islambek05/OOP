package family;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Family islambek = new Islambek("Islambek", 20, "Almaty", "Narxoz University");
        Family kainarbek = new Kainarbek("Kainarbek", 18, "Oral", "Zhangirkhan");
        Family mama = new Mama("Manura", 45, "Oral", "Makhambet");

        List<Family> familyList = new ArrayList<>();
        familyList.add(islambek);
        familyList.add(kainarbek);
        familyList.add(mama);

        CheckLength<Object> checkLength = (parName, value) -> {
            String message = value % 2 == 0 ? "even" : "odd";
            System.out.println(parName + " length is " + message + ".");
        };

        for (Family family : familyList) {
            checkAndPrint(family, checkLength);
        }
    }

    public static void checkAndPrint(Family family, CheckLength<Object> checkLength) {
        checkLength.checkLength(family.getName(), family.getName().length());
        checkLength.checkLength(family.getAge(), family.getAge());
        checkLength.checkLength(family.getCity(), family.getCity().length());
        checkLength.checkLength(family.getUniversity(), family.getUniversity().length());
        checkLength.checkLength(family.getBrand(), family.getBrand().length());
        checkLength.checkLength(family.getModel(), family.getModel().length());
        checkLength.checkLength(family.getColor(), family.getColor().length());
        checkLength.checkLength(family.getStorage(), family.getStorage());
    }
}
interface CheckLength<T> {
    void checkLength(T value, int length);
}
