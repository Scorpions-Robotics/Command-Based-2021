package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.analog.adis16470.frc.ADIS16470_IMU;
import com.analog.adis16470.frc.ADIS16470_IMU.IMUAxis;

public class ADIS_Gyro {
    //Classes
    private ADIS16470_IMU imu;
    //variables
    private double startTime;
    private double driftPerSecond;
    
    public ADIS_Gyro(){     
        this.imu = new ADIS16470_IMU();
        this.imu.setYawAxis(IMUAxis.kY);
        this.calibrate();
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

    public void resetGyro(){
        this.imu.reset();
        this.startTime = Timer.getFPGATimestamp();
    }

    public void calibrate() {
        this.startTime = Timer.getFPGATimestamp();   
        double startAngle = imu.getAngle();
        try{
            Thread.sleep(15000);
        } catch(Exception e) {
        }
        this.driftPerSecond = (imu.getAngle() - startAngle)/(Timer.getFPGATimestamp() - startTime);
    }
}