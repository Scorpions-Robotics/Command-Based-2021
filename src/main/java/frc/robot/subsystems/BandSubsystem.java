// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class BandSubsystem extends SubsystemBase {
  private PWMTalonSRX bandMotor = new PWMTalonSRX(Constants.PWMIDs.kBandMotorID);
  /** Creates a new BandSubsystem. */
  public BandSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void turnBand(double speed){
    bandMotor.set(speed);
  }
}
