package tests.day09;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;

public class Day09_FileExistTest extends TestBase {

    @Test
    public void isExistTest(){

        String userDIR = System.getProperty("user.dir");
        System.out.println(userDIR);
        String userHOME = System.getProperty("user.home");
        System.out.println(userHOME);


        //Pick a file on your desktop
        //And verify if that file exists on your computer or not
        //String pathOfFile = userHOME + "/Desktop/logo.jpeg"; //WRITING THE PATH DYNAMICALLY SO THIS PATH CAN WORK ON OTHER COMPUTERS
        String pathOfFile = userHOME + "\\OneDrive\\Desktop\\logo.jpeg"; //WINDOWS
        boolean isExist = Files.exists(Paths.get(pathOfFile));//returns TRUE if the file exists. FALSE if file does not exist
        Assert.assertTrue(isExist);
    }
}
