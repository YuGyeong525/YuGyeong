import java.util.Scanner;

public class S05_12 {
    public S05_12() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        new Line();
        new Rect();
        new Circle();
        int arrLen = 0;
        String[] shapeArr = new String[arrLen];
        System.out.println("그래픽 에디터 beauty를 실행합니다.");

        int input;
        do {
            String[] temp;
            int i;
            System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
            input = sc.nextInt();
            label69:
            switch(input) {
                case 1:
                    System.out.print("Line(1), Rect(2), Circle(3) >> ");
                    input = sc.nextInt();
                    ++arrLen;
                    temp = new String[arrLen];

                    for(i = 0; i < shapeArr.length; ++i) {
                        temp[i] = shapeArr[i];
                    }

                    shapeArr = new String[arrLen];

                    for(i = 0; i < arrLen - 1; ++i) {
                        shapeArr[i] = temp[i];
                    }

                    switch(input) {
                        case 1:
                            shapeArr[arrLen - 1] = "Line";
                            break label69;
                        case 2:
                            shapeArr[arrLen - 1] = "Rect";
                            break label69;
                        case 3:
                            shapeArr[arrLen - 1] = "Circle";
                            break label69;
                        default:
                            System.out.println("알 수 없는 입력입니다.");
                            break label69;
                    }
                case 2:
                    System.out.print("삭제할 도형의 위치 >> ");
                    input = sc.nextInt();
                    if (shapeArr[input - 1].equals((Object)null)) {
                        System.out.println("삭제할 수 없습니다.");
                        break;
                    }

                    shapeArr[input - 1] = null;

                    label66:
                    for(i = 0; i < shapeArr.length - 1; ++i) {
                        if (shapeArr[i] == null) {
                            int j = i;

                            while(true) {
                                if (j >= shapeArr.length - 1) {
                                    break label66;
                                }

                                if (j + 1 == shapeArr.length) {
                                    System.out.println("break");
                                    break label66;
                                }

                                shapeArr[j] = shapeArr[j + 1];
                                ++j;
                            }
                        }
                    }

                    --arrLen;
                    break;
                case 3:
                    i = 0;

                    while(true) {
                        if (i >= shapeArr.length) {
                            break label69;
                        }

                        System.out.println(shapeArr[i]);
                        ++i;
                    }
                case 4:
                    System.out.println("beauty를 종료합니다.");
                    break;
                default:
                    System.out.println("알 수 없는 입력입니다.");
            }

            temp = new String[shapeArr.length];

            for(i = 0; i < shapeArr.length; ++i) {
                temp[i] = shapeArr[i];
            }

            shapeArr = new String[arrLen];

            for(i = 0; i < arrLen; ++i) {
                shapeArr[i] = temp[i];
            }
        } while(input != 4);

    }
}
