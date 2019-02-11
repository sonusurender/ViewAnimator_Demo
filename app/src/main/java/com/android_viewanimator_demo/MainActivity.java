package com.android_viewanimator_demo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ViewAnimator;

public class MainActivity extends ActionBarActivity implements OnClickListener {
	private static Button btnNext, btnPrevious, my_button;
	private static ViewAnimator viewAnimator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
		setListeners();
	}

	
	void init() {
		viewAnimator = (ViewAnimator) findViewById(R.id.viewAnimator);
		btnNext = (Button) findViewById(R.id.buttonNext);
		btnPrevious = (Button) findViewById(R.id.buttonPrevious);
		my_button = (Button) findViewById(R.id.button);

		//Load animations for in and out for viewanimator
		final Animation inAnim = AnimationUtils.loadAnimation(this,
				android.R.anim.slide_in_left);
		final Animation outAnim = AnimationUtils.loadAnimation(this,
				android.R.anim.slide_out_right);

		viewAnimator.setInAnimation(inAnim);
		viewAnimator.setOutAnimation(outAnim);

	}

	
	//Setting listeners to buttons and viewanimator
	void setListeners() {
		btnNext.setOnClickListener(this);
		btnPrevious.setOnClickListener(this);
		viewAnimator.setOnClickListener(this);

		my_button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonNext:
			
			//Show next view
			viewAnimator.showNext();
			break;

		case R.id.buttonPrevious:
			
			//Show Previous view
			viewAnimator.showPrevious();
			break;
		case R.id.viewAnimator:
			viewAnimator.showNext();
			break;
		case R.id.button:
			
			//Show toast on button click
			Toast.makeText(MainActivity.this, "My button Pressed",
					Toast.LENGTH_SHORT).show();
			break;
		}

	}
}
