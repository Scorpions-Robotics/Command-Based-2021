// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autonomous;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FixedPositionCentered extends SequentialCommandGroup {
  /** Creates a new FixedPositionCentered. */
  public FixedPositionCentered(DriveSubsystem m_drivesubsystem,GyroSubsystem m_gyrosubsystem, int mode) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new centerRobot(m_drivesubsystem, mode), new PIDCommand_Test(m_drivesubsystem,m_gyrosubsystem, mode));
  }
}
