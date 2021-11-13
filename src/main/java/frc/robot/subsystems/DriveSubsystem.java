// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveSubsystem extends SubsystemBase {

  private WPI_VictorSPX leftLeader = new WPI_VictorSPX(Constants.CANIDs.kLeftLeaderID);
  private WPI_VictorSPX leftFollower = new WPI_VictorSPX(Constants.CANIDs.kLeftFollowerID);
  private WPI_VictorSPX rightLeader = new WPI_VictorSPX(Constants.CANIDs.kRightLeaderID);
  private WPI_VictorSPX rightFollower = new WPI_VictorSPX(Constants.CANIDs.kRightFollowerID);
  private DifferentialDrive robot = new DifferentialDrive(leftLeader,rightLeader);
  /** Creates a new DriveSubsystem. */
  public DriveSubsystem() {
    leftFollower.follow(leftLeader);
    rightFollower.follow(rightLeader);
  }

  @Override
  public void periodic() {
  }

  public void arcadeDrive(double speed, double rotation){
    robot.arcadeDrive(speed,rotation);
  }
}
