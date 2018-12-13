package com.aditi.insight.service;

import java.util.Date;
import java.util.List;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aditi.insight.utils.DateUtils;
import com.aditi.insight.ws.client.BIDataClient;
import com.jobdiva.bi.GetBIData;
import com.jobdiva.bi.GetBIDataResponse;

@Service
public class BIDataService {

	@Autowired
	private BIDataClient biDataClient;

	public GetBIDataResponse newPositionsCount(Date from, Date to) throws Exception {
		return getBIDataForMetric("New Positions Count", from, to, null);
	}
	
	public GetBIDataResponse newPositionsCountByDivision(Date from, Date to) throws Exception {
		return getBIDataForMetric("New Positions Count by Division", from, to, null);
	}
	
	public GetBIDataResponse newPositionsCountByPrimarySales(Date from, Date to) throws Exception {
		return getBIDataForMetric("New Positions Count by Primary Sales", from, to, null);
	}
	
	
	public GetBIDataResponse hiresCountByDivision(Date from, Date to) throws Exception {
		return getBIDataForMetric("Hires Count by Division", from, to, null);
	}
	
	
	public GetBIDataResponse hiresCountByPrimarySales(Date from, Date to) throws Exception {
		return getBIDataForMetric("Hires Count by Primary Sales", from, to, null);
	}
	
	
	public GetBIDataResponse openPositionCount(Date from, Date to) throws Exception {
		return getBIDataForMetric("Open Positions Count", from, to, null);
	}
	
	
	public GetBIDataResponse openPositionCountByDivision(Date from, Date to) throws Exception {
		return getBIDataForMetric("Open Positions Count by Division", from, to, null);
	}
	
	
	public GetBIDataResponse openPositionsCountByPrimarySales(Date from, Date to) throws Exception {
		return getBIDataForMetric("Open Positions Count by Primary Sales", from, to, null);
	}
	
	
	public GetBIDataResponse openPositionsCountbyJobType(Date from, Date to) throws Exception {
		return getBIDataForMetric("Open Positions Count by Job Type", from, to, null);
	}
	
	
	public GetBIDataResponse filledPositionsCount(Date from, Date to) throws Exception {
		return getBIDataForMetric("Filled Positions Count", from, to, null);
	}
	
	public GetBIDataResponse filledPositionsCountbyDivision(Date from, Date to) throws Exception {
		return getBIDataForMetric("Filled Positions Count by Division", from, to, null);
	}
	
	public GetBIDataResponse filledPositionsCountbyPrimarySales(Date from, Date to) throws Exception {
		return getBIDataForMetric("Filled Positions Count by Primary Sales", from, to, null);
	}
	
	public GetBIDataResponse submittalInterviewActivitiesCountbyDivision(Date from, Date to) throws Exception {
		return getBIDataForMetric("Submittal/Interview Activities Count by Division", from, to, null);
	}
	
	public GetBIDataResponse submittalInterviewActivitiesCountbyPrimarySales(Date from, Date to) throws Exception {
		return getBIDataForMetric("Submittal/Interview Activities Count by Primary Sales", from, to, null);
	}
	
	public GetBIDataResponse submittalInterviewActivitiesCountbyRecruiter(Date from, Date to) throws Exception {
		return getBIDataForMetric("Submittal/Interview Activities Count by Recruiter", from, to, null);
	}
	
	public GetBIDataResponse agingPositionsCountbyDivision(Date from, Date to) throws Exception {
		return getBIDataForMetric("Aging of Positions Count by Division", from, to, null);
	}
	
	public GetBIDataResponse agingPositionsCountbyPrimarySales(Date from, Date to) throws Exception {
		return getBIDataForMetric("Aging of Positions Count by Primary Sales", from, to, null);
	}
	
	public GetBIDataResponse endedAssignmentsCountbyDivision(Date from, Date to) throws Exception {
		return getBIDataForMetric("Ended Assignments Count by Division", from, to, null);
	}
	
