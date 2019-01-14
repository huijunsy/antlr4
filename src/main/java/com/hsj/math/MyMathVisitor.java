package com.hsj.math;

import java.util.HashMap;
import java.util.Map;

public class MyMathVisitor extends MathBaseVisitor<Integer>{

    Map<String, Integer> memory = new HashMap<String, Integer>();

    @Override
    public Integer visitPrintExpr(MathParser.PrintExprContext ctx) {
        // TODO Auto-generatedmethod stub
        Integer value = visit(ctx.expr()); // evaluate the exprchild
        System.out.println(value); // print theresult
        return 0; // return dummyvalue
    }

    @Override
    public Integer visitAssign(MathParser.AssignContext ctx) {
        // TODO Auto-generatedmethod stub
        String id = ctx.ID().getText(); // id is left-hand side of '='
        int value = visit(ctx.expr()); // compute valueof expression on right
        memory.put(id, value); // store it inour memory
        return value;
    }

    @Override
    public Integer visitBlank(MathParser.BlankContext ctx) {
        // TODO Auto-generatedmethod stub
        return super.visitBlank(ctx);
    }

    @Override
    public Integer visitParens(MathParser.ParensContext ctx) {
        // TODO Auto-generatedmethod stub
        return visit(ctx.expr()); // return childexpr's value
    }

    @Override
    public Integer visitMulDiv(MathParser.MulDivContext ctx) {
        // TODO Auto-generatedmethod stub
        int left = visit(ctx.expr(0)); // get value ofleft subexpression
        int right = visit(ctx.expr(1)); // get value ofright subexpression
        if ( ctx.op.getType() == MathParser.MUL ) return left * right;
        return left / right; // must be DIV
    }

    @Override
    public Integer visitAddSub(MathParser.AddSubContext ctx) {
        // TODO Auto-generatedmethod stub
        int left = visit(ctx.expr(0)); // get value ofleft subexpression
        int right = visit(ctx.expr(1)); // get value ofright subexpression
        if ( ctx.op.getType() == MathParser.ADD ) return left + right;
        return left - right; // must be SUB
    }

    @Override
    public Integer visitId(MathParser.IdContext ctx) {
        // TODO Auto-generatedmethod stub
        String id = ctx.ID().getText();
        if ( memory.containsKey(id) ) return memory.get(id);
        return 0;
    }

    @Override
    public Integer visitInt(MathParser.IntContext ctx) {
        // TODO Auto-generatedmethod stub
        return Integer.valueOf(ctx.INT().getText());
    }
}
