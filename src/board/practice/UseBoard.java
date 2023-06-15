package board.practice;

import java.util.Scanner;

public class UseBoard {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        UseBoard board = new UseBoard();
        board.startService();
        }

    public String mainMenu() {
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("메인메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴선택: ");

        String menuNo = scanner.nextLine();

        return menuNo;
    }

    public void startService() {
        String menuNo = this.mainMenu();
        BoardService bs = new BoardService();
        System.out.println();
        switch(menuNo) {
            case "1" : bs.create();
            case "2" : bs.read();
            case "3" : bs.clear();
            case "4" : bs.exit();
        }


    }
}

