package views;

import java.util.Scanner;

public interface BaseView {
    Scanner scanner = new Scanner(System.in);

    void display();

    void form(int type);

    void show();

    void showAll();
}
