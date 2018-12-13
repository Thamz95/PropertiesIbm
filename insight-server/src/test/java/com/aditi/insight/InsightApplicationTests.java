package com.aditi.insight;

import static org.junit.Assert.assertNotNull;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.aditi.insight.service.BIDataService;
import com.aditi.insight.service.DBUpdatingService;
import com.aditi.insight.utils.DateUtils;
import com.aditi.insight.utils.ExcelWriter;
import com.aditi.insight.utils.StringUtils;
import com.jobdiva.bi.GetBIDataResponse;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class InsightApplicationTests {

	private static final Integer DAYS_TO_GO_BACK = 1;

	@Autowired
	private BIDataService biDataService;
	
	@Autowired
	private DBUpdatingService dbUpdateService;

	@Test
	public void newPositionsCountTest() throws Exception {
		String metric = "New Positions Count";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newPositionsCount(from, to);

		System.out.println("*****************************newPositionsCount**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");
		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newPositionsCountByDivisionTest() throws Exception {
		String metric = "New Positions Count By Division";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newPositionsCountByDivision(from, to);

		System.out
				.println("*****************************newPositionsCountByDivision**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");
		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newPositionsCountByPrimarySales() throws Exception {
		String metric = "New Positions Count by Primary Sales";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());

		GetBIDataResponse dataResponse = biDataService.newPositionsCountByPrimarySales(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************newPositionsCountByPrimarySales**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");
		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void hiresCountByDivisionTest() throws Exception {
		String metric = "Hires Count by Division";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.hiresCountByDivision(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************hiresCountByDivision**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void hiresCountByPrimarySalesTest() throws Exception {
		String metric = "Hires Count by Primary Sales";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.hiresCountByPrimarySales(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************hiresCountByPrimarySales**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");
		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void openPositionCountTest() throws Exception {
		String metric = "Open Positions Count ";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.openPositionCount(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************openPositionCount**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");
		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void openPositionCountByDivisionTest() throws Exception {
		String metric = "Open Positions Count by Division";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.openPositionCountByDivision(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out
				.println("*****************************openPositionCountByDivision**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");
		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void openPositionsCountByPrimarySalesTest() throws Exception {
		String metric = "Open Positions Count by Primary Sales";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.openPositionsCountByPrimarySales(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************openPositionsCountByPrimarySales**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");
		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void openPositionsCountbyJobTypeTest() throws Exception {
		String metric = "Open Positions Count by Job Type";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.openPositionsCountbyJobType(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out
				.println("*****************************openPositionsCountbyJobType**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");
		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void filledPositionsCountTest() throws Exception {
		String metric = "Filled Positions Count";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.filledPositionsCount(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************filledPositionsCount**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void filledPositionsCountbyDivisionTest() throws Exception {
		String metric = "Filled Positions Count by Division";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.filledPositionsCountbyDivision(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************filledPositionsCountbyDivision**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void filledPositionsCountbyPrimarySalesTest() throws Exception {
		String metric = "Filled Positions Count by Primary Sales";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.filledPositionsCountbyPrimarySales(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************filledPositionsCountbyPrimarySales**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void submittalInterviewActivitiesCountbyDivisionTest() throws Exception {
		String metric = "Submittal Interview Activities Count by Division";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.submittalInterviewActivitiesCountbyDivision(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************submittalInterviewActivitiesCountbyDivision**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void submittalInterviewActivitiesCountbyPrimarySalesTest() throws Exception {
		String metric = "Submittal Interview Activities Count by Primary Sales";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.submittalInterviewActivitiesCountbyPrimarySales(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************submittalInterviewActivitiesCountbyPrimarySales**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void submittalInterviewActivitiesCountbyRecruiterTest() throws Exception {
		String metric = "Submittal Interview Activities Count by Recruiter";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.submittalInterviewActivitiesCountbyRecruiter(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************submittalInterviewActivitiesCountbyRecruiter**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void agingofPositionsCountbyDivisionTest() throws Exception {
		String metric = "Aging of Positions Count by Division (# of jobs still open and issued during a period)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.agingPositionsCountbyDivision(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************agingofPositionsCountbyDivision**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void agingofPositionsCountbyPrimarySalesTest() throws Exception {
		String metric = "Aging of Positions Count by Primary Sales";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.agingPositionsCountbyPrimarySales(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************agingofPositionsCountbyPrimarySales**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void endedAssignmentsCountbyDivisionTest() throws Exception {
		String metric = "Ended Assignments Count by Division";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.endedAssignmentsCountbyDivision(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************endedAssignmentsCountbyDivision**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void endedAssignmentsCountbyPrimarySalesTest() throws Exception {
		String metric = "Ended Assignments Count by Primary Sales";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.endedAssignmentsCountbyPrimarySales(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************endedAssignmentsCountbyPrimarySales**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void incomingResumesCountTest() throws Exception {
		String metric = "Incoming Resumes Count";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.incomingResumesCount(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************incomingResumesCount**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void issuedJobsListTest() throws Exception {
		String metric = "Issued Jobs List";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.issuedJobsList(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************issuedJobsList**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void updatedJobsListTest() throws Exception {
		String metric = "Updated Jobs List";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.updatedJobsList(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************updatedJobsList**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void jobsDashboardbyUserTest() throws Exception {
		String metric = "Jobs Dashboard by User";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.jobsDashboardbyUser(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************jobsDashboardbyUser**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void openJobsListbyCompanyTest() throws Exception {
		String metric = "Open Jobs List by Company (requires companyid as parameter)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.openJobsListbyCompany(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************openJobsListbyCompany**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void submittalInterviewHireActivitiesListTest() throws Exception {
		String metric = "Submittal Interview Hire Activities List";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.submittalInterviewHireActivitiesList(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************submittalInterviewHireActivitiesList**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateActionsTest() throws Exception {
		String metric = "Candidate Actions";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateActions(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************candidateActions**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void contactActionsTest() throws Exception {
		String metric = "Contact Actions";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.contactActions(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************contactActions**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void usersListTest() throws Exception {
		String metric = "Users List";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService
				.usersList(Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************usersList**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void divisionsListTest() throws Exception {
		String metric = "Divisions List";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.divisionsList(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************divisionsList**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void vMSUsersListTest() throws Exception {
		String metric = "VMS Users List";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.vMSUsersList(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************vMSUsersList**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void rejectionReasonsListTest() throws Exception {
		String metric = "Rejection Reasons List";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.rejectionReasonsList(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************rejectionReasonsList**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void userGroupListsTest() throws Exception {
		String metric = "User Group Lists";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.userGroupLists(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************userGroupLists**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newHiresTest() throws Exception {
		String metric = "New Hires";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService
				.newHires(Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newHires**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void updateHiresTest() throws Exception {
		String metric = "Update Hires";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.updateHires(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************updateHires**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void accessLogTest() throws Exception {
		String metric = "Access Log";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService
				.accessLog(Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************accessLog**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedCompanyRecordsTest() throws Exception {
		String metric = "New Updated Company Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedCompanyRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newUpdatedCompanyRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedCompanyNoteRecordsTest() throws Exception {
		String metric = "New Updated Company Note Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedCompanyNoteRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out
				.println("*****************************newUpdatedCompanyNoteRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdateContactRecordsTest() throws Exception {
		String metric = "New Update Contact Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdateContactRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newUpdateContactRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedContactNoteRecordsTest() throws Exception {
		String metric = "New Updated Contact Note Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedContactNoteRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out
				.println("*****************************newUpdatedContactNoteRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedJobRecordsTest() throws Exception {
		String metric = "New Updated Job Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedJobRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newUpdatedJobRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedCandidateRecordsTest() throws Exception {
		String metric = "New Updated Candidate Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedCandidateRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newUpdatedCandidateRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedEmployeeRecordsTest() throws Exception {
		String metric = "New Updated Employee Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedEmployeeRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newUpdatedEmployeeRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedActivityRecordsTest() throws Exception {
		String metric = "New Updated Activity Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedActivityRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newUpdatedActivityRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedCandidateNoteRecordsTest() throws Exception {
		String metric = "New Updated Candidate Note Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedCandidateNoteRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************newUpdatedCandidateNoteRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedTaskRecordsTest() throws Exception {
		String metric = "New Updated Task Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedTaskRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newUpdatedTaskRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newUpdatedEventRecordsTest() throws Exception {
		String metric = "New Updated Event Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newUpdatedEventRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newUpdatedEventRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateApplicationRecordsTest() throws Exception {
		String metric = "Candidate Application Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateApplicationRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out
				.println("*****************************candidateApplicationRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void deletedCandidateNoteRecordsTest() throws Exception {
		String metric = "Deleted Candidate Note Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.deletedCandidateNoteRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out
				.println("*****************************deletedCandidateNoteRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void deletedEmployeeRecordsTest() throws Exception {
		String metric = "Deleted Employee Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.deletedEmployeeRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************deletedEmployeeRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void deletedActivityRecordsTest() throws Exception {
		String metric = "Deleted Activity Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.deletedActivityRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************deletedActivityRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void deletedCompanyRecordsTest() throws Exception {
		String metric = "Deleted Company Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.deletedCompanyRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************deletedCompanyRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void deletedContactRecordsTest() throws Exception {
		String metric = "Deleted Contact Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.deletedContactRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************deletedContactRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void deletedContactNoteRecordsTest() throws Exception {
		String metric = "Deleted Contact Note Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.deletedContactNoteRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************deletedContactNoteRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void deletedJobRecordsTest() throws Exception {
		String metric = "Deleted Job Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.deletedJobRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************deletedJobRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void deletedCandidateRecordsTest() throws Exception {
		String metric = "Deleted Candidate Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.deletedCandidateRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************deletedCandidateRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void deletedTaskRecordsTest() throws Exception {
		String metric = "Deleted Task Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.deletedTaskRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************deletedTaskRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void mergedCompaniesTest() throws Exception {
		String metric = "Merged Companies";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.mergedCompanies(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************mergedCompanies**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void mergedContactsTest() throws Exception {
		String metric = "Merged Contacts";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.mergedContacts(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************mergedContacts**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void mergedJobsTest() throws Exception {
		String metric = "Merged Jobs";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService
				.mergedJobs(Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************mergedJobs**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void mergedCandidatesTest() throws Exception {
		String metric = "Merged Candidates";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.mergedCandidates(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************mergedCandidates**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newApprovedBillingRecordsTest() throws Exception {
		String metric = "New Approved Billing Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newApprovedBillingRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newApprovedBillingRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newApprovedSalaryRecordsTest() throws Exception {
		String metric = "New Approved Salary Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newApprovedSalaryRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newApprovedSalaryRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newApprovedTimesheetsTest() throws Exception {
		String metric = "New Approved Timesheets";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newApprovedTimesheets(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newApprovedTimesheets**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void approvedTimesheetsbyWeekEndingDateTest() throws Exception {
		String metric = "Approved Timesheets by Week Ending Date";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.approvedTimesheetsbyWeekEndingDate(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************approvedTimesheetsbyWeekEndingDate**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void updatedApprovedBillingRecordsTest() throws Exception {
		String metric = "Updated Approved Billing Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.updatedApprovedBillingRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************updatedApprovedBillingRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void updatedApprovedSalaryRecordsTest() throws Exception {
		String metric = "Updated Approved Salary Records";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.updatedApprovedSalaryRecords(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out
				.println("*****************************updatedApprovedSalaryRecords**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void newInvoicesTest() throws Exception {
		String metric = "New Invoices";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.newInvoices(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************newInvoices**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void voidedInvoices() throws Exception {
		String metric = "Voided Invoices";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.voidedInvoices(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************voidedInvoices**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void companyDetailTest() throws Exception {
		String metric = "Company Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.companyDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************companyDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void companiesDetailTest() throws Exception {
		String metric = "Companies Detail (up to 100 IDs)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.companiesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************companiesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void companyAddressesDetailTest() throws Exception {
		String metric = "Company Addresses Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.companyAddressesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************companyAddressesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void companyOwnersDetailTest() throws Exception {
		String metric = "Company Owners Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.companyOwnersDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************companyOwnersDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void companiesTypesDetailTest() throws Exception {
		String metric = "Companies Types Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.companiesTypesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************companiesTypesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void companiesOwnersDetailTest() throws Exception {
		String metric = "Companies Owners Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.companiesOwnersDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************companiesOwnersDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void companyNoteDetailTest() throws Exception {
		String metric = "Company Note Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.companyNoteDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************companyNoteDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void companyNotesDetailTest() throws Exception {
		String metric = "Company Notes Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.companyNotesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************companyNotesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void contactDetailTest() throws Exception {
		String metric = "Contact Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.contactDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************contactDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void contactsDetailTest() throws Exception {
		String metric = "Contacts Detail (up to 100 IDs)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.contactsDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************contactsDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void contactAddressesDetailTest() throws Exception {
		String metric = "Contact Addresses Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.contactAddressesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************contactAddressesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void contactOwnersDetailTest() throws Exception {
		String metric = "Contact Owners Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.contactOwnersDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************contactOwnersDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void contactsOwnersDetailTest() throws Exception {
		String metric = "Contacts Owners Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.contactsOwnersDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************contactsOwnersDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void contactsTypesDetailTest() throws Exception {
		String metric = "Contacts Types Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.contactsTypesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************contactsTypesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void contactNoteDetailTest() throws Exception {
		String metric = "Contact Note Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.contactNoteDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************contactNoteDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void contactNotesDetailTest() throws Exception {
		String metric = "Contact Notes Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.contactNotesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************contactNotesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateDetailTest() throws Exception {
		String metric = "Candidate Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************candidateDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidatesDetailTest() throws Exception {
		String metric = "Candidates Detail (up to 100 IDs)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidatesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************candidatesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateQualificationsDetailTest() throws Exception {
		String metric = "Candidate Qualifications Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateQualificationsDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************candidateQualificationsDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateEEODetailTest() throws Exception {
		String metric = "Candidate EEO Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateEEODetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************candidateEEODetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateResumeSourceDetailTest() throws Exception {
		String metric = "Candidate Resume Source Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateResumeSourceDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out
				.println("*****************************candidateResumeSourceDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateResumesDetailTest() throws Exception {
		String metric = "Candidate Resumes Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateResumesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************candidateResumesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateOnBoardingDocumentDetailTest() throws Exception {
		String metric = "Candidate On-Boarding Document Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateOnBoardingDocumentDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************candidateOnBoardingDocumentDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateNoteDetailTest() throws Exception {
		String metric = "Candidate Note Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateNoteDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************candidateNoteDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateNotesDetailTest() throws Exception {
		String metric = "Candidate Notes Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateNotesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************candidateNotesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void candidateSubmittalsDetailTest() throws Exception {
		String metric = "Candidate Submittals Detail (requires candidate id as parameter)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.candidateSubmittalsDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************candidateSubmittalsDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void jobDetailTest() throws Exception {
		String metric = "Job Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService
				.jobDetail(Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************jobDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void jobsDetailTest() throws Exception {
		String metric = "Jobs Detail (up to 100 IDs)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService
				.jobsDetail(Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************Jobs Detail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void jobContactsDetailTest() throws Exception {
		String metric = "Job Contacts Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.jobContactsDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************jobContactsDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void jobUsersDetailTest() throws Exception {
		String metric = "Job Users Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.jobUsersDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************jobUsersDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void jobsUsersDetailTest() throws Exception {
		String metric = "Jobs Users Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.jobsUsersDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************jobsUsersDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void jobApplicantsDetailTest() throws Exception {
		String metric = "Job Applicants Detail (requires jobid as parameter)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.jobApplicantsDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************jobApplicantsDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void jobSubmittalsDetailTest() throws Exception {
		String metric = "Job Submittals Detail (requires job id as parameter)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.jobSubmittalsDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************jobSubmittalsDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void resumeDetailTest() throws Exception {
		String metric = "Resume Detail (requires resume gobal id as parameter)";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.resumeDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************resumeDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void placementDetailTest() throws Exception {
		String metric = "Placement Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.placementDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************placementDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void submittalDetailTest() throws Exception {
		String metric = "Submittal Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.submittalDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************submittalDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void submittalsDetailTest() throws Exception {
		String metric = "Submittals Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.submittalsDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************submittalsDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void usersTasksDetailTest() throws Exception {
		String metric = "Users Tasks Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.usersTasksDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************usersTasksDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void eventsAttendeesDetailTest() throws Exception {
		String metric = "Events Attendees Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.eventsAttendeesDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************eventsAttendeesDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void billingRecordDetailTest() throws Exception {
		String metric = "Billing Record Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.billingRecordDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************billingRecordDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void salaryRecordDetailTest() throws Exception {
		String metric = "Salary Record Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.salaryRecordDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************salaryRecordDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void invoiceDetailTest() throws Exception {
		String metric = "Invoice Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.invoiceDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println("*****************************invoiceDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void employeeTimesheetImageDetailTest() throws Exception {
		String metric = "Employee Timesheet Image Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.employeeTimesheetImageDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out
				.println("*****************************employeeTimesheetImageDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}

	@Test
	public void employeeTimesheetImagebyTimecardIDDetailTest() throws Exception {
		String metric = "Employee Timesheet Image by Timecard ID Detail";
		Date from = Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK)));
		Date to = Date.from(Instant.now());
		GetBIDataResponse dataResponse = biDataService.employeeTimesheetImagebyTimecardIDDetail(
				Date.from(Instant.now().minus(Duration.ofDays(DAYS_TO_GO_BACK))), Date.from(Instant.now()));

		System.out.println(
				"*****************************employeeTimesheetImagebyTimecardIDDetail**********************************");
		System.out.println(StringUtils.toString(dataResponse));
		System.out.println("********************************************************************************");

		assertNotNull(dataResponse.getData());

		ExcelWriter.writeData(metric, dataResponse.getData().getColumns().getColumn(), dataResponse.getData().getRow(),
				metric + "-" + DateUtils.getDateAString(from) + "-" + DateUtils.getDateAString(to) + ".xlsx");
	}
	
	@Test
	public void dbUpdateTest() throws Exception {
		dbUpdateService.updateDbWithWebserviceData();
	}
	
}
