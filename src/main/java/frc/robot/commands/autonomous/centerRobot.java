// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

  int mode;

  PIDController pid = new PIDController(Constants.PID.kP,Constants.PID.kI,Constants.PID.kD);

  NetworkTableInstance inst = NetworkTableInstance.create();
  NetworkTable table = inst.getTable("vision");
  /** Creates a new centerRobot. */
  public centerRobot(DriveSubsystem m_drivesubsystem, int mode) {
    this.m_drivesubsystem = m_drivesubsystem;
    this.mode = mode;
    addRequirements(m_drivesubsystem);
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {inst.startClient("10.76.72.10");}

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

    b=Double.valueOf(bEntry.getString("0"));

    if(b==0){
      SmartDashboard.putNumber("B",b);
    }
    else{
      x = Double.valueOf(xEntry.getString("0"));
      y = Double.valueOf(yEntry.getString("0"));
      w = Double.valueOf(wEntry.getString("0"));
      h = Double.valueOf(hEntry.getString("0"));
      d = Double.valueOf(dEntry.getString("0"));
      r = Double.valueOf(rEntry.getString("0"));
      SmartDashboard.putNumber("R",r);
      
      
      if(r>0){
        m_drivesubsystem.arcadeDrive(0, pid.calculate(r/12,0));
      }
      else{
        m_drivesubsystem.arcadeDrive(0, pid.calculate(r/12,0));
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
    if(mode==0){
      return true;
    }
    if(r<20&&r>-20){
      return true;
    }
    return false;
  }
}
