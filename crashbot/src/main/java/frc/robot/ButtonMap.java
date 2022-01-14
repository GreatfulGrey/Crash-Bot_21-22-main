package frc.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;

public class ButtonMap {
    public static class Drivetrain {
        public static final int LEFT_PRIMARY = 0;
        public static final int LEFT_SECONDARY = 1;
        public static final int LEFT_TERTIARY = 2;
        public static final int RIGHT_PRIMARY = 3;
        public static final int RIGHT_SECONDARY = 4;
        public static final int RIGHT_TERTIARY = 5;

        public static final boolean LEFT_IS_INVERTED = false;
        public static final boolean RIGHT_IS_INVERTED = true;
    }

    public static class Controllers {
        public static final int DRIVER_PORT = 0;


        public static final int LY = 1; // Arcade drive
        public static final int RX = 4; // Arcade drive
    }
}
