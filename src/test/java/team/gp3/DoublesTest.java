package team.gp3;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class DoublesTest {

    @Test
    @FileParameters(
            value = "file:\\Users\\vaccu\\IdeaProjects\\gradle-simple\\src\\test\\java\\team\\gp3\\doubles.csv",
            mapper = CsvWithHeaderMapper.class)
    public void test(
            String Shape,
            String Size,
            String Even,
            String p1,
            String p2,
            String p3,
            String p4,
            String Result
    ) {
        String input = String.format("%s,%s,%s,%s%s%s%s", Shape, Size, Even, p1, parseParam(p2), parseParam(p3), parseParam(p4));
//        sbTestResults.append(input).append(", ").append(Result);
        ShapeClassifier sc = new ShapeClassifier();
//        sc.evaluateGuess(input);
//        assertEquals(true,true);
        assertEquals(Result, sc.evaluateGuess(input));
    }

    private String parseParam(String value) {
        return !value.equals("0") ? "," + value : "";
    }

//    private static StringBuffer sbTestResults = new StringBuffer();

//    @AfterClass
//    public static void exportCsvResult() throws IOException {
//        BufferedWriter resultWriter = Files.newBufferedWriter(
//                Paths.get("C:\\Users\\vaccu\\workspace\\Gp3\\src-gen\\triples_Results.csv"),
//                Charset.defaultCharset());
//        resultWriter.write("Shape, Size, Even, p1, p2, p3, p4, TestResult");
//        resultWriter.newLine();
//        resultWriter.write(sbTestResults.toString());
//        resultWriter.close();
//    }
//
//    @ClassRule
//    public static TestWatcher addCsvResult = new TestWatcher() {
//        @Override
//        protected void succeeded(Description description) {
//            sbTestResults.append(", Passed")
//                    .append(System.getProperty("line.separator"));
//        }
//
//        @Override
//        protected void failed(Throwable e, Description description) {
//            sbTestResults.append(", Failed")
//                    .append(System.getProperty("line.separator"));
//        }
//    };


}