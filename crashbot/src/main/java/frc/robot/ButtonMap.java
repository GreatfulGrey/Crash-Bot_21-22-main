package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;

public class ButtonMap {
    public static class Drivetrain {
        public static final int LEFT0 = 0;
        public static final int LEFT1 = 1;
        public static final int LEFT2 = 2;
        public static final int RIGHT0 = 3;
        public static final int RIGHT1 = 4;
        public static final int RIGHT2 = 5;

        public static final boolean LEFT_IS_INVERTED = false;
        public static final boolean RIGHT_IS_INVERTED = true;
    }

    public static class Controllers {
        public static final int DRIVER_PORT = 0;


        public static final int LY = 1; // Arcade drive
        public static final int RX = 4; // Arcade drive
    }
}
