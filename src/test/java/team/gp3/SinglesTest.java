package team.gp3;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class SinglesTest {

    @Test
    @FileParameters(
            value = "file:\\Users\\vaccu\\IdeaProjects\\gradle-simple\\src\\test\\java\\team\\gp3\\singles.csv",
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
        ShapeClassifier sc = new ShapeClassifier();
        assertEquals(Result, sc.evaluateGuess(input));
    }

    private String parseParam(String value) {
        return !value.equals("0") ? "," + value : "";
    }

}