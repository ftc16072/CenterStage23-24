##Bottom left  corner Middle Tape

TrajectorySequence bottom_left_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(-36.32, -24.54, Math.toRadians(270.00)))
.lineTo(new Vector2d(-37.77, -60.95))
.lineTo(new Vector2d(34.69, -60.77))
.lineTo(new Vector2d(35.23, -35.05))
.lineTo(new Vector2d(49.54, -36.86))
.lineTo(new Vector2d(48.45, -60.95))
.lineTo(new Vector2d(62.94, -61.86))
.build();


##Bottom left corner Left Tape

TrajectorySequence bottom_left_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(-47.18, -30.52, Math.toRadians(0.00)))
.lineTo(new Vector2d(-36.14, -30.16))
.lineTo(new Vector2d(-37.77, -60.59))
.lineTo(new Vector2d(35.23, -64.21))
.lineTo(new Vector2d(34.32, -34.32))
.lineTo(new Vector2d(48.63, -36.68))
.lineTo(new Vector2d(48.45, -63.49))
.lineTo(new Vector2d(62.58, -62.22))
.build();


##Bottom left corner Right Tape

TrajectorySequence bottom_left_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(-25.27, -29.98, Math.toRadians(180.00)))
.lineTo(new Vector2d(-37.95, -30.88))
.lineTo(new Vector2d(-38.85, -60.77))
.splineTo(new Vector2d(35.95, -60.77), Math.toRadians(0.00))
.lineTo(new Vector2d(34.87, -35.23))
.lineTo(new Vector2d(49.00, -36.68))
.lineTo(new Vector2d(48.45, -60.59))
.lineTo(new Vector2d(61.31, -59.32))
.build();


##Bottom Right Corner Middle Tape
TrajectorySequence bottom_right_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(11.50, -24.72, Math.toRadians(270.00)))
.lineTo(new Vector2d(10.05, -61.49))
.lineTo(new Vector2d(37.04, -62.40))
.lineTo(new Vector2d(35.23, -36.32))
.lineTo(new Vector2d(48.63, -36.68))
.lineTo(new Vector2d(48.27, -61.86))
.lineTo(new Vector2d(62.40, -61.49))
.build();


##Bottom Right Corner Left Tape
TrajectorySequence bottom_right_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(0.63, -29.98, Math.toRadians(0.00)))
.lineTo(new Vector2d(10.78, -30.34))
.lineTo(new Vector2d(9.87, -62.04))
.lineTo(new Vector2d(36.14, -61.49))
.lineTo(new Vector2d(34.51, -35.41))
.lineTo(new Vector2d(47.91, -36.32))
.lineTo(new Vector2d(48.09, -63.12))
.lineTo(new Vector2d(62.22, -62.94))
.build();


##Bottom Right Corner Right Tape
TrajectorySequence bottom_right_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(23.28, -30.34, Math.toRadians(180.00)))
.splineTo(new Vector2d(10.60, -31.06), Math.toRadians(183.27))
.lineTo(new Vector2d(10.60, -61.86))
.lineTo(new Vector2d(36.32, -61.49))
.lineTo(new Vector2d(37.40, -35.23))
.lineTo(new Vector2d(48.45, -36.32))
.lineTo(new Vector2d(48.09, -63.12))
.lineTo(new Vector2d(61.86, -63.67))
.build();


##Top left corner middle tape

TrajectorySequence Top_left_corner_middle_tape = drive.trajectorySequenceBuilder(new Pose2d(-36.26, 70.37, Math.toRadians(90.00)))
.splineTo(new Vector2d(-35.37, 24.69), Math.toRadians(-88.88))
.lineTo(new Vector2d(-36.26, 59.54))
.lineTo(new Vector2d(-19.20, 59.10))
.lineTo(new Vector2d(34.33, 59.10))
.splineTo(new Vector2d(34.48, 33.59), Math.toRadians(-89.67))
.lineTo(new Vector2d(49.01, 34.78))
.splineTo(new Vector2d(47.83, 57.17), Math.toRadians(93.03))
.lineTo(new Vector2d(61.17, 61.77))
.build();


##Top left corner left tape

TrajectorySequence Top_left_corner_left_tape = drive.trajectorySequenceBuilder(new Pose2d(-37.45, 62.21, Math.toRadians(90.00)))
.splineTo(new Vector2d(-37.00, 33.59), Math.toRadians(-89.11))
.lineTo(new Vector2d(-49.01, 30.92))
.lineTo(new Vector2d(-38.78, 57.47))
.lineTo(new Vector2d(-7.79, 61.32))
.lineTo(new Vector2d(38.34, 58.36))
.splineTo(new Vector2d(38.19, 34.78), Math.toRadians(269.64))
.lineTo(new Vector2d(48.72, 35.81))
.lineTo(new Vector2d(47.53, 56.58))
.lineTo(new Vector2d(60.43, 60.58))
.build();


##Top left corner right tape

TrajectorySequence Top_left_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(-37.30, 71.11, Math.toRadians(90.00)))
.lineTo(new Vector2d(-35.81, 35.22))
.lineTo(new Vector2d(-23.21, 34.33))
.lineTo(new Vector2d(-36.85, 39.52))
.lineTo(new Vector2d(-37.59, 58.36))
.lineTo(new Vector2d(-21.28, 59.69))
.lineTo(new Vector2d(33.29, 58.36))
.lineTo(new Vector2d(36.85, 36.70))
.lineTo(new Vector2d(49.16, 37.15))
.lineTo(new Vector2d(49.75, 62.06))
.lineTo(new Vector2d(58.95, 59.25))
.build();


##Top right corner middle tape



##Top right corner left tape

Top right corner right tape
TrajectorySequence top_right_corner_right_tape = drive.trajectorySequenceBuilder(new Pose2d(23.46, 29.98, Math.toRadians(180.00)))
.lineTo(new Vector2d(12.23, 30.52))
.lineTo(new Vector2d(13.86, 61.31))
.lineTo(new Vector2d(37.40, 62.40))
.lineTo(new Vector2d(37.58, 33.60))
.lineTo(new Vector2d(48.82, 35.23))
.lineTo(new Vector2d(48.63, 64.39))
.lineTo(new Vector2d(60.95, 63.31))
.build();
