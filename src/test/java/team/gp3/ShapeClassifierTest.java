package team.gp3;

import org.junit.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeClassifierTest {

    @Rule //https://stackoverflow.com/questions/6141252/dealing-with-system-exit0-in-junit-tests
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private static Logger logger = LoggerFactory.getLogger(ShapeClassifierTest.class);
    String inputArray[]= {
            "Equilateral,Large,Yes,100,100,100",    //1



            "Equilateral,Large,Yes,100,100,100,4,5",    //13

            "Line,Large,Yes,300",    //2
            "Circle,Large,Yes,300,500",    //2,5
            "Square,Large,Yes,500,500,300,300",    //4
            "Equilateral,Large,Yes,100,200,100",    //5
            "Equilateral,Small,Yes,20,20,20",    //6
            "Circle,Large,Yes,500,500",    //3
            "Circle,Large,Yes,300",    //8
            "Ellipse,Large,Yes,300,500",    //9
            "Square,Large,Yes,100,500,100,500",    //10
            "Equilateral,Small,Yes,2,2,2",    //11
            "Equilateral,Large,No,99,99,99",    //7
            "Square,Large,Yes,401,401,401,401"

    };

    String answerArray[]= {
            "Yes",    //1



            "No",    //13

            "Yes",    //2
            "No",    //2,5
            "No",    //4
            "No",    //5
            "Yes",    //6
            "Yes",    //
            "No",    //8
            "Yes",    //9
            "No",    //10
            "Yes",    //11
            "Yes",    //7
            "No"

    };


    @BeforeClass
    public static void beforeTest (){
//        logger.info("this is @BeforeClass method");

    }

    @Before
    public void before(){
//        logger.info("this is @Before method");
    }



    @org.junit.Test
    public void singleInputTest  (){
//        exit.expectSystemExit(); // here should be all OK

        ShapeClassifier shapeClassifier;
        boolean Ok=true;
        int failedTests = 0;
        int passedTests =0;
        for(int i=0;i<inputArray.length;i++) {
            shapeClassifier = new ShapeClassifier(); // to have new classfiier
            String input = inputArray[i];
            String answer = shapeClassifier.evaluateGuess(input);
            logger.info("test "+(i+1)+" input= " + input + "  real/expected answer= " + answer+ "/"+
                    answerArray[i]+ (answerArray[i].equals(answer) ? "" : "   test failed!"));
            if (answerArray[i].equals(answer)){
                passedTests++;
            } else {
                failedTests++;
                Ok=false;
            }
        }
        logger.info("tests passed = "+passedTests+" tests failed = "+failedTests);
        Assert.assertTrue("Every test should be passed", Ok);
    }

    @org.junit.Test
    public void tripleWrongInputTest  (){
        //the code under test, which calls System.exit(0)
        Assert.assertTrue("Every test should be passed", true);

        logger.info("tripleWrongInputTest Starts ");
        String wrongInput="Equilateral,Large,Yes,100,200,100";
        ShapeClassifier shapeClassifier=new ShapeClassifier();
        String answer=null;
        for(int i=0;i<2;i++) {
            answer = shapeClassifier.evaluateGuess(wrongInput);
            logger.info("test "+(i+1)+" input= " + wrongInput + "answwer = " +answer);
        }

        exit.expectSystemExitWithStatus(1);
        answer = shapeClassifier.evaluateGuess(wrongInput);
        Assert.assertTrue("Every test should be passed", true);
    }



    @After
    public void after(){
//        logger.info("this is @After method");
    }
    @AfterClass
    public static void afterClass(){
//        logger.info("this is @AfterClass method");

    }


}
