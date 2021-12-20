// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.ADIS_Gyro;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class PIDCommand_Test extends PIDCommand {
  GyroSubsystem m_gyrosubsystem;
  DriveSubsystem m_drivesubsystem;
  int mode;
  
  /** Creates a new PIDCommand_Test. */
  public PIDCommand_Test(DriveSubsystem m_drivesubsystem, GyroSubsystem m_gyrosubsystem, int mode) {
    super(
        // The controller that the command will use
        new PIDController(Constants.PID.kP,Constants.PID.kI,Constants.PID.kD),
        // This should return the measurement
        () -> m_gyrosubsystem.getGyroAngle(),
        // This should return the setpoint (can also be a constant)
        () -> 0,
        // This uses the output
        output -> {
          m_drivesubsystem.arcadeDrive(RobotContainer.stick.getY(),-output);
          SmartDashboard.putNumber("output",output);
        }, m_drivesubsystem);
        this.m_gyrosubsystem = m_gyrosubsystem;
        this.m_drivesubsystem = m_drivesubsystem;
        this.mode = mode;
       
      
    // Use addRequirements() here to declare subsystem dependencies.
    // Configure additional PID options by calling `getController` here.
  }

@Override
public void initialize() {
  this.m_gyrosubsystem.resetGyro();
}

@Override
public void end(boolean interrupted) {
  m_drivesubsystem.stopMotors();
}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(mode==0){
      return true;
    }
    return false;
  }
}
