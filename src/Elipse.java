import java.util.Scanner;

public class Elipse implements ParseObject {

    private double middleX;
    private double middleY;


    @Override
    public Scanner parseObject(Scanner scanner, Dimension dimension) {

        while (scanner.hasNext()) {
            String elipseLine = scanner.nextLine();
            if (elipseLine.equals(" 10")) {
                middleX = Double.valueOf(scanner.nextLine());

            }

            if (elipseLine.equals(" 20")) {
                middleY = Double.valueOf(scanner.nextLine());
            }





            if (elipseLine.equals("ENDSEC")) {
                break;
            }
        }
        return scanner;

    }
}
