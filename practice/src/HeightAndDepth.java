
public class HeightAndDepth {
	
	public int depth(Position<E> position) {
        if (isRoot(position)) {
            return 0;
        }

        return 1 + depth(parent(position));
    }
	
	public int height(Position<E> position) {
        int height = 0;

        for (Position<E> child : children(position)) {
            height = Math.max(height, 1 + height(child));
        }

        return height;
    }

}
