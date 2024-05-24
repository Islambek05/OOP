import java.math.BigInteger;import java.util.Scanner;
public class RSA {
    private static boolean isPrime(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) <= 0)            return false;
        if (n.compareTo(new BigInteger("2")) <= 0)            return true;
        if (n.mod(new BigInteger("2")).equals(BigInteger.ZERO))            return false;
        BigInteger i = new BigInteger("3");
        while (i.multiply(i).compareTo(n) <= 0) {            if (n.mod(i).equals(BigInteger.ZERO))
            return false;            i = i.add(new BigInteger("2"));
        }        return true;
    }
    private static BigInteger getE(BigInteger phi) {        BigInteger e = new BigInteger("2");
        while (phi.gcd(e).intValue() > 1) {            e = e.add(BigInteger.ONE);
        }        return e;
    }
    private static BigInteger modInverse(BigInteger a, BigInteger m) {        BigInteger m0 = m;
        BigInteger y = BigInteger.ZERO, x = BigInteger.ONE;
        if (m.equals(BigInteger.ONE))            return BigInteger.ZERO;
        while (a.compareTo(BigInteger.ONE) > 0) {
            BigInteger q = a.divide(m);            BigInteger t = m;
            m = a.mod(m);
            a = t;            t = y;
            y = x.subtract(q.multiply(y));
            x = t;        }
        if (x.compareTo(BigInteger.ZERO) < 0)
            x = x.add(m0);
        return x;    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger p, q;
        do {            System.out.print("Жай p нөмірін енгізіңіз: ");
            p = scanner.nextBigInteger();        } while (!isPrime(p));
        do {            System.out.print("Жай q нөмірін енгізіңіз: ");
            q = scanner.nextBigInteger();        } while (!isPrime(q));
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e;
        do {            System.out.print("E нөмірін енгізіңіз  (взаимно простое с " + phi + "): ");
            e = scanner.nextBigInteger();        } while (phi.gcd(e).intValue() != 1);

        BigInteger d = modInverse(e, phi);
        System.out.println("Ашық кілт (e, n): (" + e + ", " + n + ")");
        System.out.println("Жабық кілт (d, n): (" + d + ", " + n + ")");
        scanner.nextLine();
        System.out.print("Шифрлау үшін хабарды енгізіңіз: ");
        String message = scanner.nextLine().toUpperCase();
        StringBuilder encryptedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {            if (Character.isLetter(c)) {
            int charIndex = c - 'A' + 1;                BigInteger charValue = BigInteger.valueOf(charIndex);
            BigInteger encryptedChar = charValue.modPow(e, n);                encryptedMessage.append(encryptedChar).append(" ");
        }        }
        System.out.println("Шифрланған хабарлама: " + encryptedMessage);
        StringBuilder decryptedMessage = new StringBuilder();
        String[] encryptedChars = encryptedMessage.toString().split(" ");        for (String encryptedChar : encryptedChars) {
            if (!encryptedChar.isEmpty()) {                BigInteger charValue = new BigInteger(encryptedChar);
                BigInteger decryptedChar = charValue.modPow(d, n);                int charIndex = decryptedChar.intValue();
                char decryptedCharValue = (char) (charIndex + 'A' - 1);                decryptedMessage.append(decryptedCharValue);
            }        }
        System.out.println("Шифрланған хабарлама: " + decryptedMessage);    }
}