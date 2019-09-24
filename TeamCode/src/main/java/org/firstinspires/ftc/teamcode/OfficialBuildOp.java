package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Official_Build (Blocks to Java)", group = "")
public class Official_Build extends LinearOpMode {

  private DcMotor frontLeft;
  private DcMotor frontRight;
  private DcMotor backLeft;
  private DcMotor backRight;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    frontLeft = hardwareMap.dcMotor.get("frontLeft");
    frontRight = hardwareMap.dcMotor.get("frontRight");
    backLeft = hardwareMap.dcMotor.get("backLeft");
    backRight = hardwareMap.dcMotor.get("backRight");

    // runs the op mode
    waitForStart();
    // waits for start button to be pressed
    if (opModeIsActive()) {
      // if the stop button is pressed than it will stop
      while (opModeIsActive()) {
        // while the drive system is running it does this loop
        if (gamepad1.left_stick_x < 0 && Math.abs(Math.atan(gamepad1.left_stick_y / gamepad1.left_stick_x) / Math.PI * 180) < 45) {
          // if true crab left
          left();
        } else if (gamepad1.left_stick_y < 0 && Math.abs(Math.atan(gamepad1.left_stick_y / gamepad1.left_stick_x) / Math.PI * 180) > 45) {
          // if true move forward
          forward();
        } else if (gamepad1.left_stick_x > 0 && Math.abs(Math.atan(gamepad1.left_stick_y / gamepad1.left_stick_x) / Math.PI * 180) < 45) {
          // if true crab right
          right();
        } else if (gamepad1.left_stick_y > 0 && Math.abs(Math.atan(gamepad1.left_stick_y / gamepad1.left_stick_x) / Math.PI * 180) > 45) {
          // if true move backward
          backward();
        } else if (gamepad1.right_trigger > 0) {
          // if true tank right
          turnRight();
        } else if (gamepad1.left_trigger > 0) {
          // if true tank left
          turnLeft();
        } else if (gamepad1.right_stick_x > 0 && gamepad1.right_stick_y < 0) {
          // NE
          NE();
        } else if (gamepad1.right_stick_x < 0 && gamepad1.right_stick_y > 0) {
          // SW
          SW();
        } else if (gamepad1.right_stick_x > 0 && gamepad1.right_stick_y > 0) {
          // SE
          SE();
        } else if (gamepad1.right_stick_x < 0 && gamepad1.right_stick_y < 0) {
          // NW
          NW();
        } else {
          // if functions are not met robot does not move
          // The Y axis of a joystick ranges from -1 in its topmost position
          // to +1 in its bottommost position. We negate this value so that
          // the topmost position corresponds to maximum forward power.
          frontLeft.setPower(0);
          frontRight.setPower(0);
          // The Y axis of a joystick ranges from -1 in its topmost position
          // to +1 in its bottommost position. We negate this value so that
          // the topmost position corresponds to maximum forward power.
          backLeft.setPower(0);
          backRight.setPower(0);
        }
        // display user input from the game pad
        telemetry.addData("LT", gamepad1.left_trigger);
        telemetry.addData("RT", gamepad1.right_trigger);
        telemetry.addData("LX", gamepad1.left_stick_x);
        telemetry.addData("LY", gamepad1.left_stick_y);
        telemetry.update();
        telemetry.addData("RX", gamepad1.right_stick_x);
        telemetry.addData("RY", gamepad1.right_stick_y);
        telemetry.addData("Degree", Math.abs(Math.atan(gamepad1.left_stick_y / gamepad1.left_stick_x) / Math.PI * 180));
      }
    }
  }

  /**
   * Sets the speed for the motors in the direction of forward and backward movement
   */
  private void forward() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottom most position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontLeft.setPower(Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    frontRight.setPower(Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    backLeft.setPower(Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    backRight.setPower(Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
  }

  /**
   * Sets the speed for the motors in the direction of forward and backward movement
   */
  private void backward() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottom most position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontLeft.setPower(-Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    frontRight.setPower(-Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    backLeft.setPower(-Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    backRight.setPower(-Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
  }

  /**
   * Describe this function...
   */
  private void right() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontLeft.setPower(-Math.abs(Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2))));
    backRight.setPower(-Math.abs(Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2))));
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontRight.setPower(-(-Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2))));
    backLeft.setPower(-(-Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2))));
  }

  /**
   * Describe this function...
   */
  private void left() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontLeft.setPower(-(-Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2))));
    backRight.setPower(-(-Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2))));
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontRight.setPower(-Math.abs(Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2))));
    backLeft.setPower(-Math.abs(Math.sqrt(Math.pow(Math.abs(gamepad1.left_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2))));
  }

  /**
   * Describe this function...
   */
  private void turnRight() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontLeft.setPower(-(-Math.sqrt(1)));
    backLeft.setPower(-(-Math.sqrt(1)));
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontRight.setPower(-Math.abs(Math.sqrt(1)));
    backRight.setPower(-Math.abs(Math.sqrt(1)));
  }

  /**
   * Describe this function...
   */
  private void turnLeft() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontLeft.setPower(-Math.abs(Math.sqrt(1)));
    backLeft.setPower(-Math.abs(Math.sqrt(1)));
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontRight.setPower(-(-Math.sqrt(1)));
    backRight.setPower(-(-Math.sqrt(1)));
  }

  /**
   * Describe this function...
   */
  private void NW() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontLeft.setPower(Math.sqrt(Math.pow(Math.abs(gamepad1.right_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    backRight.setPower(Math.sqrt(Math.pow(Math.abs(gamepad1.right_stick_y), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
  }

  /**
   * Describe this function...
   */
  private void NE() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontRight.setPower(Math.sqrt(Math.pow(Math.abs(gamepad1.right_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    backLeft.setPower(Math.sqrt(Math.pow(Math.abs(gamepad1.right_stick_y), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
  }

  /**
   * Describe this function...
   */
  private void SE() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontLeft.setPower(-Math.sqrt(Math.pow(Math.abs(gamepad1.right_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    backRight.setPower(-Math.sqrt(Math.pow(Math.abs(gamepad1.right_stick_y), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
  }

  /**
   * Describe this function...
   */
  private void SW() {
    // The Y axis of a joystick ranges from -1 in its topmost position
    // to +1 in its bottommost position. We negate this value so that
    // the topmost position corresponds to maximum forward power.
    frontRight.setPower(-Math.sqrt(Math.pow(Math.abs(gamepad1.right_stick_x), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
    backLeft.setPower(-Math.sqrt(Math.pow(Math.abs(gamepad1.right_stick_y), 2) + Math.pow(Math.abs(gamepad1.left_stick_y), 2)));
  }
}
