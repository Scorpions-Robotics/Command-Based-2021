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
import frc.robot.commands.ElevatorPneumaticBack;
import frc.robot.commands.ElevatorPneumaticPush;
import frc.robot.commands.IntakeAndBand;
import frc.robot.commands.IntakePneumaticBack;
import frc.robot.commands.IntakePneumaticPush;
import frc.robot.commands.ShooterTurn;
import frc.robot.commands.autonomous.AutoDrive;
import frc.robot.commands.autonomous.FixedPositionCentered;
import frc.robot.commands.autonomous.PIDCommand_Test;
import frc.robot.commands.autonomous.centerRobot;
import frc.robot.commands.ShooterLidBack;
import frc.robot.commands.ShooterLidPush;
import frc.robot.subsystems.BandSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.GyroSubsystem;
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
  GyroSubsystem m_gyrosubsystem = new GyroSubsystem();
  public static final Joystick stick = new Joystick(Constants.OIConstants.kStickPort);
  private final XboxController controller = new XboxController(Constants.OIConstants.kControllerPort);

  private JoystickButton stick_button1 = new JoystickButton(stick, Constants.OIConstants.button1);
  private JoystickButton stick_button2 = new JoystickButton(stick, Constants.OIConstants.button2);
  private JoystickButton stick_button3 = new JoystickButton(stick, Constants.OIConstants.button3);
  private JoystickButton stick_button4 = new JoystickButton(stick, Constants.OIConstants.button4);
  private JoystickButton stick_button5 = new JoystickButton(stick, Constants.OIConstants.button5);
  private JoystickButton stick_button6 = new JoystickButton(stick, Constants.OIConstants.button6);
  private JoystickButton stick_button7 = new JoystickButton(stick, Constants.OIConstants.button7);
  private JoystickButton stick_button8 = new JoystickButton(stick, Constants.OIConstants.button8);
  private JoystickButton stick_button9 = new JoystickButton(stick, Constants.OIConstants.button9);
  private JoystickButton stick_button10 = new JoystickButton(stick, Constants.OIConstants.button10);
  private JoystickButton stick_button11 = new JoystickButton(stick, Constants.OIConstants.button11);
  private JoystickButton stick_button12 = new JoystickButton(stick, Constants.OIConstants.button12);

  private JoystickButton xbox_button1 = new JoystickButton(controller, Constants.OIConstants.button1);
  private JoystickButton xbox_button2 = new JoystickButton(controller, Constants.OIConstants.button2);
  private JoystickButton xbox_button3 = new JoystickButton(controller, Constants.OIConstants.button3);
  private JoystickButton xbox_button4 = new JoystickButton(controller, Constants.OIConstants.button4);
  private JoystickButton xbox_button5 = new JoystickButton(controller, Constants.OIConstants.button5);
  private JoystickButton xbox_button6 = new JoystickButton(controller, Constants.OIConstants.button6);
  private JoystickButton xbox_button7 = new JoystickButton(controller, Constants.OIConstants.button7);
  private JoystickButton xbox_button8 = new JoystickButton(controller, Constants.OIConstants.button8);
  private JoystickButton xbox_button9 = new JoystickButton(controller, Constants.OIConstants.button9);
  private JoystickButton xbox_button10 = new JoystickButton(controller, Constants.OIConstants.button10);
  private JoystickButton xbox_button11 = new JoystickButton(controller, Constants.OIConstants.button11);
  private JoystickButton xbox_button12 = new JoystickButton(controller, Constants.OIConstants.button12);


  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    m_drivesubsystem.setDefaultCommand(new Drive(m_drivesubsystem, m_gyrosubsystem, stick.getThrottle()));
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
    stick_button1.whenPressed(new ShooterTurn(m_shootersubsystem,0.83));
    stick_button1.whenReleased(new ShooterTurn(m_shootersubsystem,0));

    stick_button5.whenPressed(new ShooterLidPush(m_shootersubsystem));
    stick_button5.whenReleased(new ShooterLidBack(m_shootersubsystem));

    stick_button2.whenPressed(new IntakeAndBand(m_intakesubsytem, m_bandsubsytem, -1));
    stick_button2.whenReleased(new IntakeAndBand(m_intakesubsytem, m_bandsubsytem, 0));
    stick_button3.whenPressed(new IntakeAndBand(m_intakesubsytem, m_bandsubsytem, 1));
    stick_button3.whenReleased(new IntakeAndBand(m_intakesubsytem, m_bandsubsytem, 0));

    stick_button4.whenPressed(new FixedPositionCentered(m_drivesubsystem,m_gyrosubsystem,1));
    stick_button4.whenReleased(new FixedPositionCentered(m_drivesubsystem,m_gyrosubsystem,0));

    stick_button6.whenPressed(new ElevatorPneumaticPush(m_shootersubsystem));
    stick_button7.whenPressed(new ElevatorPneumaticBack(m_shootersubsystem));

    stick_button11.whenPressed(new IntakePneumaticPush(m_intakesubsytem));
    stick_button11.whenReleased(new IntakePneumaticBack(m_intakesubsytem));

    stick_button9.whenPressed(new PIDCommand_Test(m_drivesubsystem, m_gyrosubsystem,1));
    stick_button9.whenReleased(new PIDCommand_Test(m_drivesubsystem,m_gyrosubsystem,0));


    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand(Integer mode) {
    // An ExampleCommand will run in autonomous
    if(mode==0){
      return new AutoDrive(m_drivesubsystem, 0.4, 0);
    }
    else if(mode==1){
      return new AutoDrive(m_drivesubsystem,0.4,0.4);

    }
    else if(mode==2){
      return new AutoDrive(m_drivesubsystem,0.4,-0.4);
    }
    return null;
    
  }
}
