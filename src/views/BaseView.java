package views;

import java.util.Scanner;

public interface BaseView {
    Scanner scanner = new Scanner(System.in);
    public void display();
    public void form(int type);
    public void show();
    public void showAll();
}
