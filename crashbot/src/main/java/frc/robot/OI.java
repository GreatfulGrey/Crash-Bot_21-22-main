package frc.robot; // I could probably put all of Buttons.java in her but I want this to be "scaleable"



public class OI {

    public static ButtonWrapper driver = new ButtonWrapper(ButtonMap.Controllers.DRIVER_PORT, true);

    public static void init() {initSD();}

    public static void update() {



        Robot.drivetrain.arcadeDrive(0.4);
//        Robot.drivetrain.tankDrive(0.4);


    }
    public static void initSD() {}  
}