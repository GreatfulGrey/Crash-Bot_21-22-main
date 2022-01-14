package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * This is the code for the robot drivetrain. It initializes motor controllers and has methods
 * for various functions of the drivetrain.
 */

public class Drivetrain {
    private CANSparkMax l_primary, l_secondary, r_primary, r_secondary, l_tertiary, r_tertiary;
    private static Drivetrain instance;
    private SpeedControllerGroup leftSpeedControl;
    private SpeedControllerGroup rightSpeedControl;
    private CANEncoder lEncoder, rEncoder;
    private double klP = 0.0;
    private double klI = 0.0;
    private double klD = 0.0;
    private double initialDistance = 0; // used for driveStraight()
    private PIDController leftPID, rightPID;
    private double kP = 0;
    private double kI = 0;
    private double kD = 0;
    private final double INCHES_PER_TICK = 1/ 18.064; // TODO: entirely untested!
    private final double maxVelocity = 5676; // TODO: entirely untested! measured in RPM

    private Drivetrain() {
        l_primary = new CANSparkMax(RobotMap.Drivetrain.LEFT_PRIMARY, MotorType.kBrushless);
        r_primary = new CANSparkMax(RobotMap.Drivetrain.RIGHT_PRIMARY, MotorType.kBrushless);
        l_secondary = new CANSparkMax(RobotMap.Drivetrain.LEFT_SECONDARY, MotorType.kBrushless);
        r_secondary = new CANSparkMax(RobotMap.Drivetrain.RIGHT_SECONDARY, MotorType.kBrushless);
        l_tertiary = new CANSparkMax(RobotMap.Drivetrain.LEFT_TERTIARY, MotorType.kBrushless);
        r_tertiary = new CANSparkMax(RobotMap.Drivetrain.RIGHT_TERTIARY, MotorType.kBrushless);

        leftSpeedControl = new SpeedControllerGroup(l_primary,l_secondary, l_tertiary);
        rightSpeedControl = new SpeedControllerGroup(r_primary, r_secondary, r_tertiary);
        // leftPID = new PIDController(klP, klI, klD);

        leftSpeedControl.setInverted(RobotMap.Drivetrain.LEFT_IS_INVERTED);
        rightSpeedControl.setInverted(RobotMap.Drivetrain.RIGHT_IS_INVERTED);

        leftPID = new PIDController(kP, kI, kD);
        rightPID = new PIDController(kP, kI, kD);

        // lEncoder = l_primary.getEncoder();
        // rEncoder = r_primary.getEncoder();
        // leftPID = new PIDController(kP, kI, kD);
        // l_primary.getEncoder()
        //     .setPositionConversionFactor(INCHES_PER_TICK); // set scale for encoder ticks
        // r_primary.getEncoder()
        //     .setPositionConversionFactor(INCHES_PER_TICK);
    }

    /**
     * creates a new instance of the drivetrain class if one has not been made
     * @return an instance of the drivetrain class
     */
    public static Drivetrain getInstance() {
        if (instance == null) {
            return new Drivetrain();
        }
        return instance;
    }
   
    public void setLeftSpeed(double speed){
        leftSpeedControl.set(speed);
    }

    public void setRightSpeed(double speed){
        rightSpeedControl.set(speed);
    }

    /**
     * Maps joysticks to the drivetrain for Arcade layout
     * @param speed scaling factor for robot speed
     */
    public void arcadeDrive(double speed){
        double y = OI.driver.getLY();
        double x = OI.driver.getRX();
        y = -speed * y;
        x = -speed * x;
        setSpeed(y-x, y+x);
    }

    public void setSpeed(double leftSpeed, double rightSpeed) {
        setRightSpeed(rightSpeed);
        setLeftSpeed(leftSpeed);
    }

    public void resetPosition() {
        l_primary.getEncoder().setPosition(0);
        r_primary.getEncoder().setPosition(0);
    }

    public void resetOrientation() {
        gyro.reset();
    }

    public void move(double speed) {
        setSpeed(speed, speed);
    }

    public double errorFunction(double error){
        return Math.sqrt(-error + 1);
    }

    
    public void driveStraight (double targetDist) {
        resetPosition();
        double error = (getLeftPosition()) / targetDist;
        double speed = 0;

        if (targetDist > 0) {
            while (targetDist > getLeftPosition()) {
                error = (getLeftPosition()) / targetDist;
                speed = errorFunction(error);
                setSpeed(speed, speed);
            }
        }
        
        if (targetDist < 0) {
            while (targetDist < getLeftPosition()) {
                error = (getLeftPosition()) / targetDist;
                speed = errorFunction(error);
                setSpeed(-speed, -speed);
            }
        }
        resetPosition();
    }


    public double getRightPosition() {
        return r_primary.getEncoder().getPosition();
    }

    public double getLeftPosition() {
        return l_primary.getEncoder().getPosition();
    }

}
