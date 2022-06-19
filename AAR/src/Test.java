import java.io.File;
import java.io.FileReader;
import java.util.Random;

public class Test {
    static String dic = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWWXYZ0123456789";
    public static void main(String[] args) {
        Test test = new Test();
        File fileDir = new File("B:\\FreeTool\\图片\\新建文件夹");
        String[] fileList = fileDir.list();

        for (int i = 0; i < fileList.length; i++) {
            String newName = "";
            for (int j = 0; j < 3; j++) {
                int random = (int) (Math.random()*(dic.length()));
                char c = dic.charAt(random);
                newName += c;
            }
//            System.out.println(newName);
            File src = new File("B:\\FreeTool\\图片\\新建文件夹",fileList[i]);
            File des = new File("B:\\FreeTool\\图片\\新建文件夹",newName+".jpg");
            src.renameTo(des);
        }
    }
}
