/*
package com.hsj;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import com.zetyun.aiops.core.math.MathLexer;
import com.zetyun.aiops.core.math.MathParser;

public class Test {


    public static void main(String[] args) {


        CharStream input = CharStreams.fromString("12*2+12\r\n");
        MathLexer lexer=new MathLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MathParser parser = new MathParser(tokens);
        ParseTree tree = parser.prog(); // parse
        MathVisitorTest vt=new MathVisitorTest();
        vt.visit(tree);

    }


}*/
