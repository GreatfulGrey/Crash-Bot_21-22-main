package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Drivetrain {
    public static Drivetrain instance;
    private CANSparkMax left, right, left1, right1, left2, right2; //Motor declaration stuff
    private SpeedControllerGroup leftSpeedControl; //set speed control for right and left groups
    private SpeedControllerGroup rightSpeedControl; 

    private Drivetrain(){
        left = new CANSparkMax(ButtonMap.Drivetrain.LEFT0, MotorType.kBrushless);
        right = new CANSparkMax(ButtonMap.Drivetrain.RIGHT0, MotorType.kBrushless);
        left1 = new CANSparkMax(ButtonMap.Drivetrain.LEFT1, MotorType.kBrushless);
        right1 = new CANSparkMax(ButtonMap.Drivetrain.RIGHT1, MotorType.kBrushless);
        left2 = new CANSparkMax(ButtonMap.Drivetrain.LEFT2, MotorType.kBrushless);
        right2 = new CANSparkMax(ButtonMap.Drivetrain.RIGHT2, MotorType.kBrushless);

        leftSpeedControl = new SpeedControllerGroup(left, left1, left2);
        rightSpeedControl = new SpeedControllerGroup(right, right1, right2);

        leftSpeedControl.setInverted(true); 
    }
    public void setSpeed(double leftSpeed, double rightSpeed) {
        setRightSpeed(rightSpeed);
        setLeftSpeed(leftSpeed);
    }
    public static Drivetrain getInstance(){
        if(instance == null){
            instance = new Drivetrain();
        }
        return instance;
    }
    public void setRightSpeed(double speed){
        rightSpeedControl.set(speed);
    }
    public void setLeftSpeed(double speed){
        leftSpeedControl.set(speed);
    }
    public void arcadeDrive(double speed){ //arcade drive shamelessly stolen from old code should probably make it a tank but whatever idc
        double y = OI.driver.getLY();
        double x = OI.driver.getRX();
        y = -speed * y;
        x = -speed * x;
        setSpeed(y-x, y+x);
    }
}
