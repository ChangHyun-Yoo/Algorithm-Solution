import java.io.*;
import java.util.*;

public class Main {

    public static int[][] direction = new int[4][4];
    public static int[][] info = new int[4][4];
    public static int sharkX;
    public static int sharkY;
    public static int sharkDir;
    public static int max = -1;
    public static int current = 0;
    public static Map<Integer, int[]> fish = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 1; i <= 16; i++) {
            fish.put(i, null);
        }

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 8; j++) {
                if(j % 2 == 1)
                    direction[i][j / 2] = Integer.parseInt(st.nextToken());
                else {
                    int value = Integer.parseInt(st.nextToken());
                    info[i][j / 2] = value;
                    int[] place = new int[2];
                    place[0] = i;
                    place[1] = j / 2;
                    fish.replace(value, place);
                }
            }
        }

        sharkX = 0;
        sharkY = 0;
        sharkDir = direction[0][0];
        current = info[0][0];
        fish.remove(info[0][0]);
        info[0][0] = 0;
        direction[0][0] = 0;

        dfs();

        System.out.println(max);
    }

    public static void dfs() {

        fishMove();
        boolean canMove = true;

        int[][] copyInfo = new int[4][4];
        int[][] copyDir = new int[4][4];
        Map<Integer, int[]> copyFish = new HashMap<>();
        for(int i = 0; i < 4; i++) {
            copyInfo[i] = info[i].clone();
            copyDir[i] = direction[i].clone();
        }
        for(int key:fish.keySet()) {
            copyFish.put(key, fish.get(key).clone());
        }

        int count = 0;
        switch(sharkDir) {
            case 1:
                if(sharkX == 0) {
                    canMove = false;
                } else {
                    int x = sharkX - 1;
                    int y = sharkY;
                    while(x >= 0) {
                        if(info[x][y] != 0) {
                            count++;
                            int tempInfo = info[x][y];
                            int tempX = sharkX;
                            int tempY = sharkY;
                            int tempSDir = sharkDir;
                            sharkX = x;
                            sharkY = y;
                            sharkDir = direction[x][y];
                            fish.remove(info[x][y]);
                            direction[x][y] = 0;
                            info[x][y] = 0;

                            current += tempInfo;
                            dfs();
                            current -= tempInfo;

                            for(int i = 0; i < 4; i++) {
                                info[i] = copyInfo[i].clone();
                                direction[i] = copyDir[i].clone();
                            }
                            fish = new HashMap<>();
                            for(int key:copyFish.keySet()) {
                                fish.put(key, copyFish.get(key).clone());
                            }
                            sharkX = tempX;
                            sharkY = tempY;
                            sharkDir = tempSDir;
                        }
                        x--;
                    }
                }
                break;
            case 2:
                if(sharkX == 0 || sharkY == 0) {
                    canMove = false;
                } else {
                    int x = sharkX - 1;
                    int y = sharkY - 1;
                    while(x >= 0 && y >= 0) {
                        if(info[x][y] != 0) {
                            count++;
                            int tempInfo = info[x][y];
                            int tempX = sharkX;
                            int tempY = sharkY;
                            int tempSDir = sharkDir;
                            sharkX = x;
                            sharkY = y;
                            sharkDir = direction[x][y];
                            fish.remove(info[x][y]);
                            direction[x][y] = 0;
                            info[x][y] = 0;

                            current += tempInfo;
                            dfs();
                            current -= tempInfo;

                            for(int i = 0; i < 4; i++) {
                                info[i] = copyInfo[i].clone();
                                direction[i] = copyDir[i].clone();
                            }
                            fish = new HashMap<>();
                            for(int key:copyFish.keySet()) {
                                fish.put(key, copyFish.get(key).clone());
                            }
                            sharkX = tempX;
                            sharkY = tempY;
                            sharkDir = tempSDir;
                        }
                        x--;
                        y--;
                    }
                }
                break;
            case 3:
                if(sharkY == 0) {
                    canMove = false;
                } else {
                    int x = sharkX;
                    int y = sharkY - 1;
                    while(y >= 0) {
                        if(info[x][y] != 0) {
                            count++;
                            int tempInfo = info[x][y];
                            int tempX = sharkX;
                            int tempY = sharkY;
                            int tempSDir = sharkDir;
                            sharkX = x;
                            sharkY = y;
                            sharkDir = direction[x][y];
                            fish.remove(info[x][y]);
                            direction[x][y] = 0;
                            info[x][y] = 0;

                            current += tempInfo;
                            dfs();
                            current -= tempInfo;

                            for(int i = 0; i < 4; i++) {
                                info[i] = copyInfo[i].clone();
                                direction[i] = copyDir[i].clone();
                            }
                            fish = new HashMap<>();
                            for(int key:copyFish.keySet()) {
                                fish.put(key, copyFish.get(key).clone());
                            }
                            sharkX = tempX;
                            sharkY = tempY;
                            sharkDir = tempSDir;
                        }
                        y--;
                    }
                }
                break;
            case 4:
                if(sharkX == 3 || sharkY == 0) {
                    canMove = false;
                } else {
                    int x = sharkX + 1;
                    int y = sharkY - 1;
                    while(x <= 3 && y >= 0) {
                        if(info[x][y] != 0) {
                            count++;
                            int tempInfo = info[x][y];
                            int tempX = sharkX;
                            int tempY = sharkY;
                            int tempSDir = sharkDir;
                            sharkX = x;
                            sharkY = y;
                            sharkDir = direction[x][y];
                            fish.remove(info[x][y]);
                            direction[x][y] = 0;
                            info[x][y] = 0;

                            current += tempInfo;
                            dfs();
                            current -= tempInfo;

                            for(int i = 0; i < 4; i++) {
                                info[i] = copyInfo[i].clone();
                                direction[i] = copyDir[i].clone();
                            }
                            fish = new HashMap<>();
                            for(int key:copyFish.keySet()) {
                                fish.put(key, copyFish.get(key).clone());
                            }
                            sharkX = tempX;
                            sharkY = tempY;
                            sharkDir = tempSDir;
                        }
                        x++;
                        y--;
                    }
                }
                break;
            case 5:
                if(sharkX == 3) {
                    canMove = false;
                } else {
                    int x = sharkX + 1;
                    int y = sharkY;
                    while(x <= 3) {
                        if(info[x][y] != 0) {
                            count++;
                            int tempInfo = info[x][y];
                            int tempX = sharkX;
                            int tempY = sharkY;
                            int tempSDir = sharkDir;
                            sharkX = x;
                            sharkY = y;
                            sharkDir = direction[x][y];
                            fish.remove(info[x][y]);
                            direction[x][y] = 0;
                            info[x][y] = 0;

                            current += tempInfo;
                            dfs();
                            current -= tempInfo;

                            for(int i = 0; i < 4; i++) {
                                info[i] = copyInfo[i].clone();
                                direction[i] = copyDir[i].clone();
                            }
                            fish = new HashMap<>();
                            for(int key:copyFish.keySet()) {
                                fish.put(key, copyFish.get(key).clone());
                            }
                            sharkX = tempX;
                            sharkY = tempY;
                            sharkDir = tempSDir;
                        }
                        x++;
                    }
                }
                break;
            case 6:
                if(sharkX == 3 || sharkY == 3) {
                    canMove = false;
                } else {
                    int x = sharkX + 1;
                    int y = sharkY + 1;
                    while(x <= 3 && y <= 3) {
                        if(info[x][y] != 0) {
                            count++;
                            int tempInfo = info[x][y];
                            int tempX = sharkX;
                            int tempY = sharkY;
                            int tempSDir = sharkDir;
                            sharkX = x;
                            sharkY = y;
                            sharkDir = direction[x][y];
                            fish.remove(info[x][y]);
                            direction[x][y] = 0;
                            info[x][y] = 0;

                            current += tempInfo;
                            dfs();
                            current -= tempInfo;

                            for(int i = 0; i < 4; i++) {
                                info[i] = copyInfo[i].clone();
                                direction[i] = copyDir[i].clone();
                            }
                            fish = new HashMap<>();
                            for(int key:copyFish.keySet()) {
                                fish.put(key, copyFish.get(key).clone());
                            }
                            sharkX = tempX;
                            sharkY = tempY;
                            sharkDir = tempSDir;
                        }
                        x++;
                        y++;
                    }
                }
                break;
            case 7:
                if(sharkY == 3) {
                    canMove = false;
                } else {
                    int x = sharkX;
                    int y = sharkY + 1;
                    while(y <= 3) {
                        if(info[x][y] != 0) {
                            count++;
                            int tempInfo = info[x][y];
                            int tempX = sharkX;
                            int tempY = sharkY;
                            int tempSDir = sharkDir;
                            sharkX = x;
                            sharkY = y;
                            sharkDir = direction[x][y];
                            fish.remove(info[x][y]);
                            direction[x][y] = 0;
                            info[x][y] = 0;

                            current += tempInfo;
                            dfs();
                            current -= tempInfo;

                            for(int i = 0; i < 4; i++) {
                                info[i] = copyInfo[i].clone();
                                direction[i] = copyDir[i].clone();
                            }
                            fish = new HashMap<>();
                            for(int key:copyFish.keySet()) {
                                fish.put(key, copyFish.get(key).clone());
                            }
                            sharkX = tempX;
                            sharkY = tempY;
                            sharkDir = tempSDir;
                        }
                        y++;
                    }
                }
                break;
            case 8:
                if(sharkX == 0 || sharkY == 3) {
                    canMove = false;
                } else {
                    int x = sharkX - 1;
                    int y = sharkY + 1;
                    while(x >= 0 && y <= 3) {
                        if(info[x][y] != 0) {
                            count++;
                            int tempInfo = info[x][y];
                            int tempX = sharkX;
                            int tempY = sharkY;
                            int tempSDir = sharkDir;
                            sharkX = x;
                            sharkY = y;
                            sharkDir = direction[x][y];
                            fish.remove(info[x][y]);
                            direction[x][y] = 0;
                            info[x][y] = 0;

                            current += tempInfo;
                            dfs();
                            current -= tempInfo;

                            for(int i = 0; i < 4; i++) {
                                info[i] = copyInfo[i].clone();
                                direction[i] = copyDir[i].clone();
                            }
                            fish = new HashMap<>();
                            for(int key:copyFish.keySet()) {
                                fish.put(key, copyFish.get(key).clone());
                            }
                            sharkX = tempX;
                            sharkY = tempY;
                            sharkDir = tempSDir;
                        }
                        x--;
                        y++;
                    }
                }
                break;
        }

        if(count == 0) {
            canMove = false;
        }

        if(!canMove) {
            max = Math.max(max, current);
        }
    }

    public static void fishMove() {
        List<Integer> key = new ArrayList<>(fish.keySet());
        Collections.sort(key);
        for(int num: key) {
            int x = fish.get(num)[0];
            int y = fish.get(num)[1];
            int size = info[x][y];
            int dir = direction[x][y];

            boolean check = true;
            while(check) {
                switch (dir) {
                    case 1:
                        if(x == 0 || (x - 1 == sharkX && y == sharkY)) {//움직이지 못할 경우
                            dir++;
                        } else {
                            direction[x][y] = direction[x - 1][y];
                            info[x][y] = info[x - 1][y];
                            int[] newP = {x, y};
                            fish.replace(info[x][y], newP);
                            direction[x - 1][y] = dir;
                            info[x - 1][y] = size;
                            int[] newP1 = {x - 1, y};
                            fish.replace(info[x - 1][y], newP1);
                            check = false;
                        }
                        break;
                    case 2:
                        if(x == 0 || y == 0 || (x - 1 == sharkX && y - 1 == sharkY)) {//움직이지 못할 경우
                            dir++;
                        } else {
                            direction[x][y] = direction[x - 1][y - 1];
                            info[x][y] = info[x - 1][y - 1];
                            int[] newP = {x, y};
                            fish.replace(info[x][y], newP);
                            direction[x - 1][y - 1] = dir;
                            info[x - 1][y - 1] = size;
                            int[] newP1 = {x - 1, y - 1};
                            fish.replace(info[x - 1][y - 1], newP1);
                            check = false;
                        }
                        break;
                    case 3:
                        if(y == 0 || (x == sharkX && y - 1 == sharkY)) {//움직이지 못할 경우
                            dir++;
                        } else {
                            direction[x][y] = direction[x][y - 1];
                            info[x][y] = info[x][y - 1];
                            int[] newP = {x, y};
                            fish.replace(info[x][y], newP);
                            direction[x][y - 1] = dir;
                            info[x][y - 1] = size;
                            int[] newP1 = {x, y - 1};
                            fish.replace(info[x][y - 1], newP1);
                            check = false;
                        }
                        break;
                    case 4:
                        if(x == 3 || y == 0 || (x + 1 == sharkX && y - 1 == sharkY)) {//움직이지 못할 경우
                            dir++;
                        } else {
                            direction[x][y] = direction[x + 1][y - 1];
                            info[x][y] = info[x + 1][y - 1];
                            int[] newP = {x, y};
                            fish.replace(info[x][y], newP);
                            direction[x + 1][y - 1] = dir;
                            info[x + 1][y - 1] = size;
                            int[] newP1 = {x + 1, y - 1};
                            fish.replace(info[x + 1][y - 1], newP1);
                            check = false;
                        }
                        break;
                    case 5:
                        if(x == 3 || (x + 1 == sharkX && y == sharkY)) {//움직이지 못할 경우
                            dir++;
                        } else {
                            direction[x][y] = direction[x + 1][y];
                            info[x][y] = info[x + 1][y];
                            int[] newP = {x, y};
                            fish.replace(info[x][y], newP);
                            direction[x + 1][y] = dir;
                            info[x + 1][y] = size;
                            int[] newP1 = {x + 1, y};
                            fish.replace(info[x + 1][y], newP1);
                            check = false;
                        }
                        break;
                    case 6:
                        if(x == 3 || y == 3 || (x + 1 == sharkX && y + 1 == sharkY)) {//움직이지 못할 경우
                            dir++;
                        } else {
                            direction[x][y] = direction[x + 1][y + 1];
                            info[x][y] = info[x + 1][y + 1];
                            int[] newP = {x, y};
                            fish.replace(info[x][y], newP);
                            direction[x + 1][y + 1] = dir;
                            info[x + 1][y + 1] = size;
                            int[] newP1 = {x + 1, y + 1};
                            fish.replace(info[x + 1][y + 1], newP1);
                            check = false;
                        }
                        break;
                    case 7:
                        if(y == 3 || (x == sharkX && y + 1 == sharkY)) {//움직이지 못할 경우
                            dir++;
                        } else {
                            direction[x][y] = direction[x][y + 1];
                            info[x][y] = info[x][y + 1];
                            int[] newP = {x, y};
                            fish.replace(info[x][y], newP);
                            direction[x][y + 1] = dir;
                            info[x][y + 1] = size;
                            int[] newP1 = {x, y + 1};
                            fish.replace(info[x][y + 1], newP1);
                            check = false;
                        }
                        break;
                    case 8:
                        if(x == 0 || y == 3 || (x - 1 == sharkX && y + 1 == sharkY)) {//움직이지 못할 경우
                            dir = 1;
                        } else {
                            direction[x][y] = direction[x - 1][y + 1];
                            info[x][y] = info[x - 1][y + 1];
                            int[] newP = {x, y};
                            fish.replace(info[x][y], newP);
                            direction[x - 1][y + 1] = dir;
                            info[x - 1][y + 1] = size;
                            int[] newP1 = {x - 1, y + 1};
                            fish.replace(info[x - 1][y + 1], newP1);
                            check = false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }
}