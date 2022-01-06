package exercise;

public enum RoleEnum {
    SANITATION_WORKER(300000),
    RECEPTIONIST(350000),
    ACCOUNTANT(500000),
    ENGINEER(800000),
    DIRECTOR(1500000);

    int salary;

    RoleEnum(int salary) {
	this.salary = salary;
    }

    public static RoleEnum getRole(String role) {
	for (RoleEnum value : RoleEnum.values()) {
	    if (value.name().equals(role)) {
		return value;
	    }
	}
	return null;
    }
}
