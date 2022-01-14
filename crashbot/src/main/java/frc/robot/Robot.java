package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.Compressor;


public class Robot extends TimedRobot {
    public static Drivetrain drivetrain = Drivetrain.getInstance();





    @Override
    public void teleopInit() {
        OI.init();
    }

    @Override
    public void testInit() {
        OI.init();
    }

    @Override
    public void testPeriodic() {
        OI.update();
        Scheduler.getInstance().run();
        Robot.drivetrain.driveStraight(1);
    }
}
