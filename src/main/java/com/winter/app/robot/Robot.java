package com.winter.app.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//객체 생성 @COntroller, @Service @Repository @Component Spring pool
@Component // new Robot();
public class Robot {

	@Autowired // setRightArm(rightArm)
	@Qualifier("ra")
	private Arm rightArm;

	@Autowired
	@Qualifier("la")
	private Arm leftArm;

	public Arm getRa() {
		return ra;
	}

	public void setRa(Arm ra) {
		this.ra = ra;
	}

	public Arm getLa() {
		return la;
	}

	public void setLa(Arm la) {
		this.la = la;
	}

}
