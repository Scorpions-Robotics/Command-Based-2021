// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class Drive extends CommandBase {
  private DriveSubsystem m_drivesubsystem;
  private GyroSubsystem m_gyrosubsystem;
  PIDController m_pidController;
  private double throttle;
  private double joystick_x;
  private double joystick_y;

  /** Creates a new Drive. */
  public Drive(DriveSubsystem m_drivesubsystem, GyroSubsystem m_gyrosubsystem, double throttle) {
    this.m_drivesubsystem = m_drivesubsystem;
    this.m_gyrosubsystem = m_gyrosubsystem;
    this.throttle = throttle;
    this.m_pidController = new PIDController(Constants.PID.kP, Constants.PID.kI, Constants.PID.kD);
   

    addRequirements(m_drivesubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    joystick_y = RobotContainer.stick.getY();
    joystick_x = RobotContainer.stick.getX();
    throttle = (throttle + 1) / 2; 
    SmartDashboard.putNumber("throttle",this.throttle);
    m_drivesubsystem.arcadeDrive(this.throttle*joystick_y, this.throttle*joystick_x);
    // check_rate();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
