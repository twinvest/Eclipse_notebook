import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Macro {

	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		robot.mouseMove(200, 300);
		robot.keyPress(InputEvent.BUTTON3_DOWN_MASK);
		robot.keyRelease(InputEvent.BUTTON3_DOWN_MASK);
	}

}
