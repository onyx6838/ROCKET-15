import com.vti.utils.ScannerUtils;

public class Program {

    public static void main(String[] args) {
        System.out.println("Email ???????????");
        String email = inputPhoneNumber("Wrong email format");
        System.out.println("Email with: " + email);
    }

    public static String inputEmail(String errorMessage) {
        while (true) {
            String email = ScannerUtils.getInstance().inputString("Not Empty");
            if (!email.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}")) {
                System.out.println(errorMessage);
                System.out.println("Input email");
            } else return email;
        }
    }

    public static String inputPassword(String errorMessage) {
        while (true) {
            String password = ScannerUtils.getInstance().inputString("Not Empty");
            if (!password.matches("^(?=.*?[A-Z]).{6,12}$")) {
                System.out.println(errorMessage);
                System.out.println("Input password");
            } else return password;
        }
    }

    public static String inputFullName(String errorMessage) {
        while (true) {
            String fullName = ScannerUtils.getInstance().inputString("Not Empty");
            if (!fullName.matches("^[a-zA-Z]+(?:[\\s.]+[a-zA-Z]+)*$")) {
                System.out.println(errorMessage);
                System.out.println("Input fullname");
            } else return fullName;
        }
    }

    public static String inputPhoneNumber(String errorMessage) {
        while (true) {
            String fullName = ScannerUtils.getInstance().inputString("Not Empty");
            if (!fullName.matches("(84|0[3|5|7|8|9])+([0-9]{8})\\b")) {
                System.out.println(errorMessage);
                System.out.println("Input phoneNumber");
            } else return fullName;
        }
    }
}
