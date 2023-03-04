package presentation;

public class Menu {
    public static final int ADD_STUDENT=1;
    public static final int UPDATE_STUDENT=2;
    public static final int GET_STUDENTS=3;
    public static final int DELETE_STUDENT = 4;
    public  static  final int EXIT = 5;
    public void showMenu(){
        System.out.println("Available Menu Items: ");
        System.out.println("1: Add Student");
        System.out.println("2: Update Student");
        System.out.println("3: Get Students");
        System.out.println("""
                4: Delete Student

                """);
        System.out.println("Which function do you want to execute>");
        System.out.print("Menu Item: ");
    }
}
