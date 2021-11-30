// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveSubsystem;

public class centerRobot extends CommandBase {
  NetworkTableEntry xEntry;
  NetworkTableEntry yEntry;
  NetworkTableEntry hEntry;
  NetworkTableEntry wEntry;
  NetworkTableEntry dEntry;
  NetworkTableEntry bEntry;
  NetworkTableEntry rEntry;

  DriveSubsystem m_drivesubsystem;

  double x;
  double y;
  double w;
  double h;
  double d;
  double r;
  double b;

  PIDController pid = new PIDController(Constants.PID.kP,Constants.PID.kI,Constants.PID.kD);

  NetworkTableInstance inst = NetworkTableInstance.getDefault();
  NetworkTable table = inst.getTable("vision");
  /** Creates a new centerRobot. */
  public centerRobot(DriveSubsystem m_drivesubsystem) {
    this.m_drivesubsystem = m_drivesubsystem;
    addRequirements(m_drivesubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {inst.startClient("roborio-7672-frc.local");}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    xEntry = table.getEntry("X");
    yEntry = table.getEntry("Y");
    hEntry = table.getEntry("H");
    wEntry = table.getEntry("W");
    dEntry = table.getEntry("D");
    bEntry = table.getEntry("B");
    rEntry = table.getEntry("R");

    if(bEntry.getDouble(0.0)==0){
      
    }
    else{
      x = Double.valueOf(xEntry.getString(""));
      y = Double.valueOf(yEntry.getString(""));
      w = Double.valueOf(wEntry.getString(""));
      h = Double.valueOf(hEntry.getString(""));
      d = Double.valueOf(dEntry.getString(""));
      r = Double.valueOf(rEntry.getString(""))/5;
      b = bEntry.getDouble(0.0);
      if(r>0){
        m_drivesubsystem.arcadeDrive(0, pid.calculate(r,0));
      }
      else{
        m_drivesubsystem.arcadeDrive(0, pid.calculate(r,0));
      }
    }

    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivesubsystem.stopMotors();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(r<10&&r>-10){
      return true;
    }
    return false;
  }
}
