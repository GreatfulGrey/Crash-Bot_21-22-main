package frc.robot; // I could probably put all of Buttons.java in her but I want this to be "scaleable"
import frc.robot.ButtonWrapper;


public class OI {

    public static ButtonWrapper driver = new ButtonWrapper(ButtonMap.Controllers.DRIVER_PORT, true);

    public static void init() {initSD();}

    public static void update() {


        if (driver.isAltMode()) {
            Robot.drivetrain.arcadeDrive(0.4); // driver LY and RX
        } 
        else {
            Robot.drivetrain.arcadeDrive(1);
        }

    }
    public static void initSD() {}  
}