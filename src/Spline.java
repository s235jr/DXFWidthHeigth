import java.util.Scanner;

public class Spline implements ParseObject {
    @Override
    public Scanner parseObject(Scanner scanner, Dimension dimension) {

        while (scanner.hasNext()) {
            String splineLine = scanner.nextLine();
            if (splineLine.equals(" 10")) {
                PointX pointX = new PointX(Double.valueOf(scanner.nextLine()));
                pointX.chceckPoint(dimension);
            }

            if (splineLine.equals(" 20")) {
                PointY pointY = new PointY(Double.valueOf(scanner.nextLine()));
                pointY.chceckPoint(dimension);
            }
            if (splineLine.equals("ENDSEC")) {
                break;
            }
        }
        return scanner;
    }
}
