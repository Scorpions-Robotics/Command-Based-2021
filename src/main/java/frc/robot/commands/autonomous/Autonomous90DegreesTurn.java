// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ADIS_Gyro;
import frc.robot.subsystems.DriveSubsystem;

public class Autonomous90DegreesTurn extends CommandBase {
  ADIS_Gyro gyro = new ADIS_Gyro();
  private DriveSubsystem m_drivesubsystem;
  /** Creates a new Autonomous90DegreesTurn. */
  public Autonomous90DegreesTurn(DriveSubsystem m_drivesubsystem) {
    this.m_drivesubsystem = m_drivesubsystem;
    addRequirements(m_drivesubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gyro.resetGyro();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivesubsystem.arcadeDrive(0, 0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(gyro.getGyroAngle()>90||gyro.getGyroAngle()<-90){
      return true;
    }
    return false;
  }
}
