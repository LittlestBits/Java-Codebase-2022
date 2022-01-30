/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class BarrelDump extends SequentialCommandGroup {
  /**
   * Creates a new BarrelDump.
   */
  public BarrelDump() {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(new BarrelMotors(0.0, 0.5).withTimeout(1), new BarrelMotors(0.0, 0.3).withTimeout(1));
  }
  //new BarrelMotors(-0.4, 0.0).withTimeout(1.25)
}