	public GetBIDataResponse endedAssignmentsCountbyPrimarySales(Date from, Date to) throws Exception {
		return getBIDataForMetric("Ended Assignments Count by Primary Sales", from, to, null);
	}
	
	public GetBIDataResponse incomingResumesCount(Date from, Date to) throws Exception {
		return getBIDataForMetric("Incoming Resumes Count", from, to, null);
	}
	
	
	public GetBIDataResponse issuedJobsList(Date from, Date to) throws Exception {
		return getBIDataForMetric("Issued Jobs List", from, to, null);
	}
	
	public GetBIDataResponse updatedJobsList(Date from, Date to) throws Exception {
		return getBIDataForMetric("Updated Jobs List", from, to, null);
	}
	
	public GetBIDataResponse jobsDashboardbyUser(Date from, Date to) throws Exception {
		return getBIDataForMetric("Jobs Dashboard by User", from, to, null);
	}
	
	public GetBIDataResponse openJobsListbyCompany(Date from, Date to) throws Exception {
		return getBIDataForMetric("Open Jobs List by Company", from, to, null);
	}
	
	public GetBIDataResponse submittalInterviewHireActivitiesList(Date from, Date to) throws Exception {
		return getBIDataForMetric("Submittal/Interview/Hire Activities List", from, to, null);
	}
	
	public GetBIDataResponse candidateActions(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate Actions", from, to, null);
	}
	
	public GetBIDataResponse contactActions(Date from, Date to) throws Exception {
		return getBIDataForMetric("Contact Actions", from, to, null);
	}
	
	public GetBIDataResponse usersList(Date from, Date to) throws Exception {
		return getBIDataForMetric("Users List", from, to, null);
	}
	
	public GetBIDataResponse divisionsList(Date from, Date to) throws Exception {
		return getBIDataForMetric("Divisions List", from, to, null);
	}
	
	public GetBIDataResponse vMSUsersList(Date from, Date to) throws Exception {
		return getBIDataForMetric("VMS Users List", from, to, null);
	}
	
	public GetBIDataResponse rejectionReasonsList(Date from, Date to) throws Exception {
		return getBIDataForMetric("Rejection Reasons List", from, to, null);
	}
	
	public GetBIDataResponse userGroupLists(Date from, Date to) throws Exception {
		return getBIDataForMetric("User Group Lists", from, to, null);
	}
	
	public GetBIDataResponse newHires(Date from, Date to) throws Exception {
		return getBIDataForMetric("New Hires", from, to, null);
	}
	
	public GetBIDataResponse updateHires(Date from, Date to) throws Exception {
		return getBIDataForMetric("Update Hires", from, to, null);
	}
	
