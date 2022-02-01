package frc.robot;
import edu.wpi.first.wpilibj.XboxController;

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
        double ly = this.controller.getRawAxis(ButtonMap.Controllers.L);
        if (DEADZONE_ENABLED) {
            return Helper.deadzone(ly, this.getDeadzone());
        }
        return ly;
	}
	

    public double getRY() {
        double ry = this.controller.getRawAxis(ButtonMap.Controllers.R);
        if (DEADZONE_ENABLED) {
            return Helper.deadzone(ry, this.getDeadzone());
        }
        return ry;
    }
}
