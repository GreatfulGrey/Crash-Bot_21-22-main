package frc.robot;

public class OI {
    public static ButtonWrapper driver = new ButtonWrapper(ButtonMap.Controllers.DRIVER_PORT, true);

    public static void init() {initSD();}

    public static void update() {


        Robot.drivetrain.arcadeDrive(0);

    }
    public static void initSD() {}  
}
