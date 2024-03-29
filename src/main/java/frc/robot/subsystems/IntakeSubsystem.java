// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private WPI_VictorSPX intakeMotor = new WPI_VictorSPX(Constants.CANIDs.kIntakeID);
  DoubleSolenoid intake_solenoid = new DoubleSolenoid(Constants.Pneumatics.kIntakeSolenoidID1, Constants.Pneumatics.kIntakeSolenoidID2);
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {}

  @Override
  public void periodic() {
  }
  public void turnIntake(double speed){
    intakeMotor.set(speed);
  }


  public void push(){
    intake_solenoid.set(DoubleSolenoid.Value.kForward);
  }

  public void back(){
    intake_solenoid.set(DoubleSolenoid.Value.kReverse);
  }
}
