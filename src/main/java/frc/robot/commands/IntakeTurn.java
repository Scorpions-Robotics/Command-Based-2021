// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeTurn extends CommandBase {
  private double speed;
  private IntakeSubsystem m_intakesubsytem;
  /** Creates a new Intake. */
  public IntakeTurn(IntakeSubsystem m_intakesubsytem, double speed) {
    this.m_intakesubsytem = m_intakesubsytem;
    this.speed = speed;
    addRequirements(m_intakesubsytem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_intakesubsytem.turnIntake(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
