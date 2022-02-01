package frc.robot;

public class OI {
    public static ButtonWrapper driver = new ButtonWrapper(ButtonMap.Controllers.DRIVER_PORT, true);

    public static void init() {initSD();}

    public static void update() {


        if (driver.isAltMode()) {
            Robot.drivetrain.tankDrive(0.5);
        } 
        else {
            Robot.drivetrain.tankDrive(0.5);
        }

    }
    public static void initSD() {}  
}
