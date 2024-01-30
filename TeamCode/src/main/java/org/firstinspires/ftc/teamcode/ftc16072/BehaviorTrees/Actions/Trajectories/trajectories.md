##Going to tape
##Far Red corner
##Left
TrajectorySequence Going_to_far_red_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(-36.26, -62.51, Math.toRadians(-87.72)))
.lineTo(new Vector2d(-47.23, -30.18))
.build();


##Middle
TrajectorySequence Going_to_far_red_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(-36.26, -62.51, Math.toRadians(-87.72)))
.lineTo(new Vector2d(-36.70, -23.95))
.build();

##Right
TrajectorySequence Going_to_far_red_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(-35.96, -62.51, Math.toRadians(-87.72)))
.lineTo(new Vector2d(-36.41, -35.22))
.lineTo(new Vector2d(-25.14, -36.70))
.build();


##Close Red corner
##Left
TrajectorySequence Going_to_close_red_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(11.79, -63.99, Math.toRadians(-87.72)))
.lineTo(new Vector2d(11.35, -35.52))
.lineTo(new Vector2d(-0.07, -33.74))
.build();


##Middle
TrajectorySequence Going_to_close_red_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(11.79, -63.99, Math.toRadians(-87.72)))
.lineTo(new Vector2d(11.35, -24.54))
.build();

##Right
TrajectorySequence Going_to_close_red_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(11.79, -63.99, Math.toRadians(-87.72)))
.lineTo(new Vector2d(22.76, -30.77))
.build();



##Far blue corner
##Left
TrajectorySequence Going_to_far_blue_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(-36.56, 59.54, Math.toRadians(90.00)))
.lineTo(new Vector2d(-47.68, 30.03))
.build();

##Middle
TrajectorySequence Going_to_far_blue_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(-36.56, 59.54, Math.toRadians(90.00)))
.lineTo(new Vector2d(-36.26, 25.43))
.build();

##Right
TrajectorySequence Going_to_far_blue_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(-36.56, 59.54, Math.toRadians(90.00)))
.lineTo(new Vector2d(-35.67, 32.70))
.lineTo(new Vector2d(-24.54, 35.81))
.build();

##Close blue corner
##Left
TrajectorySequence Going_to_close_blue_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(12.53, 62.36, Math.toRadians(90.00)))
.lineTo(new Vector2d(10.90, 35.67))
.lineTo(new Vector2d(0.22, 35.22))
.build();



##Middle
TrajectorySequence Going_to_close_blue_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(11.64, 60.14, Math.toRadians(90.00)))
.lineTo(new Vector2d(11.64, 24.40))
.build();


##Right
TrajectorySequence Going_to_close_blue_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(11.64, 60.14, Math.toRadians(90.00)))
.lineTo(new Vector2d(23.06, 30.92))
.build();

























##Going to backboard
##Far red corner
##Left
TrajectorySequence far_red_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(-47.80, -30.56, Math.toRadians(-1.33)))
.lineTo(new Vector2d(-37.18, -30.38))
.lineTo(new Vector2d(-37.52, -62.07))
.lineTo(new Vector2d(35.43, -61.20))
.lineTo(new Vector2d(33.87, -36.48))
.lineTo(new Vector2d(48.84, -37.70))
.build();


##Middle
TrajectorySequence far_red_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(-36.30, -25.16, Math.toRadians(270.00)))
.lineTo(new Vector2d(-37.70, -62.42))
.lineTo(new Vector2d(34.74, -61.73))
.lineTo(new Vector2d(33.69, -34.39))
.lineTo(new Vector2d(48.84, -36.83))
.build();


##Right
TrajectorySequence far_red_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(-26.03, -30.21, Math.toRadians(178.45)))
.lineTo(new Vector2d(-38.05, -31.26))
.lineTo(new Vector2d(-37.35, -61.73))
.lineTo(new Vector2d(34.91, -61.90))
.lineTo(new Vector2d(34.22, -34.74))
.lineTo(new Vector2d(49.02, -36.48))
.build();


