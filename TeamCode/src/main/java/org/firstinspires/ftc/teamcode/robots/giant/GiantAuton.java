package org.firstinspires.ftc.teamcode.robots.giant;
import static org.firstinspires.ftc.teamcode.util.utilMethods.futureTime;
import static org.firstinspires.ftc.teamcode.util.utilMethods.isPast;


import com.acmerobotics.dashboard.canvas.Canvas;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.internal.system.Misc;
import org.firstinspires.ftc.teamcode.robots.deepthought.util.StickyGamepad;


import java.util.Map;


@Autonomous(name = "auton SPECIMEN")
@Config(value = "auton SPECIMEN")
public class GiantAuton extends OpMode {


    public static double FORWARD=1.21;
    public static double BUFFER=.3;
    public static double LONGBUFFER= 1.9;        //2.2
    public static double BACKWARD=.255;     //.255


    Robot robot;
    StickyGamepad g1=null;
    StickyGamepad g2=null;
    //HardwareMap hardwareMap;


    @Override
    public void init() {
        robot = new Robot(hardwareMap, gamepad1,gamepad2);
        robot.init();
        //  robot.setRotate(950);
    }
    @Override
    public void init_loop(){
        g1=new StickyGamepad(gamepad1);
        g2=new StickyGamepad(gamepad2);
        g1.update();
        g2.update();
        if(g1.guide){
            robot.changeAlly();
        }
        robot.update(new Canvas());
        handleTelemetry(robot.getTelemetry(true), robot.getTelemetryName());
    }


    @Override
    public void loop() {
        robot.update(new Canvas());
        execute();
        handleTelemetry(robot.getTelemetry(true), robot.getTelemetryName());
    }


    //forward vertical for one tile practice    vertical=4000;

    //forward one tile, turn 135, forward 1.25, extend arm, drop
    int autonIndex = 0;
    long autonTimer = 0;
    public void execute() {
        switch (autonIndex) {
            case 0:
                robot.close();
                robot.setUpExtend(2280);        //2250
                autonIndex++;
                break;
            case 1:
                if(robot.getUpExtend()>2000){
                    robot.resetDrive();
                    robot.setShoulder(1250+420);        //1350
                }
                if(robot.getShoulder()>1230+420){
                    autonIndex++;
                }

                break;
            case 2:
              //  robot.driveDistance(13,.5);
                if (robot.driveDistance(12.9,1)){    //17.5    .5
                    autonTimer=futureTime(.5);
                    autonIndex++;
                }
                break;

            case 3:
                if(isPast(autonTimer)){
                    robot.downHook();
                    autonTimer=futureTime(.6);
                    autonIndex++;
                }

                break;
            case 4:
                if(isPast(autonTimer)){
                    robot.open();
                    robot.wallGrab();
                    autonIndex++;
                }
                break;
            case 5:
                if(robot.driveDistance(38,.8)){
                    autonTimer=futureTime(.3);
                    autonIndex++;
                }
                break;
            case 6:
                if(isPast(autonTimer)){
                    robot.resetDrive();
                    //robot.setDrive(0,1,0);
                    autonIndex++;
                }
                break;
            case 7:
                if(robot.strafe(43,1)){       //speed up??
                    autonIndex++;
                }
                break;
            case 8:
                if(robot.turnUntilDegreesIMU(180,1)){      //robot.getHor()<=(-3780) &&robot.getVert()<=(-7180)
                    robot.resetDrive();
                   // robot.setDrive(0,0,-.5);    //930
                    //autonTimer=futureTime(.01);
                     autonTimer=futureTime(2);
                    //autonTimer=futureTime(1.5);
                    autonIndex++;
                }
                break;
            case 9:
                if(robot.driveDistance(18.7,1)){
                    autonTimer=futureTime(.4);
                    autonIndex++;

                }
                break;
            case 10:
                if(isPast(autonTimer)){
                    robot.close();
                    autonTimer=futureTime(.2);
                    autonIndex++;
                }
                break;
            case 11:
                if(isPast(autonTimer)){
                    robot.hookit();
                    robot.setUpExtend(1500);
                    autonIndex++;
                }
                break;
            case 12:
                if(robot.getUpExtend()>200){
                    autonIndex++;
                }
                break;
            case 13:        //47.8
                if(robot.driveDistance(45,1)){        //47.8
                    autonIndex++;
                    robot.setShoulder(1250+420);
//                if(isPast(autonTimer))
                }
                break;
            case 14:
                if(robot.turnUntilDegreesIMU(-90,1)){
                    autonIndex++;
                }
                break;
            case 15:
                if(robot.driveDistance(70,1)){   //robot.getHor()<-13000
                    robot.setUpExtend(2288);
                    robot.resetDrive();
                    autonTimer=futureTime(1.1);
                    robot.setDrive(-1,0,0);
                    autonIndex++;
                }
                break;
            case 16:
                if(isPast(autonTimer)){
                    robot.setDrive(0,0,0);
                    autonIndex++;
                }
                break;
            case 17:
                if(robot.turnUntilDegreesIMU(0,1)){
                    autonIndex++;
                }
                break;
            case 18:
                if (robot.driveDistance(11.8,1)){    //9.1   .5
                    autonTimer=futureTime(.5);
                    autonIndex++;
                }
                break;
            case 19:
                if(isPast(autonTimer)){
                    //robot.downHook();
                    robot.setUpExtend(1310);
                    autonTimer=futureTime(.6);
                    autonIndex++;
                }
                break;
            case 20:
                if(isPast(autonTimer)){
                    robot.open();
                    robot.wallGrab();
                    autonIndex++;
                }
                break;
            case 21:
                if(robot.driveDistance(35,.8)){
                    autonTimer=futureTime(.5);
                    robot.setUpExtend(1600);
                    autonIndex++;
                }
                break;
            case 22:
                if(isPast(autonTimer)) {
                    robot.setShoulder(750+420);
                    autonTimer=futureTime(.2);
                    autonIndex++;
                }
                break;
            case 23:
                if(isPast(autonTimer)){
                    robot.setUpExtend(0);
                    autonIndex++;
                }
                break;
            case 24:
                if(robot.strafe(40,1)){           //speedup???
                    autonTimer=futureTime(.44);
                    robot.setDrive(-1,0,0);
                    autonIndex++;
                }
                break;
            case 25:
                if(isPast(autonTimer)){
                    robot.setDrive(0,0,0);
                    autonIndex++;
                }
                break;


        }
    }


    private void handleTelemetry(Map<String, Object> telemetryMap, String telemetryName) {
        telemetry.addLine(telemetryName);


        for (Map.Entry<String, Object> entry : telemetryMap.entrySet()) {
            String line = Misc.formatInvariant("%s: %s", entry.getKey(), entry.getValue());
            telemetry.addLine(line);
            //telemetry.addLine(""+autonIndex);
        }


        telemetry.addLine();
    }
}
