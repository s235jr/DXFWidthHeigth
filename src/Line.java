import java.util.Scanner;

public class Line implements ParseObject {
    @Override
    public Scanner parseObject(Scanner scanner, Dimension dimension) {
        scanner.nextLine();
        PointX pointX = new PointX(Double.valueOf(scanner.nextLine()));
        pointX.chceckPoint(dimension);

        scanner.nextLine();
        PointY pointY = new PointY(Double.valueOf(scanner.nextLine()));
        pointY.chceckPoint(dimension);

        return scanner;
    }
}
