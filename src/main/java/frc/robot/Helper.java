package frc.robot;

public class Helper {
    public static double deadzone(double value, ButtonWrapper controller) {
        return deadzone(value, controller.getDeadzone());
    }
    public static double deadzone(double value, double size) {
        if (Math.abs(value) < Math.abs(size)) {
            return 0;
        } else {
            return value;
        }
    }
}
