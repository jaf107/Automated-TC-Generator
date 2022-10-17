package driver;

import case_generator.CaseGenerator;
import class_analyzer.MethodFinder;
import code_reader.CodeReader;
import projectOfDataClass.Statement;

import java.util.ArrayList;

public class TestCaseDriver {
    public static void main(String[] args) {
        CodeReader codeReader = new CodeReader();
        ArrayList<Statement> lines = codeReader.readCode("Codes/test.java");
        MethodFinder finder = new MethodFinder();
        ArrayList<ArrayList<Statement>> allMethods = finder.findMethods(lines);

        for (ArrayList<Statement> allMethod : allMethods) {
            CaseGenerator caseGenerator = new CaseGenerator(allMethod);
            caseGenerator.generateCases();
            caseGenerator.printTestCases();

            System.out.println();
        }
    }
}
