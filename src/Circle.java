import java.util.Scanner;

public class Circle implements ParseObject {

    private double middleX;
    private double middleY;
    private double radius;
    private double radiusStart = 0;
    private double radiusEnd = 0;

    public Circle() {
    }

    @Override
    public Scanner parseObject(Scanner scanner, Dimension dimension) {


        while (scanner.hasNext()) {
            String circleLine = scanner.nextLine();
            if (circleLine.equals(" 10")) {
                middleX = Double.valueOf(scanner.nextLine());
            }

            if (circleLine.equals(" 20")) {
                middleY = Double.valueOf(scanner.nextLine());
            }

            if (circleLine.equals(" 40")) {
                radius = Double.valueOf(scanner.nextLine());
            }

            if (circleLine.equals("AcDbArc")) {
                while (!circleLine.equals("ENDSEC") || !circleLine.equals("AcDbEntity")) {
                    circleLine = scanner.nextLine();
                    if (circleLine.equals(" 50")) {
                        radiusStart = Double.valueOf(scanner.nextLine());
                    }

                    if (circleLine.equals(" 51")) {
                        radiusEnd = Double.valueOf(scanner.nextLine());
                        break;
                    }
                }
            }
            if (circleLine.equals("ENDSEC") || circleLine.equals("AcDbEntity")) {
                break;
            }
        }

        System.out.println("start " + radiusStart);
        System.out.println("stop " + radiusEnd);

        for (int i = (int)radiusStart; i <= radiusEnd; i++) {
            if (i % 90 == 0) {
                System.out.println(i);
                PointX pointX = new PointX(middleX + radius * Math.cos(Math.toRadians(i)));
                PointY pointY = new PointY(middleY + radius * Math.sin(Math.toRadians(i)));
                pointX.chceckPoint(dimension);
                pointY.chceckPoint(dimension);
            }
        }

        PointX startPointX = new PointX(middleX + radius * Math.cos(Math.toRadians(radiusStart)));
        PointY startPointY = new PointY(middleY + radius * Math.sin(Math.toRadians(radiusStart)));
        startPointX.chceckPoint(dimension);
        startPointY.chceckPoint(dimension);

        PointX endPointX = new PointX(middleX + radius * Math.cos(Math.toRadians(radiusEnd)));
        PointY endPointY = new PointY(middleY + radius * Math.sin(Math.toRadians(radiusEnd)));
        endPointX.chceckPoint(dimension);
        endPointY.chceckPoint(dimension);

        return scanner;
    }
}
