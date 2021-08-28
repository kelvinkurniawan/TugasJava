package views;

import java.util.Scanner;

public interface BaseView {
    Scanner scanner = new Scanner(System.in);

    /**
     * Method to display main menu
     */
    void display();

    /**
     * Method to display the form
     *
     * @param type is param to identify form type for insert or update
     */
    void form(int type);

    /**
     * Method to display the single row data
     */
    void show();

    /**
     * Method to display list of the data
     */
    void showAll();
}
