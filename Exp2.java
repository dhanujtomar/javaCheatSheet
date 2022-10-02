import java.util.*;

class Video {
    String title;
    boolean Flag = false;
    int avg = 0;
}

class VideoStore {
    private static final Scanner input = new Scanner(System.in);
    String chek2;
    Video beat[] = new Video[10];
    int num_video;

    void addVideo() {
        System.out.println("Enter " + num_video + " Video Title:- ");
        for (int i = 0; i < num_video; i++) {
            beat[i] = new Video();
            beat[i].title = input.nextLine();
        }
        System.out.println("Enter " + num_video + " Video rating between 1 to 5:- ");
        for (int i = 0; i < num_video; i++) {
            beat[i].avg = input.nextInt();
        }
    }

    int chekOut(int k) {
        String chek1;
        System.out.println("chekout " + (k + 1));
        chek1 = input.next();
        for (int i = 0; i < num_video; i++) {
            if (beat[i].title.equals(chek1) && (beat[i].Flag == false)) {
                beat[i].Flag = true;
                return -1;
            } else if (beat[i].title.equals(chek1) && (beat[i].Flag == true)) {
                System.out.println("Failed to chekout: ");
                return -1;
            }
        }
        return 1;
    }
}