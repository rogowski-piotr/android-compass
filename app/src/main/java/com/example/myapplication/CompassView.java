package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class CompassView extends View {
    private Context context;
    private int rotation = 0;

    public CompassView(Context context) {
        super(context);
        this.context = context;
    }

    public CompassView(Context context, AttributeSet attribs) {
        super(context, attribs);
    }

//    @Override
//    public void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        Paint red_paint = new Paint();
//        red_paint.setARGB(255, 255,0,0);
//        red_paint.setStrokeWidth(5);
//
//        Paint blue_paint = new Paint();
//        blue_paint.setARGB(255, 0,0,255);
//        blue_paint.setStrokeWidth(5);
//
//        canvas.save();
//        canvas.rotate(rotation, (int) (getWidth() / 2), (int) getHeight() / 2);
//
//        Path red_triangle_path = new Path();
//        red_triangle_path.setFillType(Path.FillType.EVEN_ODD);
//        red_triangle_path.moveTo(getWidth() / 2, 0);
//        red_triangle_path.lineTo(getWidth() /  16 * 7 , getHeight() / 2);
//        red_triangle_path.lineTo(getWidth() / 16 * 9, getHeight() / 2);
//        red_triangle_path.close();
//        canvas.drawPath(red_triangle_path, red_paint);
//
//        Path blue_triangle_path = new Path();
//        blue_triangle_path.setFillType(Path.FillType.EVEN_ODD);
//        blue_triangle_path.moveTo(getWidth() / 16 * 7, getHeight());
//        blue_triangle_path.lineTo(getWidth() /16 * 9, getHeight());
//        blue_triangle_path.lineTo(getWidth() / 16 * 9 , getHeight() / 2);
//        blue_triangle_path.lineTo(getWidth() /  16 * 7, getHeight() / 2);
//        blue_triangle_path.close();
//        canvas.drawPath(blue_triangle_path, blue_paint);
//
//        canvas.restore();
//    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint red_paint = new Paint();
        red_paint.setARGB(255, 255,0,0);
        red_paint.setStrokeWidth(5);

        Paint blue_paint = new Paint();
        blue_paint.setARGB(255, 0,0,255);
        blue_paint.setStrokeWidth(5);

        canvas.save();
        canvas.rotate(rotation, (int) (getWidth() / 2), (int) getHeight() / 2);

        Path red_triangle_path = new Path();
        red_triangle_path.setFillType(Path.FillType.EVEN_ODD);
        red_triangle_path.moveTo(getWidth() / 2, 0);
        red_triangle_path.lineTo(getWidth() /  8 * 5 , getHeight() / 2);
        red_triangle_path.lineTo(getWidth() / 8 * 3, getHeight() / 2);
        red_triangle_path.close();
        canvas.drawPath(red_triangle_path, red_paint);

        Path blue_triangle_path = new Path();
        blue_triangle_path.setFillType(Path.FillType.EVEN_ODD);
        blue_triangle_path.moveTo(getWidth() / 2, getHeight());
        blue_triangle_path.lineTo(getWidth() /  8 * 5 , getHeight() / 2);
        blue_triangle_path.lineTo(getWidth() / 8 * 3, getHeight() / 2);
        blue_triangle_path.close();
        canvas.drawPath(blue_triangle_path, blue_paint);

        canvas.restore();
    }

    public void updateRotation(float rotation) {
        this.rotation = (int) rotation;
    }

}
