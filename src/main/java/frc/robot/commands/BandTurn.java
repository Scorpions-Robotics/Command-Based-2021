// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.BandSubsystem;

public class BandTurn extends CommandBase {

  private BandSubsystem m_bandsubsytem;
  private double speed;
  /** Creates a new Band. */
  public BandTurn(BandSubsystem m_bandsubsytem, double speed) {
    this.m_bandsubsytem = m_bandsubsytem;
    this.speed = speed;
    addRequirements(m_bandsubsytem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_bandsubsytem.turnBand(speed);
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
