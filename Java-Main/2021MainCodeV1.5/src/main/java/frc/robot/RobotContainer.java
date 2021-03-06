/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.BarrelDump;
//import frc.robot.commands.BarrelHome;
import frc.robot.commands.BarrelMotors;
import frc.robot.commands.EncoderPos1;
import frc.robot.commands.LiftMotor;
//import frc.robot.commands.LiftMotorBrake;
import frc.robot.commands.Move10ft;
//import frc.robot.commands.EncoderPos1;
import frc.robot.commands.TankDrive;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private Joystick driverController = new Joystick(Constants.DRIVER_CONTROLLER);
  private Joystick driverController1 = new Joystick(Constants.DRIVER_CONTROLLER1);
  Button AButton = new JoystickButton(driverController, Constants.BUTTON_A);
  Button XButton = new JoystickButton(driverController, Constants.BUTTON_X);
  Button BButton = new JoystickButton(driverController, Constants.BUTTON_B);
  Button BButton1 = new JoystickButton(driverController1, Constants.BUTTON_B);
  Button YButton1 = new JoystickButton(driverController1, Constants.BUTTON_Y);
  Button YButton = new JoystickButton(driverController, Constants.BUTTON_Y);
  Button LBButton = new JoystickButton(driverController, Constants.BUTTON_LB);
  Button RBButton = new JoystickButton(driverController, Constants.BUTTON_RB);

  public double GetDriverRawAxis(int axis) {
    return driverController.getRawAxis(axis);
  }

  public double GetBarrelRawAxis(int axis){
    return driverController1.getRawAxis(axis);
  }

  // private final ExampleCommand m_autoCommand = new
  // ExampleCommand(m_exampleSubsystem);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //A is down, X is up
    //AButton.whileHeld(new LiftMotor(0.8));
    AButton.whenPressed(new EncoderPos1());
    XButton.whileHeld(new LiftMotor(-0.25));
    BButton.whileHeld(new LiftMotor(0.3));
    BButton1.whileHeld(new BarrelMotors(0.3, 0.0));
    YButton.whileHeld(new BarrelMotors(0.0, 0.7));
    YButton1.whenPressed(new BarrelDump());
    //LBButton.whenPressed(new BarrelMotors(0.25, 0.0).withTimeout(0.7));
    LBButton.whenPressed(new Move10ft());
    RBButton.whenPressed(new TankDrive());
  }

  /** 
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return(null);
    // An ExampleCommand will run in autonomous
  }
}
