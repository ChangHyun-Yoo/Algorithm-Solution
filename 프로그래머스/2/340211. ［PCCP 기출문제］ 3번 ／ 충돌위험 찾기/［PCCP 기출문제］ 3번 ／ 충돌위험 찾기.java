import java.util.*;

class Solution {

    static class Position {
        int r, c;
        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return r == position.r && c == position.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        Map<Integer, Position> pointMap = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            pointMap.put(i + 1, new Position(points[i][0], points[i][1]));
        }

        List<List<Position>> robotPaths = new ArrayList<>();

        for (int[] route : routes) {
            List<Position> path = new ArrayList<>();
            Position current = pointMap.get(route[0]);
            path.add(current);

            for (int j = 1; j < route.length; j++) {
                Position next = pointMap.get(route[j]);
                path.addAll(calculatePath(current, next));
                current = next;
            }

            robotPaths.add(path);
        }

        int maxTime = 0;
        for (List<Position> path : robotPaths) {
            maxTime = Math.max(maxTime, path.size());
        }

        for (int t = 0; t < maxTime; t++) {
            Map<Position, Integer> positionCount = new HashMap<>();

            for (List<Position> path : robotPaths) {
                if (t < path.size()) {
                    Position pos = path.get(t);
                    positionCount.put(pos, positionCount.getOrDefault(pos, 0) + 1);
                }
            }

            for (int count : positionCount.values()) {
                if (count > 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private List<Position> calculatePath(Position start, Position end) {
        List<Position> path = new ArrayList<>();

        int r = start.r;
        int c = start.c;

        while (r != end.r) {
            if (r < end.r) r++;
            else r--;
            path.add(new Position(r, c));
        }

        while (c != end.c) {
            if (c < end.c) c++;
            else c--;
            path.add(new Position(r, c));
        }

        return path;
    }
}