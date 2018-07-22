import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        //String path = "resource/500x100_H.dxf";
        //String path = "resource/500x100_W.dxf";
        //String path = "resource/slizg.dxf";
        //String path = "resource/polyline.dxf";
        //String path = "resource/100x100polotw50.dxf";
        //String path = "resource/fi200.dxf";
        //String path = "resource/luk3.dxf";
        String path = "resource/e1.dxf";


        Scanner scanner = new Scanner(new File(path));

        String typLine = "AcDbLine";
        String typCircle = "AcDbCircle"; //+Arc
        String typElipse = "AcDbEllipse";
        String typSpline = "AcDbSpline";

        Dimension dimension = new Dimension();

        while (scanner.hasNext()) {
            String inputLine = scanner.nextLine();

            if (inputLine.equals(typLine)) {

                ParseObject line = new Line();
                line.parseObject(scanner, dimension);

            } else if (inputLine.equals(typCircle)) {

                ParseObject circle = new Circle();
                circle.parseObject(scanner, dimension);

            } else if (inputLine.equals(typSpline)) {

                ParseObject spline = new Spline();
                spline.parseObject(scanner, dimension);

            } else if (inputLine.equals(typElipse)) {



            }
        }

        System.out.println("Width: " + dimension.getWidth());
        System.out.println("Heigth: " + dimension.getHeigth());

    }



}
