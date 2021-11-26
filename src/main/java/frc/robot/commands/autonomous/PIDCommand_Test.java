// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.ADIS_Gyro;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PIDCommand_Test extends PIDCommand {
  /** Creates a new PIDCommand_Test. */
  public PIDCommand_Test(DriveSubsystem m_drivesubsystem) {
    super(
        // The controller that the command will use
        new PIDController(0.1, 0, 0),
        // This should return the measurement
        () -> 0,
        // This should return the setpoint (can also be a constant)
        () -> 0,
        // This uses the output
        output -> {
          m_drivesubsystem.arcadeDrive(0,output);
        }, m_drivesubsystem);
      
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
