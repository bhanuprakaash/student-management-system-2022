package presentation;

public class Menu {
    public static final int ADD_STUDENT=1;
    public static final int UPDATE_STUDENT=2;
    public static final int GET_STUDENTS=3;
    public static final int SHOW_AND_SORT_STUDENTS=4;
    public static final int DELETE_STUDENT = 5;

    public  static  final int EXIT = 6;
    public void showMenu(){
        System.out.println("Available Menu Items: ");
        System.out.println("1: Add Student");
        System.out.println("2: Update Student");
        System.out.println("3: Get Students");
        System.out.println("4: Show and Sort Students");
        System.out.println("5: Delete Student");
        System.out.println("6: Exit");
        System.out.println("Which function do you want to execute>");
        System.out.print("Menu Item: ");
    }
}
