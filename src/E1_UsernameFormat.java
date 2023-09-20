import java.util.Scanner;

/*
Định dạng biểu thức Username hợp lệ: dài từ 6 – 20 ký tự gồm có ký tự thường, ký số,
ký tự “_”, ký tự “-”.
 */

public class E1_UsernameFormat {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter the username: ");
        String username = scanner.nextLine();

        if (isValidUserName(username))
            System.out.println("The username is valid!");
        else
            System.out.println("The username is invalid! Try again!");
    }

    public static boolean isValidUserName(String username) {
        return username.matches("^[a-z0-9_-]{6,20}$");
    }
}
