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

import edu.wpi.first.wpilibj.BuiltInAccelerometer;

import org.usfirst.frc2855.cool2017.SPIGyro.ADXRS453Gyro;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static SpeedController ballintakeintaketalon;
    
    public static CANTalon shooterTalon;
    
    public static CANTalon driveleftreartalon;
    public static CANTalon driveleftreartalon2;
    public static CANTalon driveleftfronttalon;
    public static CANTalon driverightfronttalon;
    public static CANTalon driverightreartalon;
    public static CANTalon driverightreartalon2;
    public static RobotDrive2855 driveRobotDrive41;
    
    public static SpeedController climbingarmclimbingmotor;
    
    public static SpeedController agitator;
    
    public static CameraServer camera;
    
    public static edu.wpi.first.wpilibj.Ultrasonic Ultrasonic;
    
    public static DoubleSolenoid gearInOutSolenoid;
    public static DoubleSolenoid gearPinchSolenoid;
    
    public static ADXRS453Gyro gyro;
    
    public static DigitalOutput ledshooter;
    public static DigitalOutput ledintake;
    public static DigitalOutput ledflash;
    public static DigitalOutput ledbreathe;
    
    //public static I2C pixyarduino;
    public static void init() {
    	
    	CameraServer.getInstance().startAutomaticCapture();
    	
    	
        agitator = new Talon(4);
        LiveWindow.addActuator("agitator", "agitator", (Talon) agitator);
        
        ballintakeintaketalon = new Talon(5);
        LiveWindow.addActuator("ball intake", "intake talon", (Talon) ballintakeintaketalon);
        
        shooterTalon = new CANTalon(7);
        LiveWindow.addActuator("shooter", "shooter talon", shooterTalon);
        
        
        
        driveleftreartalon = new CANTalon(4);
        LiveWindow.addActuator("drive", "left rear talon", driveleftreartalon);
        
        driveleftreartalon2 = new CANTalon(1);
        driveleftreartalon2.setControlMode(CANTalon.TalonControlMode.Follower.getValue());
        LiveWindow.addActuator("drive", "left rear talon2", driveleftreartalon2);
        
        driveleftfronttalon = new CANTalon(5);
        LiveWindow.addActuator("drive", "left front talon", driveleftfronttalon);
        
        driverightfronttalon = new CANTalon(8);
        LiveWindow.addActuator("drive", "right front talon", driverightfronttalon);
        
        driverightreartalon = new CANTalon(6);
        LiveWindow.addActuator("drive", "right rear talon", driverightreartalon);
       
        driverightreartalon2 = new CANTalon(3);
        driverightreartalon2.setControlMode(CANTalon.TalonControlMode.Follower.getValue());
        LiveWindow.addActuator("drive", "right rear talon2", driverightreartalon2);
        
        /* This is to try running 18v to motors (probably won't work
         * driveleftreartalon = new CANTalon(4);
        LiveWindow.addActuator("drive", "left rear talon", driveleftreartalon);
        driveleftreartalon.configPeakOutputVoltage(+18.0, -18.0);
        
        driveleftreartalon2 = new CANTalon(1);
        driveleftreartalon2.setControlMode(CANTalon.TalonControlMode.Follower.getValue());
        LiveWindow.addActuator("drive", "left rear talon2", driveleftreartalon2);
        driveleftreartalon2.configPeakOutputVoltage(+18.0, -18.0);
        
        driveleftfronttalon = new CANTalon(5);
        LiveWindow.addActuator("drive", "left front talon", driveleftfronttalon);
        driveleftfronttalon.configPeakOutputVoltage(+18.0, -18.0);
        
        driverightfronttalon = new CANTalon(8);
        LiveWindow.addActuator("drive", "right front talon", driverightfronttalon);
        driverightfronttalon.configPeakOutputVoltage(+18.0, -18.0);
        
        driverightreartalon = new CANTalon(6);
        LiveWindow.addActuator("drive", "right rear talon", driverightreartalon);
        driverightreartalon.configPeakOutputVoltage(+18.0, -18.0);
       
        driverightreartalon2 = new CANTalon(3);
        driverightreartalon2.setControlMode(CANTalon.TalonControlMode.Follower.getValue());
        LiveWindow.addActuator("drive", "right rear talon2", driverightreartalon2);
        driverightreartalon2.configPeakOutputVoltage(+18.0, -18.0);*/
        
        driveRobotDrive41 = new RobotDrive2855(driveleftfronttalon, driveleftreartalon,
              driverightfronttalon, driverightreartalon, driveleftreartalon2, driverightreartalon2);
        
        driveRobotDrive41.setSafetyEnabled(false);
        driveRobotDrive41.setExpiration(0.5);
        driveRobotDrive41.setSensitivity(0.5);
        driveRobotDrive41.setMaxOutput(1.0);

        driveRobotDrive41.setInvertedMotor(RobotDrive2855.MotorType.kFrontRight, true);
        driveRobotDrive41.setInvertedMotor(RobotDrive2855.MotorType.kFrontLeft, true);
        
        
        climbingarmclimbingmotor = new Talon(6);
        LiveWindow.addActuator("climbing arm", "climbing motor", (Talon) climbingarmclimbingmotor);
        
        
        gearInOutSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Gear In Out Solenoid", "Gear Arm Double Solenoid", gearInOutSolenoid);
        
        gearPinchSolenoid = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("Gear Pinch", "Gear Pinch Double Solenoid", gearPinchSolenoid);
        
        
        Ultrasonic = new edu.wpi.first.wpilibj.Ultrasonic(8, 9);
        
        
        shooterTalon.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        shooterTalon.reverseSensor(false);
        shooterTalon.configNominalOutputVoltage(+0.0f, -0.0f);
        shooterTalon.configPeakOutputVoltage(+12.0f, -0.0f);
        shooterTalon.setProfile(0);
        
        
        
        gyro = new ADXRS453Gyro();

        
        ledshooter = new DigitalOutput(1);
        LiveWindow.addActuator("LED Shooter", "LED Shooter", ledshooter);
        
        ledintake = new DigitalOutput(2);
        LiveWindow.addActuator("LED Intake", "LED Intake", ledintake);
        
        ledflash = new DigitalOutput(3);
        LiveWindow.addActuator("LED Flash", "LED Flash", ledflash);
        
        ledbreathe = new DigitalOutput(4);
        LiveWindow.addActuator("LED Breathe", "LED Breathe", ledbreathe);
        
        
        //pixyarduino = new I2C(edu.wpi.first.wpilibj.I2C.Port.kOnboard, 8);
        
    }
}
