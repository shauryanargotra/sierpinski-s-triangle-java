import javax.swing.JPanel;
import java.awt.*;
import java.util.Scanner;

public class app  extends JPanel{

    //Draw fractals

    public void paintComponent(Graphics screen){
        super.paintComponent(screen);
        Scanner scan = new Scanner(System.in);

        triangle(0, 887, 1024, 887, 512,0, 5, 45, 65,5);

        scan.nextLine();
        scan.close();
    }

    public void triangle(int ax, int ay, int bx, int by, int cx, int cy, int level, int r, int g, int b){
        Graphics screen = getGraphics();
        if (level <= 0){ // base case
            return;
        }

        screen.setColor(new Color(r,g,b));
        screen.fillPolygon(new int[]{ax, bx, cx}, new int[]{ay, by, cy}, 3);

        triangle((ax + cx) / 2, (ay + cy) / 2,(cx + bx) / 2, (ay + cy) / 2, cx, cy,level - 1,r + 10,g + 2,b + 1);
        triangle(ax,ay,(ax +bx) / 2, ay, (ax + cx) / 2, (ay + cy) / 2, level - 1,r + 10, g + 2,b + 5);
        triangle((ax + bx) / 2, ay, bx, by, (cx + bx) / 2, (cy + by)/ 2, level - 1, r + 3, g + 4, b + 3);

    }
}
