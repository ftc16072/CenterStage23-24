package org.firstinspires.ftc.teamcode.ftc16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ftc16072.Robot;

@TeleOp
public class Ri3w extends OpMode {
    public static final double TRIGGER_THRESHOLD = 0.5;
    public static final double NORMAL_SPEED = 0.5;
    public static final double FAST_SPEED = 0.75;
    public static final double SLOW_SPEED = 0.25;

    Robot robot = new Robot();
    boolean manipulatorEject = false;

    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        manipulatorControl();
        driverControl();

    }
    /*
   Driver Control
   left trigger: output
   right trigger: intake
   left bumper: slow
   right bumper: fast
   y: arm down positions
   x: arm down manual
   a: arm up position
   b: arm up manual
   left joystick: drive
   right joystick: rotate
     */



   public void driverControl(){
       double speed = NORMAL_SPEED;
       if(gamepad1.left_bumper){
           speed = FAST_SPEED;

       }
       else if(gamepad1.right_bumper){
            speed = SLOW_SPEED;
       }


       robot.nav.fieldRelative(-gamepad1.left_stick_y * speed,
               gamepad1.left_stick_x * speed,
               gamepad1.right_stick_x * speed);


       if (manipulatorEject){
           robot.intake.eject();
       }
       else if (gamepad1.right_trigger> TRIGGER_THRESHOLD) {
           robot.intake.eject();
       }
       else if (gamepad1.left_trigger> TRIGGER_THRESHOLD) {
           robot.intake.run();

       }
      else {
          robot.intake.stop();
       }

   }

   /*
   y: arm to top postiion
   a: arm to bottom position
   Dpad up: arm slightly up (manual)
   dpad down: arm slightly down (manual)
   right trigger: eject
    */
    public void manipulatorControl(){
        if (gamepad2.y || gamepad1.y) {
            robot.arm.goToTop();
        } else if (gamepad2.a || gamepad1.a) {
            robot.arm.goToBottom();
        } else if (gamepad2.dpad_up || gamepad1.b) {
            robot.arm.manualUp();
        } else if (gamepad2.dpad_down || gamepad1.x) {
            robot.arm.manualDown();
        }

        if (gamepad2.right_trigger > TRIGGER_THRESHOLD) {
            manipulatorEject = true;
        }
        else {
            manipulatorEject = false;
        }
    }
}
