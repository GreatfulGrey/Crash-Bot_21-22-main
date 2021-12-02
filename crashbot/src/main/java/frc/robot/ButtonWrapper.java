package frc.robot; //Buttons is the Controller Wrapper

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import frc.robot.ButtonMap;



public class ButtonWrapper {

    private final XboxController controller;
	private final boolean DEADZONE_ENABLED;
	private double deadzone = 0.1;
	 boolean isAltMode = false;

	
    public ButtonWrapper(int port, boolean deadzone) {
        this.controller = new XboxController(port);
        this.DEADZONE_ENABLED = deadzone;
    }
	
	public XboxController getController() {
        return this.controller;
    }

	public boolean isAltMode() {
        return this.isAltMode;
    }
    
	public void setDeadzone(double deadzone) {
        this.deadzone = deadzone;
    }

    public double getDeadzone() {
        return this.deadzone;
    }
    
	public void toggleAltMode() {
        this.isAltMode = !this.isAltMode;
    }

	public double getLY() {
        double ly = this.controller.getRawAxis(ButtonMap.Controllers.LY);
        if (DEADZONE_ENABLED) {
            return Helper.deadzone(ly, this.getDeadzone());
        }
        return ly;
	}
	

    public double getRX() {
        double rx = this.controller.getRawAxis(ButtonMap.Controllers.RX);
        if (DEADZONE_ENABLED) {
            return Helper.deadzone(rx, this.getDeadzone());
        }
        return rx;
        }
    
        
}