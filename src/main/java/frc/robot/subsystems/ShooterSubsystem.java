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

  public void setShooterLid(boolean status){
    if(status){
      shooter_solenoid.set(DoubleSolenoid.Value.kForward);
    }
    else{
      shooter_solenoid.set(DoubleSolenoid.Value.kOff);
    }
  }

  public void setElevator(boolean status){
    if(status){
      elevator_solenoid.set(DoubleSolenoid.Value.kForward);
    }
    else{
      elevator_solenoid.set(DoubleSolenoid.Value.kOff);
    }
  }
  
}
