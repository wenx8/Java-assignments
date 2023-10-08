import java.util.Scanner;

/**
 * Detects if a point hits any of two circles.
 * 
 * Usage:
 * TODO: Documentation
 * 1. Ask the user to input 8 floating numbers
 * 2. radius1 or radius2 is negative?
 *    - yes -> input error
 *    - no  -> step 3
 * 3. Is the point in the first circle?
 *    - yes -> Is the point in the second circle?
 *             - yes -> The point hits both circles
 *             - no  -> The point hits the first circle
 *    - no  -> Is the point in the second circle?
 *             - yes -> The point hits the second circle
 *             - no  -> The point does not hit either circle
 * 
 * END TODO
 * 
 * @author <Xianli Wen>
 * @ID <1762656>
 * @author <NAME STUDENT 2>
 * @ID <ID STUDENT 2>
 * 
 */
class HitDetection {
    
    public void run() {
        // TODO: Hit detection
        // 1. Ask the user to input.
        Scanner scanner = new Scanner(System.in);

        // 2. Determine the first circle.
        double c1x = scanner.nextDouble();
        double c1y = scanner.nextDouble();
        double c1r = scanner.nextDouble();

        // 3. Determine the second circle.
        double c2x = scanner.nextDouble();
        double c2y = scanner.nextDouble();
        double c2r = scanner.nextDouble();

        // 4. Determine the point.
        double px = scanner.nextDouble();
        double py = scanner.nextDouble();

        scanner.close();

        // 5. Test if the radius is negative. 
        // If not, then calculate the distance between the point and each circle.
        if (c1r < 0) {
            System.out.println("input error");
        } else {
            double distanceC1 = Math.sqrt(Math.pow(px - c1x, 2) + Math.pow(py - c1y, 2));
            double distanceC2 = Math.sqrt(Math.pow(px - c2x, 2) + Math.pow(py - c2y, 2));

            //6. Compare the distance with radius.
            boolean pHitC1 = distanceC1 <= c1r;
            boolean pHitC2 = distanceC2 <= c2r;

            //7. Conclude the four situations and output.
            if (pHitC1 && pHitC2) {
                System.out.println("The point hits both circles");
            } else if (pHitC1) {
                System.out.println("The point hits the first circle");
            } else if (pHitC2) {
                System.out.println("The point hits the second circle");
            } else {
                System.out.println("The point does not hit either circle");
            }
        }
        // END TODO
    }

    public static void main(String[] args) {
        new HitDetection().run();
    }
}