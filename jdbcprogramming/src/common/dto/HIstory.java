package common.dto;

import java.util.Date;

import lombok.Data;

@Data
public class HIstory {
	private int employeeId;
	private Date startDate;
	private Date endDate;
	private String jobId;
	private int departmentId;
}
