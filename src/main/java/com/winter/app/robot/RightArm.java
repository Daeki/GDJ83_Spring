package com.winter.app.robot;

import org.springframework.stereotype.Component;

@Component("ra")
public class RightArm implements Arm {

	public void info() {
		System.out.println("오른팔 입니다.");
	}

}
