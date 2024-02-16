public class Main {
    public static void main(String[] args) throws InterruptedException {
        Reader reader = new Reader();
        String str1 = "Don't give up this opportunity, Do your best first!";
        String star = "*".repeat(str1.length());
        String underscore = "_".repeat(str1.length());
        String download = "Downloading";
        String points = ".".repeat(download.length());
        Runnable[] runnables = {
                () -> {
                    reader.printWord("WELCOME TO CSTAD!");
                    System.out.println();
                },
                () -> {
                    reader.printWord(star);
                    System.out.println();

                },
                () -> {
                    reader.printWord(str1);
                    System.out.println();

                },
                () -> {
                    reader.printWord(underscore);
                    System.out.println();

                },
                () -> {
                    System.out.print(download);
                    reader.printWord(points);
                    System.out.print("Download Completed   100%");
                }
        };
        // Create and start threads
        for (Runnable r : runnables) {
            Thread t = new Thread(r);
            t.start();
            t.join(); // Wait for the thread to finish before starting the next one
        }
    }
}
class Reader {
    public void printWord(String word) {
        for (int i =  0; i < word.length(); i++) {
            System.out.print(word.charAt(i));
            try {
                Thread.sleep(100); // Pause for  1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            }
        }
    }
}
