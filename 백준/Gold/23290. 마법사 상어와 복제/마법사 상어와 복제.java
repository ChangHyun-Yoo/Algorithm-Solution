import java.io.*;
import java.util.*;

public class Main {

    static Queue<Fish> copy;
    static Queue<Fish> current;
    static int[][] smell = new int[4][4];
    static int[][] map = new int[4][4];
    static int sharkX;
    static int sharkY;
    static int M;
    static int S;
    static int[][] road = new int[3][2];
    static int max;
    static List<Fish> past;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        copy = new LinkedList<>();
        current = new LinkedList<>();
        visited = new boolean[4][4];

        for(int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine(), " ");
            int fx = Integer.parseInt(st.nextToken()) - 1;
            int fy = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken()) - 1;
            current.offer(new Fish(fx, fy, d));
        }

        st = new StringTokenizer(br.readLine(), " ");
        sharkX = Integer.parseInt(st.nextToken()) - 1;
        sharkY = Integer.parseInt(st.nextToken()) - 1;


        for(int i = 1; i < S + 1; i++) {
            current.forEach(c -> copy.offer(new Fish(c.x, c.y, c.dir)));
            moveFishes();

            for(int[] m: map) {
                Arrays.fill(m, 0);
            }
            current.forEach(c -> map[c.x][c.y]++);

            for(boolean[] v: visited) {
                Arrays.fill(v, false);
            }
            max = -1;
            past = new ArrayList<>();
            moveShark(sharkX, sharkY, 0, 0);
            for(int j = 0; j < 3; j++) {
                if(map[road[j][0]][road[j][1]] > 0) {
                    smell[road[j][0]][road[j][1]] = i;
                }
            }
            sharkX = road[2][0];
            sharkY = road[2][1];

            int size = current.size();
            for(int k = 0; k < size; k++) {
                Fish p = current.poll();
                if((p.x == road[0][0] && p.y == road[0][1]) || (p.x == road[1][0] && p.y == road[1][1]) || (p.x == road[2][0] && p.y == road[2][1])) {
                    continue;
                } else {
                    current.add(p);
                }
            }

            for(int k = 0; k < 4; k++) {
                for(int l = 0; l < 4; l++) {
                    if(smell[k][l] == i - 2) {
                        smell[k][l] = 0;
                    }
                }
            }

            while(!copy.isEmpty()) {
                current.offer(copy.poll());
            }
        }

        System.out.println(current.size());
    }

    static void moveShark(int x, int y, int ate, int t) {
        if(t == 3) {
            if(ate > max) {
                max = ate;
                road[0][0] = past.get(0).x;
                road[0][1] = past.get(0).y;
                road[1][0] = past.get(1).x;
                road[1][1] = past.get(1).y;
                road[2][0] = past.get(2).x;
                road[2][1] = past.get(2).y;
            }
            return;
        }

        //상
        if(x != 0) {
            past.add(new Fish(x - 1, y, 0));
            if(!visited[x - 1][y]) {
                visited[x - 1][y] = true;
                moveShark(x - 1, y, ate + map[x - 1][y], t + 1);
                visited[x - 1][y] = false;
            } else {
                moveShark(x - 1, y, ate, t + 1);
            }
            past.remove(past.size() - 1);
        }

        //좌
        if(y != 0) {
            past.add(new Fish(x, y - 1, 0));
            if(!visited[x][y - 1]) {
                visited[x][y - 1] = true;
                moveShark(x, y - 1, ate + map[x][y - 1], t + 1);
                visited[x][y - 1] = false;
            } else {
                moveShark(x, y - 1, ate, t + 1);
            }
            past.remove(past.size() - 1);
        }

        //하
        if(x != 3) {
            past.add(new Fish(x + 1, y, 0));
            if(!visited[x + 1][y]) {
                visited[x + 1][y] = true;
                moveShark(x + 1, y, ate + map[x + 1][y], t + 1);
                visited[x + 1][y] = false;
            } else {
                moveShark(x + 1, y, ate, t + 1);
            }
            past.remove(past.size() - 1);
        }

        //우
        if(y != 3) {
            past.add(new Fish(x, y + 1, 0));
            if(!visited[x][y + 1]) {
                visited[x][y + 1] = true;
                moveShark(x, y + 1, ate + map[x][y + 1], t + 1);
                visited[x][y + 1] = false;
            } else {
                moveShark(x, y + 1, ate, t + 1);
            }
            past.remove(past.size() - 1);
        }
    }

    static void moveFishes() {
        int size = current.size();

        for(int i = 0; i < size; i++) {
            Fish now = current.poll();
            int x = now.x;
            int y = now.y;
            int dir = now.dir;
            int dirCopy = dir;

            int count = 0;
            while(count <= 8) {
                if(dirCopy == 0) {
                    if(y == 0) {
                        dirCopy = (dirCopy + 7) % 8;
                    } else {
                        if((x == sharkX && y - 1 == sharkY) || smell[x][y - 1] != 0) {
                            dirCopy = (dirCopy + 7) % 8;
                        } else {
                            current.add(new Fish(x, y - 1, dirCopy));
                            break;
                        }
                    }
                }
                if(dirCopy == 1) {
                    if(x == 0 || y == 0) {
                        dirCopy = (dirCopy + 7) % 8;
                    } else {
                        if((x - 1 == sharkX && y - 1 == sharkY) || smell[x - 1][y - 1] != 0) {
                            dirCopy = (dirCopy + 7) % 8;
                        } else {
                            current.add(new Fish(x - 1, y - 1, dirCopy));
                            break;
                        }
                    }
                }
                if(dirCopy == 2) {
                    if(x == 0) {
                        dirCopy = (dirCopy + 7) % 8;
                    } else {
                        if((x - 1 == sharkX && y == sharkY) || smell[x - 1][y] != 0) {
                            dirCopy = (dirCopy + 7) % 8;
                        } else {
                            current.add(new Fish(x - 1, y, dirCopy));
                            break;
                        }
                    }
                }
                if(dirCopy == 3) {
                    if(x == 0 || y == 3) {
                        dirCopy = (dirCopy + 7) % 8;
                    } else {
                        if((x - 1 == sharkX && y + 1 == sharkY) || smell[x - 1][y + 1] != 0) {
                            dirCopy = (dirCopy + 7) % 8;
                        } else {
                            current.add(new Fish(x - 1, y + 1, dirCopy));
                            break;
                        }
                    }
                }
                if(dirCopy == 4) {
                    if(y == 3) {
                        dirCopy = (dirCopy + 7) % 8;
                    } else {
                        if((x == sharkX && y + 1 == sharkY) || smell[x][y + 1] != 0) {
                            dirCopy = (dirCopy + 7) % 8;
                        } else {
                            current.add(new Fish(x, y + 1, dirCopy));
                            break;
                        }
                    }
                }
                if(dirCopy == 5) {
                    if(x == 3 || y == 3) {
                        dirCopy = (dirCopy + 7) % 8;
                    } else {
                        if((x + 1 == sharkX && y + 1 == sharkY) || smell[x + 1][y + 1] != 0) {
                            dirCopy = (dirCopy + 7) % 8;
                        } else {
                            current.add(new Fish(x + 1, y + 1, dirCopy));
                            break;
                        }
                    }
                }
                if(dirCopy == 6) {
                    if(x == 3) {
                        dirCopy = (dirCopy + 7) % 8;
                    } else {
                        if((x + 1 == sharkX && y == sharkY) || smell[x + 1][y] != 0) {
                            dirCopy = (dirCopy + 7) % 8;
                        } else {
                            current.add(new Fish(x + 1, y, dirCopy));
                            break;
                        }
                    }
                }
                if(dirCopy == 7) {
                    if(x == 3 || y == 0) {
                        dirCopy = (dirCopy + 7) % 8;
                    } else {
                        if((x + 1 == sharkX && y - 1 == sharkY) || smell[x + 1][y - 1] != 0) {
                            dirCopy = (dirCopy + 7) % 8;
                        } else {
                            current.add(new Fish(x + 1, y - 1, dirCopy));
                            break;
                        }
                    }
                }
                count++;
            }
            if(count == 9) {
                current.add(now);
            }
        }
    }

    static class Fish {
        int x;
        int y;
        int dir;

        public Fish(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

}

