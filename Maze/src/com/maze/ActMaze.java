package com.maze;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActMaze extends Activity{
    LinearLayout playScr = null;
    TextView square = null;
    TextView rod = null;

    View tile[][] = new View[10][10];
	LinearLayout playLine[] = new LinearLayout[10];
	
    public void initialTile() {
        for(int i = 0; i < tile.length; i++) {
            for (int j = 0; j < tile[i].length; j++) {
                tile[i][j] = new View(this);
                tile[i][j].setBackgroundColor(Color.BLACK);
            }
        }

        tile[0][0].setBackgroundColor(Color.WHITE);
        tile[1][0].setBackgroundColor(Color.WHITE);
        tile[2][0].setBackgroundColor(Color.WHITE);
        tile[3][0].setBackgroundColor(Color.WHITE);


    }

    View user = null;
    int tenWidth, tenHeight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tetris_main);

        initialTile();
        playScr = (LinearLayout) findViewById(R.id.playscreen);

        playScr.post(new Runnable() {
            @Override
            public void run() {
                // tenWidth = (int) (playScr.getWidth() / 10);
                // tenHeight = (int) (playScr.getHeight() / 10);
            	tenWidth = 10;
            	tenHeight = 10;
				
				
                for (int i = 0; i < tile.length; i++) {
                	LinearLayout.LayoutParams lineParam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0);
                	lineParam.weight = 0.1f;
                	
                	LinearLayout nowLine = new LinearLayout(ActMaze.this);
                	playLine[i] = nowLine; 
                	nowLine.setLayoutParams(lineParam);
                	
                    for (int j = 0; j < tile[i].length; j++) {
                        View nowTile = tile[i][j];
                        
	                    LinearLayout.LayoutParams tileParam = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT);
	                    tileParam.weight = 0.1f;
	                    nowTile.setLayoutParams(tileParam);
	                    nowLine.addView(nowTile);
                    }
                    
                    playScr.addView(nowLine);
                }

            }
        });

        user = new View(this);
        user.setBackgroundColor(Color.GREEN);

        // FrameLayout.LayoutParams flParam = new FrameLayout.LayoutParams(tenWidth, tenHeight);


    }


}
