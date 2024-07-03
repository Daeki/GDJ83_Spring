package com.winter.app.robot;

//객체 생성 @Controller, @Service @Repository @Component Spring pool
//@Component // new Robot();
public class Robot {

	private String company;

	private int age;
	// @Autowired // setRightArm(rightArm)
	// @Qualifier("ra")
	private Arm rightArm;

	// @Autowired
	// @Qualifier("la")
	private Arm leftArm;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Arm getRightArm() {
		return rightArm;
	}

	public void setRightArm(Arm rightArm) {
		this.rightArm = rightArm;
	}

	public Arm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(Arm leftArm) {
		this.leftArm = leftArm;
	}

}
