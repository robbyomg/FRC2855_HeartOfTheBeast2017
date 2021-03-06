// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2855.cool2017.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2855.cool2017.Robot;
import org.usfirst.frc2855.cool2017.RobotMap;

/**
 * spins wheel on shooter mechanism
 * set to run while held
 * completed
 */
public class spinshooter extends Command {
	private double shooterSpeed=75;

    public spinshooter() {

       requires(Robot.shooter);

       
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.shooter.shooterActivate(((Robot.oi.joystick2.getThrottle()+1)/2)*100);
    	Robot.leds.LEDShooterActivate();
    	SmartDashboard.putNumber("Shooter Velocity", RobotMap.shooterTalon.getSpeed());
    	SmartDashboard.putNumber("Shooter vBus", RobotMap.shooterTalon.getOutputVoltage());
    	SmartDashboard.putNumber("Shooter Amperage", RobotMap.shooterTalon.getOutputCurrent());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.shooter.shooterActivate(0);
    	Robot.leds.LEDShooterDeActivate();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
