package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;




public class Robot extends TimedRobot {
    public static Drivetrain drivetrain = Drivetrain.getInstance();
    
    @Override
    public void robotInit() {}
  
    @Override
    public void robotPeriodic() {}
  
    @Override
    public void autonomousInit() {}
  
    @Override
    public void autonomousPeriodic() {}
  
    @Override
    public void teleopInit() {}
  
    @Override
    public void teleopPeriodic() {}
  
    @Override
    public void disabledInit() {}
  
    @Override
    public void disabledPeriodic() {}
  
    @Override
    public void testInit() {
      OI.init();
    }
    @Override
    public void testPeriodic() {
      OI.update();
    }
}
