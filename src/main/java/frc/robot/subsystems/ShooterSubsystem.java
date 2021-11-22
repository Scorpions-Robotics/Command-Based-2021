// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {

  WPI_VictorSPX shooterLeft = new WPI_VictorSPX(Constants.CANIDs.kShooterLeftID);
  WPI_VictorSPX shooterRight = new WPI_VictorSPX(Constants.CANIDs.kShooterRightID);

  DoubleSolenoid shooter_solenoid = new DoubleSolenoid(Constants.Pneumatics.kShooterLidSolenoidID1, Constants.Pneumatics.kShooterLidSolenoidID2);
  DoubleSolenoid elevator_solenoid = new DoubleSolenoid(Constants.Pneumatics.kElevatorSolenoidID1, Constants.Pneumatics.kElevatorSolenoidID2);
  /** Creates a new Shooter. */
  public ShooterSubsystem() {}

  @Override
  public void periodic() {}

  public void turnShooters(){
    shooterLeft.set(Constants.Variables.kLeftShooterSpeed);
    shooterRight.set(Constants.Variables.kRightShooterSpeed);
  }

  public void stopShooters(){
    shooterLeft.set(0);
    shooterRight.set(0);
  }
  public void pushShooterLid(){
    shooter_solenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void pushElevator(){
    elevator_solenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void backElevator(){
    elevator_solenoid.set(DoubleSolenoid.Value.kOff);
  }

  public void backShooterLid(){
    shooter_solenoid.set(DoubleSolenoid.Value.kOff);
  }
  
}
