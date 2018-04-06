package com.example.vladislav.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class DiagramView extends View {
    private int expense;
    private int income;
    private int balance;

    private Paint paintExpense = new Paint();
    private Paint paintIncome = new Paint();

    public DiagramView(Context context) {
        this(context,null);
    }

    public DiagramView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public DiagramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paintExpense.setColor(getResources().getColor(R.color.colorBalanceExpense));
        paintIncome.setColor(getResources().getColor(R.color.colorBalanceIncome));

        if (isInEditMode()){
            expense = 12000;
            income = 60000;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (Build.VERSION_CODES.LOLLIPOP <= Build.VERSION.SDK_INT){
            drawPieDiagram(canvas);
        }
        else drawRectDiagram(canvas);

    }

    public void updateDiagram(int expense, int income){
        this.expense = expense;
        this.income = income;
        invalidate();
    }

    public void drawRectDiagram(Canvas canvas){
        if (expense + income == 0) return;
        long max = Math.max(expense, income);
        long expensesHeight = canvas.getHeight() * expense / max;
        long incomeHeight = canvas.getHeight() * income / max;
        int w = getWidth() / 4;
        canvas.drawRect(w / 2, canvas.getHeight() - expensesHeight, w * 3 / 2, canvas.getHeight(), paintExpense);
        canvas.drawRect(5 * w / 2, canvas.getHeight() - incomeHeight, w * 7 / 2, canvas.getHeight(), paintIncome);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawPieDiagram(Canvas canvas){
        float expenseAngle = 360.f * expense / (expense + income);
        float incomeAngle = 360.f * income / (expense + income);
        int space = 10; // space between income and expense
        int size = Math.min(getWidth(), getHeight()) - space * 2;
        final int xMargin = (getWidth() - size) / 2, yMargin = (getHeight() - size) / 2;
        canvas.drawArc(xMargin - space, yMargin, getWidth() - xMargin - space, getHeight() - yMargin, 180 - expenseAngle / 2, expenseAngle, true, paintExpense);
        canvas.drawArc(xMargin + space, yMargin, getWidth() - xMargin + space, getHeight() - yMargin, 360 - incomeAngle / 2, incomeAngle, true, paintIncome);

    }
}
