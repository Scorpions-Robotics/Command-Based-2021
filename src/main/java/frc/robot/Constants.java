// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class OIConstants{
        
        public static final int kControllerPort = 1;
        public static final int kStickPort = 0;
        public static final int button1 = 1;
        public static final int button2 = 2;
        public static final int button3 = 3;
        public static final int button4 = 4;
        public static final int button5 = 5;
        public static final int button6 = 6;
        public static final int button7 = 7; 
        public static final int button8 = 8; 
        public static final int button9 = 9;
        public static final int button10 = 10;
        public static final int button11 = 11;
        public static final int button12 = 12;
    }
    public final class CANIDs{
        public static final int kLeftFollowerID = 5;
        public static final int kRightFollowerID = 6;
        public static final int kLeftLeaderID = 1;
        public static final int kRightLeaderID = 2;
        public static final int kShooterLeftID = 7;
        public static final int kShooterRightID = 8;
        public static final int kIntakeID = 9;
    }
    public final class PWMIDs{
        public static final int kBandMotorID = 0;
    }
	public final class Variables{
        public static final double kLeftShooterSpeed = -0.83;
        public static final double kRightShooterSpeed = 0.83;
		public static final double kZero = 0;
    }
    public final class Pneumatics{
        public static final int kShooterLidSolenoidID1 = 6;  
        public static final int kShooterLidSolenoidID2 = 7;

        public static final int kIntakeSolenoidID1 = 2;
        public static final int kIntakeSolenoidID2 = 3;

        public static final int kElevatorSolenoidID1 = 4;
        public static final int kElevatorSolenoidID2 = 5;
    }
    public static class PID{
        public static final double kP = 0.03;
        public static final double kI = 0.0005;
        public static final double kD = 0.0025;
    }

}
