/**
 * 
 */
package gui6.whackAMole;

import gui6.components.Action;
import gui6.components.Clickable;

/**
 * @author Nockles
 * This is for my partner, the Enemy Designer to implement
 */
public interface MoleInterface extends Clickable {

	int getAppearanceTime();

	void setAppearanceTime(int screenTime);

	void setAction(Action action);

}
