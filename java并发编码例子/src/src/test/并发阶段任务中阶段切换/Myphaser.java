package test.并发阶段任务中阶段切换;

import java.util.concurrent.Phaser;

public class Myphaser extends Phaser {
	@Override
	protected boolean onAdvance(int phase, int registeredParties) {
		switch (phase) {
		case 0:
			return studentsArrived();
		case 1:
			return finishFirstExercise();
		case 2:
			return finishSecondExercise();
		case 3:
			return finishExam();
		default:
			return true;
		}
	}

	private boolean finishExam() {
		System.out.println("Phaser student have finish Exam....");
		return false;
	}

	private boolean finishSecondExercise() {
		System.out.println("Phaser student have finish second Exercise....");
		return false;
	}

	private boolean finishFirstExercise() {
		System.out.println("Phaser student have finish first Exercise....");
		return false;
	}

	private boolean studentsArrived() {
		System.out.println("Phaser student is ready....");
		return false;
	}
}
