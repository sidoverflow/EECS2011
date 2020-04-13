
public class HeightAndDepth {
	
	public int depth(Position<E> position) {
        if (isRoot(position)) {
            return 0;
        }

        return 1 + depth(parent(position));
    }
	
	public int height(Position<E> position) {
	if (isExternal(position)) {
		return 0;
	}
        int height = 0;

        for (Position<E> child : children(position)) {
            height = Math.max(height, height(child));
        }

        return 1 + height;
    }

}
