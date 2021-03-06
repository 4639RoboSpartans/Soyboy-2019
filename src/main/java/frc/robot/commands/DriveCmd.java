/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FRC Team 4639. All Rights Reserved.                     */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.OI;
import frc.robot.subsystems.DriveTrainSys;

public class DriveCmd extends Command {

	private final DriveTrainSys m_drive;
	private final OI m_oi;

	public DriveCmd(DriveTrainSys m_drive, OI m_oi) {
		this.m_drive = m_drive;
		requires(m_drive);
		this.m_oi = m_oi;
	}

	@Override
	protected void initialize() {
	}

	@Override
	protected void execute() {
		double leftY = m_oi.getLeftY(0);
		double rightX = m_oi.getRightX(0);

		if (m_oi.getRightTrigger(0) > 0) {
			leftY *= 0.4;
			rightX *= 0.4;
		}

		m_drive.drive(leftY, rightX);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
	}

	@Override
	protected void interrupted() {
	}
}
