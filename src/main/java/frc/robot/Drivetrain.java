package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Drivetrain {
    public static Drivetrain instance;

    private TalonSRX left; //Motor declaration stuff
    private TalonSRX right;
    private TalonSRX left1;
    private TalonSRX right1;

    private Drivetrain(){
        left = new TalonSRX(ButtonMap.Drivetrain.LEFT0);
        right = new TalonSRX(ButtonMap.Drivetrain.RIGHT0);
        left1 = new TalonSRX(ButtonMap.Drivetrain.LEFT1);
        right1 = new TalonSRX(ButtonMap.Drivetrain.RIGHT1);

        

    }


    public static Drivetrain getInstance(){
        if(instance == null){
            instance = new Drivetrain();
        }
        return instance;
    }
    public void setRightSpeed(double speed){
        right.set(ControlMode.PercentOutput, speed);
        right1.set(ControlMode.PercentOutput, speed);
    }
    public void setLeftSpeed(double speed){
        left.set(ControlMode.PercentOutput, speed);
        left1.set(ControlMode.PercentOutput, speed);
    }
    /*
    public void setSpeed(double speed){
        right.set(ControlMode.PercentOutput, speed);
        right1.set(ControlMode.PercentOutput, speed);
        left.set(ControlMode.PercentOutput, speed);
        left1.set(ControlMode.PercentOutput, speed);
    }
    */
    public void tankDrive(double speed){ 
//        setSpeed(0.4);
    
        
        double left = OI.driver.getLY();
        double right = OI.driver.getRY();
        left = -speed * left * 0.7;
        right = speed * right * 0.7;
        setLeftSpeed(left);
        setRightSpeed(right);
    }

    public void arcadeDrive(double speed){
        double y = OI.driver.getLY();
        double x = OI.driver.getRX();
        y = y * 0.7;
        x = x * 0.7;
        setLeftSpeed(y+x);
        setRightSpeed(y-x);
    }

    
    

}
