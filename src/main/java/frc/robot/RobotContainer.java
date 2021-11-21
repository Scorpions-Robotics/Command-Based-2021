// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Drive;
import frc.robot.commands.ElevatorPneumatic;
import frc.robot.commands.IntakeAndBand;
import frc.robot.commands.IntakePneumatic;
import frc.robot.commands.Shooter;
import frc.robot.commands.ShooterLid;
import frc.robot.subsystems.BandSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  DriveSubsystem m_drivesubsystem = new DriveSubsystem();
  ShooterSubsystem m_shootersubsystem = new ShooterSubsystem();
  IntakeSubsystem m_intakesubsytem = new IntakeSubsystem();
  BandSubsystem m_bandsubsytem = new BandSubsystem();
  private static final Joystick stick = new Joystick(Constants.OIConstants.kStickPort);
  private final XboxController controller = new XboxController(Constants.OIConstants.kControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_drivesubsystem.setDefaultCommand(new Drive(m_drivesubsystem, stick.getThrottle(),stick.getY(), stick.getX()));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(stick,1).whileHeld(new Shooter(m_shootersubsystem));
    new JoystickButton(stick,5).whileHeld(new ShooterLid(m_shootersubsystem,true));
    new JoystickButton(stick,9).whileHeld(new ShooterLid(m_shootersubsystem,false));
    new JoystickButton(stick,2).whileHeld(new IntakeAndBand(m_intakesubsytem, m_bandsubsytem, -1));
    new JoystickButton(stick,3).whileHeld(new IntakeAndBand(m_intakesubsytem, m_bandsubsytem, 1));
    new JoystickButton(stick,6).whileHeld(new ElevatorPneumatic(m_shootersubsystem,true));
    new JoystickButton(stick,7).whileHeld(new ElevatorPneumatic(m_shootersubsystem,false));
    new JoystickButton(stick,11).whileHeld(new IntakePneumatic(m_intakesubsytem, true));
    new JoystickButton(stick,10).whileHeld(new IntakePneumatic(m_intakesubsytem, false));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