##Close red corner
Left:
TrajectorySequence close_red_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(0.44, -30.38, Math.toRadians(-1.91)))
.lineTo(new Vector2d(11.58, -30.56))
.lineTo(new Vector2d(10.71, -61.73))
.lineTo(new Vector2d(34.39, -61.03))
.lineTo(new Vector2d(33.87, -33.87))
.lineTo(new Vector2d(49.02, -35.61))
.build();


##Middle:
TrajectorySequence close_red_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(11.75, -24.64, Math.toRadians(270.00)))
.lineTo(new Vector2d(11.06, -62.07))
.splineToConstantHeading(new Vector2d(35.43, -61.38), Math.toRadians(1.64))
.lineTo(new Vector2d(34.39, -35.43))
.lineTo(new Vector2d(48.84, -37.18))
.build();



##Right
TrajectorySequence close_red_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(23.25, -30.56, Math.toRadians(180.00)))
.lineTo(new Vector2d(11.06, -31.43))
.lineTo(new Vector2d(10.53, -62.07))
.lineTo(new Vector2d(36.30, -62.25))
.lineTo(new Vector2d(36.83, -35.78))
.lineTo(new Vector2d(49.36, -36.48))
.build();



##Far blue corner
##Left

TrajectorySequence far_blue_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(-47.10, 30.04, Math.toRadians(0.00)))
.lineTo(new Vector2d(-36.13, 29.86))
.lineTo(new Vector2d(-38.05, 61.20))
.lineTo(new Vector2d(35.26, 61.20))
.lineTo(new Vector2d(34.74, 33.69))
.lineTo(new Vector2d(48.67, 34.56))
.build();

##Middle

TrajectorySequence far_blue_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(-36.13, 24.81, Math.toRadians(90.00)))
.lineTo(new Vector2d(-36.83, 62.25))
.lineTo(new Vector2d(33.87, 61.90))
.lineTo(new Vector2d(35.09, 31.78))
.lineTo(new Vector2d(49.19, 34.74))
.build();

##Right

TrajectorySequence far_blue_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(-25.86, 30.73, Math.toRadians(180.00)))
.lineTo(new Vector2d(-37.00, 30.56))
.lineTo(new Vector2d(-35.96, 62.42))
.lineTo(new Vector2d(35.78, 61.38))
.lineTo(new Vector2d(35.78, 33.00))
.lineTo(new Vector2d(48.84, 33.69))
.build();



##Close blue corner
##Left

TrajectorySequence close_blue_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(0.44, 30.21, Math.toRadians(0.00)))
.lineTo(new Vector2d(12.10, 30.91))
.lineTo(new Vector2d(10.53, 62.42))
.lineTo(new Vector2d(35.78, 63.64))
.lineTo(new Vector2d(35.61, 33.52))
.lineTo(new Vector2d(49.02, 34.91))
.build();



##Middle
TrajectorySequence close_blue_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(11.93, 24.29, Math.toRadians(90.00)))
.UNSTABLE_addTemporalMarkerOffset(2.66,() -> {})
.UNSTABLE_addTemporalMarkerOffset(2.75,() -> {})
.lineTo(new Vector2d(10.53, 59.46))
.lineTo(new Vector2d(34.74, 59.64))
.lineTo(new Vector2d(33.69, 32.30))
.lineTo(new Vector2d(47.62, 34.56))
.build();



##Right
TrajectorySequence close_blue_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(23.46, 29.98, Math.toRadians(180.00)))
.lineTo(new Vector2d(12.23, 30.52))
.lineTo(new Vector2d(13.86, 61.31))
.lineTo(new Vector2d(37.40, 62.40))
.lineTo(new Vector2d(37.58, 33.60))
.lineTo(new Vector2d(48.82, 35.23))
.build();







##Parking Trajectories

##Blue(Top)

TrajectorySequence parking_blue = drive.trajectorySequenceBuilder(new Pose2d(49.02, 35.43, Math.toRadians(-2.73)))
.lineTo(new Vector2d(48.67, 64.16))
.lineTo(new Vector2d(62.25, 63.99))
.build();

##Red(Bottom)

TrajectorySequence parking_red = drive.trajectorySequenceBuilder(new Pose2d(48.49, -36.65, Math.toRadians(0.00)))
.lineTo(new Vector2d(48.32, -64.51))
.lineTo(new Vector2d(63.29, -63.99))
.build();