	public GetBIDataResponse accessLog(Date from, Date to) throws Exception {
		return getBIDataForMetric("Access Log", from, to, null);
	}
	
	
	public GetBIDataResponse newUpdatedCompanyRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Company Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdatedCompanyNoteRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Company Note Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdateContactRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Update Contact Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdatedContactNoteRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Contact Note Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdatedJobRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Job Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdatedCandidateRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Candidate Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdatedEmployeeRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Employee Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdatedActivityRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Activity Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdatedCandidateNoteRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Candidate Note Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdatedTaskRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Task Records", from, to, null);
	}
	
	public GetBIDataResponse newUpdatedEventRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New/Updated Event Records", from, to, null);
	}
	
	public GetBIDataResponse candidateApplicationRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate Application Records", from, to, null);
	}
	
	public GetBIDataResponse deletedCandidateNoteRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Deleted Candidate Note Records", from, to, null);
	}
	
	public GetBIDataResponse deletedEmployeeRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Deleted Employee Records", from, to, null);
	}
	
	public GetBIDataResponse deletedActivityRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Deleted Activity Records", from, to, null);
	}
	
	public GetBIDataResponse deletedCompanyRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Deleted Company Records", from, to, null);
	}
	
	public GetBIDataResponse deletedContactRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Deleted Contact Records", from, to, null);
	}
	
	public GetBIDataResponse deletedContactNoteRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Deleted Contact Note Records", from, to, null);
	}
	
	public GetBIDataResponse deletedJobRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Deleted Job Records", from, to, null);
	}
	
	public GetBIDataResponse deletedCandidateRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Deleted Candidate Records", from, to, null);
	}
	
	public GetBIDataResponse deletedTaskRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Deleted Task Records", from, to, null);
	}
	
	public GetBIDataResponse mergedCompanies(Date from, Date to) throws Exception {
		return getBIDataForMetric("Merged Companies", from, to, null);
	}
	
	public GetBIDataResponse mergedContacts(Date from, Date to) throws Exception {
		return getBIDataForMetric("Merged Contacts", from, to, null);
	}
	
	public GetBIDataResponse mergedJobs(Date from, Date to) throws Exception {
		return getBIDataForMetric("Merged Jobs", from, to, null);
	}
	
	public GetBIDataResponse mergedCandidates(Date from, Date to) throws Exception {
		return getBIDataForMetric("Merged Candidates", from, to, null);
	}
	
	public GetBIDataResponse newApprovedBillingRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New Approved Billing Records", from, to, null);
	}
	
	public GetBIDataResponse newApprovedSalaryRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("New Approved Salary Records", from, to, null);
	}
	
	public GetBIDataResponse newApprovedTimesheets(Date from, Date to) throws Exception {
		return getBIDataForMetric("New Approved Timesheets", from, to, null);
	}
	
	public GetBIDataResponse approvedTimesheetsbyWeekEndingDate(Date from, Date to) throws Exception {
		return getBIDataForMetric("Approved Timesheets by Week Ending Date", from, to, null);
	}
	
	public GetBIDataResponse updatedApprovedBillingRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Updated Approved Billing Records", from, to, null);
	}
	
	
	public GetBIDataResponse updatedApprovedSalaryRecords(Date from, Date to) throws Exception {
		return getBIDataForMetric("Updated Approved Salary Records", from, to, null);
	}
	
	public GetBIDataResponse newInvoices(Date from, Date to) throws Exception {
		return getBIDataForMetric("New Invoices", from, to, null);
	}
	
	public GetBIDataResponse voidedInvoices(Date from, Date to) throws Exception {
		return getBIDataForMetric("Voided Invoices", from, to, null);
	}
	
	public GetBIDataResponse companyDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Company Detail", from, to, null);
	}
	
	public GetBIDataResponse companiesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Companies Detail", from, to, null);
	}
	
	public GetBIDataResponse companyAddressesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Company Addresses Detail", from, to, null);
	}
	
	public GetBIDataResponse companyOwnersDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Company Owners Detail", from, to, null);
	}
	
	public GetBIDataResponse companiesTypesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Companies Types Detail", from, to, null);
	}
	
	public GetBIDataResponse companiesOwnersDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Companies Owners Detail", from, to, null);
	}
	
	public GetBIDataResponse companyNoteDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Company Note Detail", from, to, null);
	}
	
	public GetBIDataResponse companyNotesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Company Notes Detail", from, to, null);
	}
	
	public GetBIDataResponse contactDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Contact Detail", from, to, null);
	}
	
	public GetBIDataResponse contactsDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Contacts Detail", from, to, null);
	}
	
	public GetBIDataResponse contactAddressesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Contact Addresses Detail", from, to, null);
	}
	
	public GetBIDataResponse contactOwnersDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Contact Owners Detail", from, to, null);
	}
	
	
	public GetBIDataResponse contactsOwnersDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Contacts Owners Detail", from, to, null);
	}
	
	public GetBIDataResponse contactsTypesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Contacts Types Detail", from, to, null);
	}
	
	public GetBIDataResponse contactNoteDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Contact Note Detail", from, to, null);
	}
	
	public GetBIDataResponse contactNotesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Contact Notes Detail", from, to, null);
	}
	
	public GetBIDataResponse candidateDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate Detail", from, to, null);
	}
	
	public GetBIDataResponse candidatesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidates Detail", from, to, null);
	}
	
	public GetBIDataResponse candidateQualificationsDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate Qualifications Detail", from, to, null);
	}
	
	public GetBIDataResponse candidateEEODetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate EEO Detail", from, to, null);
	}
	
	public GetBIDataResponse candidateResumeSourceDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate Resume Source Detail", from, to, null);
	}
	
	public GetBIDataResponse candidateResumesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate Resumes Detail", from, to, null);
	}
	
	public GetBIDataResponse candidateOnBoardingDocumentDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate On-Boarding Document Detail", from, to, null);
	}
	
	public GetBIDataResponse candidateNoteDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate Note Detail", from, to, null);
	}
	
	public GetBIDataResponse candidateNotesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate Notes Detail", from, to, null);
	}
	
	public GetBIDataResponse candidateSubmittalsDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Candidate Submittals Detail", from, to, null);
	}
	
	public GetBIDataResponse jobDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Job Detail", from, to, null);
	}
	
	public GetBIDataResponse jobsDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Jobs Detail", from, to, null);
	}
	
	public GetBIDataResponse jobContactsDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Job Contacts Detail", from, to, null);
	}
	
	public GetBIDataResponse jobUsersDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Job Users Detail", from, to, null);
	}
	
	public GetBIDataResponse jobsUsersDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Jobs Users Detail", from, to, null);
	}
	
	public GetBIDataResponse jobApplicantsDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Job Applicants Detail", from, to, null);
	}
	
	public GetBIDataResponse jobSubmittalsDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Job Submittals Detail", from, to, null);
	}
	
	public GetBIDataResponse resumeDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Resume Detail", from, to, null);
	}
	
	public GetBIDataResponse placementDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Placement Detail", from, to, null);
	}
	
	public GetBIDataResponse submittalDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Submittal Detail", from, to, null);
	}
	
	public GetBIDataResponse submittalsDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Submittals Detail", from, to, null);
	}
	
	public GetBIDataResponse usersTasksDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Users Tasks Detail", from, to, null);
	}
	
	public GetBIDataResponse eventsAttendeesDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Events Attendees Detail", from, to, null);
	}
	
	public GetBIDataResponse billingRecordDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Billing Record Detail", from, to, null);
	}
	
	public GetBIDataResponse salaryRecordDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Salary Record Detail", from, to, null);
	}
	
	public GetBIDataResponse invoiceDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Invoice Detail", from, to, null);
	}
	
	public GetBIDataResponse employeeTimesheetImageDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Employee Timesheet Image Detail", from, to, null);
	}
	
	public GetBIDataResponse employeeTimesheetImagebyTimecardIDDetail(Date from, Date to) throws Exception {
		return getBIDataForMetric("Employee Timesheet Image by Timecard ID Detail", from, to, null);
	}
	
	private GetBIDataResponse getBIDataForMetric(String metric, Date from, Date to, List<String> parameters)
			throws Exception {
		// null checks
		Preconditions.checkNotNull(metric);
		Preconditions.checkNotNull(from);
		Preconditions.checkNotNull(to);
		
		GetBIData biDataRequest = BIDataClient.initBIDataRequest();
		biDataRequest.setMetricName(metric);
		biDataRequest.setFromDate(DateUtils.convertDateToXMLGregorianCalendar(from));
		biDataRequest.setToDate(DateUtils.convertDateToXMLGregorianCalendar(to));
		
		if(parameters!=null && !parameters.isEmpty())
			biDataRequest.getParameters().addAll(parameters);
		
		GetBIDataResponse dataResponse = biDataClient.getData(biDataRequest);
		return dataResponse;
	}

}
