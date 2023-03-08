import java.util.Scanner;
//Разработать консольную игру крестики-нолики.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] field = new char [3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = '·'; //·
            }
        }
        fieldView(field);

        int a = 0;
        while (a < 9) {
            if (a % 2 == 0) {
                System.out.println("==========");
                System.out.println("Ход Х!");
                System.out.println("Введите координаты поля.");

                // ---test---
//                int x=0, y=0;
//                do {
//                    System.out.print("x [0;2]: ");
//                    x = scanner.nextInt();
//                    System.out.print("y [0;2]: ");
//                    y = scanner.nextInt();
//
//                    if (x < 0 || x > 2) System.out.println("Координата х введена не правильно =(");
//                    if (y < 0 || y > 2) System.out.println("Координата y введена не правильно =(");
//                } while ( x > -1 && x < 3 && y > -1 && y < 3);
//                while (x > -1 && x < 3 && y > -1 && y < 3) {
//                    System.out.print("x [0;2]: ");
//                    x = scanner.nextInt();
//                    System.out.print("y [0;2]: ");
//                    y = scanner.nextInt();
//
//                    if (x < 0 || x > 2) System.out.println("Координата х введена не правильно =(");
//                    if (y < 0 || y > 2) System.out.println("Координата y введена не правильно =(");
//                }
                // ---test---
                System.out.print("x [0;2]: ");
                int x = scanner.nextInt();
                System.out.print("y [0;2]: ");
                int y = scanner.nextInt();
                field[x][y] = 'X';
                fieldView(field);
            } else {
                System.out.println("==========");
                System.out.println("Ход O!");
                System.out.println("Введите координаты поля.");
                System.out.print("x [0;2]: ");
                int x = scanner.nextInt();
                System.out.print("y [0;2]: ");
                int y = scanner.nextInt();
                field[x][y] = 'O';
                fieldView(field);
            }
            int XCounter = 0, OCounter = 0;
            // проверка всех строк
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[i][j] == 'X') XCounter++;
                    if (field[i][j] == 'O') OCounter++;
                }
                if (XCounter == 3) {
                    System.out.println("Победа X !!!");
                    a = 10;
                    break;
                }
                if (OCounter == 3) {
                    System.out.println("Победа O !!!");
                    a = 10;
                    break;
                }
                XCounter = 0;
                OCounter = 0;
            }

            // проверка всех столбцов
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (field[j][i] == 'X') XCounter++;
                    if (field[j][i] == 'O') OCounter++;
                }
                if (XCounter == 3) {
                    System.out.println("Победа X !!!");
                    a = 10;
                    break;
                }
                if (OCounter == 3) {
                    System.out.println("Победа O !!!");
                    a = 10;
                    break;
                }
                XCounter = 0;
                OCounter = 0;
            }

            //проверка главной диагонали
            for (int i = 0; i < 3; i++) {
                if (field[i][i] == 'X') XCounter++;
                if (field[i][i] == 'O') OCounter++;
            }
            if (XCounter == 3) {
                System.out.println("Победа X !!!");
                a = 10;
                break;
            }
            if (OCounter == 3) {
                System.out.println("Победа O !!!");
                a = 10;
                break;
            }
            XCounter = 0;
            OCounter = 0;

            // проверка побочной диагонали
            int i = 0, j = 2;
            while (i < 3) {
                if (field[i][j] == 'X') XCounter++;
                if (field[i][j] == 'O') OCounter++;
                i++;
                j--;
            }
            if (XCounter == 3) {
                System.out.println("Победа X !!!");
                a = 10;
                break;
            }
            if (OCounter == 3) {
                System.out.println("Победа O !!!");
                a = 10;
                break;
            }

            a++;
        }

        if (a == 9) {
            System.out.println("==========");
            System.out.println("Ничья!");
        }
    }

    public static void fieldView (char[][] array) {

        System.out.println("==========");
        System.out.println("x↓ 0 1 2 y");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");;
            }
            System.out.println("|");
        }
    }

}

