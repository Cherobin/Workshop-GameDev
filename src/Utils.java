
public class Utils {

	public static boolean collisionQuad(Sprite s1, Sprite s2) {

		if (s1.x < s2.x + s2.sizeX && s1.x + s1.sizeX > s2.x && s1.y < s2.y + s2.sizeY && s1.y + s1.sizeY > s2.y) {
			return true;

		} else {
			return false;
		}
	}

	public static boolean collissionCircle(Sprite s1, Sprite s2) {
		return true;
	}
}
