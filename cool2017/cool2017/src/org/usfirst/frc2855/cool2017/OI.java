// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2855.cool2017;

import org.usfirst.frc2855.cool2017.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc2855.cool2017.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    public JoystickButton climbButton;
    public JoystickButton ballOut;
    public Joystick joystick1;
    public JoystickButton ballin;
    public JoystickButton gearout;
    public JoystickButton gearin;
    public JoystickButton shooterbutton;
    public JoystickButton gearpinch;
    public JoystickButton gearrelease;
    public Joystick joystick2;
    public JoystickButton ledflash;
    public JoystickButton ledbreathe;
    
    public OI() {

        joystick2 = new Joystick(1);
        
        shooterbutton = new JoystickButton(joystick2, 1);
        shooterbutton.whileHeld(new spinshooter());
        gearin = new JoystickButton(joystick2, 5);
        gearin.whileHeld(new GearIn());
        gearout = new JoystickButton(joystick2, 4);
        gearout.whileHeld(new GearOut());
        ballin = new JoystickButton(joystick2, 2);
        ballin.whileHeld(new IntakeControl(1));
        ballOut = new JoystickButton(joystick2, 3);
        ballOut.whileHeld(new IntakeControl(-1));
        
        joystick1 = new Joystick(0);
        
        gearpinch = new JoystickButton(joystick1, 2);
        gearpinch.whenPressed(new GearPinch());
        gearrelease = new JoystickButton(joystick1, 6);
        gearrelease.whenPressed(new GearRelease());
        climbButton = new JoystickButton(joystick1, 1);
        climbButton.whileHeld(new climb());
        ledflash = new JoystickButton(joystick1, 8);
        ledflash.whileHeld(new LEDFlash());
        ledbreathe = new JoystickButton(joystick1, 9);
        ledbreathe.whileHeld(new LEDBreathe());
        

        SmartDashboard.putData("Gear up n down: down", new Gearupndown(false));
        SmartDashboard.putData("Gear up n down: up", new Gearupndown(true));
        SmartDashboard.putData("Intake Control: ballIn", new IntakeControl(1));
        SmartDashboard.putData("Intake Control: ballOut", new IntakeControl(-1));
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("climb", new climb());
        SmartDashboard.putData("Auto Command Group", new AutoCommandGroup());
        SmartDashboard.putData("Drive to Line", new DrivetoLine());
        SmartDashboard.putData("Strafe to wall: Red", new Strafetowall(false));
        SmartDashboard.putData("Strafe to wall: Blue", new Strafetowall(true));
        SmartDashboard.putData("Spin shooter", new spinshooter());
        SmartDashboard.putData("Unclimb", new Unclimb());
        SmartDashboard.putData("Calibrate Gyro", new calibrateGyro());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }

    public Joystick getJoystick2() {
        return joystick2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

