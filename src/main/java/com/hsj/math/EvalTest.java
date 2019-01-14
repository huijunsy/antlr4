package com.hsj.math;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;

public class EvalTest {
    public static void main(String[] args) throws Exception {
        // create a CharStream thatreads from standard input
        String inputFile = "E:\\dev_WorkSpace\\git_workspace\\antlr4\\src\\main\\java\\com\\hsj\\math\\data.txt";
        InputStream is = System.in;

        if ( inputFile!=null ) is = new FileInputStream(inputFile);
        ANTLRInputStream input = new ANTLRInputStream(is);

        MathLexer lexer = new MathLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MathParser parser = new MathParser(tokens);
        ParseTree tree = parser.prog(); // parse
        MyMathVisitor eval = new MyMathVisitor();
        eval.visit(tree);
    }

}
