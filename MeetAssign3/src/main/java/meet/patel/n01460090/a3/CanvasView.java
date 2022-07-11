// Meet Patel N01460090 Section:- RNB

package meet.patel.n01460090.a3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class CanvasView extends View {

    private static final float TOLERANCE = 5;
    public int width;
    public int height;
    Context context;
    private Bitmap mBitmap;
    private Canvas mCanvas;
    private Path mPath;
    private Paint mPaint;
    private float mX, mY;

    public CanvasView(Context c, AttributeSet attrs) {
        super(c, attrs);
        context = c;

        // we set a new Path
        mPath = new Path();

        // and we set a new Paint with the desired attributes
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(10f);
    }

    // override onSizeChanged
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        // your Canvas will draw onto the defined Bitmap
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
    }

    // override onDraw
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Code for the Bitmap Picture and Thumbnail
        Bitmap CodePicture = BitmapFactory.decodeResource(getResources(), R.drawable.imgthumbnail);

        Bitmap CodePic= Bitmap.createScaledBitmap(CodePicture, 1000, 1400, false);
        canvas.drawBitmap(CodePic, 60, 75, null);

        Bitmap CodePic2= Bitmap.createScaledBitmap(CodePic, 50, 75, false);

        Matrix maxTopLeft = new Matrix();
        maxTopLeft.preRotate(60);

        Matrix maxTopRight = new Matrix();
        maxTopRight.preRotate(-30);
        maxTopRight.preScale(-1, 1);

        Bitmap CodePicTopLeft = Bitmap.createBitmap(CodePic2, 0, 0, CodePic2.getWidth(), CodePic2.getHeight(), maxTopLeft, false);

        Bitmap CodePicTopRight = Bitmap.createBitmap(CodePic2, 0, 0, CodePic2.getWidth(), CodePic2.getHeight(), maxTopRight, false);


        CodePic2.recycle();
        CodePic.recycle();

        canvas.drawBitmap(CodePicTopLeft, 30, 30, null);
        canvas.drawBitmap(CodePicTopRight, 1025, 30, null);


        // draw the mPath with the mPaint on the canvas when onDraw
        canvas.drawPath(mPath, mPaint);

    }

    // when ACTION_DOWN start touch according to the x,y values
    private void startTouch(float x, float y) {
        mPath.moveTo(x, y);
        mX = x;
        mY = y;
    }

    // when ACTION_MOVE move touch according to the x,y values
    private void moveTouch(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);
        if (dx >= TOLERANCE || dy >= TOLERANCE) {
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
            mX = x;
            mY = y;
        }
    }


    // when ACTION_UP stop touch
    private void upTouch() {
        mPath.lineTo(mX, mY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                moveTouch(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP:
                upTouch();
                invalidate();
                break;
        }
        return true;
    }

    public void resetDrawing() {
        mPath.reset();
        invalidate();
    }

    public void setStrokeWidth(float width) {
        mPaint.setStrokeWidth(width);
    }

    public void setStrokeColor(String color) {
        mPaint.setColor(Color.parseColor(color));
    }
}