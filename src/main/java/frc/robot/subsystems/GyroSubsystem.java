// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.analog.adis16470.frc.ADIS16470_IMU;
import com.analog.adis16470.frc.ADIS16470_IMU.IMUAxis;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
  private ADIS16470_IMU imu;
    //variables
  private double startTime;
  private double driftPerSecond;
  /** Creates a new GyroSubsystem. */
  public GyroSubsystem() {
    this.imu = new ADIS16470_IMU();
    this.imu.setYawAxis(IMUAxis.kY);
    this.calibrate();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Angle",this.getGyroAngle());
  }

  public double getGyroAngle(){
    double runTime = Timer.getFPGATimestamp() - startTime;
    double drift = runTime * driftPerSecond;
    SmartDashboard.putNumber("Drift", drift);
    SmartDashboard.putNumber("runTime", runTime);
    SmartDashboard.putNumber("driftPerSecond", driftPerSecond);
    SmartDashboard.putNumber("Angle", this.imu.getAngle() - drift);
    return this.imu.getAngle() - drift;
}

public double getGyroRate(){
  return this.imu.getRate();
}

public void resetGyro(){
    this.imu.reset();
    this.startTime = Timer.getFPGATimestamp();
}

public void calibrate() {
    this.startTime = Timer.getFPGATimestamp();   
    double startAngle = imu.getAngle();
    try{
        Thread.sleep(5000);
    } catch(Exception e) {
    }
    this.driftPerSecond = (imu.getAngle() - startAngle)/(Timer.getFPGATimestamp() - startTime);
}
}
